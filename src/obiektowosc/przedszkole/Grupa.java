package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Grupa {
    private String nazwa;
    private Wychowawca wychowawca;
    private static int MAX_LICZBA_DZIECI = 15;

    private List<Dziecko> dzieci = new ArrayList<>();

    private static List<Grupa> ekstensja = new ArrayList<>();

    public Grupa(String nazwa, Wychowawca wychowawca) {
        this.nazwa = nazwa;
        this.wychowawca = wychowawca;

        ekstensja.add(this);
    }

    public void dodajDziecko(Dziecko dziecko) {
        if (dzieci.size() < MAX_LICZBA_DZIECI) {
            dzieci.add(dziecko);
            dziecko.dodajDoGrupy(this);
        } else {
            System.out.println("Nie można dodać dziecka do grupy " + nazwa + " - grupa jest pełna");
        }
    }

    public void dodajWychowawce(Wychowawca wychowawca) {
        this.wychowawca = wychowawca;
        wychowawca.dodajGrupe(this);
    }
}
