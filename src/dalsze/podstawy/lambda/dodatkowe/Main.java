package dalsze.podstawy.lambda.dodatkowe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
// TODO Podstawowe
// - Filtrowanie kolekcji: Napisz wyrażenie lambda, które filtruje listę liczb całkowitych, zwracając tylko te, które są parzyste.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> even = new ArrayList<>();

        numbers.forEach(num -> {
            if (num % 2 == 0) {
                even.add(num);
            }
        });

        even.forEach(System.out::println);
        System.out.println();


// - Sortowanie kolekcji: Użyj wyrażenia lambda, aby posortować listę ciągów znaków alfabetycznie.
        List<String> strings = new ArrayList<>(List.of("aaaa", "ddd", "cad", "x", "b"));
        strings.sort(String::compareTo);

        strings.forEach(System.out::println);
        System.out.println();

// - Konwersja elementów listy: Stwórz wyrażenie lambda, które przekształca wszystkie ciągi na liście na ich wielkie litery.
        strings.replaceAll(str -> str.toUpperCase());
        strings.forEach(System.out::println);
        System.out.println();

// - Sumowanie wartości: Napisz wyrażenie lambda, które sumuje wszystkie liczby w liście przy użyciu metody reduce() ze strumieni.
        List<Integer> listaLiczb = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(sumaKwadratowParzystychLiczb(listaLiczb));

        int suma = listaLiczb.stream().reduce(0, Integer::sum);
        System.out.println(suma);


// TODO Średnio zaawansowane
// - Tworzenie własnego interfejsu funkcyjnego: Zdefiniuj własny interfejs funkcyjny z jedną metodą abstrakcyjną, a następnie użyj wyrażenia lambda do jego implementacji.
        Predicate<Integer> p = i -> i == 0;

        List<Integer> listFiltered = listaLiczb.stream()
                .filter(p)
                .toList();

        listFiltered.forEach(System.out::println);

// - Wykorzystanie łańcuchów wyrażeń lambda: Użyj wyrażeń lambda w połączeniu ze strumieniami, aby wykonać filtrowanie, sortowanie i mapowanie kolekcji w jednym łańcuchu operacji.
// - Zastosowanie w programowaniu zdarzeniowym: Napisz prosty interfejs graficzny (np. przy użyciu Swing), w którym zdarzenia przycisków obsługiwane są przez wyrażenia lambda.
// - Operacje na mapie: Użyj wyrażeń lambda do iteracji przez Map i wykonaj operację na każdym kluczu i wartości (np. wydrukuj każdy klucz i jego wartość podwojoną).
// - Obsługa wyjątków w wyrażeniach lambda: Stwórz wyrażenie lambda, które może generować wyjątek, i obsłuż ten wyjątek wewnątrz wyrażenia lub poza nim.

// TODO Zaawansowane
// - Zastosowanie referencji do metody: Wykorzystaj referencje do metody w połączeniu z wyrażeniami lambda, aby przekazać zachowanie metody jako parametr do innej funkcji.
// - Wprowadzenie do programowania funkcyjnego: Stwórz przykład użycia wyrażeń lambda, który ilustruje idee programowania funkcyjnego, np. niemutowalność danych i funkcje czyste.
// - Wykorzystanie opcjonalnych: Napisz wyrażenie lambda, które działa z typem Optional w Javie, np. do eleganckiego obsługiwania możliwych wartości null.
// - Kompozycja funkcji: Zaimplementuj kilka prostych funkcji matematycznych jako wyrażenia lambda i pokaż, jak można je komponować, aby stworzyć bardziej skomplikowane operacje.
// - Strumienie równoległe: Użyj wyrażenia lambda do przetwarzania danych w strumieniu równoległym i zilustruj różnicę w wydajności między strumieniem sekwencyjnym a równoległym.
    }

    public static int sumaKwadratowParzystychLiczb(List<Integer> list) {
        int sum = 0;

        for (Integer i : list) {
            if (i % 2 == 0) {
                sum = sum + i ^ 2;
            }
        }

        return sum;
    }
}
