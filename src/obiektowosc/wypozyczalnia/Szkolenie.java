package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class Szkolenie {
    private String nazwa;
    private String data;

    private List<Pracownik> uczestnicy = new ArrayList<>();

    private static List<Szkolenie> ekstensja = new ArrayList<>();

    public Szkolenie(String nazwa, String data) {
        this.nazwa = nazwa;
        this.data = data;

        ekstensja.add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Pracownik> getUczestnicy() {
        return uczestnicy;
    }

    public void setUczestnicy(List<Pracownik> uczestnicy) {
        this.uczestnicy = uczestnicy;
    }

    public static List<Szkolenie> getEkstensja() {
        return ekstensja;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
