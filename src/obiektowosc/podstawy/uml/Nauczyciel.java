package obiektowosc.podstawy.uml;

import java.util.ArrayList;
import java.util.List;

public class Nauczyciel extends Osoba {

    private String przedmiot;
    // asocjacja licznosci *
    private List<Szkolenie> szkolenia = new ArrayList<>();

    public Nauczyciel(String imie, String nazwisko, String adres, String przedmiot) {
        super(imie, nazwisko, adres);
        this.przedmiot = przedmiot;
    }

    public List<Szkolenie> getSzkolenia() {
        return szkolenia;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    @Override
    public double obliczDochod() {
        return 3500;
    }
}
