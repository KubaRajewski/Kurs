package testy.test2.zadanie4;

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
    public String opis() {
        return "Prostokat o bokach " + (int)bokA + "x" + (int)bokB + ".";
    }
}
