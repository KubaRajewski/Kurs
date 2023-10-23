package dalsze.podstawy.daty.plik;

// 1 ETAP stworz sobie jakis plik z liczbami, kazda linia w pliku ma zawierac
// jakas liczbe ktora ma np: 100 znakow niech plik ma 100 linii(randomowe liczby, rozne od siebie), ale
// przed linia ma byc zapisana godzina zapisu (z dokladnoscia co do milisekund)
// 2 ETAP Wczytaj te liczby z pliku i zapisz iloczyn tych liczb do pliku
// wynik.txt a na
// koncu masz zapisac ile trwały wszystkie obliczenia :)

import java.io.*;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        String liczbyPath = "src/dalsze/podstawy/daty/plik/liczby.txt";
        String wynikPath = "src/dalsze/podstawy/daty/plik/wynik.txt";

        Instant poczatek = Instant.now();

        zapiszDoPlikuLosoweLiczby(liczbyPath, 100, 100);
        BigInteger iloczyn = obliczIloczyn(liczbyPath);

        Instant koniec = Instant.now();

        long czasWykonaniaMillis = poczatek.until(koniec, ChronoUnit.MILLIS);

        zapiszWynikIDuration(wynikPath, iloczyn, czasWykonaniaMillis);
    }

    public static void zapiszDoPlikuLosoweLiczby(String sciezka, int iloscLinijek, int dlugoscLinijki) throws IOException {
        File file = new File(sciezka);

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        Random random = new Random();

        for (int i = 0; i < iloscLinijek; i++) {
            LocalTime now = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

            String formattedTime = now.format(formatter);

            writer.write(formattedTime + " - ");

            StringBuilder line = new StringBuilder();

            for (int j = 0; j < dlugoscLinijki; j++) {
                int randomNumber = random.nextInt(10);
                line.append(randomNumber);
            }

            writer.write(line.toString());
            writer.newLine();
        }

        writer.close();
    }

    public static BigInteger obliczIloczyn(String wejsciowy) throws IOException {
        File inputFile = new File(wejsciowy);

        if (!inputFile.exists()) {
            throw new FileNotFoundException("Plik wejściowy nie istnieje.");
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String line;
        BigInteger iloczyn = BigInteger.ONE;  // używaj BigInteger

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" - ");
            if (parts.length == 2) {
                String numbers = parts[1].trim();
                if (!numbers.isEmpty()) {
                    BigInteger currentNumber = new BigInteger(numbers);
                    iloczyn = iloczyn.multiply(currentNumber);
                }
            }
        }
        reader.close();

        return iloczyn;
    }

    public static void zapiszWynikIDuration(String sciezka, BigInteger iloczyn, long durationMillis) throws IOException {
        File outputFile = new File(sciezka);

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write("Iloczyn liczb: " + iloczyn.toString());
        writer.newLine();
        writer.write("Czas wykonania obliczeń: " + durationMillis + " milisekund");
        writer.close();
    }

}