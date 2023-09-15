package obiektowosc.turniej;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wynik {

    private static List<Wynik> ekstensja = new ArrayList<>();
    private Turniej turniej;
    private Gracz gracz;
    private int pozycja;
    private int punkty;

    public Wynik(Turniej turniej, Gracz gracz, int pozycja) {

        int punkty;
        if (pozycja == 1) {
            punkty = 10;
        } else if (pozycja == 2) {
            punkty = 8;
        } else if (pozycja == 3) {
            punkty = 6;
        } else if (pozycja == 4) {
            punkty = 4;
        } else if (pozycja == 5) {
            punkty = 2;
        } else if (pozycja == 6) {
            punkty = 1;
        } else if (pozycja < 1 || pozycja > turniej.getUczestnicy().size()) {
            System.out.println("Nieprawidłowa pozycja");
            return;
        } else {
            punkty = 0;
        }

        this.turniej = turniej;
        this.gracz = gracz;
        this.pozycja = pozycja;
        this.punkty = punkty;

        ekstensja.add(this);
        gracz.getWyniki().add(this);
        gracz.setSumaPunktow(gracz.getSumaPunktow() + punkty);
        turniej.getWyniki().add(this);
    }

    public static List<Wynik> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Wynik> ekstensja) {
        Wynik.ekstensja = ekstensja;
    }

    public Turniej getTurniej() {
        return turniej;
    }

    public Gracz getGracz() {
        return gracz;
    }

    public int getPozycja() {
        return pozycja;
    }

    public int getPunkty() {
        return punkty;
    }

    @Override
    public String toString() {
        return turniej + ", Gracz: " + gracz + ", Pozycja: " + pozycja + ", Punkty: " + punkty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wynik wynik = (Wynik) o;
        return pozycja == wynik.pozycja && punkty == wynik.punkty && Objects.equals(turniej, wynik.turniej) && Objects.equals(gracz, wynik.gracz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(turniej, gracz, pozycja, punkty);
    }
}
