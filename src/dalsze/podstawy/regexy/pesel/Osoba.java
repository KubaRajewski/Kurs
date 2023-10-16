package dalsze.podstawy.regexy.pesel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*todo
 * Stworz klase Osoba(imie,nazwisko, pesel, PLEC)
 * 1) Sprawdz czy pesel jest poprawny - czy sklada sie z 11 znakow, samych cyfr itp
 * 2) Sprawdz czy pesel odpowiada podanej płci
 * 3) Napisz metody które zwracaja z peselu date urodzenia (LocalDAte)
 */

public class Osoba {
    private String imie;
    private String nazwisko;
    private final String pesel;
    private final Plec plec;

    public static List<Osoba> ekstensja = new ArrayList<>();

    Pattern peselPattern = Pattern.compile("(?<ROK>\\d{2})(?<MIESIAC>(0[1-9]|1[0-2])|(2[1-9]|3[0-2]))(?<DZIEN>[0-2]\\d|3[0-1])(?<PORZADKOWA>\\d{3})(?<PLEC>[0-9])(?<KONTROLNA>\\d)");

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
        }
        czyPeselJestOk(pesel);
        czyPlecSieZgadza(pesel);
        czyCyfraKontrolnaSieZgadza(pesel);

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.plec = plec;

        ekstensja.add(this);
    }

    public void czyPeselJestOk(String pesel) {
        if (!pesel.matches("\\d{11}")) {
            throw new IllegalArgumentException();
        }
    }

    public void czyPlecSieZgadza(String pesel) {

        int i = Character.getNumericValue(pesel.charAt(9));

        if ((plec == Plec.MEZCZYZNA && i % 2 == 0) || (plec == Plec.KOBIETA && i % 2 != 0)) {
            throw new IllegalArgumentException();
        }
    }

    public void czyCyfraKontrolnaSieZgadza(String pesel) {

        int[] wagi = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int suma = 0;

        for (int i = 0; i < 10; i++) {
            int cyfra = Character.getNumericValue(pesel.charAt(i));
            suma += cyfra * wagi[i];
        }

        int ostatniaCyfra = Character.getNumericValue(pesel.charAt(10));
        int cyfraKontrolna = 10 - (suma % 10);

        if (cyfraKontrolna != ostatniaCyfra) {
            throw new IllegalArgumentException("Cyfra kontrolna nie zgadza sie z peselem");
        }
    }

    public LocalDate getDataUrodzenia() {
        Matcher matcher = peselPattern.matcher(this.pesel);

        matcher.matches();
        int rok = Integer.parseInt(pesel.substring(0, 2));
        int miesiac = Integer.parseInt(pesel.substring(2, 4));
        int dzien = Integer.parseInt(pesel.substring(4, 6));

        if (miesiac >= 81 && miesiac <= 92) {
            rok += 1800;
            miesiac -= 80;
        } else if (miesiac >= 21 && miesiac <= 32) {
            rok += 2000;
            miesiac -= 20;
        } else {
            rok += 1900;
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
