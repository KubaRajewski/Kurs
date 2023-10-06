package dalsze.podstawy.wyjatki.odczyt;

//Stworz program ktory pozwoli odczytac z pliku zawarte informacje.
//Jesli plik nie istnieje to obsluz ta sytuacje is stworz go (createNewFile() z klasy FIle tworzy nowy plik)

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String nazwaPliku = "src/testy/test2/zadanie2/files/lekarze.txt";
        String nazwaPliku2 = "src/dalsze/podstawy/wyjatki/pliki/testowy.txt";
        File file = new File(nazwaPliku);
        File file2 = new File(nazwaPliku2);

        czytajPlik(file);
        System.out.println();
        czytajPlik(file2);
    }

    public static void czytajPlik(File file) throws IOException {
        try {
            Scanner scanner = new Scanner(file);
            System.out.println("Odczytujemy zawartość pliku:");
            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine();
                System.out.println(linia);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            file.createNewFile();
            System.out.println("Nowy plik został utworzony.");
            FileWriter writer = new FileWriter(file);
            writer.write("To jest zawartość nowego pliku.");
            writer.close();
            czytajPlik(file);
        }
    }
}
