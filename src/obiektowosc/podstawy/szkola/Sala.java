package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nazwa;
    private final Szkola szkola;

    public Sala(String nazwa, Szkola szkola) {
        if (szkola == null) throw new IllegalArgumentException("Szkola musi istniec");
        this.nazwa = nazwa;
        this.szkola = szkola;

        // informacja zwrotna
        szkola.getSale().add(this);
    }


    public String getNazwa() {
        return nazwa;
    }

    public Szkola getSzkola() {
        return szkola;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
