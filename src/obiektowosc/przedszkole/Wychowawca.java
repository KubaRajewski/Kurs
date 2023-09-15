package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public abstract class Wychowawca extends Osoba {

    public static List<Wychowawca> ekstensja = new ArrayList<>();
    private List<Grupa> grupy = new ArrayList<>();

    public Wychowawca(String imie, String nazwisko, String dataUrodzenia) {
        super(imie, nazwisko, dataUrodzenia);

        ekstensja.add(this);
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

    public static List<Wychowawca> getEkstensjaWychowawca() {
        return ekstensja;
    }

    public static List<Wychowawca> getEkstensjaWychowca() {
        return ekstensja;
    }

    public abstract int obliczPensje();

    public boolean czyZarabiaWiecejNiz(double pensja) {
        return obliczPensje() > pensja;
    }

    public List<Grupa> getGrupy() {
        return grupy;
    }

    public void setGrupy(List<Grupa> grupy) {
        this.grupy = grupy;
    }
}
