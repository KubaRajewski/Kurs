package dalsze.podstawy.interfejsy.dodatkowe.figury;

public class Kolo implements Figura {
    private final double promien;

    public Kolo(double promien) {
        this.promien = promien;
    }

    public double getPromien() {
        return promien;
    }

    @Override
    public double obliczPole() {
        return Math.PI * promien * promien;
    }

    @Override
    public double obliczObwod() {
        return 2 * Math.PI * promien;
    }
}
