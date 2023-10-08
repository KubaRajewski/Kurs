package dalsze.podstawy.wyjatki.programisci;

import dalsze.podstawy.wyjatki.exceptions.NoJavaProgrammerHere;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programista extends Osoba {
    private List<jezyk> jezyki;
    private double pensja;

    public List<Randka> randki = new ArrayList<>();

    public static List<Programista> ekstensja = new ArrayList<>();

    public Programista(String imie, String nazwisko, List<jezyk> jezyki, double pensja) {
        super(imie, nazwisko);
        this.jezyki = jezyki;
        this.pensja = pensja;

        ekstensja.add(this);
    }

    public void dodajRandke(String nazwa, Miejsce miejsce, Kobieta kobieta) {
        randki.add(new Randka(nazwa, miejsce, kobieta, this));
    }

    public static List<Programista> topProgramisci(List<Programista> List, int n) {
        if (List == null || n < 0 || n > List.size()) {
            throw new IllegalArgumentException("Niepoprawne dane wejściowe");
        }

        List<Programista> programisciJava = new ArrayList<>();

        for (Programista programista : List) {
            if (programista.getJezyki().contains(jezyk.JAVA)) {
                programisciJava.add(programista);
            }
        }

        if (programisciJava.isEmpty()) {
            throw new NoJavaProgrammerHere();
        }

        programisciJava.sort(Comparator.comparingDouble(Programista::getPensja).reversed());

        return programisciJava.subList(0, n);
    }

    public List<jezyk> getJezyki() {
        return jezyki;
    }

    public void setJezyki(List<jezyk> jezyki) {
        this.jezyki = jezyki;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public List<Randka> getRandki() {
        return randki;
    }

    public void setRandki(List<Randka> randki) {
        this.randki = randki;
    }

    @Override
    public String toString() {
        return super.toString() + ", pensja: " + pensja;
    }
}
