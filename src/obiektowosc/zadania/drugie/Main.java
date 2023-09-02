package obiektowosc.zadania.drugie;
//        Stwórz klasę Pracownik (imie,nazwisko, adres, pensja i Klient (imie,nazwisko, ulubiony produkt). Klient kupuje produkty (nazwa, cena).
//        Pracownik uzywa samochod (model, marka)

public class Main {
    public static void main(String[] args) {
        Klient k1 = new Klient("Anna", "Kowalska");
        Klient k2 = new Klient("Jan", "Nowak");
        Klient k3 = new Klient("Maria", "Wiśniewska");
        Klient k4 = new Klient("Piotr", "Dąbrowski");
        Klient k5 = new Klient("Magdalena", "Zielińska");
        Klient k6 = new Klient("Krzysztof", "Szymański");
        Klient k7 = new Klient("Agnieszka", "Wójcik");
        Klient k8 = new Klient("Michał", "Kaczmarek");
        Klient k9 = new Klient("Jakub", "Piotrowski");
        Klient k10 = new Klient("Natalia", "Lewandowska");

        Produkt pr1 = new Produkt("Mąka", 1.20);
        Produkt pr2 = new Produkt("Cukier", 2.50);
        Produkt pr3 = new Produkt("Ryż", 3.75);
        Produkt pr4 = new Produkt("Jajka", 0.80);
        Produkt pr5 = new Produkt("Chleb", 2.00);
        Produkt pr6 = new Produkt("Masło", 2.80);
        Produkt pr7 = new Produkt("Mleko", 1.50);
        Produkt pr8 = new Produkt("Ser", 2.20);
        Produkt pr9 = new Produkt("Kawa", 5.00);
        Produkt pr10 = new Produkt("Herbata", 3.50);

        // ul produkt = ryz
        k1.dodajProdukt(pr3);
        k1.dodajProdukt(pr2);
        k1.dodajProdukt(pr3);

        // ul produkt = cukier
        k2.dodajProdukt(pr2);
        k2.dodajProdukt(pr2);
        k2.dodajProdukt(pr4);

        // ul produkt = jajka
        k3.dodajProdukt(pr1);
        k3.dodajProdukt(pr4);
        k3.dodajProdukt(pr4);

        // ul produkt = herbata
        k4.dodajProdukt(pr8);
        k4.dodajProdukt(pr8);
        k4.dodajProdukt(pr1);
        k4.dodajProdukt(pr10);
        k4.dodajProdukt(pr10);

        // ul produkt = brak
        k5.dodajProdukt(pr5);
        k5.dodajProdukt(pr4);
        k5.dodajProdukt(pr7);

        k6.dodajProdukt(pr6);

        k7.dodajProdukt(pr9);

        ////TODO 1) Znajdz klienta ktory wydał najwiecej
        System.out.println("Klient, który wydał najwięcej: " + Klient.ktoWydalNajwiecej(Klient.getEkstensja()) + "\n");

        System.out.println("Kto kupił produkt pr4: " + pr4.getKlienci() + "\n");

        ////TODO 2) Wyswietl dla kazdego klienta jego ulubiony produkt (of cuz ulubiony produkt to ma byc atrybut wyliczalny na podstawie zakupow)
        System.out.println("Ulubione produkty klientów:");
        for (Klient k : Klient.getEkstensja()) {
            System.out.println(k + ": " + k.ulubioneProdukty());
        }

        Pracownik p1 = new Pracownik("Jakub", "Rajewski", "Ogińskiego", 3500);
        Pracownik p2 = new Pracownik("Anna", "Nowak", "Dąbrowskiego", 42000);
        Pracownik p3 = new Pracownik("Piotr", "Kowalski", "Sienkiewicza", 3100);
        Pracownik p4 = new Pracownik("Magda", "Jankowska", "Mickiewicza", 3800);
        Pracownik p5 = new Pracownik("Marcin", "Wójcik", "Wałbrzyska", 2900);

        ////TODO 3) Wyswietl 3 top pracownikow z najwieksza pensja (compartor + sortowanie) DODATKOWE

        System.out.println("\n" + "Najlepiej zarabiajacy pracownicy: " + Pracownik.najlepiejZarabiajacy(3) + "\n");

        Samochod s1 = new Samochod("Camry", "Toyota");
        Samochod s2 = new Samochod("Corolla", "Toyota");
        Samochod s3 = new Samochod("Accord", "Honda");
        Samochod s4 = new Samochod("Civic", "Honda");
        Samochod s5 = new Samochod("Mustang", "Ford");

        ////TODO 4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta
        p1.uzywalSamochodu(s1, "11-03-2023");
        p1.uzywalSamochodu(s2, "11-03-2023");
        p2.uzywalSamochodu(s2, "31-01-2022");
        p2.uzywalSamochodu(s1, "31-01-2022");
        p3.uzywalSamochodu(s3, "21-07-2010");
        p4.uzywalSamochodu(s4, "11-11-2021");
        p5.uzywalSamochodu(s2, "11-12-2021");

        for (Pracownik p : Pracownik.getEkstensja()) {
            System.out.println(p.getUzytkowaneSamochody());
        }

        System.out.println("\n" + "Kto uzywal samochodu s2: " + s2.getUzytkownicy());
    }
}
