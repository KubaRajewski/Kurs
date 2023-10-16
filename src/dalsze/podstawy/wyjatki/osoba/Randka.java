package dalsze.podstawy.wyjatki.osoba;

import dalsze.podstawy.wyjatki.exceptions.NoHomoHereException;

import java.time.LocalDate;
import java.util.Objects;

public class Randka {
    private Osoba osoba1;
    private Osoba osoba2;
    private String miejsce;
    private LocalDate data;

    public Randka(Osoba osoba1, Osoba osoba2, String miejsce) {
        if (osoba1.getPlec() == osoba2.getPlec()) {
            throw new NoHomoHereException("No homo");
        }
        this.osoba1 = osoba1;
        this.osoba2 = osoba2;
        this.miejsce = miejsce;
        this.data = LocalDate.now();

        osoba1.getRandki().add(this);
        osoba2.getRandki().add(this);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Randka randka)) return false;
        return Objects.equals(osoba1, randka.osoba1) && Objects.equals(osoba2, randka.osoba2) && Objects.equals(miejsce, randka.miejsce) && Objects.equals(data, randka.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(osoba1, osoba2, miejsce, data);
    }

    @Override
    public String toString() {
        return osoba1 + ", " + osoba2 + ", miejsce: " + miejsce;
    }
}
