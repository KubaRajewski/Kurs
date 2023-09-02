package obiektowosc.zadania.poprawione.pierwsze;

public class Kondom extends Produkt{
    private String nazwa;
    private double rozmiar;

    public Kondom(String nazwa, double cena, double rozmiar) {
        super(nazwa, cena);
        this.rozmiar = rozmiar;
    }

    public double getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(double rozmiar) {
        this.rozmiar = rozmiar;
    }

    @Override
    public String toString() {
        return nazwa + " " + rozmiar;
    }
}
