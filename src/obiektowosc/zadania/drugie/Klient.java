package obiektowosc.zadania.drugie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Klient extends Osoba {
private List<Produkt> koszyk = new ArrayList<>();

private static List<Klient> ekstensja = new ArrayList<>();

    public Klient(String imie, String nazwisko) {
        super(imie, nazwisko);

        ekstensja.add(this);
    }

    public void dodajProdukt(Produkt produkt){
        koszyk.add(produkt);
        produkt.dodajKlienta(this);
    }

    // TODO 1) Napisz metode ktora znajduje klienta ktory wydal najwiecej.

    public double obliczWartoscZakupow() {
        double wartosc = 0;
        for (Produkt produkt : koszyk) {
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

    ////TODO 2) Wyswietl dla kazdego klienta jego ulubiony produkt (of cuz ulubiony produkt to ma byc atrybut wyliczalny na podstawie zakupow)

    public List<Produkt> ulubioneProdukty(){
        if (koszyk == null)
            throw new IllegalArgumentException("koszyk tego klienta jest pusty");

        List<Produkt> ulubioneProdukty = new ArrayList<>();

        if (koszyk.size() == 1){
            ulubioneProdukty.add(koszyk.get(0));
            return ulubioneProdukty;
        }

        for (Produkt p : koszyk) {
            int licznik = 0;
            for (Produkt P : koszyk) {
                if (p.getNazwa().equals(P.getNazwa())) {
                    licznik++;
                }
            }
            if (licznik > 1 && !ulubioneProdukty.contains(p)) {
                ulubioneProdukty.add(p);
            }
        }

        Set<Produkt> s1 = new HashSet<>();
        s1.addAll(ulubioneProdukty);

        Set<Produkt> s2 = new HashSet<>();
        s2.addAll(koszyk);

        if (s1.size() == s2.size()) {
            ulubioneProdukty.clear();
        }

        return ulubioneProdukty;
    }

    public List<Produkt> getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(List<Produkt> koszyk) {
        this.koszyk = koszyk;
    }

    public static List<Klient> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Klient> ekstensja) {
        Klient.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return getImie() + " " + getNazwisko();
    }
}
