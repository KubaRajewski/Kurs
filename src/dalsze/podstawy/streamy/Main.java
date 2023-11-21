package dalsze.podstawy.streamy;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(4, 1, 2, 5, 8));
        //  Stream<Integer> stream = lista.stream();
        lista.stream().forEach(i -> System.out.print(i + " "));
        System.out.println();

        int[] array = {3, 2, 1, 5, 4};
        Integer[] array2 = {1, 2, 34, 5};

        IntStream intStream = Arrays.stream(array);
        Stream<Integer> stream = Arrays.stream(array2);

        DoubleStream doubles = DoubleStream.of(1.4, 2.2, 3.3);
        IntStream ints = IntStream.range(0, 5);

        IntStream randomInts = new Random().ints(5, 0, 11);

        // Function, Predicate, Supplier, Consumer, UnaryOperator

        // filter(predicate)
        lista.stream().filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));
        System.out.println();

        // map(function)
        lista.stream().map(i -> i + 10).forEach(i -> System.out.print(i + " "));
        System.out.println();

        lista.stream().filter(i -> i % 2 == 0).map(i -> i + 10).forEach(i -> System.out.print(i + " "));
        System.out.println();

        // limit(i) ogranicza do i elementów od początku

        // skip(i) skipuje i elementów od początku listy

        // min(), max() zwracają najmniejsza i najwiekszy element (nie koniecznie liczba - comparator)

        // distinct() - wyciąga unikalne elementy

        // count() - wielkosc streama long

        // anyMatch() - przyjmuje predicate czy jakikolwiek się zgadza

        // allMatch() - przyjmuje predicate czy wszystkie się zgadza

        // findFirst() - zwraca pierwszy element streama

        // toList() - zwraca listę

        // collect() - zwraca inny typ

        // flatMap() - mapuje jeden stream na inny

        // map Firmy -> nazwe firm, mielismy 10 obiektow firma, zmapowlaismy na 10 stringow z nazwa
        // flatMap Firmy -> liste pracownikow, mielismy 10 firm, kazda firma ma 10 pracownikow otrzymujemy streama 100 praconikow
        List<Integer> lista2 = new ArrayList<>(Arrays.asList(4, null, 2, 5, 8));
        System.out.println(iloscElementow(lista2) + "\n");

        List<String> strings = new ArrayList<>(Arrays.asList("Kadf", "fae", "Kada"));

        Instant start1 = Instant.now();
        System.out.println(numberOfStringsStartingWith(strings, "K"));
        Instant end1 = Instant.now();

        Instant start2 = Instant.now();
        System.out.println(numberOfStringsStartingWith2(strings, "K"));
        Instant end2 = Instant.now();

        System.out.println("else: " + Duration.between(start1, end1)); // elseGet o wiele szybsze bo robi to tylko wtedy
                                                                        // kiedy wartosc faktycznie jest pusta
        System.out.println("elseGet: " + Duration.between(start2, end2));
    }

    // napisz metode która zwroci ilosc elementow na liscie Integerow
    public static long iloscElementow(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .count();
    }

    // napisz metode ktora liczy sume elementow listy integerow
    public static int sumaElementow(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int sumaElementow2(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    // napisz metode która zwroci liste liczb parzystych
    public static List<Integer> liczbyParzyste(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(i -> i % 2 == 0)
                .toList();
    }

    // napisz metode która policzy sume elementow nieparzystych ale uzyj method referecne
    public static int sumaLiczbyParzyste(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(Main::czyParzysta)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static boolean czyParzysta(int i) {
        return i % 2 == 0;
    }

    // napisz metode która policzy srednia listy intow
    // orElse() jesli wartosc jest obecna to ja zwraca a jesli nie to 0.0
    public static double sredniaListyInt(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static double sredniaListyInt2(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.averagingDouble(Integer::doubleValue));
    }

    // napisz metode która zwraca najmniejsza liczbe, jesli jej nie ma to rzuc wyjatkiem NoMinElementBro
    public static int minWartosc(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Integer::intValue))
                //.orElseThrow(IllegalArgumentException::new);
                .orElseThrow(() -> new IllegalArgumentException("bla bla"));
    }

    // napisz metode która zwraca najwieksza liczbe
    public static int maxWartosc(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Integer::intValue))
                //.orElseThrow(IllegalArgumentException::new);
                .orElseThrow(() -> new IllegalArgumentException("bla bla"));
    }

    // napisz metode która znajduje najdluzszego Stringa z listy
    public static String najdluzszyStrinf(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(String::length))
                .orElseThrow(() -> new IllegalArgumentException("bla bla"));
    }

    // napisz metode która znajduje wszystkie imiona męskie
    public static List<String> imionaMeskie(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.endsWith("a"))
                .toList();

    }

    // napisz metode która znajduje wszystkie stringi które posiadaja podany char
    public static List<String> stringiZDanymCharem(List<String> list, String c) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.contains(c))
                .toList();
    }

    // napisz metode ktora zwraca wszystkie wspolne elementy z dwoch list
    public static List<String> elementyWspolne(List<String> list, List<String> list2) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .filter(list2::contains)
                .toList();
    }

    // zwroc top 5 liczb z listy
    public static List<Integer> topNElementow(List<Integer> list, int n) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Integer::intValue))
                .limit(5)
                .toList();
    }

    // policz ile jakich liter jest w slowach na liscie stringow
    public static Map<Character, Long> ileCharowWLiscie(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    // napisz metode która przyjmuje jako prametr Liste list intow a jako wynik
    // zwraca wszystkie inty zawarte w strukturze
    public static List<Integer> distinctIntegers(List<List<Integer>> lists) {
        return Optional.ofNullable(lists)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    // czym sie rozni orElse od orElseGet? Sprawdz roznice w czasach wykonan tych metod na konkretnym przykladzie
    public static long numberOfStringsStartingWith(List<String> list, String str) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(s -> s.startsWith(str))
                .distinct()
                .count();
    }

    public static long numberOfStringsStartingWith2(List<String> list, String str) {
        return Optional.ofNullable(list)
                .orElse(new ArrayList<>())
                .stream()
                .filter(s -> s.startsWith(str))
                .distinct()
                .count();
    }

    // czym sie rozni of od ofNullable
    // tym ze of nullable akceptuje wartosc null, w momencie w ktorym element jest pusty optional zwroci pusty optional
    // optional.of nie akceptuje null i w razie w ktorym wartosc jest rowna null rzuci nullPointerException

    ////napisz metode ktora znajduje najmniejszy lub najwiekszy element z tablicy zaleznie od parametru metody

    ////napisz z pomoca Stream.iterate metorde ktora zwraca liste elementow od 1 do n

    //// napisz metode która generuje 100 liczb parzystych lub nieparzystych w zaleznosci od parametru :)

    //// napisz metode która stworzy dany ciag geometryczny

    //// napisz metode która stworzy dany ciag arytmetyczny

    //// napisz za pomoca streamow generator fibonaciego

    //// napisz metode liczaca sume n elementow fibo

    //// napisz metoda ktora zwraca liczby pierwsze z podanej listy

}
