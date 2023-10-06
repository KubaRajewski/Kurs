package dalsze.podstawy.wyjatki;

import dalsze.podstawy.wyjatki.exceptions.SampleException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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

        //Stworz program ktory pozwoli odczytac z pliku zawarte informacje.
        //Jesli plik nie istnieje to obsluz ta sytuacje is tworz go (createNewFile() z klasy FIle tworzy nowy plik)
        String nazwaPliku = "mojplik.txt";
        File plik = new File(nazwaPliku);

        // Stwórz liste i dodaj jej 3 eleemtny np Stringi. Losujemy liczbe z zakrezu 0-5
        // i do zmiennej typu String
        // przypisujemy wylosowany element listy, obsluz sytuacje gdy wylosowana wartosc
        // jest poza zakresem listy

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

    //Stworz program ktory pozwoli odczytac z pliku zawarte informacje.
    //Jesli plik nie istnieje to obsluz ta sytuacje is tworz go (createNewFile() z klasy FIle tworzy nowy plik)

}
