package dalsze.podstawy.wyjatki.programisci;

public enum RozmiarBiustu {
    A(0), B(10), C(20), D(30), E(40), F(50), G(60);

    private final int wartosc;

    private RozmiarBiustu(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getWartosc() {
        return wartosc;
    }
}

