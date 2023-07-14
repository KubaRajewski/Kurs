package iteracja.pierwsza.skaner;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*
// Wczytaj skanerem 3 liczby typu int, wyswietl ich sume na konsoli

        System.out.println("Zadanie 1 - suma 3 liczb");

        System.out.print("a: ");
        double a = scanner.nextInt();
        System.out.print("b: ");
        double b = scanner.nextInt();
        System.out.print("c: ");
        double c = scanner.nextInt();

        System.out.println("suma wynosi: "+ (a+b+c));
        System.out.println();

// Wczytaj skanerem 3 napisy, wyswietl ten ktory jest najdluzszy

        System.out.println("Zadanie 2 - najdłuższy napis");

        System.out.print("Wprowadź pierwszy napis: ");
        String x = scanner.nextLine();

        System.out.print("Wprowadź drugi napis: ");
        String y = scanner.nextLine();

        System.out.print("Wprowadź trzeci napis: ");
        String z = scanner.nextLine();

        // Znalezienie najdłuższego napisu
        String longestString = x;

        if (y.length() > longestString.length()) {
            longestString = y;
        }

        if (z.length() > longestString.length()) {
            longestString = z;
        }
        System.out.println("Najdłuższy napis: " + longestString);

        System.out.println();
//Uzytkownik wprowadza liczby. Na poczatku uzytkownik deklaruje ile liczb chce wprowadzic. Nastepnie wprowadza
//tyle liczb ile podał. Chcemy policzyc ich sume, element najmniejszy, najwiekszy oraz srednia arytmetyczna.

        System.out.println("Zadanie 3 - liczby");

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
        System.out.println();

//Symulacja wprowadzania hasla przez uzytkownika. Uzytkownik wprowadza hasło, tak dlugo az jest
//niepoprawne, wyswietlamy napis ze haslo jest niepoparwne, wprowadz poprawne hasło.
//Jesli uzytkownik wprowadzi poprawne haslo to wyswietlamy komunikat ze haslo jest poprawne.

        System.out.println("Zadanie 4 - hasło");

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

// Napisz metodę, która za pomocą Scannera wczyta 3 Stringi i sprawdzi, który jest najdżuższy.

        System.out.println("Zadanie 5 - najdłuższy napis");

        System.out.print("Wprowadź pierwszy napis: ");
        String a1 = scanner.nextLine();

        System.out.print("Wprowadź drugi napis: ");
        String b1 = scanner.nextLine();

        System.out.print("Wprowadź trzeci napis: ");
        String c1 = scanner.nextLine();

        // Znalezienie najdłuższego napisu
        String longestString1 = a1;

        if (b1.length() > longestString1.length()) {
            longestString1 = b1;
        }

        if (c1.length() > longestString1.length()) {
            longestString1 = c1;
        }
        System.out.println("Najdłuższy napis: " + longestString1);

// Wczytaj scannerem 5 liczb, przypisz je do tablicy, policz sumę tych elementów
// i wyświetl ją na konsoli.

        System.out.println("Zadanie 6 - liczby, suma w tablicy");

        int[] liczby1 = new int[5];
        int suma1 = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Podaj liczbe: ");
            liczby1[i] = scanner.nextInt();
            suma1 += liczby1[i];
        }
        System.out.println("Suma wynosi: " + suma1);

// Wczytuj scannerem kilka Stringów, przypisz je do wcześniej utworzonej zmiennej typu String i wyświetl ją na konsoli.

        System.out.println("Zadanie 7 - napisy");

        String napis = "";
        for (int i = 0; i < 5; i++) {
            System.out.println("Podaj napis: ");
            napis += scanner.nextLine();
            napis = napis + " ";
        }
        System.out.println(napis);

// Za pomoca JOptionpane wczytaj liczbę i sprawdź czy jest parzysta (można zrobić to za pomocą metody)

        System.out.println("Zadanie 8 - parzysta");

        String liczba = JOptionPane.showInputDialog("Podaj liczbę: ");
        int liczbaInt = Integer.parseInt(liczba);
        if (liczbaInt % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Liczba jest parzysta");
        } else {
            JOptionPane.showMessageDialog(null, "Liczba jest nieparzysta");
        }

// Stwórz tablice 3 stringów, dodaj wszystkie w pętli do zmiennej typu String i zapisz ją do pliku

        List<String> napisy = new ArrayList<>();

        while (true) {
            System.out.println("Podaj napis (wpisz pusty napis aby przerwać): ");
            String napis = scanner.nextLine();

            if (napis.isEmpty()) {
                break; // Przerwanie pętli, gdy wprowadzono pusty napis
            }

            napisy.add(napis);
        }

        String napis1 = String.join("\n", napisy);

        // Zapisz zmienne typu String do pliku plik.csv
        try {
            FileWriter writer = new FileWriter("plik.txt");
            writer.write(napis1);
            writer.close();
            System.out.println("Zapisywanie zakończone.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku.");
            e.printStackTrace();
        }

        // Wczytaj to, co zapisaleś do pliku i wyświetl na konsoli
        try {
            FileReader reader = new FileReader("plik.txt");
            int znak;
            System.out.println("Dane z pliku: ");
            while ((znak = reader.read()) != -1) {
                System.out.print((char) znak);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu pliku.");
            e.printStackTrace();
        }
*/
// Wpisz do pliku 10 liczb oddzielonych enterem, wyświetl wszystkie które są podzielne przez 2

        List<String> liczby = new ArrayList<>();

        while (true) {
            System.out.println("Podaj liczbę (wpisz pusty napis aby przerwać): ");
            String liczba = scanner.nextLine();

            if (liczba.isEmpty()) {
                break; // Przerwanie pętli, gdy wprowadzono pusty napis
            }

            // Validate input as an integer
            try {
                Integer.parseInt(liczba);
                liczby.add(liczba);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy format liczby. Wprowadź liczbę całkowitą.");
            }
        }

        String liczba1 = String.join("\n", liczby);


// Zapisz zmienne typu String do pliku liczby.txt

        try {
            FileWriter writer = new FileWriter("liczby.txt");
            writer.write(liczba1 + "\n");
            writer.close();
            System.out.println("Zapisywanie zakończone. ");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku.");
            e.printStackTrace();
        }

// Wczytaj to, co zapisaleś do pliku i wyświetl na konsoli

        try {
            FileReader reader = new FileReader("liczby.txt");
            int znak;
            System.out.println("Dane z pliku: ");
            while ((znak = reader.read()) != -1) {
                System.out.print((char) znak);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu pliku.");
            e.printStackTrace();
        }

        System.out.println();

// Wczytaj plik liczby.txt i wyświetl na konsoli tylko liczby parzyste

        try {
            FileReader reader = new FileReader("liczby.txt");
            int znak;
            System.out.print("Liczby parzyste z pliku: ");
            while ((znak = reader.read()) != -1) {
                if (znak % 2 == 0) {
                    System.out.print((char) znak);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu pliku.");
            e.printStackTrace();
        }

    }
}
