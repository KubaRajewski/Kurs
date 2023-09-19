package dalsze.podstawy.wielkie.liczby.pliki;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String sciezka = "src/dalsze/podstawy/wielkie/liczby/pliki/liczby.txt";


        //TODO zapisz 100 losowych liczb do pliku
        Path katalog = FileSystems.getDefault().getPath(sciezka).getParent();
        try {
            Files.createDirectories(katalog);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(sciezka));

            for (int i = 0; i < 100; i++) {
                writer.write(generujLosowaLiczbe(100));
                writer.newLine();
            }

            writer.close();
            System.out.println("Liczby zostały zapisane do pliku: " + sciezka);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //TODO Wczytaj liczby z pliku i oblicz ich iloczyn
        String plikWejsciowy = "src/dalsze/podstawy/wielkie/liczby/pliki/liczby.txt";
        String plikWyjsciowy = "src/dalsze/podstawy/wielkie/liczby/pliki/wynik.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(plikWejsciowy));
            BufferedWriter writer = new BufferedWriter(new FileWriter(plikWyjsciowy));

            String linia;
            BigInteger iloczyn = BigInteger.ONE;

            while ((linia = reader.readLine()) != null) {
                BigInteger liczba = new BigInteger(linia);
                iloczyn = iloczyn.multiply(liczba);
            }

            writer.write(iloczyn.toString());
            writer.close();
            reader.close();

            System.out.println("Iloczyn liczb został zapisany do pliku: " + plikWyjsciowy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String generujLosowaLiczbe(int liczbaCyfr) {
        Random rand = new Random();
        StringBuilder liczba = new StringBuilder();

        liczba.append(rand.nextInt(1, 10));

        for (int i = 1; i < liczbaCyfr; i++) {
            liczba.append(rand.nextInt(10));
        }

        return liczba.toString();
    }
}
