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

        try {
            if (produkt == null) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Produkt nie może być nullem, ustalamy produkt na Lamboghini");
            produkt = new Produkt("Lamborghini", 10000000);
        } finally {
            produkty.add(produkt);
            produkt.setKlient(this);
        }
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
