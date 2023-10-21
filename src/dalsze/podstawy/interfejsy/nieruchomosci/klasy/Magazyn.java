package dalsze.podstawy.interfejsy.nieruchomosci.klasy;

import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IBudynek;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Magazyn implements IBudynek {

    private final String adres;
    private final int liczbaPieter;
    private final boolean czyJestGaraz;
    private final BigDecimal cena;
    private final Dzialka dzialka;

    public static List<Magazyn> ekstensja = new ArrayList<>();

    public Magazyn(String adres, int liczbaPieter, boolean czyJestGaraz, Dzialka dzialka, BigDecimal cena) {
        this.adres = adres;
        this.liczbaPieter = liczbaPieter;
        this.czyJestGaraz = czyJestGaraz;
        this.cena = cena;
        this.dzialka = dzialka;

        ekstensja.add(this);
    }


    @Override
    public int getLiczbaPieter() {
        return liczbaPieter;
    }

    @Override
    public boolean getCzyJestGaraz() {
        return czyJestGaraz;
    }

    @Override
    public String getAdres() {
        return adres;
    }

    @Override
    public BigDecimal obliczCeneNieruchomosci() {
        return dzialka.getCena().add(cena);
    }

    @Override
    public BigDecimal obliczPodatekNieruchomosci() {
        return IBudynek.super.obliczPodatekNieruchomosci();
    }


    public BigDecimal getCena() {
        return cena;
    }

    public Dzialka getDzialka() {
        return dzialka;
    }

    public static List<Magazyn> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazyn magazyn)) return false;
        return liczbaPieter == magazyn.liczbaPieter && czyJestGaraz == magazyn.czyJestGaraz && Objects.equals(adres, magazyn.adres) && Objects.equals(cena, magazyn.cena) && Objects.equals(dzialka, magazyn.dzialka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adres, liczbaPieter, czyJestGaraz, cena, dzialka);
    }

    @Override
    public String toString() {
        return "Magazyn{" +
                "adres='" + adres + '\'' +
                ", liczbaPieter=" + liczbaPieter +
                ", czyJestGaraz=" + czyJestGaraz +
                ", cena=" + cena +
                ", dzialka=" + dzialka +
                '}';
    }
}
