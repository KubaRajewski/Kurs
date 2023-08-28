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

    public static List<Motocykl> motocykleNaB (List<Motocykl> motocykle){
        List<Motocykl> moznaNaB = new ArrayList<>();
        for (Motocykl m : motocykle) {
            if (m.isCzyMoznaNaB()){
                moznaNaB.add(m);
            }
        }
        return moznaNaB;
    }

    public boolean isCzyMoznaNaB() {
        return czyMoznaNaB;
    }

    public void setCzyMoznaNaB(boolean czyMoznaNaB) {
        this.czyMoznaNaB = czyMoznaNaB;
    }

    public static List<Motocykl> getEkstensjaMotocykl() {
        return ekstensja;
    }
}
