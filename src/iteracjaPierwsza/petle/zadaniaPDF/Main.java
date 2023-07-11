package iteracjaPierwsza.petle.zadaniaPDF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

// Napisz program, który oblicza potęgę 2n, gdzie liczbę naturalną n podaje użytkownik. Dla n = 10, wynik to 2^10 = 1024
        Scanner scanner = new Scanner(System.in);
        System.out.println("zadanie 1 - potega 2n");

        System.out.print("n: ");
        int n = scanner.nextInt();

        int wynik = 1;

        for (int i = 0; i < n; i++) {
            wynik *= 2;
        }

        System.out.println("Wynik to 2^" + n + " = " + wynik);


// Napisz program drukujacy na ekranie prostokat z literek X. Wysokosc i szerokosc prostokata wczytujemy z klawiatury.
// Dla szerokosci = 10 oraz wysokosci = 4 tak powinien wygladac prostokat:
        System.out.println("zadanie 2 - prostokat z X");
//
//                                          XXXXXXXXXX
//                                          X        X
//                                          X        X
//                                          XXXXXXXXXX

        System.out.print("Height: ");
        int height = scanner.nextInt();
        System.out.print("Width: ");
        int width = scanner.nextInt();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (i == 1 || i == height || j == 1 || j == width) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }



// Napisz program, który oblicza średnią arytmetyczną liczb naturalnych od 5 do liczby podanej przez użytkownika.
// Wypisać obliczoną średnią na konsoli.
// Dla n = 9 program ma wypisać (5+6+7+8+9)/5 = 35/5= 7
        System.out.println("zadanie 3 - srednia arytmetyczna");

        System.out.print("n: ");
        int m = scanner.nextInt();

        // chcielibysmy miec niezdefiniowana tablice, zrobic petle od 5 do n i za kazda iteracja dodawac ta liczbe do
        // tablicy w ktorej pierwszym wyrazem bedzie 5, potem policzyc srednia czyli dodac do siebie wszystkie elementy
        // i podzielic przez ilosc elementow w tablicy

        // Tworzenie pustej tablicy z dynamicznym rozmiarem
        ArrayList<Integer> array = new ArrayList<>();

        // Dodawanie liczb od 5 do n do tablicy
        for (int i = 5; i <= m; i++) {
            array.add(i);
        }

        // Obliczanie sumy elementów w tablicy
        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        // Obliczanie średniej
        double average = (double) sum / array.size();

        System.out.println("Suma: " + sum);
        System.out.println("Średnia: " + average);


// Napisz program, który sumuje liczby z zakresu 1-40 ale tylko te które są podzielne przez 3
        System.out.println("zadanie 4 - suma liczb podzielnych przez 3");

        int sum2 = 0;
        for (int i = 1; i <= 40; i++) {
            if (i % 3 == 0) {
                sum2 = sum2 + i;
            }
        }
        System.out.println(sum2);

// Zadeklaruj tablicę intów długości 5 i wypełnij ja dowolnymi liczbami. Wyświetl całą tablice w pętli for lub while.
        System.out.println("zadanie 5 - tablica intow");

        int[] tablica = {3, 6, 9, 2, 7};
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + " ");
        }
        System.out.println();

// Zadeklaruj tablice stringów dlugosci 4, dodaj do niej 4 wyrazy. W petli przypisz każdy wyraz do wcześniej
// utworzonej zmiennej typu string. Wyświetl tą zmienną
        System.out.println("zadanie 6 - tablica stringow");

        String[] words = {"pies", "kot", "wiewiorka", "zegarek"};
        String result = "";


        for (int i = 0; i < words.length; i++) {
            result += words[i] + " ";
        }

        System.out.println(result);

// Zadeklaruj dwie tablice intów róznej dlugosci. Przypisz obu na indeksie 0 jakas liczbe.
// Wyswietl tę tablicę która jest dłuższa (oczywiście zmiana długości danej tablicy
// powinna wpływać na wypisanie tablic)
        System.out.println("zadanie 7 - tablice intow");

        int[] table1 = new int[10];
        int[] table2 = new int[20];

        table1[0] = 12;
        table2[0] = 5;

        if (table1.length > table2.length) {
            drukujTablice(table1);
        }
        else if (table1.length == table2.length) {
            System.out.println("tablice sa tej samej dlugosci");
        }
        else {
            drukujTablice(table2);
        }
    }
    public static void drukujTablice(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
