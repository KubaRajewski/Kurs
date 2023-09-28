package dalsze.podstawy.interfejsy.dodatkowe.figury;

public class Trojkat implements Figura {
    private final double a, b, c;

    public Trojkat(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double obliczPole() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double obliczObwod() {
        return a + b + c;
    }
}
