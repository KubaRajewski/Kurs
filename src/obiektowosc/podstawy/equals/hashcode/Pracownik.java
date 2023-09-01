package obiektowosc.podstawy.equals.hashcode;

import java.util.Objects;

public class Pracownik {
    private String imie;
    private String naziwsko;
    private double pensja;

    public Pracownik(String imie, String naziwsko, double pensja) {
        this.imie = imie;
        this.naziwsko = naziwsko;
        this.pensja = pensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pracownik pracownik = (Pracownik) o;
        return Objects.equals(imie, pracownik.imie) && Objects.equals(naziwsko, pracownik.naziwsko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, naziwsko);
    }

    public String getImie() {
        return imie;
    }

    public String getNaziwsko() {
        return naziwsko;
    }

    public double getPensja() {
        return pensja;
    }
}
