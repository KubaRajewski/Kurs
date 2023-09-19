package dalsze.podstawy.enumy.wycieczki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Klient {
    public static List<Klient> ekstensja = new ArrayList<>();
    private final String imie;
    private final String nazwisko;
    private final String pesel;
    private Map<Wycieczka, List<Dodatek>> wycieczki = new HashMap<>();

    public static List<Klient> getEkstensja() {
        return ekstensja;
    }

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


    public void dodajWycieczke(Wycieczka wycieczka, List<Dodatek> dodatki) {
        wycieczki.put(wycieczka, dodatki);
        wycieczka.getKlienci().add(this);
        wycieczka.setWybraneDodatki(dodatki);
    }


    //TODO  Znadz klienta który wydal najwiecej na dodatki do wycieczki uwzgledniajac tez cene wycieczki
    public static Klient wydalNajwiecej(List<Klient> klienci) {
        if (klienci == null) {
            throw new IllegalArgumentException("Lista klientow nie moze byc pusta");
        }

        Klient wydalNajwiecej = klienci.get(0);

        for (Klient klient : klienci) {
            if (klient.ileNajwiecejWydalNaJednaWycieczke() > wydalNajwiecej.ileNajwiecejWydalNaJednaWycieczke()) {
                wydalNajwiecej = klient;
            }
        }

        return wydalNajwiecej;
    }

    //TODO Znadz klienta który wydal najwiecej na dodatki do wycieczki nieuwzgledniajac ceny wycieczki
    public static Klient wydalNajwiecejNaDodatki(List<Klient> klienci) {
        if (klienci == null) {
            throw new IllegalArgumentException("Lista klientow nie moze byc pusta");
        }

        Klient wydalNajwiecejNaDodatki = klienci.get(0);

        for (Klient klient : klienci) {
            if (klient.ileNajwiecejWydalNaDodatki() > wydalNajwiecejNaDodatki.ileNajwiecejWydalNaDodatki()) {
                wydalNajwiecejNaDodatki = klient;
            }
        }

        return wydalNajwiecejNaDodatki;
    }

    public double ileNajwiecejWydalNaJednaWycieczke() {
        double max = 0;
        for (Wycieczka wycieczka : wycieczki.keySet()) {
            if (wycieczka.obliczCeneWybranychDodatkow() + wycieczka.getCena() > max) {
                max = wycieczka.obliczCeneWybranychDodatkow() + wycieczka.getCena();
            }
        }
        return max;
    }

    public double ileNajwiecejWydalNaDodatki() {
        double max = 0;
        for (Wycieczka wycieczka : wycieczki.keySet()) {
            if (wycieczka.obliczCeneWybranychDodatkow() > max) {
                max = wycieczka.obliczCeneWybranychDodatkow();
            }
        }
        return max;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public Map<Wycieczka, List<Dodatek>> getWycieczki() {
        return wycieczki;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
