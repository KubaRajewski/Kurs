package obiektowosc.podstawy.uml;

import java.util.ArrayList;
import java.util.List;

public class Uczen extends Osoba {

    private String numerIndeksu;
    private List<Ocena> oceny = new ArrayList<>();

    // asoacjaja licznosci 1
    private Szkola szkola;

    public Uczen(String imie, String nazwisko, String adres, String numerIndeksu) {
        super(imie, nazwisko, adres);
        this.numerIndeksu = numerIndeksu;
    }
    @Override
    public double obliczDochod() {
        return 350;
    }

    public Szkola getSzkola() {
        return szkola;
    }

    public void setSzkola(Szkola szkola) {
        this.szkola = szkola;
    }

    public String getNumerIndeksu() {
        return numerIndeksu;
    }

    public List<Ocena> getOceny() {
        return oceny;
    }
}
