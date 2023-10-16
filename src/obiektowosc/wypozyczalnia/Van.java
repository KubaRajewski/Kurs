package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public abstract class Van extends Pojazd {
    private final double dlugoscBagaznika;

    private static List<Van> ekstensja = new ArrayList<>();

    public Van(String numerRejestracyjny, String marka, String model, int rokProdukcji, int pojemnoscBaku, boolean dostepnosc, int cenaWypozyczenia, double dlugoscBagaznika) {
        super(numerRejestracyjny, marka, model, rokProdukcji, pojemnoscBaku, dostepnosc, cenaWypozyczenia);
        this.dlugoscBagaznika = dlugoscBagaznika;

        ekstensja.add(this);
    }

    public static List<Van> vanyZPakaDluzszaNiz(List<Van> vany, double dlugosc) {
        List<Van> vanyZPakaDluzszaNiz = new ArrayList<>();
        for (Van v : vany) {
            if (v.dlugoscBagaznika > dlugosc) {
                vanyZPakaDluzszaNiz.add(v);
            }
        }
        return vanyZPakaDluzszaNiz;
    }

    public static List<Van> getEkstensjaVan() {
        return ekstensja;
    }

    public double getDlugoscBagaznika() {
        return dlugoscBagaznika;
    }
}
