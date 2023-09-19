package dalsze.podstawy.enumy.wycieczki;


import java.util.ArrayList;
import java.util.List;

public class Wycieczka {
    private final String nazwa;
    private final Kraj kraj;
    private int cena;
    private List<Zakup> zakupy = new ArrayList<>();

    private List<Wycieczka> ekstensja = new ArrayList<>();

    public Wycieczka(String nazwa, Kraj kraj, int cena) {
        this.nazwa = nazwa;
        this.kraj = kraj;
        this.cena = cena;

        ekstensja.add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public Kraj getKraj() {
        return kraj;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public List<Zakup> getZakupy() {
        return zakupy;
    }

    public void setZakupy(List<Zakup> zakupy) {
        this.zakupy = zakupy;
    }

    public List<Wycieczka> getEkstensja() {
        return ekstensja;
    }

}
