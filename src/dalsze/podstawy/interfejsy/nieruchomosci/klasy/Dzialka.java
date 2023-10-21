package dalsze.podstawy.interfejsy.nieruchomosci.klasy;

import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IGrunt;

import java.math.BigDecimal;
import java.util.Objects;

public class Dzialka implements IGrunt {
    private final String adres;
    private final double szerokosc;
    private final double dlugosc;
    private final BigDecimal cena;

    public Dzialka(String adres, double szerokosc, double dlugosc, BigDecimal cena) {
        this.adres = adres;
        this.szerokosc = szerokosc;
        this.dlugosc = dlugosc;
        this.cena = cena;
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
                "szerokosc=" + szerokosc +
                ", dlugosc=" + dlugosc +
                ", cena=" + cena +
                '}';
    }
}
