package dalsze.podstawy.enumy.kalkulator;

public class KalkulatorStandardowy extends Kalkulator {
    private Operacja operacja;

    public KalkulatorStandardowy(Operacja operacja) {
        this.operacja = operacja;
    }

    @Override
    public double licz(double d1, double d2) {
        switch (operacja) {
            case DODAWANIE:
                return d1 + d2;
            case ODEJMOWANIE:
                return d1 - d2;
            case MNOZENIE:
                return d1 * d2;
            case DZIELENIE:
                if (d2 != 0) {
                    return d1 / d2;
                } else {
                    System.out.println("Nie można dzielić przez zero!");
                    return Double.NaN;
                }
            default:
                System.out.println("Nieobsługiwana operacja");
                return Double.NaN;
        }
    }
}
