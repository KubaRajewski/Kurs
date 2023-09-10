package testy.test2.zadanie4;

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
    public String opis() {
        return "Kwadrat o boku " + (int)bok + ".";
    }
}