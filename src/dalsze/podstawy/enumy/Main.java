package dalsze.podstawy.enumy;

import dalsze.podstawy.enumy.dyplom.Dyplom;
import dalsze.podstawy.enumy.dyplom.NazwaPrzedmiotu;
import dalsze.podstawy.enumy.dyplom.Ocena;
import dalsze.podstawy.enumy.dyplom.OcenaEnum;
import dalsze.podstawy.enumy.kalkulator.KalkulatorStandardowy;
import dalsze.podstawy.enumy.kalkulator.Operacja;
import dalsze.podstawy.enumy.osoba.KolorOczu;
import dalsze.podstawy.enumy.osoba.KolorWlosow;
import dalsze.podstawy.enumy.osoba.Osoba;
import dalsze.podstawy.enumy.wstep.Koszulka;
import dalsze.podstawy.enumy.wstep.Rozmiar;
import dalsze.podstawy.enumy.wycieczki.Dodatek;
import dalsze.podstawy.enumy.wycieczki.Klient;
import dalsze.podstawy.enumy.wycieczki.Kraj;
import dalsze.podstawy.enumy.wycieczki.Wycieczka;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Koszulka kk1 = new Koszulka("adidas", "czerwona", Rozmiar.M);

        System.out.println(kk1.getRozmiar().name());
        System.out.println(kk1.getRozmiar().ordinal());

        System.out.println(Rozmiar.valueOf("M"));

        for (Rozmiar r : Rozmiar.values()) {
            System.out.println(r);
        }

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


        // Stworz klase Dyplom ktora posiada imie i nazwisko, date wystawienia, na
        // dyplomie znajduja sie oceny z przedmiotow(lista klasy Ocena, gdzie ocena ma wartosc i nazwe przedmiotu)
        // stworz kilka dyplomow, znajdz dyplom z najwieksza srednia

        Dyplom dyplom1 = new Dyplom("Jan", "Kowalski", new Date(2023 - 1900, 4, 15));
        dyplom1.dodajOcene(new Ocena(NazwaPrzedmiotu.MATEMATYKA, OcenaEnum.BARDZO_DOBRY));
        dyplom1.dodajOcene(new Ocena(NazwaPrzedmiotu.FIZYKA, OcenaEnum.CELUJACY));
        dyplom1.dodajOcene(new Ocena(NazwaPrzedmiotu.CHEMIA, OcenaEnum.DOSTATECZNY));

        Dyplom dyplom2 = new Dyplom("Anna", "Nowak", new Date(2023 - 1900, 5, 10));
        dyplom2.dodajOcene(new Ocena(NazwaPrzedmiotu.MATEMATYKA, OcenaEnum.CELUJACY));
        dyplom2.dodajOcene(new Ocena(NazwaPrzedmiotu.FIZYKA, OcenaEnum.DOSTATECZNY));
        dyplom2.dodajOcene(new Ocena(NazwaPrzedmiotu.CHEMIA, OcenaEnum.BARDZO_DOBRY));

        System.out.println("\n"+Dyplom.dyplomZNajwiekszaSrednia(Dyplom.getEkstensja()));

        /*
         * Stwórz klase klient i wycieczka, klient moze miec wiele wycieczek, wycieczka
         * moze miec wielu klientow. Wycieczka ma nazwe, kraj, cena i liste dodatkow
         * (kazdy jest dodatkowo platny) Znadz klienta który wydal najwiecej na dodatki
         * do wycieczki uwzgledniajac tez cene wycieczki Znadz klienta który wydal
         * najwiecej na dodatki do wycieczki nieuwzgledniajac tez ceny wycieczki
         */

        Klient k1 = new Klient("Jan", "Kowalski", "123456789");
        Klient k2 = new Klient("Anna", "Nowak", "987654321");
        Klient k3 = new Klient("Janusz", "Kowalski", "123456732");
        Klient k4 = new Klient("Janina", "Kowalska", "123452289");

        Wycieczka w1 = new Wycieczka("Wycieczka1", Kraj.POLSKA, 1000);
        Wycieczka w2 = new Wycieczka("Wycieczka2", Kraj.FRANCJA, 2000);
        Wycieczka w3 = new Wycieczka("Wycieczka3", Kraj.JAPONIA, 1500);
        Wycieczka w4 = new Wycieczka("Wycieczka4", Kraj.AUSTRALIA, 2500);

        List<Dodatek> d1 = List.of(Dodatek.valueOf("UBEZPIECZENIE"));
        List<Dodatek> d2 = List.of(Dodatek.valueOf("PIERWSZENSTWO_WEJSCIA"), Dodatek.valueOf("NIEOGRANICZONE_DRINKI"), Dodatek.valueOf("ZWIEDZANIE"));
        List<Dodatek> d3 = List.of(Dodatek.values());
        List<Dodatek> d4 = List.of((Dodatek.valueOf("ZWIEDZANIE")));

        k1.dodajWycieczke(w1, d1);
        k2.dodajWycieczke(w2, d2);
        k3.dodajWycieczke(w3, d3);
        k4.dodajWycieczke(w4, d4);

        //TODO  Znadz klienta który wydal najwiecej na dodatki do wycieczki uwzgledniajac tez cene wycieczki
        System.out.println("\n"+Klient.wydalNajwiecej(Klient.getEkstensja()));

        //TODO Znadz klienta który wydal * najwiecej na dodatki do wycieczki nieuwzgledniajac ceny wycieczki
        System.out.println(Klient.wydalNajwiecejNaDodatki(Klient.getEkstensja()) + "\n");

        // Napisz kalkulator opierajacy sie o typ wyliczeniowy i metode abstrakcyjna licz(double d1, double d2)

        KalkulatorStandardowy kalkulator = new KalkulatorStandardowy(Operacja.DODAWANIE);
        double wynik = kalkulator.licz(5.0, 3.0);
        System.out.println("Wynik dodawania: " + wynik);

        kalkulator = new KalkulatorStandardowy(Operacja.DZIELENIE);
        wynik = kalkulator.licz(10.0, 0.0); // Przykład dzielenia przez zero
        System.out.println("Wynik dzielenia: " + wynik);
    }
}


