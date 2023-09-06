package obiektowosc.podstawy.uml;

import java.util.ArrayList;
import java.util.List;

public class Sprawdzian {
    private String przedmiot;
    private List<Ocena> oceny = new ArrayList<>();

    public Sprawdzian(String przedmiot) {
        this.przedmiot = przedmiot;
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
