package dalsze.podstawy.wyjatki.klient;

import dalsze.podstawy.wyjatki.klient.exceptions.ProduktNullException;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private final String imie;
    private final String nazwisko;

    public List<Produkt> produkty = new ArrayList<>();

    public Klient(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void dodajProdukt(Produkt produkt) {
        if (produkt == null) {
            throw new ProduktNullException("Produkt nie moze byc nullem");
        }
        if (produkt.getKlient() != null) {
            throw new IllegalArgumentException("Ten produkt ma juz klienta");
        }
        produkty.add(produkt);
        produkt.setKlient(this);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
