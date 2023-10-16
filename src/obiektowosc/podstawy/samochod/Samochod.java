package obiektowosc.podstawy.samochod;

import java.time.LocalDate;
import java.util.*;

public class Samochod {

    // pole statyczne - taka sama warotsc dla kazdego obiektu danej klasy
    private static int LICZBA_KOL = 4;
    // ekstensja klasy samochod
    private static List<Samochod> ekstensja = new ArrayList<>();
    // pola
    private final String producent;
    private final String model;
    private final int rokProdukcji;
    private String kolor;
    private int przebieg;
    private double cena;

    // konstruktor
    // ctrl + enter
    public Samochod(String producent, String model, int rokProdukcji, String kolor, int przebieg, double cena) {
        this.producent = producent;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.kolor = kolor;
        this.przebieg = przebieg;
        this.cena = cena;

        // autoamtyczne dodowani do ekstensji
        ekstensja.add(this);
    }

    // metoda obiektowa (niestatyczna) wywolujemy ja na konkretnym obiekcie
    public int obliczWiek() {
        return LocalDate.now().getYear() - rokProdukcji;
    }

    // metoda klasowa (statyczna) wywolujemy ja na klasie
    // w tego typu metodach nie dzialamy bezposrednio na ekstensji
    public static Samochod najstarszeAuto(List<Samochod> lista) {
        if (lista == null || lista.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        Samochod max = lista.get(0);

        for (Samochod s : lista) {
            if (s.obliczWiek() > max.obliczWiek()) {
                max = s;
            }
        }
        return max;
    }

    public static List<Samochod> znajdzMarke(List<Samochod> lista, String marka) {
        if (lista == null) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        List<Samochod> listaMarki = new ArrayList<>();

        for (Samochod samochod : lista) {
            if (samochod.getProducent().equals(marka)) {
                listaMarki.add(samochod);
            }
        }
        return listaMarki;
    }

    // napisz metode ktora znajduje wszystkie auta marki bmw

    public static double suma(List<Samochod> lista) {
        if (lista == null) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        double suma = 0;

        for (Samochod samochod : lista) {
            suma = +samochod.getCena();
        }
        return suma;
    }

    // napisz metode ktora sumuje ceny wszystkich aut

    public static Set<String> unikalne(List<Samochod> lista) {
        if (lista == null) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        Set<String> unikalne = new HashSet<>();

        for (Samochod samochod : lista) {
            unikalne.add(samochod.getProducent());
        }

        return unikalne;
    }

    // napisz metode ktora zwraca nazwy wszystkich marek (unikalnych!)

    public static Samochod najnizszyPrzebieg(List<Samochod> list) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        Samochod s = list.get(0);
        for (Samochod samochod : list) {
            if (samochod.getPrzebieg() < s.getPrzebieg()) {
                s = samochod;
            }
        }
        return s;
    }

    // napisz metode ktora znajduje auto o najnizszym przebiegu

    public static List<Samochod> kolorStarszeNiz(List<Samochod> list, int limit, String kolor) {
        if (list == null) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        List<Samochod> kolorStarszeNiz = new ArrayList<>();
        for (Samochod samochod : list) {
            if (samochod.getKolor().equals(kolor) && samochod.obliczWiek() > limit) {
                kolorStarszeNiz.add(samochod);
            }
        }
        return kolorStarszeNiz;
    }

    // napisz metode ktora znajduje wszystkie auta o kolorze niebieskim starsze niz 15 lat

    public static List<Samochod> samochodyPrzebiegMniejNiz(List<Samochod> list, int limit) {
        if (list == null) throw new IllegalArgumentException("lista nie moze byc nullem");
        List<Samochod> samochodyPrzebiegMniejNiz = new ArrayList<>();
        for (Samochod s : list) {
            if (s.getPrzebieg() < limit) {
                samochodyPrzebiegMniejNiz.add(s);
            }
        }
        return samochodyPrzebiegMniejNiz;
    }

    // napisz metode ktora znajduje najdrozsze auto ale z aut z przebiegiem mniejszym nzi 30k

    // napisz metode ktora sortuje po cenie
    public static List<Samochod> sortuj(List<Samochod> lista) {

        List<Samochod> kopia = new ArrayList<>(lista);
        Collections.sort(kopia, Comparator.comparing(Samochod::getCena));
        return kopia;
    }

    public static Samochod najdrozszeZPrzebiegiemMniejszymNiz(List<Samochod> list, int limit) {
        List<Samochod> przefiltrowana = new ArrayList<>(samochodyPrzebiegMniejNiz(list, limit));

        if (przefiltrowana.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        Samochod s = list.get(0);
        for (Samochod samochod : list) {
            if (samochod.getCena() > s.getCena()) {
                s = samochod;
            }
        }
        return s;
    }

    public static Samochod najtanszeZMarki(List<Samochod> list, String marka) {
        List<Samochod> przefiltrowana = new ArrayList<>(znajdzMarke(list, marka));

        if (przefiltrowana.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        Samochod najtanszeBmw = przefiltrowana.get(0);
        for (Samochod samochod : przefiltrowana) {
            if (samochod.getCena() < najtanszeBmw.getCena()) {
                najtanszeBmw = samochod;
            }
        }
        return najtanszeBmw;
    }

    // znajdz najtansze auto marki bmw

    public static List<Samochod> markaZLiterkaA(List<Samochod> list, char literka) {
        if (list == null)
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        List<Samochod> markaZLiterkaA = new ArrayList<>();
        for (Samochod samochod : list) {
            if (samochod.getProducent().contains(String.valueOf(literka))) {
                markaZLiterkaA.add(samochod);
            }
        }
        return markaZLiterkaA;
    }

    // znajsz wszystkie auta ktore w marce maja literke a

    public static List<Samochod> dluzszeNiz(List<Samochod> lista, int dlugosc) {
        if (lista == null)
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        List<Samochod> dluzszeNiz = new ArrayList<>();
        for (Samochod s : lista) {
            if (s.getProducent().length() > dlugosc) {
                dluzszeNiz.add(s);
            }
        }
        return dluzszeNiz;
    }

    // znajdz najdrozsze auto ktorego marka ma dlugosc wieksza niz 4

    public static Samochod najdrozszeMarkiDluzszejNiz(List<Samochod> list, Integer limit) {
        List<Samochod> przefiltrowana = new ArrayList<>(dluzszeNiz(list, limit));

        if (przefiltrowana.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        Samochod najdrozszeMarkiDluzszejNiz = przefiltrowana.get(0);
        for (Samochod samochod : przefiltrowana) {
            if (samochod.getCena() > najdrozszeMarkiDluzszejNiz.getCena()) {
                najdrozszeMarkiDluzszejNiz = samochod;
            }
        }
        return najdrozszeMarkiDluzszejNiz;
    }

    public static List<Samochod> getEkstensja() {
        return ekstensja;
    }

    public static int getLiczbaKol() {
        return LICZBA_KOL;
    }

    public static void setLiczbaKol(int liczbaKol) {
        LICZBA_KOL = liczbaKol;
    }

    public String getProducent() {
        return producent;
    }

    public String getModel() {
        return model;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return producent + " " + model;
    }
}
