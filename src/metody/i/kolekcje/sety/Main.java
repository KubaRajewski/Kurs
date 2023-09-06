package metody.i.kolekcje.sety;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

// Wymyślone zadania z tematem zbiorów (setów) w Javie:

        List<Integer> lista = Arrays.asList(3, 24, 3, 0, 55, 55, 24, 0, 7, 67, 23);
        List<Integer> lista2 = Arrays.asList(33, 4, 31, 0, 535, 55, 4, 3, 67, 3, 87);
        List<String> lista3 = Arrays.asList("kuba", "natan", "ala", "tomek");

// 1. Usuwanie duplikatów

        System.out.println("Usuwanie duplikatow z listy: " + lista);
        System.out.println("output: " + usunDuplikaty(lista));
        System.out.println();

// 2. Wspólne elementy

        System.out.println("Wspolne elementy z listy: " + lista + " i listy: " + lista2);
        System.out.println("output: " + wspolneElementy(lista, lista2));
        System.out.println();

// 3. Zliczanie słów

        System.out.println("Zliczanie slow: ");
        System.out.println("output: " + zliczanieSlow("ala ma kota a kot ma ale no i ala nie ma psa"));
        System.out.println();

// 4. Anagramy

        System.out.println("Anagramy: ");
        System.out.println("output: " + anagramy("kot", "tok"));
        System.out.println();

// 5. Usuwanie powtórzeń w tekście

        System.out.println("Usuwanie powtorzen w tekscie: ");
        System.out.println("output: " + usuwaniePowtorzen("ala ma kota a kot ma ale no i ala nie ma psa"));
        System.out.println();

// 6. Suma zbiorów
        System.out.println("suma dwoch list jako zbior");
        System.out.println("lista 1: " + lista);
        System.out.println("lista 2: " + lista2);
        System.out.println("suma: " + sumaZbiorow(lista, lista2));
        System.out.println();

// 7. Zbiór znaków
        System.out.println("Znaki z danego Stringa ");
        System.out.println("String: Kuba" );
        System.out.println("Set: " + zbiorZnakow("Kuba"));
        System.out.println();

// 8. Palindromy
        System.out.println("Palidromy");
        System.out.println("Lista: " + lista3);
        System.out.println("Palidromy: " + palidromy(lista3));


// todo
// 6. Zbiór osób
// Stwórz klasę Person z polami name (imię) i age (wiek). Następnie utwórz zbiór osób
// i sprawdź, czy istnieje w nim osoba o podanym imieniu i wieku.
// todo
// 7. Zbiór książek
// Stwórz klasę Book z polami title (tytuł) i author (autor). Utwórz zbiór książek i zaimplementuj funkcję,
// która znajdzie i wyświetli wszystkich autorów, którzy mają więcej niż jedną książkę w zbiorze.


// 2. Podzbiory
// Napisz funkcję, która generuje wszystkie możliwe podzbiory zbioru liczb całkowitych i zwraca je jako zbiór zbiorów.

// 3. Słownik anagramów
// Stwórz program, który wczytuje dużą listę słów i tworzy słownik, gdzie kluczem jest posortowany alfabetycznie zestaw liter,
// a wartością jest zbiór wszystkich słów, które mają takie same litery.

// 4. Sudoku solver
// Napisz program, który rozwiązuje łamigłówkę Sudoku. Wykorzystaj zbiory, aby przechowywać możliwe liczby dla każdego pola.

// 5. Najdłuższy wspólny podciąg
// Napisz funkcję, która przyjmuje dwie listy łańcuchów znaków i znajduje najdłuższy wspólny podciąg
// (czyli sekwencję znaków, która występuje w obu listach).

// 6. Zbiory rozłączne
// Stwórz klasę DisjointSet do reprezentowania zbiorów rozłącznych. Zaimplementuj operacje union (łączenie zbiorów)
// oraz find (znajdowanie zbioru).

