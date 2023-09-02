package obiektowosc.zadania.poprawione.pierwsze;

import java.util.ArrayList;
import java.util.List;

public abstract class Produkt {
    private String nazwa;
    private double cena;

    List<Produkt> ekstensja = new ArrayList<>();

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

    public void setCena(double cena) {
        this.cena = cena;
    }

    public List<Produkt> getEkstensja() {
        return ekstensja;
    }

    public void setEkstensja(List<Produkt> ekstensja) {
        this.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
