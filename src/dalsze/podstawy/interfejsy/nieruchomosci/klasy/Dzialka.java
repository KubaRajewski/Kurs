package dalsze.podstawy.interfejsy.nieruchomosci.klasy;

import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IBudynek;
import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IGrunt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dzialka implements IGrunt {
    private final String adres;
    private final double szerokosc;
    private final double dlugosc;
    private final BigDecimal cena;

    private IBudynek budynek;

    public static List<Dzialka> ekstensja = new ArrayList<>();

    public Dzialka(String adres, double szerokosc, double dlugosc, BigDecimal cena) {
        this.adres = adres;
        this.szerokosc = szerokosc;
        this.dlugosc = dlugosc;
        this.cena = cena;

        budynek = null;

        ekstensja.add(this);
    }

    @Override
    public String getAdres() {
        return adres;
    }

    @Override
    public double obliczPowierzchnieGruntu() {
        return szerokosc * dlugosc;
    }

    @Override
    public IBudynek getBudynek() {
        return budynek;
    }

    @Override
    public BigDecimal obliczCeneNieruchomosci() {
        return cena;
    }

    @Override
    public BigDecimal obliczPodatekNieruchomosci() {
        return IGrunt.super.obliczPodatekNieruchomosci();
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public double getDlugosc() {
        return dlugosc;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setBudynek(IBudynek budynek) {
        this.budynek = budynek;
    }

    public static List<Dzialka> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Dzialka> ekstensja) {
        Dzialka.ekstensja = ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dzialka dzialka)) return false;
        return Double.compare(dzialka.szerokosc, szerokosc) == 0 && Double.compare(dzialka.dlugosc, dlugosc) == 0 && Objects.equals(cena, dzialka.cena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(szerokosc, dlugosc, cena);
    }


    @Override
    public String toString() {
        return "Dzialka{" +
                "adres='" + adres  +
                ", szerokosc=" + szerokosc +
                ", dlugosc=" + dlugosc +
                ", cena=" + cena;
    }
}
