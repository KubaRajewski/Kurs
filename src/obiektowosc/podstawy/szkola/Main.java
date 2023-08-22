package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Szkola s1 = new Szkola(1992, "Liceum", "Złota szkoła", 1234876);
        Szkola s2 = new Szkola(2002, "Gimnazjum", "Srebrna szkoła", 4311);
        Szkola s3 = new Szkola(2012, "Podstawowka", "brak", 1234);

        s1.setProfile(List.of("matematyka", "fizyka", "chemia"));
        s2.setProfile(List.of("Filozofia", "Mcdonalds", "kwiatki"));
        s3.setProfile(List.of("Angielski", "Niemiecki", "Hiszpański"));

        Sala sala1 = new Sala("1", s1);
        Sala sala2 = new Sala("2", s1);
        Sala sala3 = new Sala("3", s1);

        s1.setSale(List.of(sala1, sala2, sala3));

        Sala sala4 = new Sala("4", s2);
        Sala sala5 = new Sala("5", s2);
        Sala sala6 = new Sala("6", s2);

        s2.setSale(List.of(sala4, sala5, sala6));

        Sala sala7 = new Sala("7", s3);
        Sala sala8 = new Sala("8", s3);
        Sala sala9 = new Sala("9", s3);

        s3.setSale(List.of(sala7, sala8, sala9));

        Klasa k1 = new Klasa("1a", s1, "matematyka", new ArrayList<>());
        Klasa k2 = new Klasa("2a", s1, "fizyka", new ArrayList<>());
        Klasa k3 = new Klasa("3a", s1, "chemia", new ArrayList<>());

        s1.setKlasy(List.of(k1, k2, k3));

        Klasa k4 = new Klasa("1b", s2, "Filozofia", new ArrayList<>());
        Klasa k5 = new Klasa("2b", s2, "Mcdonalds", new ArrayList<>());
        Klasa k6 = new Klasa("3b", s2, "kwiatki", new ArrayList<>());

        s2.setKlasy(List.of(k4, k5, k6));

        Klasa k7 = new Klasa("1c", s3, "Angielski", new ArrayList<>());
        Klasa k8 = new Klasa("2c", s3, "Niemiecki", new ArrayList<>());
        Klasa k9 = new Klasa("3c", s3, "Hiszpański", new ArrayList<>());

        s3.setKlasy(List.of(k7, k8, k9));

        // Tworzenie uczniów z kolejnymi numerami
        Uczen u1 = new Uczen("Kuba", "Rajewski", "Oginskiego", "1", s1, k1);
        Uczen u2 = new Uczen("Anna", "Kowalska", "Warszawska", "2", s1, k1);
        Uczen u3 = new Uczen("Marcin", "Nowak", "Krakowska", "3", s1, k1);
        Uczen u4 = new Uczen("Magda", "Wójcik", "Gdańska", "4", s1, k1);
        Uczen u5 = new Uczen("Piotr", "Lis", "Poznańska", "5", s1, k1);
        Uczen u6 = new Uczen("Zofia", "Duda", "Łódzka", "6", s1, k1);
        Uczen u7 = new Uczen("Jan", "Kaczmarek", "Sienkiewicza", "7", s1, k1);
        Uczen u8 = new Uczen("Karolina", "Mazurek", "Lechitów", "8", s1, k2);
        Uczen u9 = new Uczen("Mateusz", "Włodarczyk", "Wrocławska", "9", s1, k2);
        Uczen u10 = new Uczen("Aleksandra", "Zielińska", "Szkolna", "10", s1, k2);
        Uczen u11 = new Uczen("Kamil", "Jankowski", "Leszczyńska", "11", s1, k2);
        Uczen u12 = new Uczen("Alicja", "Nowicka", "Paderewskiego", "12", s1, k2);
        Uczen u13 = new Uczen("Michał", "Kamiński", "Pilsudskiego", "13", s1, k2);
        Uczen u14 = new Uczen("Oliwia", "Kubiak", "Wolska", "14", s1, k2);
        Uczen u15 = new Uczen("Krzysztof", "Sikorski", "Krzywa", "15", s1, k3);
        Uczen u16 = new Uczen("Natalia", "Górka", "Warszawska", "16", s1, k3);
        Uczen u17 = new Uczen("Bartosz", "Kaczor", "Krakowska", "17", s1, k3);
        Uczen u18 = new Uczen("Wiktoria", "Kowalczyk", "Gdańska", "18", s1, k3);
        Uczen u19 = new Uczen("Artur", "Pawlak", "Poznańska", "19", s1, k3);
        Uczen u20 = new Uczen("Julia", "Jasieńska", "Łódzka", "20", s1, k3);
        Uczen u21 = new Uczen("Kamil", "Nowak", "Sienkiewicza", "21", s1, k3);
        Uczen u22 = new Uczen("Aleksandra", "Kowalska", "Warszawska", "22", s2, k4);
        Uczen u23 = new Uczen("Piotr", "Lis", "Poznańska", "23", s2, k4);
        Uczen u24 = new Uczen("Zofia", "Duda", "Łódzka", "24", s2, k4);
        Uczen u25 = new Uczen("Anna", "Kaczmarek", "Krakowska", "25", s2, k4);
        Uczen u26 = new Uczen("Mateusz", "Wójcik", "Gdańska", "26", s2, k4);
        Uczen u27 = new Uczen("Karolina", "Mazurek", "Sienkiewicza", "27", s2, k4);
        Uczen u28 = new Uczen("Jan", "Kowalczyk", "Warszawska", "28", s2, k4);
        Uczen u29 = new Uczen("Oliwia", "Jankowska", "Poznańska", "29", s2, k5);
        Uczen u30 = new Uczen("Michał", "Nowicki", "Łódzka", "30", s2, k5);
        Uczen u31 = new Uczen("Katarzyna", "Sikorska", "Krakowska", "31", s2, k5);
        Uczen u32 = new Uczen("Artur", "Kamiński", "Gdańska", "32", s2, k5);
        Uczen u33 = new Uczen("Julia", "Zielińska", "Pilsudskiego", "33", s2, k5);
        Uczen u34 = new Uczen("Bartosz", "Górka", "Sienkiewicza", "34", s2, k5);
        Uczen u35 = new Uczen("Natalia", "Kaczor", "Warszawska", "35", s2, k5);
        Uczen u36 = new Uczen("Wojciech", "Pawlak", "Krakowska", "36", s2, k5);
        Uczen u37 = new Uczen("Alicja", "Jasieńska", "Gdańska", "37", s2, k6);
        Uczen u38 = new Uczen("Krzysztof", "Sikorski", "Poznańska", "38", s2, k6);
        Uczen u39 = new Uczen("Agnieszka", "Lis", "Łódzka", "39", s2, k6);
        Uczen u40 = new Uczen("Damian", "Nowak", "Sienkiewicza", "40", s2, k6);
        Uczen u41 = new Uczen("Kamil", "Nowak", "Sienkiewicza", "41", s2, k6);
        Uczen u42 = new Uczen("Aleksandra", "Kowalska", "Warszawska", "42", s2, k6);
        Uczen u43 = new Uczen("Piotr", "Lis", "Poznańska", "43", s2, k6);
        Uczen u44 = new Uczen("Zofia", "Duda", "Łódzka", "44", s2, k6);
        Uczen u45 = new Uczen("Anna", "Kaczmarek", "Krakowska", "45", s3, k7);
        Uczen u46 = new Uczen("Mateusz", "Wójcik", "Gdańska", "46", s3, k7);
        Uczen u47 = new Uczen("Karolina", "Mazurek", "Sienkiewicza", "47", s3, k7);
        Uczen u48 = new Uczen("Jan", "Kowalczyk", "Warszawska", "48", s3, k7);
        Uczen u49 = new Uczen("Oliwia", "Jankowska", "Poznańska", "49", s3, k7);
        Uczen u50 = new Uczen("Michał", "Nowicki", "Łódzka", "50", s3, k7);
        Uczen u51 = new Uczen("Katarzyna", "Sikorska", "Krakowska", "51", s3, k7);
        Uczen u52 = new Uczen("Artur", "Kamiński", "Gdańska", "52", s3, k8);
        Uczen u53 = new Uczen("Julia", "Zielińska", "Pilsudskiego", "53", s3, k7);
        Uczen u54 = new Uczen("Bartosz", "Górka", "Sienkiewicza", "54", s3, k7);
        Uczen u55 = new Uczen("Natalia", "Kaczor", "Warszawska", "55", s3, k7);
        Uczen u56 = new Uczen("Wojciech", "Pawlak", "Krakowska", "56", s3, k7);
        Uczen u57 = new Uczen("Alicja", "Jasieńska", "Gdańska", "57", s3, k7);
        Uczen u58 = new Uczen("Krzysztof", "Sikorski", "Poznańska", "58", s3, k7);
        Uczen u59 = new Uczen("Agnieszka", "Lis", "Łódzka", "59", s3, k7);
        Uczen u60 = new Uczen("Damian", "Nowak", "Sienkiewicza", "60", s3, k8);
        Uczen u61 = new Uczen("Kamil", "Nowak", "Sienkiewicza", "61", s3, k8);
        Uczen u62 = new Uczen("Aleksandra", "Kowalska", "Warszawska", "62", s3, k8);
        Uczen u63 = new Uczen("Piotr", "Lis", "Poznańska", "63", s3, k8);

        Sprawdzian sp1 = new Sprawdzian("Matematyka", "Dział 1", "2019-10-10", new ArrayList<>());
        Sprawdzian sp2 = new Sprawdzian("Matematyka", "Dział 2", "2020-10-10", new ArrayList<>());
        Sprawdzian sp3 = new Sprawdzian("Matematyka", "Dział 3", "2021-10-10", new ArrayList<>());


        Ocena o1 = new Ocena(5, "12/12/2023", u1, sp1);
        Ocena o2 = new Ocena(2, "12/122/2023", u1, sp1);
        Ocena o3 = new Ocena(5, "12/12/1992", u1, sp1);
        Ocena o4 = new Ocena(3, "12/08/2023", u1, sp1);

        Nauczyciel n1 = new Nauczyciel("Marian", "Kowalski", "Sienkiewicza 1", "Matematyka");
        Nauczyciel n2 = new Nauczyciel("Anna", "Nowak", "Warszawska 5", "Fizyka");
        Nauczyciel n3 = new Nauczyciel("Krzysztof", "Nowicki", "Poznańska 12", "Chemia");
        Nauczyciel n4 = new Nauczyciel("Alicja", "Jankowska", "Krakowska 8", "Biologia");
        Nauczyciel n5 = new Nauczyciel("Tomasz", "Lis", "Łódzka 17", "Informatyka");
        Nauczyciel n6 = new Nauczyciel("Ewa", "Kaczmarek", "Gdańska 3", "Historia");
        Nauczyciel n7 = new Nauczyciel("Maciej", "Mazurek", "Paderewskiego 9", "Język polski");
        Nauczyciel n8 = new Nauczyciel("Katarzyna", "Kamińska", "Sienkiewicza 21", "Język angielski");
        Nauczyciel n9 = new Nauczyciel("Piotr", "Zieliński", "Wrocławska 14", "Geografia");
        Nauczyciel n10 = new Nauczyciel("Aleksandra", "Górka", "Lechitów 6", "Wychowanie fizyczne");
        Nauczyciel n11 = new Nauczyciel("Jan", "Kowalczyk", "Leszczyńska 11", "Plastyka");
        Nauczyciel n12 = new Nauczyciel("Monika", "Wójcik", "Górka 7", "Muzyka");
        Nauczyciel n13 = new Nauczyciel("Marcin", "Sikorski", "Szkolna 19", "Religia");
        Nauczyciel n14 = new Nauczyciel("Natalia", "Pawlak", "Szkolna 2", "Wiedza o społeczeństwie");
        Nauczyciel n15 = new Nauczyciel("Adrian", "Lis", "Paderewskiego 8", "Technika");


        s1.dodajNauczyciela(n1);
        s1.dodajNauczyciela(n2);
        s1.dodajNauczyciela(n3);
        s1.dodajNauczyciela(n4);
        s1.dodajNauczyciela(n5);

        s2.dodajNauczyciela(n6);
        s2.dodajNauczyciela(n7);
        s2.dodajNauczyciela(n8);
        s2.dodajNauczyciela(n9);
        s2.dodajNauczyciela(n10);


        s3.dodajNauczyciela(n11);
        s3.dodajNauczyciela(n12);
        s3.dodajNauczyciela(n13);
        s3.dodajNauczyciela(n14);
        s3.dodajNauczyciela(n15);

        Szkolenie programowanie = new Szkolenie("Programowanie", "1992-12-12");
        Szkolenie kwiatki = new Szkolenie("Kwiatki", "1992-12-12");
        Szkolenie filozofia = new Szkolenie("filozofia", "1992-12-12");

        programowanie.dodajNauczyciela(n3);
        programowanie.dodajNauczyciela(n4);

        kwiatki.dodajNauczyciela(n7);
        kwiatki.dodajNauczyciela(n8);

        filozofia.dodajNauczyciela(n11);
        filozofia.dodajNauczyciela(n12);

        System.out.println("Wszystkie szkoły: ");
        System.out.println(Szkola.getEkstensja());

        System.out.println("Sale w danej szkole: ");
        System.out.println("Szkoła 1 " + s1.getSale() + "\n");

        System.out.println("Szkoła 2 " + s2.getSale() + "\n");

        System.out.println("Szkoła 3 " + s2.getSale() + "\n");

        System.out.println("Klasy dostepne w szkole 1: ");
        System.out.println(s1.getKlasy()+ "\n");

        System.out.println("uczniowie klasy 1a");
        System.out.println(k1.getUczniowie());

        System.out.println("uczniowie klasy 2a");
        System.out.println(k2.getUczniowie());

        System.out.println("uczniowie klasy 3a");
        System.out.println(k3.getUczniowie());

        System.out.println("uczniowie klasy 1b");
        System.out.println(k4.getUczniowie());

        System.out.println("uczniowie klasy 2b");
        System.out.println(k5.getUczniowie());

        System.out.println("uczniowie klasy 3b");
        System.out.println(k6.getUczniowie());

        System.out.println("uczniowie klasy 1c");
        System.out.println(k7.getUczniowie());

        System.out.println("uczniowie klasy 2c");
        System.out.println(k8.getUczniowie());

        System.out.println("uczniowie klasy 3c");
        System.out.println(k9.getUczniowie());

        System.out.println("oceny kuby: ");
        System.out.println(u1.getOceny());

        System.out.println("Klasy dostepne w szkole 2: ");
        System.out.println(s2.getKlasy()+ "\n");

        System.out.println("Klasy dostepne w szkole 3: ");
        System.out.println(s3.getKlasy()+ "\n");

        System.out.println("\nWszyscy uczniowie z pierwszej szkoły: ");
        System.out.println(Szkola.uczniowieZDanejSzkoly(s1) + "\n");

        System.out.println("Nauczyciele z pierwszej szkoły: ");
        System.out.println(Szkola.nauczycieleZDanejSzkoly(s1) + "\n");

        System.out.println("Uczniowie z drugiej szkoły: ");
        System.out.println(Szkola.uczniowieZDanejSzkoly(s2) + "\n");

        System.out.println("Nauczyciele z drugiej szkoły: ");
        System.out.println(Szkola.nauczycieleZDanejSzkoly(s2) + "\n");

        System.out.println("Uczniowie z trzeciej szkoły: ");
        System.out.println(Szkola.uczniowieZDanejSzkoly(s3) + "\n");

        System.out.println("Nauczyciele z trzeciej szkoły: ");
        System.out.println(Szkola.nauczycieleZDanejSzkoly(s3) + "\n");

        System.out.println("Uczestnicy kursu programowania: ");
        System.out.println(programowanie.getUczestnicy() + "\n");

        System.out.println("Uczestnicy kursu kwiatki: ");
        System.out.println(kwiatki.getUczestnicy() + "\n");

        System.out.println("Uczestnicy kursu filozofia: ");
        System.out.println(filozofia.getUczestnicy() + "\n");

        System.out.println("szkolenia nauczyciela n3: ");
        System.out.println(n3.getSzkolenia() + "\n");

        // TODO Wyjasnic jaka dokladnie relacja łączy klase Uczeń - Klasa - Szkoła
        // TODO Inaczej wyglada metoda dodajUcznia w klasie szkola oraz konstruktor ucznia, czy tak jest okej?
        // TODO W szkoleniach musze zainicjalizowac liste uczestnicy inaczej wyskakuje bląd, czy tak jest okej?
        // TODO Inaczej wyglada klasa Sprawdzian, czy tak jest okej?


    }
}
