package dalsze.podstawy.wyjatki.klient;

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
            throw new IllegalArgumentException();
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
