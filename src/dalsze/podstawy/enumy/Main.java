package dalsze.podstawy.enumy;

import dalsze.podstawy.enumy.dyplom.Dyplom;
import dalsze.podstawy.enumy.dyplom.Ocena;
import dalsze.podstawy.enumy.dyplom.OcenaWartosc;
import dalsze.podstawy.enumy.dyplom.Przedmiot;
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

import java.util.ArrayList;
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


        //TODO Stworz klase Dyplom ktora posiada imie i nazwisko, date wystawienia, na
        // dyplomie znajduja sie oceny z przedmiotow(lista klasy Ocena, gdzie ocena ma wartosc i nazwe przedmiotu)
        // stworz kilka dyplomow, znajdz dyplom z najwieksza srednia

        Dyplom dyplom1 = new Dyplom("Jan", "Kowalski", new Date(2023, 4, 15));
        Ocena O1 = new Ocena(Przedmiot.MATEMATYKA, OcenaWartosc.BARDZO_DOBRY, dyplom1);
        Ocena O2 = new Ocena(Przedmiot.FIZYKA, OcenaWartosc.DOSTATECZNY, dyplom1);
        Ocena O3 = new Ocena(Przedmiot.CHEMIA, OcenaWartosc.DOSTATECZNY, dyplom1);
        Ocena O4 = new Ocena(Przedmiot.INFORMATYKA, OcenaWartosc.DOBRY, dyplom1);


        Dyplom dyplom2 = new Dyplom("Anna", "Nowak", new Date(2023, 5, 10));
        Ocena O5 = new Ocena(Przedmiot.MATEMATYKA, OcenaWartosc.DOBRY, dyplom2);
        Ocena O6 = new Ocena(Przedmiot.FIZYKA, OcenaWartosc.DOBRY, dyplom2);
        Ocena O7 = new Ocena(Przedmiot.CHEMIA, OcenaWartosc.DOSTATECZNY, dyplom2);
        Ocena O8 = new Ocena(Przedmiot.INFORMATYKA, OcenaWartosc.DOBRY, dyplom2);

        System.out.println("\n" + Dyplom.dyplomZNajwiekszaSrednia(Dyplom.getEkstensja()));

        /*TODO
         * Stwórz klase klient i wycieczka, klient moze miec wiele wycieczek, wycieczka
         * moze miec wielu klientow. Wycieczka ma nazwe, kraj, cena i liste dodatkow
         * (kazdy jest dodatkowo platny) Znadz klienta który wydal najwiecej na dodatki
         * do wycieczki uwzgledniajac tez cene wycieczki Znadz klienta który wydal
         * najwiecej na dodatki do wycieczki nieuwzgledniajac tez ceny wycieczki
         */

        Klient klient1 = new Klient("Jan", "Kowalski", "12345678911");
        Klient klient2 = new Klient("Anna", "Nowak", "98765432112");
        Klient klient3 = new Klient("Janusz", "Kowalski", "12345678921");

        Wycieczka wycieczka1 = new Wycieczka("Wycieczka do chin", Kraj.CHINY, 10000);
        Wycieczka wycieczka2 = new Wycieczka("Wycieczka do francji", Kraj.FRANCJA, 5000);
        Wycieczka wycieczka3 = new Wycieczka("Wycieczka do polski", Kraj.POLSKA, 1000);

        List<Dodatek> pakietStandard = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE));
        List<Dodatek> pakietPremium = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE, Dodatek.PIERWSZENSTWO_WEJSCIA));
        List<Dodatek> pakietPremiumPlus = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE, Dodatek.PIERWSZENSTWO_WEJSCIA, Dodatek.NIEOGRANICZONE_DRINKI, Dodatek.WYPOZYCZENIE_ROWERU));

        klient1.dodajZakup(wycieczka1, pakietStandard);
        klient2.dodajZakup(wycieczka2, pakietPremium);
        klient3.dodajZakup(wycieczka3, pakietPremiumPlus);

//        // Znadz klienta który wydal najwiecej na dodatki do wycieczki uwzgledniajac tez cene wycieczki
        System.out.println("\n" + Klient.wydalNajwiecejNaWycieczke(Klient.getEkstensja(), true));

//        // Znadz klienta który wydal * najwiecej na dodatki do wycieczki nieuwzgledniajac ceny wycieczki
        System.out.println(Klient.wydalNajwiecejNaWycieczke(Klient.getEkstensja(), false) + "\n");

//        // Napisz kalkulator opierajacy sie o typ wyliczeniowy i metode abstrakcyjna licz(double d1, double d2)
        System.out.println(Operacja.DZIELENIE.licz(10,3));
    }
}


