package dalsze.podstawy.string.i.stringbuilder;

import java.util.HashSet;

public class Dodatkowe {
    public static void main(String[] args) {

        //TODO  Zadanie: Palindrom w StringBuilderze
        System.out.println("Palidromy");
        System.out.println(palidrom("kajak"));
        System.out.println(palidrom("anna"));
        System.out.println(palidrom("kuba") + "\n");

        //TODO  Zadanie: Usuwanie powtarzających się znaków
        System.out.println("Usuwanie powtarzajacych sie znakow");
        System.out.println(usunPowtarzajaceZnaki("kajak"));
        System.out.println(usunPowtarzajaceZnaki("anna"));

//  Zadanie: Liczenie wystąpień słów
//  Napisz funkcję, która zlicza ilość wystąpień określonego słowa w tekście, korzystając z klasy StringBuilder.

//  Zadanie: Szyfrowanie Caesar'a
//  Zaimplementuj algorytm szyfrowania Cezara, który przekształca tekst przy użyciu przesunięcia znaków w StringBuilderze.

//  Zadanie: Odwracanie słów w zdaniu
//  Napisz program, który odwraca kolejność słów w zdaniu, zachowując oryginalną kolejność liter w każdym słowie, przy użyciu StringBuilder.

//  Zadanie: Zamiana formatu daty
//  Napisz funkcję, która zamienia datę z jednego formatu na inny, wykorzystując StringBuilder do manipulacji tekstem daty.

//  Zadanie: Wyszukiwanie najdłuższego wspólnego podciągu
//  Zaimplementuj algorytm znajdowania najdłuższego wspólnego podciągu (LCS) dwóch łańcuchów znaków za pomocą klasy StringBuilder.

//  Zadanie: Kompresja tekstu
//  Napisz program do kompresji tekstu, który zamienia powtarzające się znaki na liczbę ich wystąpień, korzystając z StringBuilder.

//  Zadanie: Generowanie skrótu (hash)
//  Stwórz funkcję, która generuje skrót (hash) tekstu przy użyciu algorytmu MD5 lub SHA-256, wykorzystując StringBuilder do tworzenia wynikowego skrótu.

//  Zadanie: Liczenie wystąpień podciągu
//  Napisz funkcję, która zlicza ilość wystąpień określonego podciągu w tekście, wykorzystując StringBuilder do porównywania znaków.
    }

//  Zadanie: Palindrom w StringBuilderze
//  Napisz funkcję, która sprawdza, czy dany tekst jest palindromem, wykorzystując StringBuilder do odwracania tekstu.
    public static boolean palidrom(String str){
        StringBuilder sb = new StringBuilder().append(str);
        return str.contentEquals(sb.reverse());
    }

//  Zadanie: Usuwanie powtarzających się znaków
//  Napisz program, który usuwa wszystkie powtarzające się znaki z danego łańcucha znaków, wykorzystując StringBuilder.
    public static String usunPowtarzajaceZnaki(String str){
        StringBuilder sb = new StringBuilder();

        HashSet<Character> unikalneZnaki = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (!unikalneZnaki.contains(currentChar)) {
                sb.append(currentChar);
                unikalneZnaki.add(currentChar);
            }
        }

        return sb.toString();
    }
}
