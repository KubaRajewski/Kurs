package obiektowosc.zadania.drugie;

import java.util.ArrayList;
import java.util.List;

public class Produkt {
    private String nazwa;
    private double cena;

    private static List<Produkt> ekstensja = new ArrayList<>();

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;

        ekstensja.add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public static List<Produkt> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Produkt> ekstensja) {
        Produkt.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
