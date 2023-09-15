package testy.test2.zadanie4;

import java.util.Objects;

public class Kolo extends Figura {
    private double srednica;

    public Kolo(double srednica) {
        super();
        this.srednica = srednica;
    }

    @Override
    public double obwod() {
        return 2 * Math.PI * srednica / 2;
    }

    @Override
    public double pole() {
        return Math.PI * srednica / 2 * srednica / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kolo kolo)) return false;
        return Double.compare(kolo.srednica, srednica) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(srednica);
    }

    @Override
    public String opis() {
        return "Koło o promieniu " + (int) srednica / 2;
    }
}
