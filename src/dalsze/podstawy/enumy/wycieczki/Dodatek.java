package dalsze.podstawy.enumy.wycieczki;

public enum Dodatek {
    PIERWSZENSTWO_WEJSCIA("Pierwszeństwo wejścia", 100), ZWIEDZANIE("Darmowe zwiedzanie", 45), UBEZPIECZENIE("Ubezpieczenie", 50),
    NIEOGRANICZONE_DRINKI("Nieograniczone drinki", 150), WYPOZYCZENIE_ROWERU("Darmowe wypożyczenie roweru", 220);

    private final String nazwa;
    private final int cena;


    Dodatek(String nazwa, int cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return nazwa + " " + cena;
    }


}
