package obiektowosc.podstawy.samochod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Samochod {

    // pola
    private final String producent;
    private final String model;
    private final int rokProdukcji;
    private String kolor;
    private int przebieg;
    private double cena;

    // pole statyczne - taka sama warotsc dla kazdego obiektu danej klasy
    private static int LICZBA_KOL = 4;

    // ekstensja klasy samochod
    private static List<Samochod> ekstensja = new ArrayList<>();

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
        if (lista == null || lista.isEmpty()) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        Samochod max = lista.get(0);

        for (Samochod s : lista) {
            if (s.obliczWiek() > max.obliczWiek()) {
                max = s;
            }
        }
        return max;
    }

    // napisz metode ktora znajduje wszystkie auta marki bmw

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

    // napisz metode ktora sumuje ceny wszystkich aut

    public static double suma(List<Samochod> lista){
        if (lista == null) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        double suma = 0;

        for (Samochod samochod : lista) {
            suma =+ samochod.getCena();
        }
        return suma;
    }

    // napisz metode ktora zwraca nazwy wszystkich marek (unikalnych!)

    public static Set<String> unikalne(List<Samochod> lista) {
        if (lista == null) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        Set<String> unikalne = new HashSet<>();

        for (Samochod samochod : lista) {
            unikalne.add(samochod.getProducent());
        }

        return unikalne;
    }

    // napisz metode ktora znajduje auto o najnizszym przebiegu

    public static int najnizszyPrzebieg(List<Samochod> list){
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        int najnizszyPrzebieg = Integer.MAX_VALUE;
        for (Samochod samochod : list) {
            if (samochod.getPrzebieg() < najnizszyPrzebieg){
                najnizszyPrzebieg = samochod.getPrzebieg();
            }
        }
        return najnizszyPrzebieg;
    }

    // napisz metode ktora znajduje wszystkie auta o kolorze niebieskim starsze niz 15 lat

    public static List<Samochod> niebieskieStarszeNiz (List<Samochod> list, Integer limit){
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        List<Samochod> niebieskieStarszeNiz = new ArrayList<>();
        for (Samochod samochod : list) {
            if (samochod.getKolor().equals("blue") && samochod.obliczWiek() > 15){
                niebieskieStarszeNiz.add(samochod);
            }
        }
        return niebieskieStarszeNiz;
    }

    // napisz metode ktora znajduje najdrozsze auto ale z aut z przebiegiem mniejszym nzi 30k

    public static Samochod najdrozszeZPrzebiegiemMniejszymNiz (List<Samochod> list, Integer limit){
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        Samochod najdrozszeZPrzebiegiemMniejszymNiz = null;
        for (Samochod samochod : list) {
            if (samochod.getPrzebieg() < 30000 && (najdrozszeZPrzebiegiemMniejszymNiz == null || samochod.getCena() > najdrozszeZPrzebiegiemMniejszymNiz.getCena())){
                najdrozszeZPrzebiegiemMniejszymNiz = samochod;
            }
        }
        return najdrozszeZPrzebiegiemMniejszymNiz;
    }

    // znajdz najtansze auto marki bmw

    public static Samochod najtanszeZMarki (List<Samochod> list, String marka){
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        Samochod najtanszeBmw = null;
        for (Samochod samochod : list) {
            if (samochod.getProducent().equals(marka) && (najtanszeBmw == null || samochod.getCena() < najtanszeBmw.getCena())){
                najtanszeBmw = samochod;
            }
        }
        return najtanszeBmw;
    }

    // znajsz wszystkie auta ktore w marce maja literke a

    public static List<Samochod> markaZLiterkaA (List<Samochod> list, Character literka){
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        List<Samochod> markaZLiterkaA = new ArrayList<>();
        for (Samochod samochod : list) {
            if (samochod.getProducent().contains(literka.toString())){
                markaZLiterkaA.add(samochod);
            }
        }
        return markaZLiterkaA;
    }

    // znajdz najdrozsze auto ktorego marka ma dlugosc wieksza niz 4

    public static Samochod najdrozszeMarkiDluzszejNiz (List<Samochod> list, Integer limit){
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        Samochod najdrozszeMarkiDluzszejNiz = null;
        for (Samochod samochod : list) {
            if (samochod.getProducent().length() > 4 && (najdrozszeMarkiDluzszejNiz == null || samochod.getCena() > najdrozszeMarkiDluzszejNiz.getCena())){
                najdrozszeMarkiDluzszejNiz = samochod;
            }
        }
        return najdrozszeMarkiDluzszejNiz;
    }


    public static List<Samochod> getEkstensja() {
        return ekstensja;
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

    public static int getLiczbaKol() {
        return LICZBA_KOL;
    }

    public static void setLiczbaKol(int liczbaKol) {
        LICZBA_KOL = liczbaKol;
    }

    @Override
    public String toString() {
        return producent + " " + model;
    }
}
