package dalsze.podstawy.wyjatki.klient;

//Stworz asocjacje pomiedzy klientem i produktem 1-*. Obsluz sytuacje gdy produkt jest nullem, wtedy automatycznie ustwiamy
//klientowi ze zamowil lamborghini za 10000000

public class Main {
    public static void main(String[] args) {
        Klient klient = new Klient("Jan", "Kowalski");

        Produkt produkt = new Produkt("Porsche", 200000);
        Produkt produkt1 = new Produkt("ziemniaki", 2);

        klient.dodajProdukt(produkt);
        klient.dodajProdukt(produkt1);
        klient.dodajProdukt(null);

        System.out.println("\n" + "Klient " + klient + " kupił:");
        klient.getProdukty().forEach(System.out::println);
    }
}
