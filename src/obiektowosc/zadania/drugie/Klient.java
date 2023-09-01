package obiektowosc.zadania.drugie;

import java.util.*;

public class Klient {
    private String imie;
    private String nazwisko;
    private List<Produkt> koszyk;

    // TODO asocjacja!!!!!!

    private static List<Klient> ekstensja = new ArrayList<>();

    public Klient(String imie, String nazwisko, List<Produkt> koszyk) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.koszyk = koszyk != null ? koszyk : new ArrayList<>(); // Inicjalizacja koszyka

        ekstensja.add(this);
    }

// TODO 1) Znajdz klienta który wydal najwiecej

    public static double obliczWartoscZakupow(List<Produkt> koszyk) {
        if (koszyk == null)
            throw new IllegalArgumentException("koszyk nie moze byc nullem");

        double wartosc = 0;
        for (Produkt produkt : koszyk) {
            wartosc += produkt.getCena();
        }
        return wartosc;
    }

    public static Klient ktoWydalNajwiecej(List<Klient> klienci) {
        if (klienci == null || klienci.isEmpty())
            throw new IllegalArgumentException("koszyk nie moze byc nullem");

        Klient nk = klienci.get(0);
        double maxWartosc = obliczWartoscZakupow(nk.getKoszyk());

        for (Klient k : klienci) {
            double wartoscKoszyka = obliczWartoscZakupow(k.getKoszyk());
            if (wartoscKoszyka > maxWartosc) {
                maxWartosc = wartoscKoszyka;
                nk = k;
            }
        }
        return nk;
    }

// TODO 2) Wyswietl dla kazdego klienta jego ulubiony produkt (of cuz ulubiony produkt to ma byc atrybut wyliczalny na podstawie zakupow)

    // metoda obiektowa dla klienta co kupowal najczesciej


//
//    public static Map<Klient, List<Produkt>> znajdzUlubioneProdukty(List<Klient> klienci) {
//        if (klienci == null || klienci.isEmpty())
//            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
//
//        Map<Klient, List<Produkt>> ulubioneProdukty = new HashMap<>();
//
//        for (Klient k : klienci) {
//            ulubioneProdukty.put(k, znajdzNajczestszeProdukty(k.getKoszyk()));
//        }
//
//        return ulubioneProdukty;
//    }
//
//    public static List<Produkt> znajdzNajczestszeProdukty(List<Produkt> koszyk) {
//        if (koszyk == null)
//            throw new IllegalArgumentException("koszyk nie moze byc nullem");
//
//        List<Produkt> najczestszeProdukty = new ArrayList<>();
//
//        for (Produkt p : koszyk) {
//            int licznik = 0;
//            for (Produkt P : koszyk) {
//                if (p.getNazwa().equals(P.getNazwa())) {
//                    licznik++;
//                }
//            }
//            if (licznik > 1 && !najczestszeProdukty.contains(p)) {
//                najczestszeProdukty.add(p);
//            }
//        }
//
//        Set<Produkt> s1 = new HashSet<>();
//        s1.addAll(najczestszeProdukty);
//
//        Set<Produkt> s2 = new HashSet<>();
//        s2.addAll(koszyk);
//
//        if (s1.size() == s2.size()) {
//            najczestszeProdukty.clear();
//        }
//
//        return najczestszeProdukty;
//    }

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

    public List<Produkt> getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(List<Produkt> koszyk) {
        this.koszyk = koszyk;
    }

    public static List<Klient> getEkstensja() {
        return ekstensja;
    }

    public void setEkstensja(List<Klient> ekstensja) {
        this.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
