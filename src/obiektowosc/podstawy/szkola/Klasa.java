package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Klasa {
    private String nazwa;
    private String profil;
    private final Szkola szkola;

    private static List<Uczen> uczniowie = new ArrayList<>();

    public Klasa(String nazwa, Szkola szkola, String profil) {
        if (szkola == null) throw new IllegalArgumentException("Szkola musi istniec");
        this.nazwa = nazwa;
        this.szkola = szkola;
        this.profil = profil;

        // informacja zwrotna
        szkola.getKlasy().add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public Szkola getSzkola() {
        return szkola;
    }

    public static List<Uczen> getUczniowie() {
        return uczniowie;
    }

    public static void setUczniowie(List<Uczen> uczniowie) {
        Klasa.uczniowie = uczniowie;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public void dodajUcznia(Uczen uczen) {
        if (uczen.getKlasa() != null) {
            throw new IllegalArgumentException("Ten uczen jest juz zapisany do innej klasy");
        }
        uczniowie.add(uczen);
        uczen.setKlasa(this);
    }
}
