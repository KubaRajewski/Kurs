package dalsze.podstawy.enumy.wycieczki;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klient {

    private String imie;
    private String nazwisko;
    private final String pesel;
    private List<Zakup> zakupy = new ArrayList<>();

    public static List<Klient> ekstensja = new ArrayList<>();

    public Klient(String imie, String nazwisko, String pesel) {

        if (imie == null || nazwisko == null || pesel == null) {
            throw new IllegalArgumentException("Brak danych");
        }
        for (Klient klient : ekstensja) {
            if (klient.getPesel().equals(pesel)) {
                throw new IllegalArgumentException("Klient o takim peselu juz istnieje");
            }
        }

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;

        ekstensja.add(this);
    }

    //TODO 1 ile wydal na dodatki
    public double ileWydalNaDodatki(){
        double ileWydal = 0;
        for (Zakup zakup : zakupy) {
            ileWydal += zakup.obliczCenyWydatkow();
        }
        return ileWydal;
    }
    //TODO 2 ile wydal na wycieczki
    public double ileWydalNaWycieczki() {
        double ileWydal = 0;
        for (Zakup zakup : zakupy) {
            ileWydal += zakup.getWycieczka().getCena();
        }
        return ileWydal;
    }

    //TODO 3 ile wydal na wszystko
    public double ileWydalNaWszystko(){
        return ileWydalNaDodatki() + ileWydalNaWycieczki();
    }

    public static Klient wydalNajwiecejNaDodatki(List<Klient> klienci) {
        if (klienci == null || klienci.isEmpty()){
            throw new IllegalArgumentException();
        }

        Klient wydalNajwiecejNaDodatki = klienci.get(0);

        for (Klient klient : klienci) {
            if (klient.ileWydalNaDodatki() > wydalNajwiecejNaDodatki.ileWydalNaWycieczki()){
                wydalNajwiecejNaDodatki = klient;
            }
        }

        return wydalNajwiecejNaDodatki;
    }

    public static Klient wydalNajwiecejNaDodatkiIWycieczki(List<Klient> klienci) {
        if (klienci == null || klienci.isEmpty()){
            throw new IllegalArgumentException();
        }

        Klient wydalNajwiecej = klienci.get(0);

        for (Klient klient : klienci) {
            if (klient.ileWydalNaWszystko() > wydalNajwiecej.ileWydalNaWszystko()){
                wydalNajwiecej = klient;
            }
        }

        return wydalNajwiecej;
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

    public String getPesel() {
        return pesel;
    }

    public List<Zakup> getZakupy() {
        return zakupy;
    }

    public void setZakupy(List<Zakup> zakupy) {
        this.zakupy = zakupy;
    }

    public static List<Klient> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klient klient)) return false;
        return Objects.equals(imie, klient.imie) && Objects.equals(nazwisko, klient.nazwisko) && Objects.equals(pesel, klient.pesel) && Objects.equals(zakupy, klient.zakupy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, pesel, zakupy);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
