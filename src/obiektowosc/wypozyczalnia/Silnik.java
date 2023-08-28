package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class Silnik {
    private final String typ;
    private final int pojemnosc;
    private final int momentObrotowy;
    private final int moc;

    // relacja z pojazdem 1:* (Silnik jest w wielu pojazdach)
    private List<Pojazd> pojazdyZDanymSilnikiem = new ArrayList<>();

    private static List<Silnik> ekstensja = new ArrayList<>();

    public Silnik(String typ, int pojemnosc, int momentObrotowy, int moc) {
        this.typ = typ;
        this.pojemnosc = pojemnosc;
        this.momentObrotowy = momentObrotowy;
        this.moc = moc;

        ekstensja.add(this);
    }

    public static List<Pojazd> pojazdyZDanymSilnikiem(Silnik silnik) {
        return silnik.getPojazdyZDanymSilnikiem();
    }

    public String getTyp() {
        return typ;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public int getMomentObrotowy() {
        return momentObrotowy;
    }

    public int getMoc() {
        return moc;
    }

    public List<Pojazd> getPojazdyZDanymSilnikiem() {
        return pojazdyZDanymSilnikiem;
    }

    public void setPojazdyZDanymSilnikiem(List<Pojazd> pojazdyZDanymSilnikiem) {
        this.pojazdyZDanymSilnikiem = pojazdyZDanymSilnikiem;
    }

    public static List<Silnik> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Silnik> ekstensja) {
        Silnik.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return typ + " " + pojemnosc;
    }
}
