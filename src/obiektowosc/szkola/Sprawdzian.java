package obiektowosc.szkola;

import java.util.ArrayList;
import java.util.List;

public class Sprawdzian {
    private String przedmiot;
    private String data;
    private String opis;
    private List<Ocena> oceny;

    public Sprawdzian(String przedmiot, String data, String opis, List<Ocena> oceny) {
        this.przedmiot = przedmiot;
        this.data = data;
        this.opis = opis;
        this.oceny = new ArrayList<>();
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(List<Ocena> oceny) {
        this.oceny = oceny;
    }

    @Override
    public String toString() {
        return przedmiot;
    }
}
