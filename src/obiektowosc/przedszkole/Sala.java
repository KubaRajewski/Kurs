package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private static List<Sala> ekstensja = new ArrayList<>();
    private String nazwa;
    private String kolorScian;
    private Grupa grupa;

    public Sala(String nazwa, String kolorScian) {
        this.nazwa = nazwa;
        this.kolorScian = kolorScian;

        ekstensja.add(this);
    }

    public static List<Sala> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Sala> ekstensja) {
        Sala.ekstensja = ekstensja;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKolorScian() {
        return kolorScian;
    }

    public void setKolorScian(String kolorScian) {
        this.kolorScian = kolorScian;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return nazwa + " " + kolorScian;
    }
}
