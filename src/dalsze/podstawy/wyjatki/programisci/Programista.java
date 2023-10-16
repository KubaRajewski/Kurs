package dalsze.podstawy.wyjatki.programisci;

import dalsze.podstawy.wyjatki.exceptions.NoJavaProgrammerHereException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programista extends Osoba {
    private List<Jezyk> jezyki;
    private double pensja;

    public List<Randka> randki = new ArrayList<>();

    public static List<Programista> ekstensja = new ArrayList<>();

    public Programista(String imie, String nazwisko, List<Jezyk> jezyki, double pensja) {
        super(imie, nazwisko);
        this.jezyki = jezyki;
        this.pensja = pensja;

        ekstensja.add(this);
    }

    public static List<Programista> programisciJava(List<Programista> programisci) {
        if (programisci == null || programisci.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<Programista> programisciJava = new ArrayList<>();

        for (Programista programista : programisci) {
            if (programista.getJezyki().contains(Jezyk.JAVA)) {
                programisciJava.add(programista);
            }
        }

        if (programisciJava.isEmpty()) {
            throw new NoJavaProgrammerHereException();
        }

        return programisciJava;
    }

    public static List<Programista> topProgramisci(List<Programista> list, int n) {
        if (n < 0 || n > list.size()) {
            throw new IllegalArgumentException("Niepoprawne dane wejściowe");
        }

        List<Programista> programisciJava = programisciJava(list);
        programisciJava.sort(Comparator.comparingDouble(Programista::getPensja).reversed());

        return programisciJava.subList(0, n);
    }

    public List<Jezyk> getJezyki() {
        return jezyki;
    }

    public void setJezyki(List<Jezyk> jezyki) {
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
