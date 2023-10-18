package dalsze.podstawy.interfejsy.zbiornik;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Operacja {
    private String nazwa;
    private LocalDateTime data;
    private Zbiornik zbiornik;
    private double ilosc;
    private boolean czyPowiodloSie;

    public static List<Operacja> ekstensja = new ArrayList<>();

    public Operacja(String nazwa, Zbiornik zbiornik, double ilosc, boolean czyPowiodloSie) {
        this.nazwa = nazwa;
        this.data = LocalDateTime.now();
        this.zbiornik = zbiornik;
        this.ilosc = ilosc;
        this.czyPowiodloSie = czyPowiodloSie;

        ekstensja.add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Zbiornik getZbiornik() {
        return zbiornik;
    }

    public void setZbiornik(Zbiornik zbiornik) {
        this.zbiornik = zbiornik;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public boolean isCzyPowiodloSie() {
        return czyPowiodloSie;
    }

    public void setCzyPowiodloSie(boolean czyPowiodloSie) {
        this.czyPowiodloSie = czyPowiodloSie;
    }

    public static List<Operacja> getEkstensja() {
        return ekstensja;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
