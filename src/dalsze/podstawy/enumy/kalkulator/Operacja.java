package dalsze.podstawy.enumy.kalkulator;

public enum Operacja {
    DODAWANIE {
        @Override
        public double licz(double d1, double d2) {
            return d1 + d2;
        }
    },
    ODEJMOWANIE {
        @Override
        public double licz(double d1, double d2) {
            return d1 - d2;
        }
    },
    MNOZENIE {
        @Override
        public double licz(double d1, double d2) {
            return d1 * d2;
        }
    },
    DZIELENIE {
        @Override
        public double licz(double d1, double d2) {
            return d1 / d2;
        }
    };


    public abstract double licz(double d1, double d2);
}
