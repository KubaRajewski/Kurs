package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Uczen extends Osoba {
    private String numerIndeksu;
    private Szkola szkola;

    // Zmienna statyczna do śledzenia wszystkich uczniów
    private static List<Uczen> ekstensja = new ArrayList<>();

    public Uczen(String imie, String nazwisko, String adres, String numerIndeksu) {
        super(imie, nazwisko, adres);

        // Sprawdzanie, czy uczeń o danym numerze indeksu już istnieje w danej szkole
        for (Uczen u : ekstensja) {
            if (u.numerIndeksu.equals(numerIndeksu)) {
                throw new IllegalArgumentException("Uczeń z danym numerem już istnieje");
            }
        }
        this.numerIndeksu = numerIndeksu;
        ekstensja.add(this);
    }

    public String getNumerIndeksu() {
        return numerIndeksu;
    }

    public void setNumerIndeksu(String numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }

    public Szkola getSzkola() {
        return szkola;
    }

    public void setSzkola(Szkola szkola) {
        this.szkola = szkola;
    }

    @Override
    public double obliczDochod() {
        return 100;
    }

    @Override
    public String toString() {
        return getImie() + " " + getNazwisko() + " " + numerIndeksu;
    }

    // Metoda do pobierania wszystkich uczniów
    public static List<Uczen> pobierzEkstensje() {
        return ekstensja;
    }
}
