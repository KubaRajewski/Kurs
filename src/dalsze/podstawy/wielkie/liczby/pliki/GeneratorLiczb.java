package dalsze.podstawy.wielkie.liczby.pliki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

// stworz sobie jakis plik z liczbami, 100 liczb stucyfrowych (roznych, losowych!)
// Wczytaj te liczby z pliku i zapisz iloczyn tych liczb do pliku wynik.txt

public class GeneratorLiczb {
    public static void main(String[] args) {
        String sciezka = "src/dalsze/podstawy/wielkie/liczby/pliki/liczby.txt";

        // Sprawdzanie i tworzenie katalogu, jeśli nie istnieje
        Path katalog = FileSystems.getDefault().getPath(sciezka).getParent();
        try {
            Files.createDirectories(katalog);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(sciezka));

            for (int i = 0; i < 100; i++) {
                String losowaLiczba = generujLosowaLiczbe(100);
                writer.write(losowaLiczba);
                writer.newLine();
            }

            writer.close();
            System.out.println("Liczby zostały zapisane do pliku: " + sciezka);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generujLosowaLiczbe(int liczbaCyfr) {
        Random rand = new Random();
        StringBuilder liczba = new StringBuilder();

        liczba.append(rand.nextInt(9) + 1);

        for (int i = 1; i < liczbaCyfr; i++) {
            liczba.append(rand.nextInt(10));
        }

        return liczba.toString();
    }
}
