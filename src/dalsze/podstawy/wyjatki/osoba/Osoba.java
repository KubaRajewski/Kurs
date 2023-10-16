package dalsze.podstawy.wyjatki.osoba;

import dalsze.podstawy.wyjatki.exceptions.NoWomenExeption;
import dalsze.podstawy.wyjatki.exceptions.ShopsAreOnlyForWomenException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Osoba {
    private String imie;
    private String nazwisko;
    private String miasto;
    private final Plec plec;
    private int wiek;

    private List<Sklep> sklepy = new ArrayList<>();
    private List<Randka> randki = new ArrayList<>();

    public static List<Osoba> ekstensja = new ArrayList<>();

    public Osoba(String imie, String nazwisko, String miasto, Plec plec, int wiek) {
        if (wiek < 18) {
            throw new IllegalArgumentException(imie + " " + nazwisko + " " + miasto + " " + plec);
        }

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.plec = plec;
        this.wiek = wiek;

        ekstensja.add(this);
    }

    public void dodajSklep(Sklep sklep) {
        if (sklep == null) {
            throw new IllegalArgumentException("Sklep nie moze byc nullem");
        }
        if (plec == Plec.MEZCZYZNA) {
            throw new ShopsAreOnlyForWomenException("Sklepy sa tylko dla kobiet");
        }

        sklepy.add(sklep);
        sklep.getOsoby().add(this);
    }

    public static List<Osoba> listaKobiet(List<Osoba> osoby){
        if (osoby == null) {
            throw new IllegalArgumentException("Lista jest pusta");
        }

        List<Osoba> kobiety = new ArrayList<>();

        for (Osoba osoba : osoby) {
            if (osoba.getPlec() == Plec.KOBIETA) {
                kobiety.add(osoba);
            }
        }

        if (kobiety.isEmpty()) {
            throw new NoWomenExeption("Brak kobiet na liscie");
        }

        return kobiety;
    }

    // - metoda co zwraca najstarsza kobiete lub NoWomenException jesli brak kobiet na liscie
    public static Osoba najstarszaKobieta(List<Osoba> osoby) {
        if (osoby == null || osoby.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta");
        }

        List<Osoba> kobiety = listaKobiet(osoby);
        Osoba najstarszaKobieta = kobiety.get(0);

        for (Osoba osoba : kobiety) {
            if (osoba.getWiek() > najstarszaKobieta.getWiek()) {
                najstarszaKobieta = osoba;
            }
        }

        return najstarszaKobieta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public Plec getPlec() {
        return plec;
    }

    public List<Sklep> getSklepy() {
        return sklepy;
    }

    public List<Randka> getRandki() {
        return randki;
    }

    public static List<Osoba> getEkstensja() {
        return ekstensja;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba osoba)) return false;
        return wiek == osoba.wiek && Objects.equals(imie, osoba.imie) && Objects.equals(nazwisko, osoba.nazwisko) && Objects.equals(miasto, osoba.miasto) && plec == osoba.plec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, miasto, plec, wiek);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + ", miasto: " + miasto + ", wiek: " + wiek;
    }
}
