package dalsze.podstawy.wyjatki.programisci;

/*
 * Stworz krotki system do zarzadzania programistami i ich partnerkami
 *
 * Programista ma imie, nazwisko, pensje oraz lsite jezykow jakie zna
 *
 * Kobieta ma imie, nazwsiko, rozmiar biustu oraz IQ
 *
 * Napisz metode ktora znajduje top n programistow (jesli chodzi o zarobki)
 * ktorzy kodza w javie. Jesli nie jestes w stanie tego zrobic rzuc wyjatkiem
 * NoJavaPorgrammerHere
 *
 * Programista moze chodzic na Randke(nazwa, miejsce, kobieta). Napisz metode
 * ktora wylicza % szanse na zaliczenie na randce. Algorytm zalezy odm iejsca np
 * restuaracja +10%, kino +20% itd oraz od kobiety, rozmiar A + 10%, B+ 20% itd
 * oraz od IQ wzor IQ/1000. Jesli szansa na zaliczenie wynosi over 100%
 * programista jest zapewny siebie i jego szanse spdaja, zatem obslugujemy
 * wyajtek i ustawiamy szanse na zaliczenie do 30%
 *
 * Dodaj kobiecie atrybut ulubione miejsce, ktore jest losowane z listy miejsc.
 * Jesli wylosowane ulubione miejsce kobiety jest inne niz to w ktorym zabral je
 * programista powstaje konflikt, BadPlaceForDateException z zastrzezeniem ze
 * moze przyjac on wiadomosc dla programisty od kobiety albo zostac pusty
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Programista p1 = new Programista("Jan", "Nowak", new ArrayList<>(List.of(jezyk.JAVA, jezyk.C, jezyk.VISUAL_BASIC)), 8000);
        Programista p2 = new Programista("Jan", "Kowalski", new ArrayList<>(List.of(jezyk.JAVA, jezyk.KOTLIN, jezyk.C)), 7000);
        Programista p3 = new Programista("Marcin", "Nowak", new ArrayList<>(List.of(jezyk.JAVA, jezyk.RUBY)), 6000);
        Programista p4 = new Programista("Jan", "Nowak", new ArrayList<>(List.of(jezyk.PYTHON, jezyk.SWIFT)), 5000);
        Programista p5 = new Programista("Janusz", "Marciński", new ArrayList<>(List.of(jezyk.C, jezyk.RUST)), 4000);

        Kobieta k1 = new Kobieta("Anna", "Kowalska", 100, RozmiarBiustu.A);
        Kobieta k2 = new Kobieta("Anna", "Nowak", 200, RozmiarBiustu.B);
        Kobieta k3 = new Kobieta("Anna", "Nowakowska", 300, RozmiarBiustu.C);

        // najlepiej zarabiajacy programisci javy
        Programista.topProgramisci(Programista.ekstensja, 2).forEach(System.out::println);

        p1.dodajRandke("randka1", Miejsce.KINO, k1);
        p2.dodajRandke("randka2", Miejsce.GOKARTY, k2);
        p3.dodajRandke("randka3", Miejsce.TEATR, k3);

        p1.getRandki().forEach(System.out::println);

    }
}
