package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public abstract class Van extends Pojazd {
    private int dlugoscBagaznika;

    private static List<Van> ekstensja = new ArrayList<>();

    public Van(String numerRejestracyjny, String marka, String model, int rokProdukcji, int pojemnoscBaku, boolean dostepnosc, int cenaWypozyczenia, int dlugoscBagaznika) {
        super(numerRejestracyjny, marka, model, rokProdukcji, pojemnoscBaku, dostepnosc, cenaWypozyczenia);
        this.dlugoscBagaznika = dlugoscBagaznika;

        ekstensja.add(this);
    }

    public int getDlugoscBagaznika() {
        return dlugoscBagaznika;
    }

    public void setDlugoscBagaznika(int dlugoscBagaznika) {
        this.dlugoscBagaznika = dlugoscBagaznika;
    }
}
