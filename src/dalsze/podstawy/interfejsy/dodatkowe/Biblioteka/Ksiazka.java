package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ksiazka {
    private final String tytul;
    private final String autor;
    private final Rodzaj rodzaj;
    private final Year rokWydania;

    public static List<Ksiazka> ekstensja = new ArrayList<>();

    public Ksiazka(String tytul, String autor, Rodzaj rodzaj, Year rokWydania) {
        this.tytul = tytul;
        this.autor = autor;
        this.rodzaj = rodzaj;
        this.rokWydania = rokWydania;

        ekstensja.add(this);
    }

    public String getTytul() {
        return tytul;
    }

    public String getAutor() {
        return autor;
    }

    public Rodzaj getRodzaj() {
        return rodzaj;
    }

    public Year getRokWydania() {
        return rokWydania;
    }

    public static List<Ksiazka> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ksiazka ksiazka)) return false;
        return Objects.equals(tytul, ksiazka.tytul) && Objects.equals(autor, ksiazka.autor) && rodzaj == ksiazka.rodzaj && Objects.equals(rokWydania, ksiazka.rokWydania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, autor, rodzaj, rokWydania);
    }


    @Override
    public String toString() {
        return "\"" + tytul + "\", Autor:  " + autor;
    }
}