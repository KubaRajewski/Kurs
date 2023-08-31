package obiektowosc.zadania.drugie;

//        Stwórz klasę Pracownik (imie,nazwisko, adres, pensja i Klient (imie,nazwisko, ulubiony produkt). Klient kupuje produkty (nazwa, cena).
//        Pracownik uzywa samochod (model, marka)

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Samochod s1 = new Samochod("Camry", "Toyota");
        Samochod s2 = new Samochod("Corolla", "Toyota");
        Samochod s3 = new Samochod("Accord", "Honda");
        Samochod s4 = new Samochod("Civic", "Honda");
        Samochod s5 = new Samochod("Mustang", "Ford");
        Samochod s6 = new Samochod("F-150", "Ford");
        Samochod s7 = new Samochod("Model 3", "Tesla");
        Samochod s8 = new Samochod("Model S", "Tesla");
        Samochod s9 = new Samochod("Cruze", "Chevrolet");
        Samochod s10 = new Samochod("Malibu", "Chevrolet");
        Samochod s11 = new Samochod("Camry", "Toyota");
        Samochod s12 = new Samochod("Accord", "Honda");
        Samochod s13 = new Samochod("Mustang", "Ford");
        Samochod s14 = new Samochod("Model 3", "Tesla");
        Samochod s15 = new Samochod("Cruze", "Chevrolet");

        Pracownik p1 = new Pracownik("Jakub", "Rajewski", "Ogińskiego", 3500);
        Pracownik p2 = new Pracownik("Anna", "Nowak", "Dąbrowskiego", 42000);
        Pracownik p3 = new Pracownik("Piotr", "Kowalski", "Sienkiewicza", 3100);
        Pracownik p4 = new Pracownik("Magda", "Jankowska", "Mickiewicza", 3800);
        Pracownik p5 = new Pracownik("Marcin", "Wójcik", "Wałbrzyska", 2900);
        Pracownik p6 = new Pracownik("Ewa", "Zielińska", "Grunwaldzka", 4100);
        Pracownik p7 = new Pracownik("Kamil", "Lewandowski", "Słowackiego", 3400);
        Pracownik p8 = new Pracownik("Natalia", "Duda", "Kościuszki", 3700);
        Pracownik p9 = new Pracownik("Tomasz", "Pawlak", "Czarnieckiego", 2800);
        Pracownik p10 = new Pracownik("Karolina", "Mazur", "Orzeszkowej", 4000);
        Pracownik p11 = new Pracownik("Wojciech", "Adamczyk", "Chrobrego", 3300);
        Pracownik p12 = new Pracownik("Monika", "Sikora", "Fredry", 36000);
        Pracownik p13 = new Pracownik("Mateusz", "Kaczmarek", "Paderewskiego", 27000);
        Pracownik p14 = new Pracownik("Alicja", "Czerwińska", "Kopernika", 3900);
        Pracownik p15 = new Pracownik("Krzysztof", "Wojciechowski", "Piłsudskiego", 3200);

        p1.uzywalSamochodu(s1, "2019-01-01");
        p1.uzywalSamochodu(s1, "2019-01-02");
        p1.uzywalSamochodu(s1, "2019-01-03");
        p1.uzywalSamochodu(s2, "2019-01-04");
        p2.uzywalSamochodu(s2, "2019-01-05");
        p2.uzywalSamochodu(s2, "2019-01-06");
        p3.uzywalSamochodu(s3, "2019-01-07");
        p3.uzywalSamochodu(s3, "2019-01-08");
        p5.uzywalSamochodu(s5, "2019-01-10");
        p6.uzywalSamochodu(s6, "2019-01-11");
        p7.uzywalSamochodu(s7, "2019-01-12");
        p9.uzywalSamochodu(s9, "2019-01-14");
        p11.uzywalSamochodu(s11, "2019-01-16");
        p11.uzywalSamochodu(s11, "2019-01-16");
        p11.uzywalSamochodu(s11, "2019-01-17");
        p11.uzywalSamochodu(s11, "2019-01-18");
        p11.uzywalSamochodu(s11, "2019-01-19");
        p12.uzywalSamochodu(s12, "2019-01-17");
        p14.uzywalSamochodu(s14, "2019-01-19");
        p15.uzywalSamochodu(s15, "2019-01-20");

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
        Produkt pr11 = new Produkt("Pomidory", 2.40);
        Produkt pr12 = new Produkt("Ogórki", 1.80);
        Produkt pr13 = new Produkt("Marchewki", 1.30);
        Produkt pr14 = new Produkt("Cebula", 0.90);
        Produkt pr15 = new Produkt("Ziemniaki", 1.70);
        Produkt pr16 = new Produkt("Banany", 2.60);
        Produkt pr17 = new Produkt("Jabłka", 2.20);
        Produkt pr18 = new Produkt("Gruszki", 2.40);
        Produkt pr19 = new Produkt("Papryka", 2.90);
        Produkt pr20 = new Produkt("Kapusta", 1.60);
        Produkt pr21 = new Produkt("Śledzie", 3.80);
        Produkt pr22 = new Produkt("Kiełbasa", 4.50);
        Produkt pr23 = new Produkt("Kurczak", 6.20);
        Produkt pr24 = new Produkt("Wołowina", 8.00);
        Produkt pr25 = new Produkt("Schab", 5.50);
        Produkt pr26 = new Produkt("Łosoś", 9.75);
        Produkt pr27 = new Produkt("Makaron", 1.40);
        Produkt pr28 = new Produkt("Ravioli", 2.70);
        Produkt pr29 = new Produkt("Oliwa", 3.20);
        Produkt pr30 = new Produkt("Sól", 0.60);
        Produkt pr31 = new Produkt("Pieprz", 0.70);
        Produkt pr32 = new Produkt("Cynamon", 1.90);
        Produkt pr33 = new Produkt("Curry", 1.60);
        Produkt pr34 = new Produkt("Ketchup", 1.10);
        Produkt pr35 = new Produkt("Musztarda", 0.90);
        Produkt pr36 = new Produkt("Majonez", 1.30);
        Produkt pr37 = new Produkt("Czekolada", 2.20);
        Produkt pr38 = new Produkt("Ciastka", 1.50);
        Produkt pr39 = new Produkt("Orzechy", 3.40);
        Produkt pr40 = new Produkt("Soki", 2.80);
        Produkt pr41 = new Produkt("Woda", 0.90);
        Produkt pr42 = new Produkt("Piwo", 2.50);
        Produkt pr43 = new Produkt("Wino", 8.50);
        Produkt pr44 = new Produkt("Whisky", 20.00);
        Produkt pr45 = new Produkt("Chipsy", 1.70);

        Klient k1 = new Klient("Anna", "Kowalska", List.of(pr9, pr9, pr9, pr15, pr30));
        Klient k2 = new Klient("Jan", "Nowak", List.of(pr10, pr16, pr16, pr31));
        Klient k3 = new Klient("Maria", "Wiśniewska", List.of(pr11, pr17, pr17, pr32));
        Klient k4 = new Klient("Piotr", "Dąbrowski", List.of(pr12, pr12, pr18, pr33));
        Klient k5 = new Klient("Magdalena", "Zielińska", List.of(pr13, pr13, pr19, pr34));
        Klient k6 = new Klient("Krzysztof", "Szymański", List.of(pr14, pr14, pr20, pr35));
        Klient k7 = new Klient("Agnieszka", "Wójcik", List.of(pr15, pr15, pr21, pr36));
        Klient k8 = new Klient("Michał", "Kaczmarek", List.of(pr16, pr16, pr22, pr37));
        Klient k9 = new Klient("Jakub", "Piotrowski", List.of(pr17, pr23, pr23, pr38));
        Klient k10 = new Klient("Natalia", "Lewandowska", List.of(pr18, pr24, pr24, pr39));
        Klient k11 = new Klient("Tomasz", "Wojciechowski", List.of(pr19, pr25, pr25, pr40));
        Klient k12 = new Klient("Karolina", "Kwiatkowska", List.of(pr20, pr26, pr41));
        Klient k13 = new Klient("Grzegorz", "Krawczyk", List.of(pr21, pr27, pr27, pr42));
        Klient k14 = new Klient("Paulina", "Mazur", List.of(pr22, pr28, pr43));
        Klient k15 = new Klient("Dawid", "Kaczmarczyk", List.of(pr23, pr29, pr29, pr44));
        Klient k16 = new Klient("Patrycja", "Pawłowska", List.of(pr24, pr24, pr30, pr45));
        Klient k17 = new Klient("Rafał", "Sikora", List.of(pr25, pr31, pr1, pr1));
        Klient k18 = new Klient("Dominika", "Kalinowska", List.of(pr26, pr32, pr2, pr2));
        Klient k19 = new Klient("Mariusz", "Lis", List.of(pr27, pr33, pr3, pr3, pr3));
        Klient k20 = new Klient("Aleksandra", "Czarnecka", List.of(pr28, pr28, pr34, pr4));
        Klient k21 = new Klient("Adrian", "Witkowski", List.of(pr29, pr35, pr5));
        Klient k22 = new Klient("Maja", "Sikorska", List.of(pr30, pr36, pr36, pr6, pr6));
        Klient k23 = new Klient("Kamil", "Kucharski", List.of(pr31, pr31, pr37, pr7));
        Klient k24 = new Klient("Natalia", "Włodarczyk", List.of(pr32, pr38, pr38, pr8));
        Klient k25 = new Klient("Łukasz", "Majewski", List.of(pr33, pr39, pr9, pr9));
        Klient k26 = new Klient("Martyna", "Olszewska", List.of(pr34, pr40, pr10, pr10));
        Klient k27 = new Klient("Patryk", "Jaworski", List.of(pr35, pr41, pr11, pr11));
        Klient k28 = new Klient("Wiktoria", "Wróbel", List.of(pr36, pr42, pr12, pr12));
        Klient k29 = new Klient("Radosław", "Malinowski", List.of(pr37, pr43, pr13, pr13));
        Klient k30 = new Klient("Karina", "Pawlak", List.of(pr38, pr44, pr14, pr14, pr14));
        Klient k31 = new Klient("Julia", "Krawiec", List.of(pr1, pr17, pr30, pr17));
        Klient k32 = new Klient("Tymon", "Czerwiński", List.of(pr2, pr18, pr31));
        Klient k33 = new Klient("Anna", "Kaczmarek", List.of(pr3, pr19, pr32, pr3, pr29));
        Klient k34 = new Klient("Filip", "Kołodziej", List.of(pr4, pr20, pr20, pr33));
        Klient k35 = new Klient("Iga", "Sikorska", List.of(pr5, pr21, pr34, pr5));
        Klient k36 = new Klient("Bartłomiej", "Nowakowski", List.of(pr6, pr22, pr35, pr6));
        Klient k37 = new Klient("Zofia", "Lewandowska", List.of(pr7, pr23, pr36, pr7));
        Klient k38 = new Klient("Maciej", "Pawlak", List.of(pr8, pr24, pr37, pr26));
        Klient k39 = new Klient("Nadia", "Jankowska", List.of(pr9, pr25, pr9, pr38));
        Klient k40 = new Klient("Stanisław", "Mazurek", List.of(pr10, pr26, pr26, pr39));
        Klient k41 = new Klient("Szymon", "Kaczmarczyk", List.of(pr11, pr11, pr27, pr41));
        Klient k42 = new Klient("Helena", "Piotrowska", List.of(pr12, pr28, pr28, pr42));
        Klient k43 = new Klient("Wojciech", "Jaworski", List.of(pr13, pr13, pr29, pr43));
        Klient k44 = new Klient("Eliza", "Wróbel", List.of(pr14, pr14, pr44, pr30, pr44));
        Klient k45 = new Klient("Amir", "Malinowski", List.of(pr15, pr31, pr45, pr15, pr31, pr45));


