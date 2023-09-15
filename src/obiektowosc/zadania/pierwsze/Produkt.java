package obiektowosc.zadania.pierwsze;

import java.util.ArrayList;
import java.util.List;

public abstract class Produkt {
    List<Produkt> ekstensja = new ArrayList<>();
    private String nazwa;
    private double cena;
    private List<Klient> klienci = new ArrayList<>();

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;

        ekstensja.add(this);
    }

    public void dodajKlienta(Klient klient) {
        if (!klienci.contains(klient)) {
            klienci.add(klient);
        }
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

    public List<Klient> getKlienci() {
        return klienci;
    }

    public void setKlienci(List<Klient> klienci) {
        this.klienci = klienci;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
