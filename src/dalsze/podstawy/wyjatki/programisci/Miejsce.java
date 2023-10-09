package dalsze.podstawy.wyjatki.programisci;

public enum Miejsce {

    GOKARTY(0),
    LASER_TAG(10),
    KINO(20),
    PARK(30),
    RESTAURACJA(40),
    TEATR(50);

    private final int wartosc;

    private Miejsce(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getWartosc() {
        return wartosc;
    }
}
