package obiektowosc.podstawy.samochod;

public class Main {
    public static void main(String[] args) {

        /*
            Klasa - naturalny opis obiektu, zestaw cech (atrybutow) i funkcji (metod) dla danego obiektu, np klasa Samochod

            Obiekt - wystapienie (instancja) danej klasy, czyli konkrenty byt, np Twoj samochod honda civic

            Ekstensja klasy - zbior wszystkich obiektow danej klasy
         */

        Samochod s1 = new Samochod("bmw", "m5", 2021, "black", 100000, 80000);
        Samochod s2 = new Samochod("audi", "rs7", 2005, "black", 100000, 80000);
        Samochod s3 = new Samochod("bmw", "x6", 1985, "blue", 100000, 80000);
        Samochod s4 = new Samochod("mercedes", "cla", 2017, "black", 100000, 80000);

        Samochod s5 = new Samochod("toyota", "corolla", 2010, "white", 60000, 120000);
        Samochod s6 = new Samochod("ford", "mustang", 2015, "red", 75000, 50000);
        Samochod s7 = new Samochod("honda", "civic", 2018, "blue", 55000, 75000);
        Samochod s8 = new Samochod("volkswagen", "golf", 2019, "silver", 65000, 90000);
        Samochod s9 = new Samochod("nissan", "altima", 2016, "gray", 55000, 60000);

        Samochod s10 = new Samochod("chevrolet", "cruze", 2014, "red", 45000, 80000);
        Samochod s11 = new Samochod("kia", "rio", 2013, "blue", 40000, 70000);
        Samochod s12 = new Samochod("bmw", "320i", 2015, "black", 60000, 60000);
        Samochod s13 = new Samochod("audi", "a4", 2018, "white", 70000, 55000);
        Samochod s14 = new Samochod("mercedes", "e350", 2016, "silver", 80000, 40000);

        Samochod s15 = new Samochod("toyota", "camry", 2020, "gray", 900, 35000);
        Samochod s16 = new Samochod("ford", "focus", 2019, "red", 55000, 45000);
        Samochod s17 = new Samochod("honda", "accord", 2017, "white", 65000, 55000);
        Samochod s18 = new Samochod("volkswagen", "passat", 2014, "blue", 50000, 70000);
        Samochod s19 = new Samochod("nissan", "sentra", 2012, "black", 35000, 90000);
        Samochod s20 = new Samochod("chevrolet", "malibu", 2015, "silver", 45000, 60000);

        // metoda obiektowa
        System.out.println("metoda obiektowa, obliczanie wieku");
        System.out.println(s1.obliczWiek());
        System.out.println(s3.obliczWiek());
        System.out.println();

        // metoda klasowa
        System.out.println("metoda klasowa, najstarsze auto");
        System.out.println(Samochod.najstarszeAuto(Samochod.getEkstensja()));
        System.out.println();

        //znajdz marke
        System.out.println("wszystkie bmw: " + Samochod.znajdzMarke(Samochod.getEkstensja(), "bmw"));

        //suma cen wszystkich aut
        System.out.println("suma cen wszystkich aut: " + Samochod.suma(Samochod.getEkstensja()));

        // unikalne marki
        System.out.println("unikalne marki: " + Samochod.unikalne(Samochod.getEkstensja()));

        // najnizszy przebieg
        System.out.println("najnizszy przebieg: " + Samochod.najnizszyPrzebieg(Samochod.getEkstensja()));

        // niebieskie starsze niz 15 lat
        System.out.println("niebieskie starsze niz 15 lat: " + Samochod.niebieskieStarszeNiz(Samochod.getEkstensja(), 15));

        // najdrozsze auto z przebiegiem mniejszym niz 30000
        System.out.println("najdrozsze auto z przebiegiem mniejszym niz 30000: " + Samochod.najdrozszeZPrzebiegiemMniejszymNiz(Samochod.getEkstensja(), 30000));

        // najtansze bmw
        System.out.println("najtansze bmw: " + Samochod.najtanszeZMarki(Samochod.getEkstensja(), "bmw"));

        // auta z litera 'a' w nazwie
        System.out.println("auta z litera 'a' w nazwie marki: " + Samochod.markaZLiterkaA(Samochod.getEkstensja(), 'a'));

        // najdrozsze auto gdzie marka jest dluzsza niz 4 znaki
        System.out.println("najdrozsze auto gdzie marka jest dluzsza niz 4 znaki: " + Samochod.najdrozszeMarkiDluzszejNiz(Samochod.getEkstensja(), 4));
    }
}
