package dalsze.podstawy.wyjatki.klient;

public class Produkt {
    private final String nazwa;
    private final double cena;

    private Klient klient;

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Klient getKlient() {
        return klient;
    }

    @Override
    public String toString() {
        return nazwa + " za: " + cena;
    }
}
