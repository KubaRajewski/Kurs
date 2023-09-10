package testy.test2.zadanie4;

import java.util.Objects;

public class Prostokat extends Figura {
    private double bokA;
    private double bokB;

    public Prostokat(double bokA, double bokB) {
        super();
        this.bokA = bokA;
        this.bokB = bokB;
    }

    @Override
    public double obwod() {
        return 2 * (bokA + bokB);
    }

    @Override
    public double pole() {
        return bokA * bokB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prostokat prostokat)) return false;
        return Double.compare(prostokat.bokA, bokA) == 0 && Double.compare(prostokat.bokB, bokB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bokA, bokB);
    }

    @Override
    public String opis() {
        return "Prostokat o bokach " + (int)bokA + "x" + (int)bokB + ".";
    }
}
