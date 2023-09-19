package testy.test2.zadanie3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Osoba {
    private static List<Osoba> ekstensja = new ArrayList<>();
    private String imie;
    private String nazwisko;
    private String pesel;
    private String miasto;

    public Osoba(String imie, String nazwisko, String pesel, String miasto) {
        if (imie == null || nazwisko == null || pesel == null) {
            throw new IllegalArgumentException("podaj conajmniej imie, nazwisko i pesel");
        }
        for (Osoba osoba : Osoba.getEkstensja()) {
            if (osoba.getPesel().equals(pesel)) {
                throw new IllegalArgumentException("Pesel nie moze sie powtarzac");
            }
        }

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.miasto = miasto;

        ekstensja.add(this);
    }

    public String getPlec() {
        return (Integer.parseInt(String.valueOf(getPesel().charAt(10))) % 2 == 0) ? "Kobieta" : "Mezczyzna";
    }

    public static List<Osoba> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Osoba> ekstensja) {
        Osoba.ekstensja = ekstensja;
    }

    public abstract double obliczDochod();

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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Osoba osoba)) return false;
        return Objects.equals(imie, osoba.imie) && Objects.equals(nazwisko, osoba.nazwisko) && Objects.equals(pesel, osoba.pesel) && Objects.equals(miasto, osoba.miasto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, pesel, miasto);
    }
}
