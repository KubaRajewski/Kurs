package obiektowosc.wypozyczalnia;

import obiektowosc.zadania.drugie.Produkt;

import java.util.ArrayList;
import java.util.List;

public class Klient extends Osoba{
    private boolean kartaLojalnosciowa;

    private List<Wypozyczenie> wypozyczenia = new ArrayList<>();

    public static List<Klient> ekstensja = new ArrayList<>();

    public Klient(String imie, String nazwisko, String adres, String numerDowodu, boolean kartaLojalnosciowa) {
        super(imie, nazwisko, adres, numerDowodu);
        this.kartaLojalnosciowa = kartaLojalnosciowa;

        ekstensja.add(this);
    }

    public static List<Klient> klienciZKarta(List<Klient> klienci) {
        List<Klient> klienciZKarta = new ArrayList<>();
        for (Klient k : klienci) {
            if (k.kartaLojalnosciowa) {
                klienciZKarta.add(k);
            }
        }
        return klienciZKarta;
    }

    public boolean isKartaLojalnosciowa() {
        return kartaLojalnosciowa;
    }

    public void setKartaLojalnosciowa(boolean kartaLojalnosciowa) {
        this.kartaLojalnosciowa = kartaLojalnosciowa;
    }

    public List<Wypozyczenie> getWypozyczenia() {
        return wypozyczenia;
    }

    public void setWypozyczenia(List<Wypozyczenie> wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }

    public static List<Klient> getEkstensjaKlient() {
        return ekstensja;
    }
}
