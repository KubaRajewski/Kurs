package dalsze.podstawy.wyjatki.programisci;

import dalsze.podstawy.wyjatki.exceptions.BadPlaceForDateException;
import dalsze.podstawy.wyjatki.exceptions.ZaDuzeEgoExeption;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Randka {
    private Miejsce miejsce;
    private final LocalDate data;
    private Kobieta kobieta;
    private Programista programista;

    public static List<Randka> ekstensja = new ArrayList<>();

    public Randka(Miejsce miejsce, Kobieta kobieta, Programista programista) {
        if (miejsce != kobieta.getUlubioneMiejsce()) {
            throw new BadPlaceForDateException();
        }

        this.miejsce = miejsce;
        this.kobieta = kobieta;
        this.programista = programista;
        this.data = LocalDate.now();


        kobieta.getRandki().add(this);
        programista.getRandki().add(this);
        ekstensja.add(this);
    }

    public double obliczSzanseNaZaliczenie() {
        double szansa = getMiejsce().getWartosc() + getKobieta().getRozmiarBiustu().getWartosc() - (getKobieta().getIq() / 10);

        if (szansa > 100) {
            throw new ZaDuzeEgoExeption();
        }

        return szansa;
    }

    public Miejsce getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(Miejsce miejsce) {
        this.miejsce = miejsce;
    }

    public LocalDate getData() {
        return data;
    }

    public Kobieta getKobieta() {
        return kobieta;
    }

    public void setKobieta(Kobieta kobieta) {
        this.kobieta = kobieta;
    }

    public Programista getProgramista() {
        return programista;
    }

    public void setProgramista(Programista programista) {
        this.programista = programista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Randka randka)) return false;
        return miejsce == randka.miejsce && Objects.equals(data, randka.data) && Objects.equals(kobieta, randka.kobieta) && Objects.equals(programista, randka.programista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(miejsce, data, kobieta, programista);
    }

    @Override
    public String toString() {
        return "Randka{" +
                "miejsce=" + miejsce +
                ", data=" + data +
                ", kobieta=" + kobieta +
                ", programista=" + programista +
                '}';
    }
}
