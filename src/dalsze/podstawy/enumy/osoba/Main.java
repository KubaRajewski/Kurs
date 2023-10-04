package dalsze.podstawy.enumy.osoba;

public class Main {
    public static void main(String[] args) {
        /*
         * Stworz klase Osoba, imie nazwisko, kolor oczu, kolor wlosow, pomysl co moze byc enumem.
         * Stworz ekstnesje klasy Osoba i napisz metody:
         * Napisz ktora zwraca liste osobo o kolorze oczu  podanym jako parametr
         * Napisz metodę która liczy ile jest osób z kolorem wlosow podanym jako parametr
         * Napisz metodę która zwraca Osobe o najdluzszym nazwisku z oczami podanymi jako parametr
         */

        Osoba o1 = new Osoba("Jan", "Kowalskiiiiiii", KolorOczu.NIEBIESKI, KolorWlosow.BRAZOWY);
        Osoba o3 = new Osoba("Jan", "Kowalski", KolorOczu.NIEBIESKI, KolorWlosow.BRAZOWY);
        Osoba o2 = new Osoba("Janusz", "Kowalski", KolorOczu.ZIELONY, KolorWlosow.BRAZOWY);

        System.out.println(Osoba.osobyODanymKolorzeOczu(Osoba.getEkstensja(), null));
        System.out.println(Osoba.ileOsobZDanymKoloremWlosow(Osoba.getEkstensja(), KolorWlosow.BRAZOWY));
        System.out.println(Osoba.osobaONajdluzszymNazwiskuZDanymiOczami(Osoba.getEkstensja(), KolorOczu.NIEBIESKI));
    }
}
