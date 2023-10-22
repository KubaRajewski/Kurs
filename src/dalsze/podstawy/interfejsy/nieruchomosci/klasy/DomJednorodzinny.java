package dalsze.podstawy.interfejsy.nieruchomosci.klasy;

import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IBudynek;
import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IDomJednorodzinny;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DomJednorodzinny implements IDomJednorodzinny {

    private final String adres;
    private final int liczbaPieter;
    private final int liczbaPokoi;
    private BigDecimal powierzchnia;
    private final boolean czyJestGaraz;
    private final boolean czyJestOgrod;
    private final Dzialka dzialka;
    private BigDecimal cenaDomu;

    public static List<DomJednorodzinny> ekstensja = new ArrayList<>();

    public DomJednorodzinny(String adres, int liczbaPieter, int liczbaPokoi, BigDecimal powierzchnia, boolean czyJestGaraz, boolean czyJestOgrod, Dzialka dzialka, BigDecimal cenaDomu) {
        this.adres = adres;
        this.liczbaPieter = liczbaPieter;
        this.liczbaPokoi = liczbaPokoi;
        this.powierzchnia = powierzchnia;
        this.czyJestGaraz = czyJestGaraz;
        this.czyJestOgrod = czyJestOgrod;
        this.cenaDomu = cenaDomu;

        if (!Objects.equals(adres, dzialka.getAdres())) {
            throw new IllegalArgumentException("Adresy muszą być takie same!");
        }

        this.dzialka = dzialka;
        dzialka.setBudynek(this);

        ekstensja.add(this);
    }

    @Override
    public String getAdres() {
        return adres;
    }

    @Override
    public int getLiczbaPokoi() {
        return liczbaPokoi;
    }

    @Override
    public int getLiczbaPieter() {
        return liczbaPieter;
    }

    @Override
    public BigDecimal powierzchnia() {
        return powierzchnia;
    }

    @Override
    public boolean getCzyJestGaraz() {
        return czyJestGaraz;
    }

    @Override
    public boolean czyJestOgrod() {
        return czyJestOgrod;
    }

    @Override
    public double obliczPowierzchnieGruntu() {
        return dzialka.getDlugosc() * dzialka.getSzerokosc();
    }

    @Override
    public IBudynek getBudynek() {
        return this;
    }

    @Override
    public BigDecimal obliczCeneNieruchomosci() {
        return dzialka.getCena().add(cenaDomu);
    }

    @Override
    public BigDecimal obliczPodatekNieruchomosci() {
        return IDomJednorodzinny.super.obliczPodatekNieruchomosci();
    }


    public Dzialka getDzialka() {
        return dzialka;
    }

    public BigDecimal getCenaDomu() {
        return cenaDomu;
    }

    public void setCenaDomu(BigDecimal cenaDomu) {
        this.cenaDomu = cenaDomu;
    }

    public static List<DomJednorodzinny> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomJednorodzinny that)) return false;
        return liczbaPieter == that.liczbaPieter && liczbaPokoi == that.liczbaPokoi && czyJestGaraz == that.czyJestGaraz && czyJestOgrod == that.czyJestOgrod && Objects.equals(dzialka, that.dzialka) && Objects.equals(cenaDomu, that.cenaDomu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liczbaPieter, liczbaPokoi, czyJestGaraz, czyJestOgrod, dzialka, cenaDomu);
    }

    @Override
    public String toString() {
        return "DomJednorodzinny{" +
                "adres='" + adres + '\'' +
                ", liczbaPieter=" + liczbaPieter +
                ", liczbaPokoi=" + liczbaPokoi +
                ", powierzchnia=" + powierzchnia +
                ", czyJestGaraz=" + czyJestGaraz +
                ", czyJestOgrod=" + czyJestOgrod +
                ", dzialka=" + dzialka +
                ", cenaDomu=" + cenaDomu +
                '}';
    }
}
