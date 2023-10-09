package dalsze.podstawy.wyjatki.programisci;

import java.util.ArrayList;
import java.util.List;

public class Kobieta extends Osoba {
    private double iq;
    private RozmiarBiustu rozmiarBiustu;
    private final Miejsce ulubioneMiejsce;

    public List<Randka> randki = new ArrayList<>();

    public static List<Kobieta> ekstensja = new ArrayList<>();

    public Kobieta(String imie, String nazwisko, double iq, RozmiarBiustu rozmiarBiustu) {
        super(imie, nazwisko);
        this.iq = iq;
        this.rozmiarBiustu = rozmiarBiustu;
        this.ulubioneMiejsce = wylosujUlubioneMiejsce();

        ekstensja.add(this);
    }

    public Miejsce wylosujUlubioneMiejsce() {
        return Miejsce.values()[(int) (Math.random() * Miejsce.values().length)];
    }


    public double getIq() {
        return iq;
    }

    public void setIq(double iq) {
        this.iq = iq;
    }

    public RozmiarBiustu getRozmiarBiustu() {
        return rozmiarBiustu;
    }

    public void setRozmiarBiustu(RozmiarBiustu rozmiarBiustu) {
        this.rozmiarBiustu = rozmiarBiustu;
    }

    public Miejsce getUlubioneMiejsce() {
        return ulubioneMiejsce;
    }

    public List<Randka> getRandki() {
        return randki;
    }

    public void setRandki(List<Randka> randki) {
        this.randki = randki;
    }
}
