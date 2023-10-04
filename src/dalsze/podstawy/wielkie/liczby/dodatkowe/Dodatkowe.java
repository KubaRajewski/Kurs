package dalsze.podstawy.wielkie.liczby.dodatkowe;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dodatkowe {
    public static void main(String[] args) {
//        Dodawanie BigDecimal:
//        Napisz funkcję, która przyjmuje dwa argumenty typu BigDecimal i zwraca wynik ich dodawania.

        BigDecimal a = new BigDecimal("1.123456789");
        BigDecimal b = new BigDecimal("2.9876542367221");
        System.out.println("Dodawanie: " + a.add(b));
        System.out.println();

//        Mnożenie BigDecimal przez liczbę całkowitą:
//        Napisz funkcję, która przyjmuje argument typu BigDecimal oraz liczbę całkowitą i zwraca wynik mnożenia BigDecimal przez tę liczbę.

        int d = 2;
        System.out.println("Mnożenie: " + a.multiply(BigDecimal.valueOf(d)));
        System.out.println();

//      Operacja dzielenia BigDecimal:
//      Napisz funkcję, która przyjmuje dwa argumenty typu BigDecimal i zwraca wynik dzielenia pierwszego argumentu przez drugi argument.

        System.out.println("Dzielenie: " + a.divide(b, 10, RoundingMode.HALF_UP));
        System.out.println();


//        Obliczanie wartości odsetek:
//        Napisz funkcję, która przyjmuje początkową kwotę (BigDecimal), roczną stopę oprocentowania (typu double) i liczbę lat (typu int).
//        Funkcja powinna zwrócić wartość końcową po obliczeniu odsetek składanych rocznie.

        BigDecimal g = new BigDecimal("1000");
        double h = 0.05;
        int i = 5;
        System.out.println("Odsetki: " + g.multiply(BigDecimal.valueOf(Math.pow(1 + h, i))));
        System.out.println();

//        Porównywanie BigDecimal:
//        Napisz funkcję, która porównuje dwa obiekty typu BigDecimal i zwraca 0, jeśli są sobie równe, -1,
//        jeśli pierwszy argument jest mniejszy od drugiego, i 1, jeśli pierwszy argument jest większy od drugiego.

        System.out.println("Porównywanie: " + a.compareTo(b));
        System.out.println();

//        Obliczanie średniej wartości BigDecimal:
//        Napisz funkcję, która przyjmuje listę obiektów typu BigDecimal i zwraca ich średnią wartość.

        BigDecimal[] c = {new BigDecimal("1.123456789"), new BigDecimal("2.9876542367221")};
        System.out.println("Liczby: " + c[0] + " " + c[1]);
        System.out.println("Średnia: " + srednia(c));
        System.out.println();


//        Obliczanie pierwiastka kwadratowego BigDecimal:
//        Napisz funkcję, która przyjmuje argument typu BigDecimal i zwraca jego pierwiastek kwadratowy.

        System.out.println("Liczba: " + a);
        System.out.println("Pierwiastek: " + BigDecimal.valueOf(Math.sqrt(a.doubleValue())));
        System.out.println();

//        Obliczanie wartości potęgi BigDecimal:
//        Napisz funkcję, która przyjmuje dwa argumenty typu BigDecimal: podstawę i wykładnik, i zwraca wynik potęgowania.

        System.out.println("\nLiczba: " + a);
        System.out.println("Potęga: " + a.pow(b.intValue()));
        System.out.println();

//        Zaokrąglanie BigDecimal do określonej liczby miejsc po przecinku:
//        Napisz funkcję, która przyjmuje argument typu BigDecimal i liczbę miejsc po przecinku i
//        zwraca nowy obiekt BigDecimal zaokrąglony do podanej liczby miejsc po przecinku.

        System.out.println("Liczba: " + a);
        System.out.println("Zaokrąglenie: " + zaokraglij(a, 5));
        System.out.println();

//        Sprawdzanie, czy liczba jest liczbą całkowitą:
//        Napisz funkcję, która przyjmuje argument typu BigDecimal i zwraca true, jeśli liczba jest liczbą całkowitą, a w przeciwnym razie zwraca false.

        System.out.println("Liczba: " + a);
        System.out.println("Czy liczba całkowita: " + czyCalkowita(a));
        System.out.println();
    }

    public static double srednia(BigDecimal[] liczby) {
        BigDecimal suma = new BigDecimal("0");
        for (BigDecimal i : liczby) {
            suma = suma.add(i);
        }
        return suma.divide(BigDecimal.valueOf(liczby.length)).doubleValue();
    }

    public static BigDecimal zaokraglij(BigDecimal liczba, int miejscaPoPrzecinku) {
        return liczba.setScale(miejscaPoPrzecinku, RoundingMode.HALF_DOWN);
    }

    public static boolean czyCalkowita(BigDecimal liczba) {
        return liczba.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO);
    }

}
