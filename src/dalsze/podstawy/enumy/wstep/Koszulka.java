package dalsze.podstawy.enumy.wstep;

public class Koszulka {
    private final String producent;
    private final String kolor;
    private final Rozmiar rozmiar;

    public Koszulka(String producent, String kolor, Rozmiar rozmiar) {
        this.producent = producent;
        this.kolor = kolor;
        this.rozmiar = rozmiar;
    }

    public String getProducent() {
        return producent;
    }

    public String getKolor() {
        return kolor;
    }

    public Rozmiar getRozmiar() {
        return rozmiar;
    }

    @Override
    public String toString() {
        return "Koszulka{" +
                "producent='" + producent + '\'' +
                ", kolor='" + kolor + '\'' +
                ", rozmiar=" + rozmiar +
                '}';
    }
}
