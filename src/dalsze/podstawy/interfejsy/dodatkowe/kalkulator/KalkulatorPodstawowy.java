package dalsze.podstawy.interfejsy.dodatkowe.kalkulator;

public class KalkulatorPodstawowy implements Kalkulator {

    @Override
    public double dodawanie(double a, double b) {
        return a + b;
    }

    @Override
    public double odejmowanie(double a, double b) {
        return a - b;
    }

    @Override
    public double mnozenie(double a, double b) {
        return a * b;
    }

    @Override
    public double dzielenie(double a, double b) {
        if (b == 0) {
            System.out.println("Nie można dzielić przez zero.");
            return Double.NaN;
        }
        return a / b;
    }
}