// 7. Algorytm Bloom Filter
// Zaimplementuj strukturę danych Bloom Filter, która umożliwia efektywne sprawdzanie czy element jest w zbiorze.
// Możesz wykorzystać różne funkcje haszujące i bitsety.

// 8. Permutacje
// Napisz funkcję, która generuje wszystkie permutacje zbioru liczb całkowitych i zwraca je jako zbiór zbiorów.

// 9. Ciągi arytmetyczne
// Napisz funkcję, która sprawdza, czy dana lista liczb całkowitych zawiera dowolny ciąg arytmetyczny o długości co najmniej 3.

// 10. Kolorowanie grafu
// Stwórz algorytm kolorowania grafu, który wykorzystuje zbiory do przypisywania kolorów w taki sposób,
// aby żadne dwa połączone wierzchołki nie miały tego samego koloru.

    }


// 1. Usuwanie duplikatów
// Napisz funkcję, która przyjmuje listę liczb całkowitych i zwraca zbiór, który zawiera tylko unikalne elementy z listy.

    public static Set<Integer> usunDuplikaty(List<Integer> lista) {
        return new HashSet<>(lista);
    }

// 2. Wspólne elementy
// Napisz funkcję, która przyjmuje dwie listy liczb całkowitych i zwraca zbiór zawierający elementy występujące w obu listach.

    public static Set<Integer> wspolneElementy(List<Integer> lista, List<Integer> lista2) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : lista) {
            if (lista2.contains(i)) {
                set.add(i);
            }
        }
        return set;
    }

// 3. Zliczanie słów
// Napisz program, który wczytuje ciąg słów od użytkownika i tworzy zbiór unikalnych słów.
// Następnie wypisz liczbę unikalnych słów oraz same słowa w kolejności alfabetycznej.

    public static Set<String> zliczanieSlow(String tekst) {
        Set<String> set = new HashSet<>();
        String[] slowa = tekst.split(" ");
        for (String s : slowa) {
            set.add(s);
        }
        return set;
    }

// 4. Anagramy
// Napisz funkcję, która przyjmuje dwie łańcuchy znaków i sprawdza, czy są one anagramami.
// Wykorzystaj zbiory do sprawdzenia.

    public static boolean anagramy(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }
        return set1.equals(set2);
    }

// 5. Usuwanie powtórzeń w tekście
// Napisz program, który wczytuje długi tekst od użytkownika i usuwa z niego powtarzające się słowa,
// zachowując tylko jedno wystąpienie każdego słowa.

    public static String usuwaniePowtorzen(String tekst) {
        Set<String> set = new HashSet<>();
        String[] slowa = tekst.split(" ");
        for (String s : slowa) {
            set.add(s);
        }
        return set.toString();
    }

// 6. Suma zbiorów
// Napisz funkcję, która przyjmuje dwie listy liczb całkowitych i zwraca zbiór zawierający wszystkie unikalne elementy z obu list.

    public static Set<Integer> sumaZbiorow(List<Integer> list1, List<Integer> list2) {
        Set<Integer> suma = new HashSet<>();
        for (Integer i : list1) {
            suma.add(i);
        }
        for (Integer i : list2) {
            suma.add(i);
        }
        return suma;
    }

// 7. Zbiór znaków
// Stwórz program, który wczytuje łańcuch znaków od użytkownika i tworzy zbiór zawierający wszystkie unikalne znaki (litery) w łańcuchu.

    public static Set<String> zbiorZnakow(String str) {
        Set<String> znaki = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            znaki.add(String.valueOf(str.charAt(i)));
        }
        return znaki;
    }


// 8. Palindromy
// Napisz funkcję, która przyjmuje listę łańcuchów znaków i zwraca zbiór palindromów (słów, które czytane od przodu i od tyłu są identyczne).

    public static Set<String> palidromy(List<String> list) {
        Set<String> palidromy = new HashSet<>();
        for (String s : list) {
            StringBuffer sb = new StringBuffer(s);
            if (s.equals(sb.reverse().toString())) {
                palidromy.add(s);
            }
        }
        return palidromy;
    }

}
