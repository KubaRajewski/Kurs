package dalsze.podstawy.wyjatki.programisci;

import java.util.ArrayList;
import java.util.List;

public class Kobieta extends Osoba {
    private int iq;
    private RozmiarBiustu rozmiarBiustu;

    public static List<Kobieta> ekstensja = new ArrayList<>();

    public Kobieta(String imie, String nazwisko, int iq, RozmiarBiustu rozmiarBiustu) {
        super(imie, nazwisko);
        this.iq = iq;
        this.rozmiarBiustu = rozmiarBiustu;

        ekstensja.add(this);
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public RozmiarBiustu getRozmiarBiustu() {
        return rozmiarBiustu;
    }

    public void setRozmiarBiustu(RozmiarBiustu rozmiarBiustu) {
        this.rozmiarBiustu = rozmiarBiustu;
    }
}
