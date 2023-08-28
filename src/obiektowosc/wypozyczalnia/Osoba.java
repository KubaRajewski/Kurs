package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public abstract class Osoba {
    private final String imie;
    private final String nazwisko;
    private String adres;
    private final String numerDowodu;

    public static List<Osoba> ekstensja = new ArrayList<>();

    public Osoba(String imie, String nazwisko, String adres, String numerDowodu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.numerDowodu = numerDowodu;

        ekstensja.add(this);
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

    public static List<Osoba> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Osoba> ekstensja) {
        Osoba.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko +  " " + numerDowodu;
    }
}
