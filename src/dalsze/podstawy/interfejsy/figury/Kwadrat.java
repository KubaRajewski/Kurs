package dalsze.podstawy.interfejsy.figury;

public class Kwadrat implements Figura {
    private double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    @Override
    public double obliczPole() {
        return bok*bok;
    }

    @Override
    public double obliczObwod() {
        return bok*4;
    }

    public double getBok() {
        return bok;
    }

    public void setBok(double bok) {
        this.bok = bok;
    }

    @Override
    public String toString() {
        return "Kwadrat{" +
                "bok=" + bok +
                '}';
    }
}
