package obiektowosc.zadania.drugie;

import java.util.ArrayList;
import java.util.List;

public class Pracownik {
    private String imie;
    private String nazwisko;
    private String adres;
    private int pensja;
    private Samochod samochod;

    List<Pracownik> ekstensja = new ArrayList<>();

    public Pracownik(String imie, String nazwisko, String adres, int pensja, Samochod samochod) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.pensja = pensja;
        this.samochod = samochod;

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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
