package testy.test2.zadanie4;

import java.util.ArrayList;
import java.util.List;

public abstract class Figura {
    private int index;

    private static List<Figura> ekstensja = new ArrayList<>();

    public Figura() {
        this.index = 0;
        ekstensja.add(this);
    }

    public abstract double obwod();

    public abstract double pole();

    public abstract String opis();

    public static Figura stworzKwadrat(double bok) {
        int index = ekstensja.size() + 1;
        Kwadrat kwadrat = new Kwadrat(bok);
        kwadrat.setIndex(index);
        return kwadrat;
    }

    public static Figura stworzKolo(double srednica) {
        int index = ekstensja.size() + 1;
        Kolo kolo = new Kolo(srednica);
        kolo.setIndex(index);
        return kolo;
    }

    public static Figura stworzProstokat(double bokA, double bokB) {
        int index = ekstensja.size() + 1;
        Prostokat prostokat = new Prostokat(bokA, bokB);
        prostokat.setIndex(index);
        return prostokat;
    }

    public static Figura znajdzNajwiekszyObwod(Figura[] figury) {
        if (figury.length == 0) {
            return null;
        }

        Figura najwiekszyObwod = figury[0];
        for (Figura figura : figury) {
            if (figura.obwod() > najwiekszyObwod.obwod()) {
                najwiekszyObwod = figura;
            }
        }

        return najwiekszyObwod;
    }

    public static Figura znajdzNajwiekszePole(Figura[] figury) {
        if (figury.length == 0) {
            return null;
        }

        Figura najwiekszePole = figury[0];
        for (Figura figura : figury) {
            if (figura.pole() > najwiekszePole.pole()) {
                najwiekszePole = figura;
            }
        }

        return najwiekszePole;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static List<Figura> getEkstensja() {
        return ekstensja;
    }

    @Override
    public String toString() {
        return "Figura nr " + getIndex() + ": " + opis();
    }
}
