package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public abstract class Osoba {
    public static List<Osoba> ekstensja = new ArrayList<>();
    private final String imie;
    private final String nazwisko;
    private final String numerDowodu;
    private String adres;

    public Osoba(String imie, String nazwisko, String adres, String numerDowodu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.numerDowodu = numerDowodu;

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

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNumerDowodu() {
        return numerDowodu;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " " + numerDowodu;
    }
}
