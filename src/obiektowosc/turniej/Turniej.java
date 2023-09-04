package obiektowosc.turniej;

import java.util.*;

public class Turniej {
    private String nazwa;
    private String miesiac;

    private List<Gracz> uczestnicy = new ArrayList<>();
    private List<Wynik> turnieje = new ArrayList<>();

    private static List<Turniej> ekstensja = new ArrayList<>();

    public Turniej(String nazwa, String miesiac) {
        this.nazwa = nazwa;
        this.miesiac = miesiac;

        ekstensja.add(this);
    }

    public void dodajUczestnika(Gracz gracz) {
        if (uczestnicy.contains(gracz)) {
            System.out.println("Gracz " + gracz + " już jest na liście uczestników");
            return;
        }
        uczestnicy.add(gracz);
        gracz.dodajTurniej(this);
    }


    public String getNazwa () {
        return nazwa;
    }

    public void setNazwa (String nazwa){
        this.nazwa = nazwa;
    }

    public String getMiesiac () {
        return miesiac;
    }

    public void setMiesiac (String miesiac){
        this.miesiac = miesiac;
    }

    public List<Gracz> getUczestnicy () {
        return uczestnicy;
    }

    public void setUczestnicy (List < Gracz > uczestnicy) {
        this.uczestnicy = uczestnicy;
    }

    public List<Wynik> getWyniki() {
        return turnieje;
    }

    public void setWyniki(List<Wynik> turnieje) {
        this.turnieje = turnieje;
    }

    public static List<Turniej> getEkstensja () {
        return ekstensja;
    }

    public static void setEkstensja (List < Turniej > ekstensja) {
        Turniej.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return nazwa + " " + miesiac;
    }
}

