package obiektowosc.zadania.pierwsze;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String imie;
    private String nazwisko;
    private final double rozmiarPenisa;

    private List<Produkt> produkty = new ArrayList<>();

    public static List<Klient> ekstensja = new ArrayList<>();

    public Klient(String imie, String nazwisko, double rozmiarPenisa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rozmiarPenisa = rozmiarPenisa;

        ekstensja.add(this);
    }

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
        produkt.dodajKlienta(this);
    }

    // TODO 1) Napisz metode ktora znajduje klienta ktory wydal najwiecej.

    public double obliczWartoscZakupow() {
        double wartosc = 0;
        for (Produkt produkt : produkty) {
            wartosc += produkt.getCena();
        }
        return wartosc;
    }

    public static Klient ktoWydalNajwiecej(List<Klient> klienci) {
        if (klienci == null || klienci.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem lub byc pusta");
        Klient max = klienci.get(0);
        for (Klient k : klienci) {
            if (k.obliczWartoscZakupow() > max.obliczWartoscZakupow()) {
                max = k;
            }
        }
        return max;
    }

    // TODO 2) napisz metode ktora zwroci liste klientow ktorzy kupili kondoma
    public boolean czyKupilKondoma() {
        for (Produkt produkt : produkty) {
            if (produkt instanceof Kondom) {
                return true;
            }
        }
        return false;
    }

    public static List<Klient> klienciKtorzyKupiliKondoma(List<Klient> list) {
        if (list == null)
            throw new IllegalArgumentException("lista nie moze byc nullem lub byc pusta");

        List<Klient> klienciZKondomem = new ArrayList<>();
        for (Klient klient : list) {
            if (klient.czyKupilKondoma()) {
                klienciZKondomem.add(klient);
            }
        }
        return klienciZKondomem;
    }

    // TODO 3) napisz metode ktora zwroci liste klientow ktorzy kupili kondoma ale nie na swoj rozmiar :D
    public boolean czyKupilZlegoKondoma() {
        for (Produkt produkt : produkty) {
            if (produkt instanceof Kondom && ((Kondom) produkt).getRozmiar() != rozmiarPenisa) {
                return true;
            }
        }
        return false;
    }

    public static List<Klient> kupiliZlegoKondoma(List<Klient> klienci) {
        List<Klient> kupiliZlegoKondoma = new ArrayList<>();
        for (Klient klient : klienci) {
            if(klient.czyKupilZlegoKondoma()){
                kupiliZlegoKondoma.add(klient);
            }
        }
        return kupiliZlegoKondoma;
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

    public double getRozmiarPenisa() {
        return rozmiarPenisa;
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    public static List<Klient> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Klient> ekstensja) {
        Klient.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
