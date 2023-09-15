package obiektowosc.szkola;

import java.util.ArrayList;
import java.util.List;

public class Klasa {
    private final Szkola szkola;
    private String nazwa;
    private String profil;
    private List<Uczen> uczniowie = new ArrayList<>(); // Dodaj listę uczniów jako atrybut instancji

    public Klasa(String nazwa, Szkola szkola, String profil, List<Uczen> uczniowie) {
        if (szkola == null) throw new IllegalArgumentException("Szkola musi istniec");
        this.nazwa = nazwa;
        this.szkola = szkola;
        this.profil = profil;
        this.uczniowie = uczniowie;

        // informacja zwrotna
        szkola.getKlasy().add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public Szkola getSzkola() {
        return szkola;
    }

    public List<Uczen> getUczniowie() {
        return uczniowie;
    }

    // Setter for uczniowie
    public void setUczniowie(List<Uczen> uczniowie) {
        this.uczniowie = uczniowie;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public void dodajUcznia(Uczen uczen) {
        uczniowie.add(uczen);
    }
}
