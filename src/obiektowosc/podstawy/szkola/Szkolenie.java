package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Szkolenie {
    private String nazwa;
    private String data;
    private List<Nauczyciel> uczestnicy; // Zmiana nazwy listy nauczycieli na uczestnicy

    private static List<Szkolenie> ekstensja =  new ArrayList<>();

    public Szkolenie(String nazwa, String data) {
        this.nazwa = nazwa;
        this.data = data;
        this.uczestnicy = new ArrayList<>(); // Inicjalizuj listę uczestników

        ekstensja.add(this);
    }

    public void dodajNauczyciela(Nauczyciel n) {
        uczestnicy.add(n);
        // info zwrotne
        n.getSzkolenia().add(this);
    }

    public static List<Szkolenie> getEkstensja() {
        return ekstensja;
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

    @Override
    public String toString() {
        return "Szkolenie{" +
                "uczestnicy=" + uczestnicy +
                '}';
    }
}
