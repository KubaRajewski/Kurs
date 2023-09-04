package obiektowosc.turniej;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gracz {
    private String imie;
    private String nazwisko;
    private int punkty;

    private List<Turniej> turnieje = new ArrayList<>();
    private List<Wynik> wyniki = new ArrayList<>();

    private static List<Gracz> ekstensja = new ArrayList<>();

    public Gracz(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;

        ekstensja.add(this);
    }

    public void dodajTurniej(Turniej turniej) {
        if (turnieje.contains(turniej)) {
            System.out.println("Ten gracz jest juz zapisany na ten turniej");
            return;
        }
        turnieje.add(turniej);
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

    public List<Turniej> getTurnieje() {
        return turnieje;
    }

    public void setTurnieje(List<Turniej> turnieje) {
        this.turnieje = turnieje;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public List<Wynik> getWyniki() {
        return wyniki;
    }

    public void setWyniki(List<Wynik> wyniki) {
        this.wyniki = wyniki;
    }

    public static List<Gracz> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Gracz> ekstensja) {
        Gracz.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }


}
