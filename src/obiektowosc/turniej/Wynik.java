package obiektowosc.turniej;

import java.util.ArrayList;
import java.util.List;

public class Wynik {
    private Turniej turniej;
    private Gracz gracz;
    private int pozycja;
    private int punkty;

    private static List<Wynik> ekstensja = new ArrayList<>();

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


    public Turniej getTurniej() {
        return turniej;
    }

    public void setTurniej(Turniej turniej) {
        this.turniej = turniej;
    }

    public Gracz getGracz() {
        return gracz;
    }

    public void setGracz(Gracz gracz) {
        this.gracz = gracz;
    }

    public int getPozycja() {
        return pozycja;
    }

    public void setPozycja(int pozycja) {
        this.pozycja = pozycja;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public static List<Wynik> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Wynik> ekstensja) {
        Wynik.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return turniej + ", Gracz: " + gracz + ", Pozycja: " + pozycja + ", Punkty: " + punkty;
    }
}
