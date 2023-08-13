package obiektowosc.podstawy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
            Klasa - naturalny opis obiektu, zestaw cech (atrybutow) i funkcji (metod) dla danego obiektu, np klasa Samochod

            Obiekt - wystapienie (instancja) danej klasy, czyli konkrenty byt, np Twoj samochod honda civic

            Ekstensja klasy - zbior wszystkich obiektow danej klasy
         */

        Samochod s1 = new Samochod("bmw", "m5", 2021, "black", 100000, 80000);
        Samochod s2 = new Samochod("audi", "rs7", 2005, "black", 100000, 80000);
        Samochod s3 = new Samochod("bmw", "x6", 1985, "black", 100000, 80000);
        Samochod s4 = new Samochod("merol", "cla", 2017, "black", 100000, 80000);

        System.out.println(s1.getCena());
        s1.setCena(75000);
        System.out.println(s1.getCena());
        System.out.println(s1.getProducent());

        System.out.println(s1);

        System.out.println(Samochod.getEkstensja());

        // metoda obiektowa
        System.out.println(s1.obliczWiek());
        System.out.println(s3.obliczWiek());

        // metoda klasowa
        System.out.println(Samochod.najstarszeAuto(Samochod.getEkstensja()));
        System.out.println(Samochod.najstarszeAuto(null));
    }
}
