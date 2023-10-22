package dalsze.podstawy.interfejsy.nieruchomosci.klasy;

import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IMieszkanie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mieszkanie implements IMieszkanie {

    private final String adres;
    private final BigDecimal powierzchnia;
    private final int liczbaPokoi;
    private final int liczbaPieter;
    private final boolean czyJestGaraz;
    private final boolean czyJestBalkon;
    private final BigDecimal cena;

    public static List<Mieszkanie> ekstensja = new ArrayList<>();

    public Mieszkanie(String adres, BigDecimal powierzchnia, int liczbaPokoi, int liczbaPieter, boolean czyJestGaraz, boolean czyJestBalkon, BigDecimal cena) {
        this.adres = adres;
        this.powierzchnia = powierzchnia;
        this.liczbaPokoi = liczbaPokoi;
        this.liczbaPieter = liczbaPieter;
        this.czyJestGaraz = czyJestGaraz;
        this.czyJestBalkon = czyJestBalkon;
        this.cena = cena;

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
    public boolean getCzyJestBalkon() {
        return czyJestBalkon;
    }

    @Override
    public BigDecimal obliczCeneNieruchomosci() {
        return cena;
    }

    @Override
    public BigDecimal obliczPodatekNieruchomosci() {
        return IMieszkanie.super.obliczPodatekNieruchomosci();
    }

    public static List<Mieszkanie> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mieszkanie that)) return false;
        return liczbaPokoi == that.liczbaPokoi && liczbaPieter == that.liczbaPieter && czyJestGaraz == that.czyJestGaraz && czyJestBalkon == that.czyJestBalkon && Objects.equals(cena, that.cena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liczbaPokoi, liczbaPieter, czyJestGaraz, czyJestBalkon, cena);
    }

    @Override
    public String toString() {
        return "Mieszkanie{" +
                "adres='" + adres + '\'' +
                ", powierzchnia=" + powierzchnia +
                ", liczbaPokoi=" + liczbaPokoi +
                ", liczbaPieter=" + liczbaPieter +
                ", czyJestGaraz=" + czyJestGaraz +
                ", czyJestBalkon=" + czyJestBalkon +
                ", cena=" + cena +
                '}';
    }
}
