package dalsze.podstawy.daty.lokal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Osoba {
    private String imie;
    private String nazwisko;
    private String pesel;

    private List<Lokal> lokale = new ArrayList<>();

    public Osoba(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public void dodajLokal(Lokal lokal) {
        if (lokal == null) {
            throw new IllegalArgumentException();
        }

        if (getWiek() < lokal.getMinimalnyWiek()) {
            throw new JestesZaMlodyException();
        }

        lokale.add(lokal);
        lokal.getOsoby().add(this);
    }

    public Long getWiek() {
        return ChronoUnit.YEARS.between(getDataUrodzenia(), LocalDate.now());
    }

    public LocalDate getDataUrodzenia() {
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

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
