package dalsze.podstawy.interfejsy.zbiornik;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Zbiornik implements IZbiornik{
    private String nazwa;
    private BigDecimal pojemnosc;
    private BigDecimal iloscWody;

    public static List<Zbiornik> ekstensja = new ArrayList<>();

    public Zbiornik(String nazwa, BigDecimal pojemnosc) {
        this.nazwa = nazwa;
        this.pojemnosc = pojemnosc;
        this.iloscWody = BigDecimal.ZERO;

        ekstensja.add(this);
    }

    @Override
    public void dolanieWody(BigDecimal ilosc) {
        if (ilosc.compareTo(pojemnosc) > 0) {
            throw new IllegalArgumentException("Nie można dolać więcej wody niż wynosi pojemność zbiornika");
        }

    }

    @Override
    public void odlanieWody(BigDecimal ilosc) {

    }

    @Override
    public void przelanieWody(Zbiornik zbiornik, BigDecimal ilosc) {

    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(BigDecimal pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public static List<Zbiornik> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Zbiornik> ekstensja) {
        Zbiornik.ekstensja = ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zbiornik zbiornik)) return false;
        return Objects.equals(nazwa, zbiornik.nazwa) && Objects.equals(pojemnosc, zbiornik.pojemnosc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, pojemnosc);
    }

    @Override
    public String toString() {
        return "Zbiornik{" +
                "nazwa='" + nazwa + '\'' +
                ", pojemnosc=" + pojemnosc +
                '}';
    }
}
