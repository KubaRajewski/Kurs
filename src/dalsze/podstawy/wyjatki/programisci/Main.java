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

import dalsze.podstawy.wyjatki.exceptions.BadPlaceForDateException;
import dalsze.podstawy.wyjatki.exceptions.NoJavaProgrammerHereException;
import dalsze.podstawy.wyjatki.exceptions.ZaDuzeEgoExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Programista p1 = new Programista("Jan", "Nowak", new ArrayList<>(List.of(jezyk.JAVA, jezyk.C, jezyk.VISUAL_BASIC)), 8000);
        Programista p2 = new Programista("Jan", "Kowalski", new ArrayList<>(List.of(jezyk.JAVA, jezyk.KOTLIN, jezyk.C)), 7000);
        Programista p3 = new Programista("Marcin", "Nowak", new ArrayList<>(List.of(jezyk.JAVA, jezyk.RUBY)), 6000);
        Programista p4 = new Programista("Jan", "Nowak", new ArrayList<>(List.of(jezyk.PYTHON, jezyk.SWIFT)), 5000);
        Programista p5 = new Programista("Janusz", "Marciński", new ArrayList<>(List.of(jezyk.C, jezyk.RUST)), 4000);

        Kobieta k1 = new Kobieta("Anna", "Kowalska", 140, RozmiarBiustu.B);
        Kobieta k2 = new Kobieta("Anna", "Nowak", 120, RozmiarBiustu.C);
        Kobieta k3 = new Kobieta("Anna", "Nowakowska", 70, RozmiarBiustu.D);
        Kobieta k4 = new Kobieta("Anna", "Kowalska", 60, RozmiarBiustu.G);

        // najlepiej zarabiajacy programisci javy
        try {
            Programista.topProgramisci(Programista.ekstensja, 2).forEach(System.out::println);
        } catch (NoJavaProgrammerHereException e) {
            System.out.println(e.getMessage());
        }

        // dodawanie randek
        try {
            p1.dodajRandke("randka1", Miejsce.KINO, k1);
            p2.dodajRandke("randka2", Miejsce.GOKARTY, k2);
            p3.dodajRandke("randka3", Miejsce.RESTAURACJA, k3);
            p3.dodajRandke("randka4", Miejsce.TEATR, k4);
        } catch (BadPlaceForDateException e) {
            System.out.println(e.getMessage());

        }

        try {
            //Obliczanie szansy na zaliczenie
            for (int i = 0; i < Randka.ekstensja.size(); i++) {
                System.out.println("Szansa na zaliczenie na randce " + (i + 1) + ": " + Randka.ekstensja.get(i).obliczSzanseNaZaliczenie() + "%");
            }
        } catch (ZaDuzeEgoExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
