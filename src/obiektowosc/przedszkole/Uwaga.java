package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public abstract class Uwaga {
    private String nazwa;
    private String opis;
    private String dataWystawienia;
    private Dziecko dziecko;

    public static List<Uwaga> ekstensja = new ArrayList<>();

    public Uwaga(String nazwa, String opis, String dataWystawienia, Dziecko dziecko) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataWystawienia = dataWystawienia;
        this.dziecko = dziecko;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDataWystawienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(String dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public static List<Uwaga> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Uwaga> ekstensja) {
        Uwaga.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return "Uczeń: " + dziecko + ", Tytuł: " + nazwa + ", Data: " + dataWystawienia;
    }
}
