package dalsze.podstawy.enumy.wycieczki;

public enum Dodatek {
    PIERWSZENSTWO_WEJSCIA( 100), ZWIEDZANIE(45), UBEZPIECZENIE(50),
    NIEOGRANICZONE_DRINKI(150), WYPOZYCZENIE_ROWERU(220);

    private final double cena;

    Dodatek(double cena) {
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return Dodatek.this.name().toLowerCase() + " " + cena;
    }
}
