package dalsze.podstawy.streamy.zadania;

import dalsze.podstawy.streamy.zadania.klasy.pomocnicze.Person;
import dalsze.podstawy.streamy.zadania.klasy.pomocnicze.Person.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    //// 1 Policz sumę elementów parzystych w liście liczb całkowitych, ale pomijaj liczby, które są większe niż 100.
    public static int sumEvenNumbersMoreThenN(List<Integer> list, int n) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(m -> m % 2 == 0 && m < n)
                .reduce(0, Integer::sum);
    }

    //// 2 Znajdź wszystkie pary liczb z listy liczb całkowitych, których suma jest równa określonej wartości.
    public static List<List<Integer>> pairsWhichSumToN(List<Integer> list, int sum) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMap(i -> list.stream()
                        .filter(j -> i + j == sum)
                        .map(j -> List.of(i, j)))
                .toList();
    }

    //// 3 Oblicz iloczyn wszystkich liczb zmiennoprzecinkowych w liście i zaokrąglij wynik do dwóch miejsc po przecinku.

    public static <T> double productOfAllElements(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(object -> object instanceof Double)
                .mapToDouble(i -> (Double) i)
                .reduce(1.0, (a, b) -> (a * b));
    }

    //// 4 Znajdź najczęściej występujące słowo w liście napisów (rozważając małe/duże litery jako to samo słowo).
    public static String mostFrequentWord(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        Map<String, Long> wordCounts = list.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        Map.Entry<String, Long> mostFrequent = wordCounts.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        assert mostFrequent != null;
        return mostFrequent.toString();
    }

    //// 5 Wygeneruj listę liczb pierwszych w określonym zakresie (np. od 1 do 100).
    public static List<Integer> generatePrimeNumbersInRange(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException();
        }

        return IntStream.range(min, max)
                .filter(Main::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int number) {
        return number >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> number % n == 0);
    }


    //// 6 Znajdź wszystkie kombinacje liczb z listy, które sumują się do określonej liczby.
    public static List<List<Integer>> combinationsWhichSumToN(List<Integer> list, int sum) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMap(i -> list.stream()
                        .filter(j -> i + j == sum)
                        .map(j -> List.of(i, j)))
                .toList();
    }

    //// 7 Posortuj listę obiektów po kilku polach, na przykład po wieku, nazwisku i wyniku egzaminu.
    public static List<Person> sortedByNameAgeExamScore(List<Person> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        Comparator<Person> personComparator = Comparator
                .comparing(Person::getAge)
                .thenComparing(Person::getName)
                .thenComparing(Person::getExamScore);

        return list.stream()
                .sorted(personComparator)
                .collect(Collectors.toList());
    }

    //// 8 Znajdź wszystkie anagramy danej frazy w liście napisów.
    public static List<String> anagrams(List<String> list, String str) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> stringToSortedLowercaseCharList(s).equals(stringToSortedLowercaseCharList(str)))
                .collect(Collectors.toList());
    }

    public static List<Character> stringToSortedLowercaseCharList(String str) {
        str = str.toLowerCase();
        return str.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(Collectors.toList());
    }

    // 9 Wykonaj równoległe przetwarzanie strumieni dla zadań, które można rozdzielić na kilka niezależnych operacji.

    //// 10 Stwórz histogram dla listy liczb całkowitych, określając ile razy każda liczba występuje w liście.
    public static Map<Integer, Integer> histogram(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).collect(Collectors.toMap(
                        i -> i,
                        i -> 1,
                        Integer::sum));
    }

    //// 11 Znajdź drugą najmniejszą liczbę w liście liczb całkowitych.
    public static int secondSmallest(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).sorted()
                .skip(1)
                .findFirst()
                .orElseThrow();
    }

    //// 12 Wyfiltrowanie napisów z listy, które zawierają tylko małe litery.
    public static List<String> onlyLowercase(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(s -> s.equals(s.toLowerCase()))
                .collect(Collectors.toList());
    }

    //// 13 Oblicz iloczyn dwóch list liczb całkowitych (element po elemencie) i zwróć wynik jako nową listę.
    public static List<Integer> productOfTwoLists(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty() || list1.size() != list2.size()) {
            throw new IllegalArgumentException();
        }

        return IntStream.range(0, list1.size())
                .mapToObj(i -> list1.get(i) * list2.get(i))
                .collect(Collectors.toList());
    }

    //// 14 Połącz kilka list napisów w jedną listę unikalnych napisów.
    public static List<String> combineAndDistinct(List<List<String>> lists) {
        return Optional.ofNullable(lists)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    //// 15 Posortuj listę obiektów po dwóch polach, na przykład po roku urodzenia i nazwisku.
    public static List<Person> sortedByBirthDateAndName(List<Person> list) {
        Comparator<Person> personComparator = Comparator
                .comparing(Person::getBirthDate)
                .thenComparing(Person::getName);

        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .sorted(personComparator)
                .collect(Collectors.toList());
    }

    //// 16 Znajdź sumę długości wszystkich napisów w liście napisów zawierających określone słowo.
    public static int containsStringLengthSum(List<String> list, String str) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(s -> s.contains(str))
                .mapToInt(String::length)
                .sum();
    }

    //// 17 Stwórz mapę, gdzie kluczem jest napis, a wartością jest liczba wystąpień tego napisu w liście.
    public static Map<String, Integer> stringCount(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).collect(Collectors.toMap(
                        i -> i,
                        i -> 1,
                        Integer::sum));
    }

    //// 18 Wybierz tylko te obiekty z listy, które mają wartość określonego pola z zakresu wartości.
    public static <T> List<T> elementsWithCertainValue(List<T> list, T a) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(x -> Objects.equals(x, a))
                .collect(Collectors.toList());
    }

    //// 19 Przekształć mapę z listą obiektów do listy, w której klucze mapy będą polami obiektów.

    //// 20 Znajdź największą sumę podciągu kolejnych liczb w liście liczb całkowitych (tzw. maksymalna suma podciągu).
    public static int maximumSubstringSum(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .reduce(new int[]{0, Integer.MIN_VALUE}, (acc, x) -> {
                    acc[0] = Math.max(x, acc[0] + x);
                    acc[1] = Math.max(acc[1], acc[0]);
                    return acc;
                }, (acc1, acc2) -> {
                    throw new UnsupportedOperationException("Combining not supported");
                })[1];
    }

    //// 21 Znajdź sumę wszystkich liczb całkowitych w liście.
    public static <T> int integerSum(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Integer)
                .mapToInt(i -> (Integer) i)
                .sum();
    }

    //// 22 Znajdź największą liczbę całkowitą w liście.
    public static <T> int maxInteger(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Integer)
                .mapToInt(i -> (Integer) i)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    //// 23 Znajdź najmniejszą liczbę całkowitą w liście.
    public static <T> int minInteger(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Integer)
                .mapToInt(i -> (Integer) i)
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    //// 24 Znajdź średnią z liczb zmiennoprzecinkowych w liście.
    public static <T> double meanDouble(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Double)
                .mapToDouble(i -> (Double) i)
                .average()
                .orElse(Double.NaN);
    }


    //// 25 Znajdź iloczyn wszystkich liczb całkowitych dodatnich w liście.
    public static <T> int intProduct(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Integer && (Integer) object > 0)
                .mapToInt(i -> (Integer) i)
                .reduce(1, (a, b) -> a * b);
    }

    //// 26 Znajdź liczbę wystąpień danego napisu w liście napisów.
    public static long stringAppearances(List<String> list, String string) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.equals(string))
                .count();
    }

    //// 27 Znajdź długość najdłuższego napisu w liście napisów.
    public static int longestStringLength(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).mapToInt(String::length)
                .max()
                .orElse(0);
    }

    //// 28 Znajdź napisy, które zaczynają się od określonego prefiksu.
    public static List<String> stringsStartingWithPrefix(List<String> list, String prefix) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(string -> string.startsWith(prefix))
                .collect(Collectors.toList());
    }

    //// 29 Znajdź liczbę unikalnych liczb całkowitych w liście.
    public static <T> long uniqueNumbersInList(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(object -> object instanceof Integer)
                .distinct()
                .count();
    }

    //// 30 Znajdź pierwszą liczbę parzystą w liście.
    public static <T> int firstEvenNumber(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Number)
                .mapToInt(i -> (Integer) i)
                .filter(i -> i % 2 == 0)
                .findFirst()
                .orElse(Integer.MAX_VALUE);
    }

    //// 31 Znajdź ostatnią liczbę nieparzystą w liście.
    public static <T> int lastOddNumber(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Number)
                .mapToInt(i -> (Integer) i)
                .filter(i -> i % 2 != 0)
                .reduce((first, second) -> second)
                .orElse(Integer.MAX_VALUE);
    }

    //// 32 Znajdź wszystkie liczby podzielne przez 3 w liście.
    public static <T> List<Integer> divisibleBy3(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Integer)
                .mapToInt(i -> (Integer) i)
                .filter(i -> i % 3 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    //// 33 Zamień wszystkie litery w napisach na małe litery.
    public static List<String> changeToLowercase(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    //// 34 Oblicz sumę kwadratów liczb całkowitych w liście.
    public static <T> int sumOfSquares(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(i -> i instanceof Integer)
                .mapToInt(i -> (Integer) i)
                .map(x -> x * x)
                .sum();
    }

    //// 35 Sprawdź, czy lista liczb jest pusta.
    public static boolean checkIfEmpty(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        return list.stream().allMatch(Objects::isNull);
    }

    //// 36 Znajdź najmniejszą liczbę z zakresu od 20 do 50.
    public static int smallestNumberInRange(int start, int finish) {
        if (finish < start) {
            throw new IllegalArgumentException("Range error");
        }

        return IntStream.rangeClosed(start, finish)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Empty range"));
    }

    //// 37 Znajdź napisy, które zawierają określony znak.
    public static List<String> stringsContainingChar(List<String> list, char c) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(s -> s.contains(String.valueOf(c)))
                .collect(Collectors.toList());
    }

    //// 38 Znajdź długość wszystkich napisów w liście.
    public static List<Integer> lengthsOfStrings(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .collect(Collectors.toList());
    }

    //// 39 Posortuj liczby całkowite w liście od największej do najmniejszej.
    public static List<Integer> sortReverseOrder(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    //// 40 Znajdź napisy o długości większej niż 5 znaków.
    public static List<String> stringsLongerThanN(List<String> list, int n) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(s -> s.length() > n)
                .collect(Collectors.toList());
    }

    //// 41 Znajdź liczbę liczb całkowitych w liście, które są większe od 50.
    public static <T> long countOfNumbersLongerThanN(List<T> list, int n) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(object -> object instanceof Integer)
                .mapToInt(i -> (Integer) i)
                .filter(i -> i > n)
                .count();
    }

    //// 42 Znajdź najmniejszy napis (według długości) w liście napisów.
    public static String shortestString(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new IllegalArgumentException("shortest string not found"));
    }

    //// 43 Znajdź sumę wszystkich liczb zmiennoprzecinkowych w liście większych niż 0.
    public static <T> double sumOfNumbersGreaterThanN(List<T> list, int n) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(object -> object instanceof Double)
                .mapToDouble(i -> (Double) i)
                .filter(i -> i > n)
                .sum();
    }

    //// 44 Znajdź długość wszystkich napisów, które mają co najmniej 3 znaki.
    public static List<Integer> lengthsOfStringsLongerThanN(List<String> list, int minLength) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).map(String::length)
                .filter(length -> length >= minLength)
                .collect(Collectors.toList());
    }

    //// 45 Znajdź wszystkie liczby pierwsze w liście liczb całkowitych.
    public static List<Integer> primeNumbers(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(Main::isPrime)
                .toList();
    }

    //// 46 Znajdź sumę różnic kolejnych liczb całkowitych w liście.
    public static int sumOfDifferences(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMapToInt(i -> IntStream.range(0, list.size() - 1).map(j -> list.get(j) - list.get(j + 1)))
                .sum();
    }

    //// 47 Znajdź napisy, które zawierają tylko litery (bez cyfr ani znaków specjalnych).
    public static List<String> stringsThatMatchPattern(List<String> list, String pattern) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(s -> Pattern.matches(pattern, s))
                .toList();
    }

    //// 48 Znajdź sumę kwadratów liczb całkowitych nieparzystych.
    public static <T> int sumOfSquaresOddNumbers(List<T> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).filter(a -> a instanceof Integer)
                .mapToInt(a -> (Integer) a)
                .filter(i -> i % 2 != 0)
                .map(x -> x * x)
                .sum();
    }


    //// 49 Znajdź unikalne znaki występujące we wszystkich napisach z listy napisów.
    public static List<Character> distinctCharsInStringList(List<String> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull).flatMapToInt(CharSequence::chars)
                .distinct()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    //// 50 test wszystkich metod
    public static void testAll() {
        List<Integer> numbers = List.of(1, 2, 3, 3, 42, 4, 5, 6, 90, 3124, 456, -8, -25);
        List<Double> numbersDouble = List.of(1.0, 2.1, 3.8, 42.4, 4.0, 5.0, 6.0, 90.2, 3124.4, 456.6, -8.6, -25.54);
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        List<String> words2 = List.of("ma", "kota", "afsdv", "kofeaet", "fecea", "Ale", "laa");
        List<String> words3 = List.of("komputer", "kota", "a", "gosia", "ma", "Ale", "kuba");
        List<List<String>> wordsList = List.of(words, words2, words3);
        List<Person> people = List.of(new Person("Jan", LocalDate.of(2003, 12, 2), 87.3),
                new Person("Gosia", LocalDate.of(1999, 2, 11), 90.5),
                new Person("Kuba", LocalDate.of(1973, 8, 23), 100.0));

        System.out.println("sum of even numbers more than 100: " + sumEvenNumbersMoreThenN(numbers, 100));
        System.out.println("pairs which sum to 3: " + pairsWhichSumToN(numbers, 3));
        System.out.println("product of all elements: " + productOfAllElements(numbersDouble));
        System.out.println("most frequent word: " + mostFrequentWord(words));
        System.out.println("generate prime numbers in range: " + generatePrimeNumbersInRange(1, 20));
        System.out.println("combinations which sum to 5: " + combinationsWhichSumToN(numbers, 5));
        System.out.println("sorted by name, age, and exam score: " + sortedByNameAgeExamScore(people));
        System.out.println("anagrams: " + anagrams(words, "leppa"));
        System.out.println("sorted by birth date and name: " + sortedByBirthDateAndName(people));
        System.out.println("contains string length sum: " + containsStringLengthSum(words, "banana"));
        System.out.println("histogram: " + histogram(numbers));
        System.out.println("second smallest number: " + secondSmallest(numbers));
        System.out.println("only lowercase strings: " + onlyLowercase(words));
        System.out.println("product of two lists: " + productOfTwoLists(numbers, numbers));
        System.out.println("combine and distinct: " + combineAndDistinct(wordsList));
        System.out.println("contains string length sum: " + containsStringLengthSum(words, "banana"));
        System.out.println("string count: " + stringCount(words));
        System.out.println("integer check list: " + elementsWithCertainValue(numbers, 5));
        System.out.println("maximum substring sum: " + maximumSubstringSum(numbers));
        System.out.println("integer sum: " + integerSum(numbers));
        System.out.println("max integer: " + maxInteger(numbers));
        System.out.println("min integer: " + minInteger(numbers));
        System.out.println("mean double: " + meanDouble(numbersDouble));
        System.out.println("int product: " + intProduct(numbers));
        System.out.println("string appearances: " + stringAppearances(words, "apple"));
        System.out.println("longest string length: " + longestStringLength(words));
        System.out.println("strings starting with prefix: " + stringsStartingWithPrefix(words, "app"));
        System.out.println("unique numbers in list: " + uniqueNumbersInList(numbers));
        System.out.println("first even number: " + firstEvenNumber(numbers));
        System.out.println("last odd number: " + lastOddNumber(numbers));
        System.out.println("divisible by 3: " + divisibleBy3(numbers));
        System.out.println("change to lowercase: " + changeToLowercase(words));
        System.out.println("sum of squares: " + sumOfSquares(numbers));
        System.out.println("check if empty: " + checkIfEmpty(numbers));
        System.out.println("smallest number in range: " + smallestNumberInRange(5, 15));
        System.out.println("strings containing char: " + stringsContainingChar(words, 'a'));
        System.out.println("lengths of strings: " + lengthsOfStrings(words));
        System.out.println("sort reverse order: " + sortReverseOrder(numbers));
        System.out.println("strings longer than N: " + stringsLongerThanN(words, 5));
        System.out.println("count of numbers longer than N: " + countOfNumbersLongerThanN(numbers, 2));
        System.out.println("shortest string: " + shortestString(words));
        System.out.println("sum of numbers greater than N: " + sumOfNumbersGreaterThanN(numbers, 5));
        System.out.println("lengths of strings longer than N: " + lengthsOfStringsLongerThanN(words, 4));
        System.out.println("prime numbers: " + primeNumbers(numbers));
        System.out.println("sum of differences: " + sumOfDifferences(numbers));
        System.out.println("strings that match pattern: " + stringsThatMatchPattern(words, ".*pple"));
        System.out.println("sum of squares odd numbers: " + sumOfSquaresOddNumbers(numbers));
        System.out.println("distinct chars in string list: " + distinctCharsInStringList(words));
    }

    public static void main(String[] args) {
        testAll();
    }
}