package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class WychowawcaTymczasowy extends Wychowawca {

    private static final int STAWKA_GODZINOWA = 35;
    private final int liczbaGodzin;

    private static List<WychowawcaTymczasowy> ekstensja = new ArrayList<>();

    public WychowawcaTymczasowy(String imie, String nazwisko, String dataUrodzenia, int liczbaGodzin) {
        super(imie, nazwisko, dataUrodzenia);
        this.liczbaGodzin = liczbaGodzin;

        ekstensja.add(this);
    }

    @Override
    public int obliczPensje() {
        return liczbaGodzin * STAWKA_GODZINOWA;
    }

    @Override
    public String toString() {
        return super.toString() + ", Liczba godzin: " + liczbaGodzin;
    }
}
