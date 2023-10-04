package dalsze.podstawy.enumy.dyplom;

import dalsze.podstawy.enumy.osoba.KolorOczu;
import dalsze.podstawy.enumy.osoba.KolorWlosow;
import dalsze.podstawy.enumy.osoba.Osoba;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

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
    }
}
