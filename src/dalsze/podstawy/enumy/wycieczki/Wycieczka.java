package dalsze.podstawy.enumy.wycieczki;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wycieczka {
    private final String nazwa;
    private final Kraj kraj;
    private double cena;
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

    public double getCena() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wycieczka wycieczka)) return false;
        return cena == wycieczka.cena && Objects.equals(nazwa, wycieczka.nazwa) && kraj == wycieczka.kraj && Objects.equals(zakupy, wycieczka.zakupy) && Objects.equals(ekstensja, wycieczka.ekstensja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, kraj, cena, zakupy, ekstensja);
    }

    @Override
    public String toString() {
        return "Wycieczka{" +
                "nazwa='" + nazwa + '\'' +
                ", kraj=" + kraj +
                ", cena=" + cena +
                ", zakupy=" + zakupy +
                ", ekstensja=" + ekstensja +
                '}';
    }
}
