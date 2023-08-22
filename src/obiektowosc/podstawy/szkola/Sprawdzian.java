package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Sprawdzian {
    private String przedmiot;
    private String data;
    private String opis;
    private List<Ocena> oceny = new ArrayList<>();

    public Sprawdzian(String przedmiot, String data, String opis, List<Ocena> oceny) {
        this.przedmiot = przedmiot;
        this.data = data;
        this.opis = opis;
        this.oceny = new ArrayList<>();
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public List<Ocena> getOceny() {
        return oceny;
    }

    @Override
    public String toString() {
        return przedmiot;
    }
}
