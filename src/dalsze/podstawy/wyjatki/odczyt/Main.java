package dalsze.podstawy.wyjatki.odczyt;

//Stworz program ktory pozwoli odczytac z pliku zawarte informacje.
//Jesli plik nie istnieje to obsluz ta sytuacje is stworz go (createNewFile() z klasy FIle tworzy nowy plik)

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        czytajPlik("src/testy/test2/zadanie2/files/lekarze.txt");
        System.out.println();
        czytajPlik("src/dalsze/podstawy/wyjatki/pliki/testowy.txt");
    }

    public static void czytajPlik(String path) throws IOException {
        File file = new File(path);
        if (file.createNewFile()) {
            System.out.println("Nowy plik został utworzony.");
            FileWriter writer = new FileWriter(file);
            writer.write("To jest zawartość nowego pliku.");
            writer.close();
        } else {
            System.out.println("Odczytujemy zawartość pliku: ");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine();
                System.out.println(linia);
            }
            scanner.close();
        }
    }
}
