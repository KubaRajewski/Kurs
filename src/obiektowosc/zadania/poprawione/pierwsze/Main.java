package obiektowosc.zadania.poprawione.pierwsze;


//        Klient kupuje produkty. Klient ma imie nazwisko i rozmiar penisa. Pordukt ma nazwe, cene i jesli jest to kondom to wymiar
//        Klient moze miec wiele produktow, produkt moze miec jednego klienta.
//        TODO 1) Napisz metode ktora znajduje klienta ktory wydal najwiecej.
//        TODO 2) napisz metode ktora zwroci liste klientow ktorzy kupili kondoma
//        TODO 3) napisz metode ktora zwroci liste klientow ktorzy kupili kondoma ale nie na swoj rozmiar :D

public class Main {
    public static void main(String[] args) {

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

        Kondom kondom1 = new Kondom("Durex", 10, 5);
        Kondom kondom2 = new Kondom("Durex", 2, 6);
        Kondom kondom3 = new Kondom("unimil", 12, 7);
        Kondom kondom4 = new Kondom("nazwa", 3, 8);
        Kondom kondom5 = new Kondom("giga", 5, 10);

        k1.dodajProdukt(kondom1);
        k2.dodajProdukt(kondom2);
        k4.dodajProdukt(kondom4);
        k5.dodajProdukt(kondom5);
        k6.dodajProdukt(kondom1);
        k8.dodajProdukt(kondom3);

        System.out.println("Klient ktory wydal najwiecej: " + Klient.ktoWydalNajwiecej(Klient.ekstensja) + "\n");

        System.out.println("Klienci ktorzy kupili kondoma: " + Klient.klienciKtorzyKupiliKondoma(Klient.ekstensja) + "\n");

        System.out.println("Klienci ktorzy kupili kondoma ale nie na swoj rozmiar: " + Klient.kupiliZlegoKondoma(Klient.ekstensja) + "\n");
    }
}
