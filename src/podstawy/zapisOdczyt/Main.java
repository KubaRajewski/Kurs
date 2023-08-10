package podstawy.zapisOdczyt;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File folder = new File("pliki");
        if (!folder.exists()) {
            folder.mkdir();
        }

        // Zapisz do pliku plik.txt kilka nazw zwierząt, odczytaj je i wypisz

        File file = new File(folder, "plik.txt");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("Kot\n");
        fileWriter.write("Pies\n");
        fileWriter.write("Krowa\n");
        fileWriter.write("Kura\n");

        fileWriter.close();

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        System.out.println();

        // Stwórz plik z 10 liczbami, wczytaj je i przypisz do tablicy, wyświetl całą tablicę

        File file2 = new File(folder, "liczby.txt");

        FileReader fileReader2 = new FileReader(file2);
        BufferedReader reader2 = new BufferedReader(fileReader2);

        int[] tab = new int[10];
        int i = 0;
        String line2;
        System.out.println("Liczby z pliku: ");
        while ((line2 = reader2.readLine()) != null) {
            tab[i] = Integer.parseInt(line2);
            i++;
        }

        reader2.close();

        for (int j = 0; j < tab.length; j++) {
            System.out.println(tab[j]);
        }

        // Stwórzmy program, który pozwala zapisać do pliku 3 imiona podane przez użytkownika.
        // Następnie odczytajmy te imiona i wyświetl najdłuższe z nich

        Scanner scanner = new Scanner(System.in);

        File file3 = new File(folder, "imiona.txt");
        FileWriter fileWriter3 = new FileWriter(file3);

        for (int i1 = 0; i1 < 3; i1++) {
            System.out.println("Podaj imię: ");
            String imie = scanner.nextLine();
            fileWriter3.write(imie + "\n");
        }

        fileWriter3.close();

        FileReader fileReader3 = new FileReader(file3);
        BufferedReader reader3 = new BufferedReader(fileReader3);

        String line3;
        String najdluzsze = "";
        while ((line3 = reader3.readLine()) != null) {
            if (line3.length() > najdluzsze.length()) {
                najdluzsze = line3;
            }
        }

        reader3.close();

        System.out.println("Najdłuższe imię to: " + najdluzsze);

        // Stwórz plik słownik z kilkunastoma wyrazami. Wśród tych wyrazów wsadź kilka "kurde", "kurcze" i "kurka".
        // Program ma za zadanie każdy brzydki wyraz zastąpić "****" i zapisać całość do nowego pliku o nazwie "slownikPoprawiony.txt"

        File file4 = new File(folder, "slownik.txt");
        FileReader fileReader4 = new FileReader(file4);
        BufferedReader reader4 = new BufferedReader(fileReader4);

        String line4;
        StringBuilder line5 = new StringBuilder();
        while ((line4 = reader4.readLine()) != null) {
            line5.append(line4.replaceAll("kurde|kurcze|kurka", "****")).append("\n");
        }

        reader4.close();

        File file5 = new File(folder, "slownikPoprawiony.txt");
        FileWriter fileWriter5 = new FileWriter(file5);
        fileWriter5.write(line5.toString());
        fileWriter5.close();

        // W pliku tekstowym są wyrazy. Wypisz te, które są palindromami np. "kajak", "ala"

        File file6 = new File(folder, "wyrazy.txt");
        FileReader fileReader6 = new FileReader(file6);
        BufferedReader reader5 = new BufferedReader(fileReader6);

        String line6;
        while ((line6 = reader5.readLine()) != null) {
            if (line6.equals(new StringBuilder(line6).reverse().toString())) {
                System.out.println(line6);
            }
        }

        reader5.close();
    }
}
