package dalsze.podstawy.interfejsy.dodatkowe.figury;

public class Prostokat implements Figura{

    private final double bokA;
    private final double bokB;

    public Prostokat(double bokA, double bokB) {
        this.bokA = bokA;
        this.bokB = bokB;
    }

    public double getBokA() {
        return bokA;
    }

    public double getBokb() {
        return bokB;
    }

    @Override
    public double obliczPole() {
        return bokA*bokB;
    }

    @Override
    public double obliczObwod() {
        return (2*bokA) + (2*bokB);
    }
}
