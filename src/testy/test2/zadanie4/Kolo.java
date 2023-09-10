package testy.test2.zadanie4;

public class Kolo extends Figura {
    private double srednica;

    public Kolo(double srednica) {
        super();
        this.srednica = srednica;
    }

    @Override
    public double obwod() {
        return 2 * Math.PI * srednica/2;
    }

    @Override
    public double pole() {
        return Math.PI * srednica/2 * srednica/2;
    }

    @Override
    public String opis() {
        return "Koło o promieniu " + (int)srednica/2;
    }
}
