package dalsze.podstawy.wielkie.liczby.pliki;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

// stworz sobie jakis plik z liczbami, 100 liczb stucyfrowych (roznych, losowych!)
// Wczytaj te liczby z pliku i zapisz iloczyn tych liczb do pliku wynik.txt

public class ZapiszIloczyn {
    public static void main(String[] args) {
        try {
            zapiszIloczynDoPliku("src/dalsze/podstawy/wielkie/liczby/pliki/liczby.txt", "src/dalsze/podstawy/wielkie/liczby/pliki/wynik.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zapiszIloczynDoPliku(String sciezkaWejsciowegoPliku, String sciezkaWyjsciowegoPliku) throws IOException {
        Path katalogWyjsciowegoPliku = FileSystems.getDefault().getPath(sciezkaWyjsciowegoPliku).getParent();
        try {
            Files.createDirectories(katalogWyjsciowegoPliku);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(sciezkaWejsciowegoPliku));
             BufferedWriter writer = new BufferedWriter(new FileWriter(sciezkaWyjsciowegoPliku))) {

            String linia;
            BigInteger iloczyn = BigInteger.ONE;

            while ((linia = reader.readLine()) != null) {
                BigInteger liczba = new BigInteger(linia);
                iloczyn = iloczyn.multiply(liczba);
            }

            writer.write(iloczyn.toString());

            System.out.println("Iloczyn liczb został zapisany do pliku: " + sciezkaWyjsciowegoPliku);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
