package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Osoba {
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;

    public static List<Osoba> ekstensja = new ArrayList<>();

    public Osoba(String imie, String nazwisko, String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;

        ekstensja.add(this);
    }

    public static List<Osoba> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Osoba> ekstensja) {
        Osoba.ekstensja = ekstensja;
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

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return Objects.equals(imie, osoba.imie) && Objects.equals(nazwisko, osoba.nazwisko) && Objects.equals(dataUrodzenia, osoba.dataUrodzenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, dataUrodzenia);
    }
}
