package dalsze.podstawy.wyjatki;

import dalsze.podstawy.wyjatki.exceptions.SampleException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // https://www.protechtraining.com/static/bookshelf/java_fundamentals_tutorial/images/ExceptionClassHierarchy.png
        double sal = 0;
        try {
            sal = getSal(-10, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("podales zla liczbe godzin");
        } finally {
            System.out.println("wykonam sie zawsze");
        }

        System.out.println(sal);

        int result = 0;
        try {
            result = divide(11, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("licznik nie moze byc rowny 10");
        } catch (ArithmeticException e) {
            System.out.println("nie dziel przez 0");
        }

        System.out.println(result);
    }

    // napisz metode ktora liczy pensje z parametrem liczbagodzin, sprawdz czy liczba godzin nie jest ujemna, jesli tak to rzuc wyjatkeim
    // jesli to liczba godzin * 50
    public static double getSal(int hours, double stake) {
        if (hours < 0) throw new IllegalArgumentException("asdasd");
        return hours * stake;
    }

    public static int divide(int a, int b) {
        if (a == 10) throw new SampleException();
        return a / b;
    }
}
