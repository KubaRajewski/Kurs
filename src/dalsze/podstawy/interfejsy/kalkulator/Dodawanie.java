package dalsze.podstawy.interfejsy.kalkulator;

public class Dodawanie implements Dzialanie {
    @Override
    public double licz(double a, double b) {
        return a + b;
    }
}
