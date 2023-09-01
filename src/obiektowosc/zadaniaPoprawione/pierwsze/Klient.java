package obiektowosc.zadaniaPoprawione.pierwsze;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String imie;
    private String nazwisko;
    private double rozmiarPenisa;

    List<Produkt> produkty = new ArrayList<>();

    List<Klient> ekstensja = new ArrayList<>();

    public Klient(String imie, String nazwisko, double rozmiarPenisa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rozmiarPenisa = rozmiarPenisa;

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

    public double getRozmiarPenisa() {
        return rozmiarPenisa;
    }

    public void setRozmiarPenisa(double rozmiarPenisa) {
        this.rozmiarPenisa = rozmiarPenisa;
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    public List<Klient> getEkstensja() {
        return ekstensja;
    }

    public void setEkstensja(List<Klient> ekstensja) {
        this.ekstensja = ekstensja;
    }
}
