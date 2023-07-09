package iteracjaPierwsza.petle.zadania;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

// Wypisz na konsoli liczby od 1 do 20

        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
        }
        System.out.println();

// Wypisz na konsoli liczby od 1 do 20 oddzielone przecinkiem

        for (int i = 1; i <= 20; i++) {
            System.out.print(i);
            if (i != 20) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println();

// Za pomocą pętli while, wypisz liczby od 1 do 10, dla kazdej liczby powyzej 5 dodaj napis'duża i'

        int a = 1;
        while (a <= 10) {
            if (a > 5) {
                System.out.println(a + ", duża liczba");
            } else {
                System.out.println(a);
            }
            a++;
        }
        System.out.println();

//Napisz program liczacy sume liczb z zakresu od 1 do 100

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.println("suma liczb z zakresu 1 do 100 to: " + sum);
        System.out.println();

//Wypisz wszystkie liczby parzyste z zakresu 1-30

        for (int i = 1; i <= 30; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println();

// wszystkie liczby nieparzyste od -10 do 40.

        for (int i = -9; i <= 39; i += 2) {
            System.out.println(i);
        }
        System.out.println();

//Napisz program liczacy silnie, np 5! = 1*2*3*4*5
        int liczba = 5;
        int wynik = 1;
        for (int i = 1; i <= liczba; i++) {
            wynik *= i;
        }
        System.out.println(liczba + "! = " + wynik);

// Napisac program, ktory liczy pole kwadratu dla boku n, który przyjmuje wartosci od 1 do 10, uzyc petli while

        Scanner scanner = new Scanner(System.in);
        int bok = 0;
        while (true) {
            System.out.println("Bok: ");
            int b = Integer.parseInt(scanner.nextLine());

            if (b >= 1 && b <= 10) {
                bok = b;
                break;
            } else {
                System.out.println("niepoprawna dlugosc boku");
            }
        }
        System.out.println("pole kwadratu o boku: " + bok + " = " + (bok * bok));
    }
}

