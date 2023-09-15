package dalsze.podstawy.enumy.dyplom;

public class Ocena {
    private NazwaPrzedmiotu nazwaPrzedmiotu;
    private OcenaEnum ocena;

    public Ocena(NazwaPrzedmiotu nazwaPrzedmiotu, OcenaEnum ocena) {
        this.nazwaPrzedmiotu = nazwaPrzedmiotu;
        this.ocena = ocena;
    }

    public NazwaPrzedmiotu getNazwaPrzedmiotu() {
        return nazwaPrzedmiotu;
    }

    public OcenaEnum getOcena() {
        return ocena;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "nazwaPrzedmiotu=" + nazwaPrzedmiotu +
                ", ocena=" + ocena +
                '}';
    }
}