package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Grupa {
    private String nazwa;
    private Wychowawca wychowawca;
    private static int MAX_LICZBA_DZIECI = 15;
    private Sala sala;

    private List<Dziecko> dzieci = new ArrayList<>();

    private static List<Grupa> ekstensja = new ArrayList<>();

    public Grupa(String nazwa) {
        this.nazwa = nazwa;
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

    public void dodajSale(Sala sala) {
        this.sala = sala;
        sala.dodajGrupe(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Wychowawca getWychowawca() {
        return wychowawca;
    }

    public void setWychowawca(Wychowawca wychowawca) {
        this.wychowawca = wychowawca;
    }

    public static int getMaxLiczbaDzieci() {
        return MAX_LICZBA_DZIECI;
    }

    public static void setMaxLiczbaDzieci(int maxLiczbaDzieci) {
        MAX_LICZBA_DZIECI = maxLiczbaDzieci;
    }

    public List<Dziecko> getDzieci() {
        return dzieci;
    }

    public void setDzieci(List<Dziecko> dzieci) {
        this.dzieci = dzieci;
    }

    public static List<Grupa> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Grupa> ekstensja) {
        Grupa.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return "Nazwa: " + nazwa + ", Sala: " + sala + ", Wychowawca: " + wychowawca;
    }
}
