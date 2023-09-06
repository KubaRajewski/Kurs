package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Uwaga {
    private final String nazwa;
    private final String opis;
    private final String dataWystawienia;
    private final Dziecko dziecko;

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

    public String getOpis() {
        return opis;
    }

    public String getDataWystawienia() {
        return dataWystawienia;
    }

    public Dziecko getDziecko() {
        return dziecko;
    }

    public static List<Uwaga> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Uwaga> ekstensja) {
        Uwaga.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        if (this instanceof Przewinienie)
            return "Typ: Przewinienie, " +  "Uczeń: " + dziecko + ", Tytuł: " + nazwa + ", Data: " + dataWystawienia;
        else if (this instanceof Odznaka)
            return "Typ: Odznaka, " + "Uczeń: " + dziecko + ", Tytuł: " + nazwa + ", Data: " + dataWystawienia;
        else {
            return "Uwaga nieznanego typu, cos poszlo nie tak.";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uwaga uwaga = (Uwaga) o;
        return Objects.equals(nazwa, uwaga.nazwa) && Objects.equals(opis, uwaga.opis) && Objects.equals(dataWystawienia, uwaga.dataWystawienia) && Objects.equals(dziecko, uwaga.dziecko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, opis, dataWystawienia, dziecko);
    }
}
