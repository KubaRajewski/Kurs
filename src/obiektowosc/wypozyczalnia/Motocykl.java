package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class Motocykl extends Pojazd{
    private boolean czyMoznaNaB;

    private static List<Motocykl> ekstensja = new ArrayList<>();

    public Motocykl(String numerRejestracyjny, String marka, String model, int rokProdukcji, int pojemnoscBaku, boolean dostepnosc, int cenaWypozyczenia, boolean czyMoznaNaB) {
        super(numerRejestracyjny, marka, model, rokProdukcji, pojemnoscBaku, dostepnosc, cenaWypozyczenia);
        this.czyMoznaNaB = czyMoznaNaB;

        ekstensja.add(this);
    }

    public boolean isCzyMoznaNaB() {
        return czyMoznaNaB;
    }

    public void setCzyMoznaNaB(boolean czyMoznaNaB) {
        this.czyMoznaNaB = czyMoznaNaB;
    }
}
