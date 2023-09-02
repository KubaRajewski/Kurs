package obiektowosc.zadania.drugie;

import java.util.ArrayList;
import java.util.List;

public class Produkt {
    private String nazwa;
    private double cena;

    private List<Klient> klienci = new ArrayList<>();

    private static List<Produkt> ekstensja = new ArrayList<>();

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;

        ekstensja.add(this);
    }

    public void dodajKlienta(Klient klient){
        if(!klienci.contains(klient)){
            klienci.add(klient);
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public List<Klient> getKlienci() {
        return klienci;
    }

    public void setKlienci(List<Klient> klienci) {
        this.klienci = klienci;
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
