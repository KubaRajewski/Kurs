package obiektowosc.turniej;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gracz {
    private String imie;
    private String nazwisko;

    private List<Turniej> turnieje = new ArrayList<>();

    private Map<Turniej, Map<Integer, Integer>> wynikiGracza = new HashMap<>();

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

    public void dodajWynik(Turniej turniej, int pozycja, int punkty) {
        if (!turnieje.contains(turniej)) {
            System.out.println("Ten gracz nie jest zapisany na ten turniej");
            return;
        }
        wynikiGracza.put(turniej, new HashMap<>());
        wynikiGracza.get(turniej).put(pozycja, punkty);
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

    public Map<Turniej, Map<Integer, Integer>> getWynikiGracza() {
        return wynikiGracza;
    }

    public void setWynikiGracza(Map<Turniej, Map<Integer, Integer>> wynikiGracza) {
        this.wynikiGracza = wynikiGracza;
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
