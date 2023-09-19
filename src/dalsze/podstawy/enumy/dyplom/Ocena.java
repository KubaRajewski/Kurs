package dalsze.podstawy.enumy.dyplom;

public class Ocena {
    private Przedmiot przedmiot;
    private OcenaWartosc ocena;
    private Dyplom dyplom;

    public Ocena(Przedmiot przedmiot, OcenaWartosc ocena, Dyplom dyplom) {
        if (dyplom == null) {
            throw new IllegalArgumentException("Dyplom nie moze byc pusty");
        }
        this.przedmiot = przedmiot;
        this.ocena = ocena;
        this.dyplom = dyplom;
        dyplom.getOceny().add(this);
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public OcenaWartosc getOcena() {
        return ocena;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public void setOcena(OcenaWartosc ocena) {
        this.ocena = ocena;
    }

    public Dyplom getDyplom() {
        return dyplom;
    }

    public void setDyplom(Dyplom dyplom) {
        this.dyplom = dyplom;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "przedmiot=" + przedmiot +
                ", ocena=" + ocena +
                '}';
    }
}