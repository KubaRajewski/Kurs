package dalsze.podstawy.wyjatki.osoba;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sklep {
    private String nazwa;
    private String miasto;

    private List<Osoba> osoby = new ArrayList<>();

    public Sklep(String nazwa, String miasto) {
        this.nazwa = nazwa;
        this.miasto = miasto;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public List<Osoba> getOsoby() {
        return osoby;
    }

    public void setOsoby(List<Osoba> osoby) {
        this.osoby = osoby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sklep sklep)) return false;
        return Objects.equals(nazwa, sklep.nazwa) && Objects.equals(miasto, sklep.miasto) && Objects.equals(osoby, sklep.osoby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, miasto, osoby);
    }

    @Override
    public String toString() {
        return nazwa + ", miasto: " + miasto + ", osoby: " + osoby;
    }
}
