package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Odznaka extends Uwaga {

    public static List<Odznaka> ekstensja = new ArrayList<>();

    public Odznaka(String nazwa, String opis, String dataWystawienia, Dziecko dziecko) {
        super(nazwa, opis, dataWystawienia, dziecko);

        ekstensja.add(this);
    }

    public static List<Odznaka> getEkstensjaOdznaka() {
        return ekstensja;
    }
}