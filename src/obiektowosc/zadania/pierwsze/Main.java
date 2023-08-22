package obiektowosc.zadania.pierwsze;

import java.util.List;


//        TODO 1
//        Klient kupuje produkty. Klient ma imie nazwisko i rozmiar penisa. Pordukt ma nazwe, cene i jesli jest to kondom to wymiar
//        Klient moze miec wiele produktow, produkt moze miec jednego klienta.


public class Main {
    public static void main(String[] args) {

        // Klienci
        Klient k1 = new Klient("Mateusz", "Morawiecki", 8);
        Klient k2 = new Klient("Mariusz", "Błaszczak", 6);
        Klient k3 = new Klient("Antoni", "Macierewicz", 3);
        Klient k4 = new Klient("Janusz", "Kowalski", 7);
        Klient k5 = new Klient("Jarosław", "Kaczyński", 10);
        Klient k6 = new Klient("Andrzej", "Duda", 6);
        Klient k7 = new Klient("Marek", "Suski", 7);
        Klient k8 = new Klient("Jacek", "Sasin", 5);
        Klient k9 = new Klient("Marek", "Ast", 8);
        Klient k10 = new Klient("Zbigniew", "Ziobro", 3);

        // Produkty
        Produkt p1 = new Produkt("Kondom Durex", 12, 15);
        Produkt p2 = new Produkt("Kondom Durex Small", 11.50, 10);
        Produkt p3 = new Produkt("Kondom Durex xSmall", 11, 8);
        Produkt p4 = new Produkt("Kondom Durex xxSmall", 10.50, 6);
        Produkt p5 = new Produkt("Mąka", 6.7);
        Produkt p6 = new Produkt("Chleb", 3.5);
        Produkt p7 = new Produkt("Jogurt", 2.0);
        Produkt p8 = new Produkt("Ser", 4.5);
        Produkt p9 = new Produkt("Mleko", 2.2);
        Produkt p10 = new Produkt("Jabłka", 1.0);
        Produkt p11 = new Produkt("Banan", 1.5);
        Produkt p12 = new Produkt("Makaron", 2.3);
        Produkt p13 = new Produkt("Płatki śniadaniowe", 5.0);
        Produkt p14 = new Produkt("Jajka", 3.8);
        Produkt p15 = new Produkt("Ryż", 4.2);
        Produkt p16 = new Produkt("Pomarańcze", 1.8);
        Produkt p17 = new Produkt("Cytryny", 2.0);
        Produkt p18 = new Produkt("Czekolada", 2.5);
        Produkt p19 = new Produkt("Kawa", 8.0);
        Produkt p20 = new Produkt("Herbata", 3.0);
        Produkt p21 = new Produkt("Sok pomarańczowy", 2.5);
        Produkt p22 = new Produkt("Piwo", 2.2);
        Produkt p23 = new Produkt("Wino", 12.5);
        Produkt p24 = new Produkt("Kiełbasa", 6.0);
        Produkt p25 = new Produkt("Ketchup", 1.5);
        Produkt p26 = new Produkt("Majonez", 2.0);
        Produkt p27 = new Produkt("Chipsy", 3.0);
        Produkt p28 = new Produkt("Orzechy", 5.5);
        Produkt p29 = new Produkt("Cukier", 2.0);
        Produkt p30 = new Produkt("Sól", 1.0);

        // Zakupy
        k1.dodajProdukt(List.of(p1, p5, p10, p10, p10, p16, p18, p9, p26, p23));
        k2.dodajProdukt(List.of(p2, p6, p11, p21, p27, p7));
        k3.dodajProdukt(List.of(p3, p13, p26, p8, p15));
        k4.dodajProdukt(List.of(p4, p14, p25, p29, p20));
        k5.dodajProdukt(List.of(p5, p15, p19, p10, p30, p14));
        k6.dodajProdukt(List.of(p6, p16, p26, p7, p27, p19));
        k7.dodajProdukt(List.of(p7, p17, p27, p8, p18, p28));
        k8.dodajProdukt(List.of(p8, p18, p28, p9, p19));
        k9.dodajProdukt(List.of(p9, p19, p29, p20, p30));
        k10.dodajProdukt(List.of(p10, p20, p30, p1, p2));

        System.out.println(Klient.ktoWydalNajwiecej(Klient.getEkstensja()));
    }

}
