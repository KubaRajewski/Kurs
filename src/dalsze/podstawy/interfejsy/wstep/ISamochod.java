package dalsze.podstawy.interfejsy.wstep;

public interface ISamochod {

    // stałe public static final
    int LICZBA_KOL = 4;

    // metody abstrakcyjne
    void hamuj();

    void przyspiesz();

    // metoda statyczna

    // metody defaultowe
    default int getLiczbaKol() {
        return LICZBA_KOL;
    }

    default int obliczMocDoDodania(int n) {
        return 50 + dodajMoc(n);
    }

    // metody prywatne
    private int dodajMoc(int n) {
        return 15 * n;
    }


}
