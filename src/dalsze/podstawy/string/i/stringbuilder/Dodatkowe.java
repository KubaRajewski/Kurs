package dalsze.podstawy.string.i.stringbuilder;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dodatkowe {

//  Zadanie: Palindrom w StringBuilderze
//  Napisz funkcję, która sprawdza, czy dany tekst jest palindromem, wykorzystując StringBuilder do odwracania tekstu.
    public static boolean palidrom(String str) {
        StringBuilder sb = new StringBuilder().append(str);
        return str.contentEquals(sb.reverse());
    }

//  Zadanie: Usuwanie powtarzających się znaków
//  Napisz program, który usuwa wszystkie powtarzające się znaki z danego łańcucha znaków, wykorzystując StringBuilder.
    public static String usunPowtarzajaceZnaki(String str) {
        StringBuilder sb = new StringBuilder();

        HashSet<Character> unikalneZnaki = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char obecnyZnak = str.charAt(i);

            if (!unikalneZnaki.contains(obecnyZnak)) {
                sb.append(obecnyZnak);
                unikalneZnaki.add(obecnyZnak);
            }
        }

        return sb.toString();
    }

//  Zadanie: Liczenie wystąpień słów
//  Napisz funkcję, która zlicza ilość wystąpień określonego słowa w tekście, korzystając z klasy StringBuilder.
    public static int policzWystapienia(String str, String szukaneSlowo) {
        StringBuilder sb = new StringBuilder().append(str);
        int licznik = 0;

        while (sb.indexOf(szukaneSlowo) != -1) {
            sb.delete(sb.indexOf(szukaneSlowo), sb.indexOf(szukaneSlowo) + szukaneSlowo.length());
            licznik++;
        }

        return licznik;
    }

//  Zadanie: Szyfrowanie Caesar'a
//  Zaimplementuj algorytm szyfrowania Cezara, który przekształca tekst przy użyciu przesunięcia znaków w StringBuilderze.
    public static String szyfruj(String str, int przesuniecie) {
        StringBuilder sb = new StringBuilder().append(str);

        for (int i = 0; i < sb.length(); i++) {
            char obecnyZnak = sb.charAt(i);
            obecnyZnak += przesuniecie;
            sb.setCharAt(i, obecnyZnak);
        }

        return sb.toString();
    }

    public static String odSzyfruj(String str, int przesuniecie) {
        StringBuilder sb = new StringBuilder().append(str);

        for (int i = 0; i < sb.length(); i++) {
            char obecnyZnak = sb.charAt(i);
            obecnyZnak -= przesuniecie;
            sb.setCharAt(i, obecnyZnak);
        }

        return sb.toString();
    }

//  Zadanie: Odwracanie słów w zdaniu
//  Napisz program, który odwraca kolejność słów w zdaniu, zachowując oryginalną kolejność liter w każdym słowie, przy użyciu StringBuilder.
    public static String odwrocKolejnoscSlow(String str) {
        StringBuilder sb = new StringBuilder();

        String[] slowa = str.split(" ");

        for (int i = slowa.length - 1; i >= 0; i--) {
            sb.append(slowa[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

//  Zadanie: Zamiana formatu daty
//  Napisz funkcję, która zamienia datę z jednego formatu na inny, wykorzystując StringBuilder do manipulacji tekstem daty.

    public static String odwrocDate(String data) {
        StringBuilder sb = new StringBuilder();
        Pattern dataPattern = Pattern.compile("^(?<dzien>0[1-9]|[12][0-9]|3[01])-(?<miesiac>0[1-9]|1[0-2])-(?<rok>\\d{4})$");
        Matcher matcher = dataPattern.matcher(data);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Nie poprawny format daty");
        }

        sb.append(matcher.group("rok"));
        sb.append("-");
        sb.append(matcher.group("miesiac"));
        sb.append("-");
        sb.append(matcher.group("dzien"));

        return sb.toString();
    }

//  Zadanie: Kompresja tekstu
//  Napisz program do kompresji tekstu, który zamienia powtarzające się znaki na liczbę ich wystąpień, korzystając z StringBuilder.
    public static String kompresja(String str) {
       StringBuilder sb = new StringBuilder();

        int licznik = 1;
        char poprzedniZnak = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char obecnyZnak = str.charAt(i);

            if (obecnyZnak == poprzedniZnak) {
                licznik++;
            } else {
                sb.append(poprzedniZnak);
                sb.append(licznik);
                licznik = 1;
                poprzedniZnak = obecnyZnak;
            }
        }

       return sb.toString();
    }

    public static void main(String[] args) {

        //TODO 1: Palindrom w StringBuilderze
        System.out.println("Palidromy");
        System.out.println(palidrom("kajak"));
        System.out.println(palidrom("anna"));
        System.out.println(palidrom("kuba") + "\n");

        //TODO 2: Usuwanie powtarzających się znaków
        System.out.println("Usuwanie powtarzajacych sie znakow");
        System.out.println(usunPowtarzajaceZnaki("kajak"));
        System.out.println(usunPowtarzajaceZnaki("anna") + "\n");

        //TODO 3: Liczenie wystąpień słów
        System.out.println("Liczenie wystapien slow");
        System.out.println(policzWystapienia("ala ma kota", "ala"));
        System.out.println(policzWystapienia("ala ma kota kota", "kota") + "\n");


        //TODO 4: Szyfrowanie Caesar'a
        System.out.println("Szyfrowanie Cezara");
        System.out.println(szyfruj("ala ma kota", 3));
        System.out.println(odSzyfruj(szyfruj("ala ma kota", 3), 3) + "\n");


        //TODO 5: Odwracanie słów w zdaniu
        System.out.println("Odwracanie slow w zdaniu");
        System.out.println(odwrocKolejnoscSlow("kuba ma psa") + "\n");

        // TODO 6: Zamiana formatu daty
        System.out.println("Zamiana formatu daty");
        System.out.println(odwrocDate("12-01-2003"));

        //TODO 5: Kompresja tekstu
        System.out.println("Kompresja tekstu");
        System.out.println(kompresja("aaabbbccc") + "\n");
    }
}
