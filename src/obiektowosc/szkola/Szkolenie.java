package obiektowosc.szkola;

import java.util.ArrayList;
import java.util.List;

public class Szkolenie {
    private String nazwa;
    private String data;
    private List<Nauczyciel> uczestnicy;

    private List<Szkolenie> ekstensja = new ArrayList<>();

    public Szkolenie(String nazwa, String data) {
        this.nazwa = nazwa;
        this.data = data;
        this.uczestnicy = new ArrayList<>();

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

    public List<Szkolenie> getEkstensja() {
        return ekstensja;
    }

    public void setEkstensja(List<Szkolenie> ekstensja) {
        this.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
