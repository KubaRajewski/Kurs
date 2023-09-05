package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Wychowawca extends Osoba{

    public static List<Wychowawca> ekstensja = new ArrayList<>();

    public Wychowawca(String imie, String nazwisko, String dataUrodzenia) {
        super(imie, nazwisko, dataUrodzenia);

        ekstensja.add(this);
    }

    public static List<Wychowawca> getEkstensjaWychowca() {
        return ekstensja;
    }
}
