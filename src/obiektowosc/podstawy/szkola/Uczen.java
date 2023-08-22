package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Uczen extends Osoba {
    private String numerIndeksu;
    private Szkola szkola;
    private Klasa klasa;
    private List<Ocena> oceny = new ArrayList<>();

    private static List<Uczen> ekstensja = new ArrayList<>();

    public Uczen(String imie, String nazwisko, String adres, String numerIndeksu, Szkola szkola, Klasa klasa) {
        super(imie, nazwisko, adres);

        // Sprawdzanie, czy uczeń o danym numerze indeksu już istnieje w danej szkole
        for (Uczen u : ekstensja) {
            if (u.numerIndeksu.equals(numerIndeksu)) {
                throw new IllegalArgumentException("Uczeń z danym numerem już istnieje");
            }
        }
        this.numerIndeksu = numerIndeksu;
        this.szkola = szkola;
        this.klasa = klasa;
        // dodaj ucznia do klasy klasa
        klasa.dodajUcznia(this);
        // dodaj ucznia do szkoly szkola
        szkola.dodajUcznia(this);
        ekstensja.add(this);
    }

    @Override
    public double obliczDochod() {
        return 100;
    }

    public String getNumerIndeksu() {
        return numerIndeksu;
    }

    public void setNumerIndeksu(String numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }

    public Szkola getSzkola() {
        return szkola;
    }

    public void setSzkola(Szkola szkola) {
        this.szkola = szkola;
    }

    public Klasa getKlasa() {
        return klasa;
    }

    public void setKlasa(Klasa klasa) {
        this.klasa = klasa;
    }

    public List<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(List<Ocena> oceny) {
        this.oceny = oceny;
    }

    public static List<Uczen> getEkstensja() {
        return ekstensja;
    }

    @Override
    public String toString() {
        return getImie() + " " + getNazwisko() + " " + numerIndeksu;
    }



}
