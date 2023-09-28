package dalsze.podstawy.interfejsy.dodatkowe.figury;

public class Kwadrat implements Figura {
    private final double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    public double getBok() {
        return bok;
    }

    @Override
    public double obliczPole() {
        return bok * bok;
    }

    @Override
    public double obliczObwod() {
        return 4 * bok;
    }
}
