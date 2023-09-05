package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Przewinienie extends Uwaga{

    public static List<Przewinienie> ekstensja = new ArrayList<>();

    public Przewinienie(String nazwa, String opis, String dataWystawienia, Dziecko dziecko) {
        super(nazwa, opis, dataWystawienia, dziecko);

        ekstensja.add(this);
    }

    public static List<Przewinienie> getEkstensjaPrzewinienie() {
        return ekstensja;
    }
}
