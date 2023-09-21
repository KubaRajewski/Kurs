package dalsze.podstawy.regexy.osoba;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Stworz klase Osoba(imie,nazwisko, pesel, plec)
 *
 * 1) Sprawdz czy pesel jest poprawny - czy sklada sie z 11 znakow, samych cyfr itp
 *
 * 2) Sprawdz czy pesel odpowiada podanej płci
 *
 * 3) Napisz metody które zwracaja z peselu date urodzenia (LocalDAte)
 */

public class Osoba {
    private String imie;
    private String nazwisko;
    private final String pesel;
    private final Plec plec;

    public static List<Osoba> ekstensja = new ArrayList<>();

    Pattern peselPattern = Pattern.compile("^(?<rok>\\d{2})(?<miesiac>(0[1-9]|1[0-2])|(2[1-9]|3[0-2]))(?<dzien>[0-2]\\d|3[0-1])(?<porzadkowa>\\d{3})(?<plec>[0-9])(?<kontrolna>\\d)$");

    public Osoba(String imie, String nazwisko, String pesel, Plec plec) {
        for (Osoba osoba : ekstensja) {
            if (osoba.getPesel().equals(pesel)) {
                throw new IllegalArgumentException("Podany pesel jest juz w bazie danych");
            }
        }

        if (imie == null || nazwisko == null || pesel == null || plec == null) {
            throw new IllegalArgumentException("Wypełnij wszystkie pola");
        } else if (!peselPattern.matcher(pesel).matches()) {
            throw new IllegalArgumentException("Podany pesel jest niepoprawny");
        } else if (!czyPlecSieZgadza(pesel, plec)) {
            throw new IllegalArgumentException("Pleć podana w peselu nie jest zgodna z płcią podana w konstruktorze");
        } else if (!czyCyfraKontrolnaSieZgadza(pesel)) {
            throw new IllegalArgumentException("nie zgadza sie liczba kontrolna");
        }

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.plec = plec;

        ekstensja.add(this);
    }

    public boolean czyPlecSieZgadza(String pesel, Plec plec) {
        Matcher matcher = peselPattern.matcher(pesel);

        matcher.matches();
        String plecZPESEL = matcher.group("plec");
        int cyfraPlec = Integer.parseInt(plecZPESEL);

        return (plec == Plec.MEZCZYZNA && cyfraPlec % 2 != 0) || (plec == Plec.KOBIETA && cyfraPlec % 2 == 0);
    }

    public boolean czyCyfraKontrolnaSieZgadza(String pesel) {

        int[] wagi = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int suma = 0;

        for (int i = 0; i < 10; i++) {
            int cyfra = Character.getNumericValue(pesel.charAt(i));
            suma += cyfra * wagi[i];
        }

        int ostatniaCyfra = Character.getNumericValue(pesel.charAt(10));
        int cyfraKontrolna = 10 - (suma % 10);

        return cyfraKontrolna == ostatniaCyfra;
    }

    public LocalDate getDataUrodzenia() {
        Matcher matcher = peselPattern.matcher(this.pesel);

        matcher.matches();
        int rok = Integer.parseInt(matcher.group("rok"));
        int miesiac = Integer.parseInt(matcher.group("miesiac"));
        int dzien = Integer.parseInt(matcher.group("dzien"));

        if (rok >= 00 && rok <= 99) {
            if (miesiac >= 81 && miesiac <= 92) {
                rok += 1800;
                miesiac -= 80;
            } else if (miesiac >= 21 && miesiac <= 32) {
                rok += 2000;
                miesiac -= 20;
            } else {
                rok += 1900;
            }
        }
        return LocalDate.of(rok, miesiac, dzien);
    }

    public String formatLocalDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public Plec getPlec() {
        return plec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba osoba)) return false;
        return Objects.equals(imie, osoba.imie) && Objects.equals(nazwisko, osoba.nazwisko) && Objects.equals(pesel, osoba.pesel) && plec == osoba.plec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, pesel, plec);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " PESEL: " + pesel;
    }
}
