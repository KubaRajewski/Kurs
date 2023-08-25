package obiektowosc.zadania.drugie;

import java.util.ArrayList;
import java.util.List;

public class Samochod {
    private String model;
    private String marka;
    private Pracownik uzytkownik;
    private List<Samochod> ekstensja = new ArrayList<>();

    public Samochod(String model, String marka) {
        this.model = model;
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public List<Samochod> getEkstensja() {
        return ekstensja;
    }

    public void setEkstensja(List<Samochod> ekstensja) {
        this.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return marka + " " + model;
    }
}
