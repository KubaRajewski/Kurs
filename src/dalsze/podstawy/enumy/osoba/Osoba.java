package dalsze.podstawy.enumy.osoba;

import java.util.ArrayList;
import java.util.List;

public class Osoba {
    public static List<Osoba> ekstensja = new ArrayList<>();
    private String imie;
    private String nazwisko;
    private KolorOczu kolorOczu;
    private KolorWlosow kolorWlosow;

    public Osoba(String imie, String nazwisko, KolorOczu kolorOczu, KolorWlosow kolorWlosow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kolorOczu = kolorOczu;
        this.kolorWlosow = kolorWlosow;

        ekstensja.add(this);
    }

//* Napisz ktora zwraca liste osobo o kolorze oczu  podanym jako parametr

    public static List<Osoba> osobyODanymKolorzeOczu(List<Osoba> lista, KolorOczu kolor) {
        if (lista == null) {
            throw new IllegalArgumentException("Lista nie mozeby byc nullem");
        }

        List<Osoba> osobyODanymKolorzeOczu = new ArrayList<>();

        for (Osoba osoba : lista) {
            if (osoba.getKolorOczu() == kolor) {
                osobyODanymKolorzeOczu.add(osoba);
            }
        }

        return osobyODanymKolorzeOczu;
    }

// * Napisz metodę która liczy ile jest osób z kolorem wlosow podanym jako parametr

    public static int ileOsobZDanymKoloremWlosow(List<Osoba> osoby, KolorWlosow kolorWlosow) {
        if (osoby == null) {
            throw new IllegalArgumentException("lista osob jest pusta");
        }

        int count = 0;

        for (Osoba osoba : osoby) {
            if (osoba.getKolorWlosow() == kolorWlosow) {
                count++;
            }
        }

        return count;
    }

// * Napisz metodę która zwraca Osobe o najdluzszym nazwisku z oczami podanymi jako parametr

    public static Osoba osobaONajdluzszymNazwiskuZDanymiOczami(List<Osoba> osoby, KolorOczu kolorOczu) {

        List<Osoba> osobyZDanymKoloremOczu = new ArrayList<>(osobyODanymKolorzeOczu(osoby, kolorOczu));
        if (osobyZDanymKoloremOczu.isEmpty()) {
            throw new IllegalArgumentException("Lista osob jest pusta");
        }

        Osoba osobaONajdluzszymNazwiskuZDanymiOczami = osobyZDanymKoloremOczu.get(0);

        for (Osoba osoba : osobyZDanymKoloremOczu) {
            if (osoba.getNazwisko().length() > osobaONajdluzszymNazwiskuZDanymiOczami.getNazwisko().length()) {
                osobaONajdluzszymNazwiskuZDanymiOczami = osoba;
            }
        }

        return osobaONajdluzszymNazwiskuZDanymiOczami;
    }

    public static List<Osoba> getEkstensja() {
        return ekstensja;
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

    public KolorOczu getKolorOczu() {
        return kolorOczu;
    }

    public void setKolorOczu(KolorOczu kolorOczu) {
        this.kolorOczu = kolorOczu;
    }

    public KolorWlosow getKolorWlosow() {
        return kolorWlosow;
    }

    public void setKolorWlosow(KolorWlosow kolorWlosow) {
        this.kolorWlosow = kolorWlosow;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", kolorOczu=" + kolorOczu +
                ", kolorWlosow=" + kolorWlosow +
                '}';
    }
}
