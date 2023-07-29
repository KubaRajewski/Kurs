package iteracja.pierwsza.kolekcje.listy;

import java.util.ArrayList;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        //	1) Zadeklaruj ArrayListe intow, dodaj do niej 5 roznych liczb metoda add, wyswietl cala liste petla for each.
        System.out.println("Zadanie 1 - ArrayLista intow");
        List<Integer> liczby = new ArrayList<>();

        liczby.add(1);
        liczby.add(6);
        liczby.add(3);
        liczby.add(5);

        for (Integer integer : liczby) {
            System.out.println(integer);
        }
        System.out.println();

        //	2) Stworz metode ktora zwroci sume liczb z ArrayListy z 1 zadania
        System.out.println("zadaie 2 - suma liczb z ArrayListy");
        System.out.println(suma(liczby));
        System.out.println();

        //	3) Stworz metode ktora zwroci liste elementow wiekszych od 3
        System.out.println("Zadanie 3 - elementy wieksze od n");
        System.out.println(wiekszeOd3(liczby, 3));
        System.out.println();

        //	4) Zadeklaruj Liste Stringow, dodaj do niej kolekcje imion Tomek Ania Tomek Krzys Grzes Tomek metoda addAll, nastepnie usun wszystkich Tomkow z tej listy
        System.out.println("Zadanie 4 - usuniecie wszystkich Tomkow");
        List<String> imiona = new ArrayList<>();
        imiona.addAll(Arrays.asList("Tomek", "Ania", "krzysiu", "Grzes", "Tomek"));

        imiona.removeAll(Arrays.asList("Tomek"));

        System.out.println(imiona);
        System.out.println();

        //	5) Napisz metode do zadania 4, ktora zwroci najdluzsze imie
        System.out.println("Zadanie 5 - najdluzsze imie");
        System.out.println(najdluzszeImie(imiona));
        System.out.println();

        //	6) Napisz metode do zadani 4 ktora sprawdza czy podane imie znajduje sie w kolekcji
        System.out.println("Zadanie 6 - czy imie znajduje sie w kolekcji");
        System.out.println(znajdujeSie(imiona, "Ania"));
        System.out.println();


        //	7) Zadeklaruj Liste zmiennych typu double, dodaj do listy 5 liczb rzeczywiste i wypisz je w kolejnosci rosnacej
        System.out.println("Zadanie 7 - liczby rosnaco");

        List<Double> liczby3 = new ArrayList<>();

        liczby3.add(5.0);
        liczby3.add(7.0);
        liczby3.add(23.454);
        liczby3.add(9.6);
        liczby3.add(7.0);

        Collections.sort(liczby3);
        System.out.println(liczby3);

        System.out.println();

        // 8) Napisz metode ktora uzupelnia losowa iloscia (od 2-8) liczb losowych z przedziaku 1-10,
        // wrzucmy te liczby do nowej listy posortujmy ja odwrotnie i zwracamy ta liste
        System.out.println("Zadanie 8 - losowe liczby");
        System.out.println(losoweLiczby());
        System.out.println();

        // 9) Napisz metode ktora jako parametr przyjmuje liste intow i zwraca wszystkie liczby parzyste z tej listy
        System.out.println("Zadanie 9 - liczby parzyste");
        System.out.println(liczbyParzyste(liczby));
        System.out.println();

        // 10) Wyswietl wszystkie imiona męskie które znajduja sie w liscie
        System.out.println("Zadanie 10 - imiona meskie");
        imionaMeskie(imiona);
        System.out.println();


        // 11) Wyswietl ile razy było podane imie podane jako parametr
        System.out.println("Zadanie 11 - ile razy imie");
        ileImion(imiona, "Ania");
        System.out.println();

        // 12) Napisz metode ktora jako parametr przyjmuje Liste Stringow oraz znak. Zwroc
        // liste zawierajaca wszystkie
        // Stringi ktore zawieraja podana znak
        // Lista: Ania Kasia Grzegorz Tomek Magda a znak to a, to lista zwracana powinna
        // zawierac Ania Kasia Magda
        System.out.println("Zadanie 12 - lista znakow");
        listaZnakow(imiona, "a");
        System.out.println();

        // 13) Napisz metode ktora jako parametr przyjmuje 2 Listy Stringow i zwraca liste
        // elementów wspolnych, ktore sa na obu listach
        System.out.println("Zadanie 13 - wspolna lista");

        List<String> inneImiona = new ArrayList<>();
        inneImiona.addAll(Arrays.asList("Miłosz", "Ania", "Kuba", "Marcin", "Tomek"));

        System.out.println("Lista 1: " + imiona);
        System.out.println("Lista 2: " + inneImiona);

        System.out.println("lista wspolna:");
        System.out.println(wspolne(imiona, inneImiona));
        System.out.println();

        // 14) Napisz metode ktora dla listy intów zwroci roznice pomiedzy jej najwiekszym a
        // najmniejszym elementem
        System.out.println("Zadanie 14 - roznica");
        System.out.println(roznica(liczby));
        System.out.println();

        // 15) Napisz metode ktora przyjmuje liste Stringow i zwraca listę (intow) indeksow
        // wszystkich elementow na liscie, ktore sa takie same jak parametr metody
        // np dla Listy Ania Krzys Ania Piotr Tomek Ania i imienia Ania
        // output: to 0,2,5
        System.out.println("Zadanie 15 - indeksy");
        System.out.println(indeksy(imiona, "Ania"));
        System.out.println();

        // 16) Napisz metode ktora odwraca kolejnosc liczb w liscie ktora jest podana jako parametr
        // nie mozna uzywac nic z Collections
        System.out.println("Zadanie 16 - odwrotna kolejnosc");
        System.out.println("liczby: " + liczby);
        odwroc(liczby);
        System.out.println("liczby odwrocone: " + liczby);




    }




    //	2) Stworz metode ktora zwroci sume liczb z ArrayListy z 1 zadania

    public static int suma(List<Integer> liczby) {

        int suma = 0;

        for (Integer i : liczby) {
            suma += i;
        }

        return suma;
    }


    //	3) Stworz metode ktora zwroci liste elementow wiekszych od 3

    public static List<Integer> wiekszeOd3(List<Integer> liczby, int n) {
        List<Integer> noweLiczby = new ArrayList<>();

        for (Integer i : liczby) {
            if (i > n) {
                noweLiczby.add(i);
            }
        }
        return noweLiczby;
    }

    //	5) Napisz metode do zadania 4, ktora zwroci najdluzsze imie

    public static String najdluzszeImie(List<String> str) {

        String najdluzsze = "";

        for (String imie : str) {
            if (imie.length() > najdluzsze.length()) {
                najdluzsze = imie;
            }
        }

        return najdluzsze;
    }

    //	6) Napisz metode do zadani 4 ktora sprawdza czy podane imie znajduje sie w kolekcji
    public static Boolean znajdujeSie(List<String> imiona, String str) {
        return imiona.contains(str);
    }

    // 8) Napisz metode ktora uzupelnia losowa iloscia (od 2-8) liczb losowych z przedziaku 1-10,
    // wrzucmy te liczby do nowej listy posortujmy ja odwrotnie i zwracamy ta liste

    public static List<Integer> losoweLiczby() {
        List<Integer> liczby = new ArrayList<>();

        Random random = new Random();

        int dlugosc = random.nextInt(2, 9);

        for (int i = 0; i < dlugosc; i++) {
            int liczba = random.nextInt(1, 11);
            liczby.add(liczba);
        }

        liczby.sort(Comparator.reverseOrder());
        System.out.println(liczby);
        return liczby;
    }


    // 9) Napisz metode ktora jako parametr przyjmuje liste intow i zwraca wszystkie liczby parzyste z tej listy

    public static List<Integer> liczbyParzyste(List<Integer> liczby) {

        List<Integer> liczbyParzyste = new ArrayList<>();

        for (Integer i : liczby) {
            if (i % 2 == 0) {
                liczbyParzyste.add(i);
            }
        }
        System.out.println(liczbyParzyste);
        return liczbyParzyste;
    }


    // 10) Wyswietl wszystkie imiona męskie które znajduja sie w liscie

    public static List<String> imionaMeskie(List<String> imiona) {

        List<String> imionaMeskie = new ArrayList<>();

        for (String s : imiona) {
            if (!s.endsWith("a")) {
                imionaMeskie.add(s);
            }
        }
        System.out.println(imionaMeskie);
        return imionaMeskie;
    }

    // 11) Wyswietl ile razy było podane imie podane jako parametr

    public static int ileImion(List<String> imiona, String imie) {
        int licznik = 0;

        for (String s : imiona) {
            if (s == imie) {
                licznik++;
            }
        }
        System.out.println(licznik);
        return licznik;
    }

    // 12) Napisz metode ktora jako parametr przyjmuje Liste Stringow oraz znak. Zwroc
    // liste zawierajaca wszystkie
    // Stringi ktore zawieraja podana znak
    // Lista: Ania Kasia Grzegorz Tomek Magda a znak to a, to lista zwracana powinna
    // zawierac Ania Kasia Magda

    public static List<String> listaZnakow(List<String> imiona, String znak) {
        List<String> listaZnakow = new ArrayList<>();

        for (String s : imiona) {
            if (s.contains(znak)) {
                listaZnakow.add(s);
            }
        }
        System.out.println(listaZnakow);
        return listaZnakow;
    }


    // 13) Napisz metode ktora jako parametr przyjmuje 2 Listy Stringow i zwraca liste
    // elementów wspolnych, ktore sa na obu listach

    public static List<String> wspolne(List<String> lista1, List<String> lista2) {

        List<String> listaWspolna = new ArrayList<>();

        for (String s : lista1) {
            for (String s1 : lista2) {
                if (s == s1) {
                    listaWspolna.add(s);
                }
            }
        }
        return listaWspolna;
    }

    // 14) Napisz metode ktora dla listy intów zwroci roznice pomiedzy jej najwiekszym a
    // najmniejszym elementem

    public static int roznica(List<Integer> liczby) {
        int max = liczby.get(0);
        int min = liczby.get(0);

        for (Integer i : liczby) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        return max - min;
    }

    // 15) Napisz metode ktora przyjmuje liste Stringow i zwraca listę (intow) indeksow
    // wszystkich elementow na liscie, ktore sa takie same jak parametr metody
    // np dla Listy Ania Krzys Ania Piotr Tomek Ania i imienia Ania
    // output: to 0,2,5

    public static List<Integer> indeksy(List<String> imiona, String imie) {
        List<Integer> indeksy = new ArrayList<>();

        for (int i = 0; i < imiona.size(); i++) {
            if (imiona.get(i) == imie) {
                indeksy.add(i);
            }
        }
        return indeksy;
    }

    // 16) Napisz metode ktora odwraca kolejnosc liczb w liscie ktora jest podana jako parametr
    // nie mozna uzywac nic z Collections

    public static void odwroc(List<Integer> liczby) {
        int temp;
        for (int i = 0; i < liczby.size() / 2; i++) {
            temp = liczby.get(i);
            liczby.set(i, liczby.get(liczby.size() - 1 - i));
            liczby.set(liczby.size() - 1 - i, temp);
        }
    }

    // 17) Napisz metode ktora odwraca kolejnosc liczb w liscie ktora jest podana jako parametr
    // metoda ma odwrocic liste, nie ma nic zwracac, nie mozna wykorzystywac innych list/tablic
    // nie mozna uzywac nic z Collections

    // 18) majac liste intow zwróc liste intow tych ktore te ktore koncza sie na cyfre
    // podana jako porametr

    // 19) Wyświetl ile razy ktorekolwiek imie zostało powtórzone Np dla imion ania piotr ania tomek krzys tomek ania program
    // powinien wypisac 3, bo byly 3 potworki

    // 20) Wyswietl ile razy we wszystkich imionach była użyta samogłoska

    // 21) Napisz metodę która wyswietli unikalne imiona

    // 22) Zwroc liste imion które sa dluzsze niz 5 znakow o parzystej dlugosci

    // 23)Zwroc liczbe słow ktore sa zlozone z samych whitespaców np spacji

    // 24) Napisz metode ktora przyjmuje jako parametr liste Stringow oraz liste intow (tej samej dlugosci obie listy)
    //Metoda ma zwrocic liste Stringow z pirwszej listy ktorych dlugosc odpowiada liczbom na 2 liscie
    // Ania Krzys Tomek Kasia Jan
    // 4 2 5 8 3
    //Ania Tomek Jan

    // 25) napisz metode ktora przyjmuje liste intow i zwraca z niej wszystkie liczby pierwsze

    // 26) Napisz metode ktora przyjmuje jako parametr liste tablic Stringow i oblicza
    // sume dlugosci wszystkich Stringów
}
