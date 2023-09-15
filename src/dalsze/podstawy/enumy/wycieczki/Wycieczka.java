package dalsze.podstawy.enumy.wycieczki;

import java.util.ArrayList;
import java.util.List;

public class Wycieczka {
    private final String nazwa;
    private final Kraj kraj;
    private final List<Dodatek> mozliweDodatki;
    private int cena;
    private List<Dodatek> wybraneDodatki = new ArrayList<>();
    private List<Klient> klienci = new ArrayList<>();

    private List<Wycieczka> ekstensja = new ArrayList<>();

    public Wycieczka(String nazwa, Kraj kraj, int cena) {
        this.nazwa = nazwa;
        this.kraj = kraj;
        this.cena = cena;
        this.mozliweDodatki = List.of(Dodatek.values());

        ekstensja.add(this);
    }

    public double obliczCeneWybranychDodatkow() {
        double suma = 0;
        for (Dodatek dodatek : wybraneDodatki) {
            suma += dodatek.getCena();
        }
        return suma;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Kraj getKraj() {
        return kraj;
    }

    public List<Dodatek> getWybraneDodatki() {
        return wybraneDodatki;
    }

    public void setWybraneDodatki(List<Dodatek> wybraneDodatki) {
        this.wybraneDodatki = wybraneDodatki;
    }

    public List<Dodatek> getMozliweDodatki() {
        return mozliweDodatki;
    }

    public List<Klient> getKlienci() {
        return klienci;
    }

    public void setKlienci(List<Klient> klienci) {
        this.klienci = klienci;
    }

    public List<Wycieczka> getEkstensja() {
        return ekstensja;
    }
}
