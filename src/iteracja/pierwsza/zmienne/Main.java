package iteracja.pierwsza.zmienne;

public class Main {

    public static void main(String[] args) {

        /*
            nigdzie w nazwach nie uzywamy polskich znakow

            nazwy paczek - male litery + kropki np moja.paczka
            nazwy klas - z wielkiej litery + cammel casy np MojaKlasa
            nazwy zmiennych oraz metod z malej litery + cammel casy np obliczPensje()

            sout -> System.out.println();
            cmd + D -> kopiowanie wiersza
            cmd + alt + L -> justownaie kodu
        */

        System.out.println("witam");
        System.out.println("witam");
        System.out.println("witam");
        System.out.println();

        System.out.print("siema");
        System.out.print("siema");
        System.out.print("siema");

        System.out.println();

        // znaki specjalne
        // \n - znak nowego wiersza
        System.out.println("Ania\nTomek");

        // \t - znak tabulacji
        System.out.println("Krzys\tPiotrek");

        // zmienne
        // String, int, double, char, boolean
        String imie = "Ania";
        System.out.println(imie);

        imie = "Krzys";
        System.out.println(imie);

        // operaotr +
        int a = 5, b = 4;
        String s1 = "kot", s2 = "pies";

        System.out.println(a + b);
        System.out.println("Zwierzeta: " + s1 + " " + s2);

        System.out.println(a + b + s1);
        System.out.println(s1 + (a + b));

        // Zadeklaruj dwie zmienne typu double (2.5, 2.2) i wykonaj działania za pomoca operatorów: +, -, *, /

        double c = 2.5, d = 2.2;
        System.out.println(c + d);
        System.out.println(c - d);
        System.out.println(c * d);
        System.out.println(c / d);
    }
}

