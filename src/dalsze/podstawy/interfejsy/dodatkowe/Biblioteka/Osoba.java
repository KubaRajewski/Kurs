package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Osoba {
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko, List<Ksiazka> wypozyczoneKsiazki) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wypozyczoneKsiazki = wypozyczoneKsiazki;
    }

    private List<Ksiazka> wypozyczoneKsiazki = new ArrayList<>();

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

    public List<Ksiazka> getWypozyczoneKsiazki() {
        return wypozyczoneKsiazki;
    }

    public void setWypozyczoneKsiazki(List<Ksiazka> wypozyczoneKsiazki) {
        this.wypozyczoneKsiazki = wypozyczoneKsiazki;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba osoba)) return false;
        return Objects.equals(imie, osoba.imie) && Objects.equals(nazwisko, osoba.nazwisko) && Objects.equals(wypozyczoneKsiazki, osoba.wypozyczoneKsiazki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, wypozyczoneKsiazki);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
