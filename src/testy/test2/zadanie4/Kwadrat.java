package testy.test2.zadanie4;

import java.util.Objects;

public class Kwadrat extends Figura {
    private double bok;

    public Kwadrat(double bok) {
        super();
        this.bok = bok;
    }

    @Override
    public double obwod() {
        return 4 * bok;
    }

    @Override
    public double pole() {
        return bok * bok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kwadrat kwadrat)) return false;
        return Double.compare(kwadrat.bok, bok) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bok);
    }

    @Override
    public String opis() {
        return "Kwadrat o boku " + (int)bok + ".";
    }
}
