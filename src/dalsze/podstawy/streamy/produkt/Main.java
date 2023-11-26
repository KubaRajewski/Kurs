package dalsze.podstawy.streamy.produkt;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Produkt produkt1 = new Produkt("Laptop", new BigDecimal("4500.00"), 2.5, 8);
        Produkt produkt2 = new Produkt("Smartfon", new BigDecimal("2500.00"), 0.5, 7);
        Produkt produkt3 = new Produkt("Kamera", new BigDecimal("3500.00"), 1.0, 9);
        Produkt produkt4 = new Produkt("Telewizor", new BigDecimal("5500.00"), 5.0, 8);
        Produkt produkt5 = new Produkt("Konsola", new BigDecimal("1800.00"), 2.0, 6);

        List<Produkt> listaProduktow = Arrays.asList(produkt1, produkt2, produkt3, produkt4, produkt5);

        // Testujemy wszystkie funkcje
        try {
            System.out.println("Najdroższy produkt: " + Produkt.najdrozszyProdukt(listaProduktow).getNazwa());
        } catch (IllegalArgumentException e) {
            System.out.println("Nie znaleziono najdroższego produktu.");
        }

        try {
            System.out.println("Najtańszy produkt lżejszy niż 3 kg: " +
                    Produkt.najtanszyProduktLzejszyNiz(listaProduktow, 3).getNazwa());
        } catch (IllegalArgumentException e) {
            System.out.println("Nie znaleziono najtańszego produktu lżejszego niż 3 kg.");
        }

        List<Produkt> wybraneProdukty = Produkt.wybraneProdukty(listaProduktow, new BigDecimal("3000.00"), 23, 6);
        System.out.println("Wybrane produkty: " + wybraneProdukty);

        System.out.println("Średnia waga produktów: " + Produkt.sredniaWaga(listaProduktow));

        List<String> wybraneNazwy = Produkt.wybraneNazwyProduktow(listaProduktow, 10);
        System.out.println("Wybrane nazwy produktów: " + wybraneNazwy);

        System.out.println("Produkty posortowane po nazwie: " + Produkt.produktyPosortowanePoNazwie(listaProduktow));

        // Tworzymy komparator do sortowania po ocenie
        Comparator<Produkt> comparatorByOcena = new Comparator<Produkt>() {
            @Override
            public int compare(Produkt o1, Produkt o2) {
                return Integer.compare(o1.getOcena(), o2.getOcena());
            }
        };
        List<Produkt> produktyPosortowanePoOcenie = Produkt.produktyPosortowanePoParametrze(listaProduktow, comparatorByOcena);
        System.out.println("Produkty posortowane po ocenie: " + produktyPosortowanePoOcenie);
    }
}