//TODO      1) Znajdz klienta ktory wydał najwiecej

        System.out.println("Kto wydał najwiecej: " + Klient.ktoWydalNajwiecej(Klient.getEkstensja()) + "\n");


//TODO      2) Wyswietl dla kazdego klienta jego ulubiony produkt (of cuz ulubiony produkt to ma byc atrybut wyliczalny na podstawie zakupow)

        System.out.println("Ulubiony produkt każdego klienta: ");
        System.out.println(Klient.znajdzUlubioneProdukty(Klient.getEkstensja()) + "\n");

//TODO      3) Wyswietl 3 top pracownikow z najwieksza pensja (compartor + sortowanie) DODATKOWE

        System.out.println("Pracownicy z najwieksza pensja: ");
        System.out.println(Pracownik.najlepiejZarabiajacy(Pracownik.getEkstensja(), 3) + "\n");

//TODO      4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta
        
        System.out.println(p1.getUzytkowaneSamochody());
        System.out.println(p2.getUzytkowaneSamochody());
        System.out.println(p3.getUzytkowaneSamochody());
        System.out.println(p4.getUzytkowaneSamochody());
        System.out.println(p5.getUzytkowaneSamochody());
        System.out.println(p6.getUzytkowaneSamochody());
        System.out.println(p7.getUzytkowaneSamochody());
        System.out.println(p8.getUzytkowaneSamochody());
        System.out.println(p9.getUzytkowaneSamochody());
        System.out.println(p10.getUzytkowaneSamochody());
        System.out.println(p11.getUzytkowaneSamochody());
        System.out.println(p12.getUzytkowaneSamochody());
        System.out.println(p13.getUzytkowaneSamochody());
        System.out.println(p14.getUzytkowaneSamochody());
        System.out.println(p15.getUzytkowaneSamochody());


    }
}
