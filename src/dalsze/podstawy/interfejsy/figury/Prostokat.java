package dalsze.podstawy.interfejsy.figury;

public class Prostokat implements Figura {
    private double dlugosc;
    private double szerokosc;

    public Prostokat(double dlugosc, double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    @Override
    public double obliczPole() {
        return dlugosc * szerokosc;
    }

    @Override
    public double obliczObwod() {
        return (2 * dlugosc) + (2 * szerokosc);
    }

    public double getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(double dlugosc) {
        this.dlugosc = dlugosc;
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    @Override
    public String toString() {
        return "Prostokat{" +
                "dlugosc=" + dlugosc +
                ", szerokosc=" + szerokosc +
                '}';
    }
}
