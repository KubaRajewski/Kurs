package testy.test2.zadanie3;

import java.util.Objects;

public class Pracownik extends Osoba {
    private String stanowisko;
    private double pensja;

    public Pracownik(String imie, String nazwisko, String pesel, String miasto, String stanowisko, double pensja) {
        super(imie, nazwisko, pesel, miasto);
        this.stanowisko = stanowisko;
        this.pensja = pensja;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    @Override
    public double obliczDochod() {
        return pensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pracownik pracownik)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(pracownik.pensja, pensja) == 0 && Objects.equals(stanowisko, pracownik.stanowisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stanowisko, pensja);
    }
}
