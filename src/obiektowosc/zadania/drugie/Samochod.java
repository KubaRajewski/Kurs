package obiektowosc.zadania.drugie;

import java.util.ArrayList;
import java.util.List;

public class Samochod {
    private String marka;
    private String model;

    private List<Pracownik> uzytkownicy = new ArrayList<>();

    private static List<Samochod> ekstensja = new ArrayList<>();

    public Samochod(String marka, String model) {
        this.marka = marka;
        this.model = model;

        ekstensja.add(this);
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Pracownik> getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(List<Pracownik> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    public static List<Samochod> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Samochod> ekstensja) {
        Samochod.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return marka + " " + model;
    }
}
