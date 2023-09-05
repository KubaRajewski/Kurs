package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public abstract class Osoba {
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;

    public static List<Osoba> ekstensja = new ArrayList<>();

    public Osoba(String imie, String nazwisko, String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;

        ekstensja.add(this);
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

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public static List<Osoba> getEkstensja() {
        return ekstensja;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
