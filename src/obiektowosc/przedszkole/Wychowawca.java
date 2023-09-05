package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public abstract class Wychowawca extends Osoba{

    private List<Grupa> grupy = new ArrayList<>();

    public static List<Wychowawca> ekstensja = new ArrayList<>();

    public Wychowawca(String imie, String nazwisko, String dataUrodzenia) {
        super(imie, nazwisko, dataUrodzenia);

        ekstensja.add(this);
    }


    public abstract int obliczPensje();

    public static List<Wychowawca> getEkstensjaWychowca() {
        return ekstensja;
    }

    public void dodajGrupe(Grupa grupa) {
        grupy.add(grupa);
    }
}
