package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class Mechanik extends Pracownik {
    private static List<Mechanik> ekstensja = new ArrayList<>();
    private String specjalizacja;

    public Mechanik(String imie, String nazwisko, String adres, String numerDowodu, int pensja, String rodzajUmowy, String specjalizacja) {
        super(imie, nazwisko, adres, numerDowodu, pensja, rodzajUmowy);
        this.specjalizacja = specjalizacja;

        ekstensja.add(this);
    }

    public static List<Mechanik> getEkstensjaMechnik() {
        return ekstensja;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }
}
