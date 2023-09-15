package dalsze.podstawy.enumy.wstep;

public enum Rozmiar {
    S(50, 60), M(55, 65), L(60, 75), XL(70, 90);

    private final int dlugosc;
    private final int szerokosc;

    Rozmiar(int dlugosc, int szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    @Override
    public String toString() {
        return "Rozmiar{" +
                "dlugosc=" + dlugosc +
                ", szerokosc=" + szerokosc +
                '}';
    }
}
