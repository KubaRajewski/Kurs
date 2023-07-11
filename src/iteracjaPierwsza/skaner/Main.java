package iteracjaPierwsza.skaner;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Wczytaj skanerem 3 liczby typu int, wyswietl ich sume na konsoli

        System.out.print("a: ");
        double a = scanner.nextInt();
        System.out.print("b: ");
        double b = scanner.nextInt();
        System.out.print("c: ");
        double c = scanner.nextInt();

        System.out.println("suma wynosi: "+ (a+b+c));
        System.out.println();

//Wczytaj skanerem 3 napisy, wyswietl ten ktory jest najdluzszy

        System.out.print("Wprowadź pierwszy napis: ");
        String a = scanner.nextLine();

        System.out.print("Wprowadź drugi napis: ");
        String b = scanner.nextLine();

        System.out.print("Wprowadź trzeci napis: ");
        String c = scanner.nextLine();

        // Znalezienie najdłuższego napisu
        String longestString = a;

        if (b.length() > longestString.length()) {
            longestString = b;
        }

        if (c.length() > longestString.length()) {
            longestString = c;
        }
        System.out.println("Najdłuższy napis: " + longestString);


//Uzytkownik wprowadza liczby. Na poczatku uzytkownik deklaruje ile liczb chce wprowadzic. Nastepnie wprowadza
//tyle liczb ile podał. Chcemy policzyc ich sume, element najmniejszy, najwiekszy oraz srednia arytmetyczna.
        System.out.print("Ile liczb chcesz podac?: ");
        int ile = scanner.nextInt();
        int[] liczby = new int[ile];

        for (int i = 0; i < ile; i++) {
            System.out.println("Podaj liczbe: ");
            liczby[i] = scanner.nextInt();
        }

        // liczymy sume liczby
        int suma = 0;
        for (int i = 0; i < ile; i++) {
            suma += liczby[i];
        }
        // liczymy srednia arytmetyczna
        double srednia = suma / ile;

        // szukamy najmniejszej liczby
        int min = liczby[0];
        for (int i = 0; i < ile; i++) {
            if (liczby[i] < min) {
                min = liczby[i];
            }
        }
        // szukamy najwiekszej liczby
        int max = liczby[0];
        for (int i = 0; i < ile; i++) {
            if (liczby[i] > max) {
                max = liczby[i];
            }
        }

        System.out.println("Srednia arytmetyczna wynosi: " + srednia);
        System.out.println("Suma wynosi: " + suma);
        System.out.println("Najmniejsza liczba to: " + min);
        System.out.println("Najwieksza liczba to: " + max);


//Symulacja wprowadzania hasla przez uzytkownika. Uzytkownik wprowadza hasło, tak dlugo az jest
//niepoprawne, wyswietlamy napis ze haslo jest niepoparwne, wprowadz poprawne hasło.
//Jesli uzytkownik wprowadzi poprawne haslo to wyswietlamy komunikat ze haslo jest poprawne.

        String haslo = "haslo";
        String wprowadzoneHaslo = "";
        while (!haslo.equals(wprowadzoneHaslo)) {
            System.out.println("Wprowadz haslo: ");
            wprowadzoneHaslo = scanner.nextLine();
            if (!haslo.equals(wprowadzoneHaslo)) {
                System.out.println("Haslo jest niepoprawne");
            }
        }
        System.out.println("Haslo jest poprawne");

// Wczytaj za pomocą scannera 2 liczby i przeprowadź na nich symulacje kalkulatora
// z operatorami +,-,*,/. Wyświetl wyniki na konsoli.

        System.out.print("Podaj pierwszą liczbę: ");
        double a = scanner.nextDouble();
        System.out.print("Podaj drugą liczbę: ");
        double b = scanner.nextDouble();
        System.out.print("Podaj operator: ");
        String operator = scanner.next();

        double wynik = 0;
        switch (operator) {
            case "+":
                wynik = a + b;
                break;
            case "-":
                wynik = a - b;
                break;
            case "*":
                wynik = a * b;
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Nie dzielimy przez 0");
                } else {
                    wynik = a / b;
                }
                break;
            default:
                System.out.println("Nieznany operator");
        }
        System.out.println("Wynik: " + wynik);

// Napisz metodę, która za pomocą Scannera wczyta 3 Stringi i sprawdzi, który jest najdżuższy.

        System.out.print("Wprowadź pierwszy napis: ");
        String a = scanner.nextLine();

        System.out.print("Wprowadź drugi napis: ");
        String b = scanner.nextLine();

        System.out.print("Wprowadź trzeci napis: ");
        String c = scanner.nextLine();

        // Znalezienie najdłuższego napisu
        String longestString = a;

        if (b.length() > longestString.length()) {
            longestString = b;
        }

        if (c.length() > longestString.length()) {
            longestString = c;
        }
        System.out.println("Najdłuższy napis: " + longestString);

// Wczytaj scannerem 5 liczb, przypisz je do tablicy, policz sumę tych elementów
// i wyświetl ją na konsoli.

        int[] liczby = new int[5];
        int suma = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Podaj liczbe: ");
            liczby[i] = scanner.nextInt();
            suma += liczby[i];
        }
        System.out.println("Suma wynosi: " + suma);

// Wczytuj scannerem kilka Stringów, przypisz je do wcześniej utworzonej zmiennej typu String i wyświetl ją na konsoli.

            String napis = "";
            for (int i = 0; i < 5; i++) {
                System.out.println("Podaj napis: ");
                napis += scanner.nextLine();
                napis = napis + " ";
            }
            System.out.println(napis);

// Za pomoca JOptionpane wczytaj liczbę i sprawdź czy jest parzysta (można zrobić to za pomocą metody)

        String liczba = JOptionPane.showInputDialog("Podaj liczbę: ");
        int liczbaInt = Integer.parseInt(liczba);
        if (liczbaInt % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Liczba jest parzysta");
        } else {
            JOptionPane.showMessageDialog(null, "Liczba jest nieparzysta");
        }

// Stwórz tablice 3 stringów, dodaj wszystkie w pętli do zmiennej typu String i zapisz ją do pliku

        String[] napisy = {"Ala", "ma", "kota"};
        String napis = "";
        for (int i = 0; i < napisy.length; i++) {
            napis += napisy[i] + " ";
        }
        System.out.println(napis);
        // Zapisz zmienną typu String do pliku plik.csv
        try {
            FileWriter writer = new FileWriter("plik.csv");
            writer.write(napis);
            writer.close();
            System.out.println("Zapisano do pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku.");
            e.printStackTrace();
        }


// Wczytaj to co zapisaleś do pliku i wyświetl na konsoli

        try {
            FileReader reader = new FileReader("plik.csv");
            int znak;
            while ((znak = reader.read()) != -1) {
                System.out.print((char) znak);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu pliku.");
            e.printStackTrace();
        }

// Wpisz do pliku 10 liczb oddzielonych enterem, wyświetl wszystkie które są podzielne przez 2


    }
}
*/