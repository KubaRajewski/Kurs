package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Wychowawca extends Osoba{

    private List<Grupa> grupy = new ArrayList<>();

    public static List<Wychowawca> ekstensja = new ArrayList<>();

    public Wychowawca(String imie, String nazwisko, String dataUrodzenia) {
        super(imie, nazwisko, dataUrodzenia);

        ekstensja.add(this);
    }

    public abstract int obliczPensje();

    public boolean czyZarabiaWiecejNiz(double pensja) {
        return obliczPensje() > pensja;
    }

    public static List<Wychowawca> wychowawcyKwalifikowaniZPensjaWiekszNiz(Double pensja) {
        List<Wychowawca> wychowawcyKwalifikowanyZPensjaWiekszNiz = new ArrayList<>();

        for (Wychowawca wychowawca : Wychowawca.getEkstensjaWychowawca()) {
            if (wychowawca instanceof Kwalifikowany) {
                if (wychowawca.czyZarabiaWiecejNiz(pensja)) {
                    wychowawcyKwalifikowanyZPensjaWiekszNiz.add(wychowawca);
                }
            }
        }

        return wychowawcyKwalifikowanyZPensjaWiekszNiz;
    }

    public List<Grupa> getGrupy() {
        return grupy;
    }

    public void setGrupy(List<Grupa> grupy) {
        this.grupy = grupy;
    }

    public static List<Wychowawca> getEkstensjaWychowawca() {
        return ekstensja;
    }

    public static List<Wychowawca> getEkstensjaWychowca() {
        return ekstensja;
    }
}
