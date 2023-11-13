package dalsze.podstawy.lambda;

import dalsze.podstawy.lambda.interfejsy.SprawdzLiczbe;
import dalsze.podstawy.lambda.interfejsy.Operacja;
import dalsze.podstawy.lambda.interfejsy.SprawdzNapis;
import dalsze.podstawy.lambda.interfejsy.Wyswietlacz;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //TODO napisz wyrazenie lambda ktore wykonuje operacje na 2 liczbach
        Operacja dodawanie = (a, b) -> a + b;
        System.out.println("Wynik dodawania: " + dodawanie.wykonaj(5, 3));

        //TODO napisz interfejs + lambda wyrazenie ktore sprawdza czy liczba jest parzysta
        SprawdzLiczbe czyParzysta = (a) -> a % 2 == 0;
        System.out.println("Czy parzysta: " + czyParzysta.sprawdz(5));

        //TODO napisz wyrazenie ktore sprawdza czy liczba jest wieksza od 5
        SprawdzLiczbe czyWiekszaNiz5 = (a) -> (a > 5);
        System.out.println("Czy wieksza niz 5: " + czyWiekszaNiz5.sprawdz(6));

        //TODO napis wyrazenie lambda ktore zwraca czy napis jest dluzszy niz 10, jesli tak to
        // returnujemy "dlugi" a jak nie "krotki"
        SprawdzNapis sprawdzDlugosc = napis -> napis.length() > 10 ? "dlugi" : "krotki";
        System.out.println("czy napis jest dlugi czy krotki: " + sprawdzDlugosc.sprawdz("bndevhucwue"));

        //TODO napisz interfejs ktory przyjmuje dowolny typ i go wyswietla
        Wyswietlacz<Integer> wyswietlaczLiczb = System.out::println;
        wyswietlaczLiczb.wyswietl(12);

        //TODO Oblicz sume dlugosci wszystkich stringow na liscie
        List<String> stringList = Arrays.asList("Java", "Lambda", "Wyrazenia", "Bardzo Dlugi Napis Dlugi");
        int sumaDlugosci = stringList.stream()
                .mapToInt(a -> a.length())
                .sum();
        System.out.println(sumaDlugosci);

        //TODO znajdz najdluzszego stringa na liscie
        String najdluzszyString = stringList.stream()
                .max(Comparator.comparing(string -> string.length()))
                .orElse(null);
        System.out.println("Najdluzszy string: " + najdluzszyString);

        //TODO Napisz program który za pomocą wyrażeń lambda wykona działania jak kalkulator
        // czyli dodawanie, odejmowanie, mnożenie i dzielenie.

        Operacja odejmowanie = (a, b) -> (a - b);
        Operacja mnozenie = (a, b) -> (a * b);
        Operacja dzielenie = (a, b) -> (a / b);

        System.out.println("Dodawanie " + dodawanie.wykonaj(5, 2));
        System.out.println("Odejmowanie " + odejmowanie.wykonaj(5, 2));
        System.out.println("Mnozenie " + mnozenie.wykonaj(5, 2));
        System.out.println("Dzielenie " + dzielenie.wykonaj(50, 2));

        //////////////////////////////////////////////////////////////////////////

        //TODO napisz metode która kazda liczbe z listy zastpeuje liczba 2* wieksza
        List<Integer> integerList = Arrays.asList(1, 2, 3, -4, 5, -6, 7, 8, 9, -10);
        System.out.println("Podwojona list: " + podwojonaLista(integerList));

        //TODO napisz metode która kazda liczbe mnozy przez sama siebie
        System.out.println("Lista do kwadratu: " + listDoKwadratu(integerList));

        //TODO napisz metode która do kazdego stringa z listy dodaje * na koncu
        System.out.println("Dodawanie gwiazdki: " + dodajGwiazdke(stringList));

        //TODO napisz metode która dla kazdego stringa dodaje y na poczatku i na koncu
        System.out.println("Dodawanie y: " + dodajY(stringList));

        //TODO napisz metode która wyfiltruje nam z listy intów wszystkie te które sa
        // mniejsze od 0
        System.out.println("Wyfiltrowana list " + dodatniaLista(integerList));

        //TODO napisz metode która wyfiltruje nam z listy intów wszystkie te które koncza
        // sie na liczbe podana jako parametr metody
        System.out.println("Lista liczb z dana koncowka: " + listZNKoncowka(integerList, 0));

        //TODO napisz metode ktora kazdego danego stringa z listy zastapi go potrojonym
        // stringiem, np
        // hello -> hellohellohello
        System.out.println("Potrojony string: " + potrojonyString(stringList));

        //TODO napisz metode ktora wszystkie elementy z listy zastepuje malymi literami
        System.out.println("Zamiana na male litery: " + zamianaNaMaleLitery(stringList));

        //TODO napisz metode ktora dla kazdego stringa usuwa z niego wszystkie literki a
        System.out.println("Wyrzuc wszystkie litery a: " + wyrzucWszystkiLiteryN(stringList, 'a'));

        //TODO napisz metode która wyrzuci z listy intow elementy ktore sa z przedzialu od a
        // do b (a i b to parametry metody)
        System.out.println("Wyrzucamy z listy liczby z danego przedzialu: " + wyrzucZListyLiczbyZPrzedzialu(integerList, -20, 0));

        //TODO napisz metode ktora z listy stringów wyswietli tylko te które posiadaja a
        System.out.println("Zwracamy liste stringow ktore zawieraja litere a: " + zawierajaLitereN(stringList, "a"));

        //TODO napisz metode która sortuje liczby rosnaco z uzyciem metody list.sort()
        System.out.println("Sortujemy liste rosnaco: " + sortujListeRosnaco(integerList));

        //TODO napisz metode która dla podanej listy doubli zwraca liste zawierajaca
        // pierwiastki liczby z pierwotnej listy
        List<Double> doubleList = Arrays.asList(4.0, 16.0, 64.0);
        System.out.println("Zwracamy liste pierwiastki z pierwotnej listy: " + zwrocListePierwiastkow(doubleList));

        //TODO napisz metode ktora wyswietli cała liste bez uzywania petli oraz bez [,]
        wyswietlElementyListy(doubleList);
        System.out.println();

        //TODO napisz metode która dla podanego klucza zwieksza jego wartosc o 100 jesli
        // klucz istnieje

        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("klucz1", 50);
        mapa.put("klucz2", 200);

        System.out.println("mapa przed: " + mapa);
        zwiekszOWartosc(mapa, "klucz1");
        zwiekszOWartosc(mapa, "klucz3");
        System.out.println("mapa po: " + mapa);

        //TODO napisz metode ktora dla podanego klucza ustawia wartosc 5000 jesli klucz nie
        // istnieje

        //TODO napisz metode ktora podwaja stringa, uzyj metody transform z klasy String
        String original = "Hello";
        System.out.println("Oryginalny: " + original);
        System.out.println("Podwojony: " + podwojString(original));

        //TODO napisz metode która ze stringa w ktorym wyrazy sa rozdzielone przecinkiem
        // tworzy liste tych wyrazow
        String napis = "jabłko,gruszka,pomarańcza,banan";
        System.out.println(napisDoListy(napis));
    }

    public static List<Integer> podwojonaLista(List<Integer> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<Integer> newList = new ArrayList<>(List.copyOf(list));

        newList.replaceAll(integer -> integer * 2);

        return newList;
    }

    public static List<Integer> listDoKwadratu(List<Integer> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<Integer> newList = new ArrayList<>(List.copyOf(list));

        newList.replaceAll(integer -> integer ^ 2);

        return newList;
    }

    public static List<String> dodajGwiazdke(List<String> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<String> newList = new ArrayList<>(List.copyOf(list));

        newList.replaceAll(string -> string + "*");

        return newList;
    }

    public static List<String> dodajY(List<String> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<String> newList = new ArrayList<>(List.copyOf(list));

        newList.replaceAll(string -> "y" + string + "y");

        return newList;
    }

    public static List<Integer> dodatniaLista(List<Integer> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<Integer> newList = new ArrayList<>(List.copyOf(list));

        newList.removeIf(i -> i > 0);

        return newList;
    }

    public static List<Integer> listZNKoncowka(List<Integer> list, int n) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<Integer> newList = new ArrayList<>(List.copyOf(list));

        newList.removeIf(a -> Math.abs(a) % 10 == n);

        return  newList;
    }

    public static List<String> potrojonyString(List<String> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<String> newList = new ArrayList<>(List.copyOf(list));

        newList.replaceAll(s -> s + s + s);

        return newList;
    }

    public static List<String> zamianaNaMaleLitery(List<String> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<String> newList = new ArrayList<>(List.copyOf(list));

        newList.replaceAll(String::toLowerCase);

        return newList;
    }

    public static List<String> wyrzucWszystkiLiteryN(List<String> list, char litera) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<String> newList = new ArrayList<>(List.copyOf(list));

        newList.replaceAll(s -> s.replaceAll("(?i)" + litera, ""));

        return newList;
    }

    public static List<Integer> wyrzucZListyLiczbyZPrzedzialu(List<Integer> list, int a, int b) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<Integer> newList = new ArrayList<>(List.copyOf(list));

        newList.removeIf(x -> x < a || x > b);

        return newList;
    }

    public static List<String> zawierajaLitereN(List<String> list, String a) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<String> newList = new ArrayList<>(List.copyOf(list));

        newList.removeIf(string -> string.contains(a));

        return newList;
    }

    public static List<Integer> sortujListeRosnaco(List<Integer> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<Integer> newList = new ArrayList<>(List.copyOf(list));

        newList.sort(Comparator.comparing(Integer::intValue));

        return newList;
    }

    public static List<Double> zwrocListePierwiastkow(List<Double> list) {
        Objects.requireNonNull(list, "Lista nie może być null");
        List<Double> newList = new ArrayList<>(List.copyOf(list));

        newList.replaceAll(Math::sqrt);

        return newList;
    }

    public static <T> void wyswietlElementyListy(List<T> list) {
        Objects.requireNonNull(list, "Lista nie może być null");

        list.forEach(element -> System.out.print(element + " "));
    }

    public static void zwiekszOWartosc(Map<String, Integer> mapa, String klucz) {
        mapa.merge(klucz, 100, Integer::sum);
    }

    public static void ustawWartosc(Map<String, Integer> mapa, String klucz) {
        mapa.putIfAbsent(klucz, 5000);
    }

    public static String podwojString(String string) {
        return string.transform(s -> s + s);
    }

    public static List<String> napisDoListy(String napis) {
        List<String> list = Arrays.asList(napis.split(","));
        list.replaceAll(String::trim);

        return list;
    }
}