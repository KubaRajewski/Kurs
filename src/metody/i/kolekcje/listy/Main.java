package metody.i.kolekcje.listy;

import java.util.ArrayList;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        //	1) Zadeklaruj ArrayListe intow, dodaj do niej 5 roznych liczb metoda add, wyswietl cala liste petla for each.
        System.out.println("Zadanie 1 - ArrayLista intow");
        List<Integer> liczby = new ArrayList<>();

        liczby.add(1);
        liczby.add(61);
        liczby.add(3);
        liczby.add(523);
        liczby.add(58);
        liczby.add(52);
        liczby.add(51);

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
        imiona.addAll(Arrays.asList("Tomek", "Ania", "krzysiu", "Grzes", "Tomek", "Marta", "Ania"));

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
        inneImiona.addAll(Arrays.asList("Miłosz", "Ania", "Kuba", "Marcin", "Tomek", "Marta"));

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
        System.out.println("liczby odwrocone: " + odwroc(liczby));
        System.out.println();

        // 17) Napisz metode ktora odwraca kolejnosc liczb w liscie ktora jest podana jako parametr
        // metoda ma odwrocic liste, nie ma nic zwracac, nie mozna wykorzystywac innych list/tablic
        // nie mozna uzywac nic z Collections
        System.out.println("Zadanie 17 - odwrotna kolejnosc");
        System.out.println("liczby: " + liczby);
        odwroc2(liczby);
        System.out.println("liczby odwrocone: " + liczby);
        System.out.println();

        // 18) majac liste intow zwróc liste intow tych ktore te ktore koncza sie na cyfre
        // podana jako porametr

        System.out.println("Zadanie 18 - koncza sie na cyfre");
        System.out.println("liczby: " + liczby);
        System.out.println("liczby koncza sie na 1: " + konczaSieNa(liczby, 1));
        System.out.println("liczby koncza sie na 2: " + konczaSieNa(liczby, 2));
        System.out.println();

        // 19) Wyświetl ile razy ktorekolwiek imie zostało powtórzone Np dla imion ania piotr ania tomek krzys tomek ania program
        // powinien wypisac 3, bo byly 3 potworki

        System.out.println("Zadanie 19 - ile razy imie");
        System.out.println("imiona: " + imiona);
        System.out.println("liczba powtorek: " + powtorki(imiona));
        System.out.println();

        // 20) Wyswietl ile razy we wszystkich imionach była użyta samogłoska

        System.out.println("Zadanie 20 - ile razy samogloska");
        System.out.println("imiona: " + imiona);
        System.out.println("liczba samoglosek: " + samogloski(imiona));
        System.out.println();

        // 21) Napisz metodę która wyswietli unikalne imiona
        System.out.println("Zadanie 21 - unikalne imiona");
        System.out.println("imiona: " + imiona);
        System.out.println("unikalne imiona: " + unikalne(imiona));
        System.out.println();

        // 22) Zwroc liste imion które sa dluzsze niz 5 znakow o parzystej dlugosci
        System.out.println("Zadanie 22 - dluzszeNiz5Parzyste");
        System.out.println("imiona: " + imiona);
        System.out.println("dluzsze niz 5 znakow o parzystej dlugosci: " + dluzszeNiz5Parzyste(imiona));
        System.out.println();

        // 23) Zwroc liczbe słow ktore sa zlozone z samych whitespaców np spacji

        List<String> imiona2 = new ArrayList<>();
        imiona2.addAll(Arrays.asList("Miłosz", "Ania", "Kuba", "Marcin", "Tomek", "Marta", "   ", "  ", "  ", "  "));

        System.out.println("Zadanie 23 - liczba spacji");
        System.out.println("imiona: " + imiona2);
        System.out.println("liczba spacji: " + liczbaSpacji(imiona2));
        System.out.println();

        // 24) Napisz metode ktora przyjmuje jako parametr liste Stringow oraz liste intow (tej samej dlugosci obie listy)
        // Metoda ma zwrocic liste Stringow z pirwszej listy ktorych dlugosc odpowiada liczbom na 2 liscie
        // Ania Krzys Tomek Kasia Jan
        // 4 2 5 8 3
        // Ania Tomek Jan

        List<String> imiona3 = new ArrayList<>();
        imiona3.addAll(Arrays.asList("Ania", "Krzys", "Tomek", "Kasia", "Jan"));

        List<Integer> liczby2 = new ArrayList<>();
        liczby2.addAll(Arrays.asList(4, 2, 5, 8, 3));


        System.out.println("Zadanie 24 - imiona o dlugosci z listy");
        System.out.println("imiona: " + imiona3);
        System.out.println("liczby: " + liczby2);
        System.out.println("imiona o dlugosci z listy: " + dlugoscStringDlugoscInt(liczby2, imiona3));
        System.out.println();


        // 25) napisz metode ktora przyjmuje liste intow i zwraca z niej wszystkie liczby pierwsze
        System.out.println("Zadanie 25 - liczby pierwsze");
        List<Integer> liczby4 = new ArrayList<>();
        liczby4.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("liczby: " + liczby4);
        System.out.println(znajdzLiczbyPierwsze(liczby4));
        System.out.println();

        // 27) Napisz metode ktora przyjmuje jako parametr liste tablic Stringow i oblicza
        // sume dlugosci wszystkich Stringów

        String[] tablica1 = {"Ania", "Krzys", "Tomek", "Kasia", "Jan" };
        String[] tablica2 = {"Ania", "Krzys", "Tomek", "Kasia", "Jan", "Marta", "Kuba", "Marek", "Kasia", "Jan" };

        List<String[]> tablice = new ArrayList<>();
        tablice.add(tablica1);
        tablice.add(tablica2);

        System.out.println("Zadanie 27 - suma dlugosci stringow");
        System.out.println();

        System.out.println("tablica1: ");
        for (String s : tablica1) {
            System.out.print(s + " ");
        }

        System.out.println();

        System.out.println();
        System.out.println("tablica2: ");
        for (String s : tablica2) {
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("suma dlugosci stringow: " + sumaDlugosciStringow(tablice));
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
            if (s.equals(imie)) {
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
                if (s.equals(s1)) {
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
            } else if (i < min) {
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

    public static List<Integer> odwroc(List<Integer> liczby) {
        int temp;
        for (int i = 0; i < liczby.size() / 2; i++) {
            temp = liczby.get(i);
            liczby.set(i, liczby.get(liczby.size() - 1 - i));
            liczby.set(liczby.size() - 1 - i, temp);
        }
        return liczby;
    }

    // 17) Napisz metode ktora odwraca kolejnosc liczb w liscie ktora jest podana jako parametr
    // metoda ma odwrocic liste, nie ma nic zwracac, nie mozna wykorzystywac innych list/tablic
    // nie mozna uzywac nic z Collections

    public static void odwroc2(List<Integer> liczby) {
        int temp;
        for (int i = 0; i < liczby.size() / 2; i++) {
            temp = liczby.get(i);
            liczby.set(i, liczby.get(liczby.size() - 1 - i));
            liczby.set(liczby.size() - 1 - i, temp);
        }
    }

    // 18) majac liste intow zwróc liste intow tych ktore te ktore koncza sie na cyfre
    // podana jako porametr

    public static List<Integer> konczaSieNa(List<Integer> liczby, int cyfra) {
        List<Integer> konczaSieNa = new ArrayList<>();

        for (Integer i : liczby) {
            if (i % 10 == cyfra) {
                konczaSieNa.add(i);
            }
        }
        return konczaSieNa;
    }

    // 19) Wyświetl ile razy ktorekolwiek imie zostało powtórzone Np dla imion ania piotr ania tomek krzys tomek ania program
    // powinien wypisac 3, bo byly 3 potworki

    public static int powtorki(List<String> strs) {
        int licznik = 0;
        List<Integer> sprawdzane = new ArrayList<>();
        for (int i = 0; i < strs.size(); i++) {
            sprawdzane.add(i);
            for (int j = 0; j < sprawdzane.size(); j++) {
                if (strs.get(i) == strs.get(j)) {
                    licznik++;
                }
            }
        }
        return licznik;
    }

    // 20) Wyswietl ile razy we wszystkich imionach była użyta samogłoska

    public static int samogloski(List<String> imiona) {
        int licznik = 0;
        for (String s : imiona) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                        || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'y') {
                    licznik++;
                }
            }
        }
        return licznik;
    }

    // 21) Napisz metodę która wyswietli unikalne imiona

    public static List<String> unikalne(List<String> imiona) {
        List<String> unikalne = new ArrayList<>();

        for (String s : imiona) {
            if (!unikalne.contains(s)) {
                unikalne.add(s);
            }
        }
        return unikalne;
    }

    // 22) Zwroc liste imion które sa dluzsze niz 5 znakow o parzystej dlugosci

    public static List<String> dluzszeNiz5Parzyste(List<String> imiona) {
        List<String> dluzszeNiz5Parzyste = new ArrayList<>();

        for (String s : imiona) {
            if (s.length() > 5 && s.length() % 2 == 0) {
                dluzszeNiz5Parzyste.add(s);
            }
        }
        return dluzszeNiz5Parzyste;
    }

    // 23) Zwroc liczbe słow ktore sa zlozone z samych whitespaców np spacji

    public static int liczbaSpacji(List<String> strs) {
        int licznik = 0;
        for (String s : strs) {
            if (s.trim().isEmpty()) {
                licznik++;
            }
        }
        return licznik;
    }

    // 24) Napisz metode ktora przyjmuje jako parametr liste Stringow oraz liste intow (tej samej dlugosci obie listy)
    // Metoda ma zwrocic liste Stringow z pirwszej listy ktorych dlugosc odpowiada liczbom na 2 liscie
    // Ania Krzys Tomek Kasia Jan
    // 4 2 5 8 3
    // Ania Tomek Jan

    public static List<String> dlugoscStringDlugoscInt(List<Integer> nums, List<String> strs) {
        List<String> dlugoscStringDlugoscInt = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            if (strs.get(i).length() == nums.get(i)) {
                dlugoscStringDlugoscInt.add(strs.get(i));
            }
        }
        return dlugoscStringDlugoscInt;
    }

    // 25) napisz metode ktora przyjmuje liste intow i zwraca z niej wszystkie liczby pierwsze
    public static boolean czyLiczbaPierwsza(int liczba) {
        if (liczba < 2) {
            return false;
        }
        for (int i = 2; i * i <= liczba; i++) {
            if (liczba % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> znajdzLiczbyPierwsze(List<Integer> listaLiczb) {
        List<Integer> liczbyPierwsze = new ArrayList<>();

        for (int liczba : listaLiczb) {
            boolean czyPierwsza = true;

            if (liczba < 2) {
                czyPierwsza = false;
            } else {
                for (int i = 2; i * i <= liczba; i++) {
                    if (liczba % i == 0) {
                        czyPierwsza = false;
                        break;
                    }
                }
            }

            if (czyPierwsza) {
                liczbyPierwsze.add(liczba);
            }
        }

        return liczbyPierwsze;
    }

    // 26) Napisz metode ktora przyjmuje jako parametr liste tablic Stringow i oblicza
    // sume dlugosci wszystkich Stringów

    public static int sumaDlugosciStringow(List<String[]> listaTablic) {
        int suma = 0;
        for (String[] tablica : listaTablic) {
            for (String s : tablica) {
                suma += s.length();
            }
        }
        return suma;
    }

    // 27) Napisz metode ktora przyjmuje jako parametr liste intow i zwraca mediane

    public static int mediana(List<Integer> nums) {
        Collections.sort(nums);
        if (nums.size() % 2 == 0) {
            return (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2;
        } else {
            return nums.get(nums.size() / 2);
        }
    }
}