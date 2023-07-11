package iteracjaPierwsza.instrukcjaWarunkowa.zadaniaPDF;

public class Main {
    public static void main(String[] args) {

// 1) Zadeklaruj dwie zmienne typu String i spróbuj je porównać operatorem >. Jaki jest efekt programu?
/*
        String imie = "Kuba";
        String nazwisko = "Rajewski";

        if (imie > nazwisko) {
            System.out.println("imie jest dluzsze");
        }

        Program nie zadziala, jesli chcielibysmy porownac dlugosc stringow trzeba by uzyc metody length

*/
// 2) Napisz program w którym deklarujesz 3 zmienne typu int (różne od siebie) i program wyświetli najmniejszą z nich.
        System.out.println("Zadanie 2 - najmniejsza zmienna");
        int a = 9;
        int b = 3;
        int c = 6;

        int najmniejsza;

        if (a <= b && a <= c) {
            najmniejsza = a;
        } else if (b <= a && b <= c) {
            najmniejsza = b;
        } else {
            najmniejsza = c;
        }

        System.out.println("Najmniejsza zmienna to: " + najmniejsza);
        System.out.println();

// 3) Napisz program w którym deklarujesz 2 zmienne typu int. Sprawdź czy są sobie równe
        System.out.println( "Zadanie 3 - czy zmienne sa rowne");

        int d = 3;
        int e = 3;

        if (d == e) {
            System.out.println("sa rowne");
        }
        System.out.println();
// 4) Napisz program który sprawdzi czy średnia dwóch liczb typu double jest większa od 5.
        System.out.println("Zadanie 4 - czy srednia jest wieksza od 5");

        double x = 5;
        double y = 15;

        if (((x + y) / 2) > 5) {
            System.out.println("średnia jest wieksza niz 5");
        }
        System.out.println();

// 5*) Napisz program w którym deklarujesz 3 zmienne typu int (różne od siebie). Program ma wyświetlić je posortowane rosnąco

        System.out.println("Zadanie 5 - sortowanie rosnaco");

        if (a <= b && a <= c) {
            if (b <= c) {
                System.out.println(a + ", " + b + ", " + c);
            } else {
                System.out.println(a + ", " + c + ", " + b);
            }
        } else if (b <= a && b <= c) {
            if (a <= c) {
                System.out.println(b + ", " + a + ", " + c);
            } else {
                System.out.println(b + ", " + c + ", " + a);
            }
        } else {
            if (a <= b) {
                System.out.println(c + ", " + a + ", " + b);
            } else {
                System.out.println(c + ", " + b + ", " + a);
            }
        }
    }
}

