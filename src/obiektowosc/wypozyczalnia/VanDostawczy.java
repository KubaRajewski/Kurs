package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class VanDostawczy extends Van {
    private Double ladownosc;

    private static List<VanDostawczy> ekstensja = new ArrayList<>();


    public VanDostawczy(String numerRejestracyjny, String marka, String model, int rokProdukcji, int pojemnoscBaku, boolean dostepnosc, int cenaWypozyczenia, int dlugoscBagaznika, double ladownosc) {
        super(numerRejestracyjny, marka, model, rokProdukcji, pojemnoscBaku, dostepnosc, cenaWypozyczenia, dlugoscBagaznika);
        this.ladownosc = ladownosc;

        ekstensja.add(this);
    }

    public Double getLadownosc() {
        return ladownosc;
    }

    public void setLadownosc(Double ladownosc) {
        this.ladownosc = ladownosc;
    }
}
