package dalsze.podstawy.wyjatki.osoba;

import dalsze.podstawy.wyjatki.exceptions.NoHomoHereException;

import java.time.LocalDate;

public class Randka {
    private Osoba osoba1;
    private Osoba osoba2;
    private String miejsce;
    private LocalDate data;

    public Randka(Osoba osoba1, Osoba osoba2, String miejsce) {
        if (osoba1.getPlec() == osoba2.getPlec()) {
            throw new NoHomoHereException();
        }
        this.osoba1 = osoba1;
        this.osoba2 = osoba2;
        this.miejsce = miejsce;
        this.data = LocalDate.now();
    }

    public Osoba getOsoba1() {
        return osoba1;
    }

    public void setOsoba1(Osoba osoba1) {
        this.osoba1 = osoba1;
    }

    public Osoba getOsoba2() {
        return osoba2;
    }

    public void setOsoba2(Osoba osoba2) {
        this.osoba2 = osoba2;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return osoba1 + ", " + osoba2 + ", miejsce: " + miejsce;
    }
}
