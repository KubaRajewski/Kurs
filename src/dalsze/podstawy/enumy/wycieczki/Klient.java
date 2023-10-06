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
        if (ekstensja.contains(this)) {
            throw new IllegalArgumentException("Klient juz istnieje");
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

    public void dodajZakup(Wycieczka wycieczka, List<Dodatek> dodatki) {
        Zakup zakup = new Zakup(wycieczka, this);
        zakupy.add(zakup);
        zakup.setKlient(this);
        zakup.setDodatki(dodatki);
    }

    public static Klient wydalNajwiecejNaDodatki(List<Klient> klienci, boolean zCenaWycieczki) {
        if (klienci == null || klienci.isEmpty()) {
            throw new IllegalArgumentException("Lista klientow jest pusta");
        }
        Klient wydalNajwiecej = klienci.get(0);

        if (zCenaWycieczki) {
            for (Klient klient : klienci) {
                if (wydalNajwiecej.ileWydalNajwiecejNaDodatki(true) < klient.ileWydalNajwiecejNaDodatki(true)) {
                    wydalNajwiecej = klient;
                }
            }

            return wydalNajwiecej;
        } else {
            for (Klient klient : klienci) {
                if (wydalNajwiecej.ileWydalNajwiecejNaDodatki(false) < klient.ileWydalNajwiecejNaDodatki(false)){
                    wydalNajwiecej = klient;
                }
            }

            return wydalNajwiecej;
        }
    }

    public double ileWydalNajwiecejNaDodatki(boolean zCenaWycieczki) {
        double max = 0;
        for (Zakup zakup : zakupy) {
            if (zCenaWycieczki) {
                if (zakup.obliczCeneWybranychDodatkow() + zakup.getWycieczka().getCena() > max) {
                    max = zakup.obliczCeneWybranychDodatkow() + zakup.getWycieczka().getCena();
                }
            } else {
                if (zakup.obliczCeneWybranychDodatkow() > max) {
                    max = zakup.obliczCeneWybranychDodatkow();
                }
            }
        }
        return max;
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
