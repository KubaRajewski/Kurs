package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Szkolenie {
    private String nazwa;
    private String data;
    private List<Nauczyciel> uczestnicy;

    private static List<Szkolenie> ekstensja =  new ArrayList<>();

    public Szkolenie(String nazwa, String data) {
        this.nazwa = nazwa;
        this.data = data;
        this.uczestnicy = new ArrayList<>(); //  TODO Inicjalizuj listę uczestników w UML tego nie ma

        ekstensja.add(this);
    }

    public void dodajNauczyciela(Nauczyciel n) {
        uczestnicy.add(n);
        n.getSzkolenia().add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Nauczyciel> getUczestnicy() {
        return uczestnicy;
    }

    public void setUczestnicy(List<Nauczyciel> uczestnicy) {
        this.uczestnicy = uczestnicy;
    }

    public static List<Szkolenie> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Szkolenie> ekstensja) {
        Szkolenie.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
