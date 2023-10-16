package dalsze.podstawy.wyjatki.odczyt;

//Stworz program ktory pozwoli odczytac z pliku zawarte informacje.
//Jesli plik nie istnieje to obsluz ta sytuacje is stworz go (createNewFile() z klasy FIle tworzy nowy plik)

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("src/dalsze/podstawy/wyjatki/odczyt/testowy.txt");

        FileReader fileReader;

        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            file.createNewFile();
        }
    }
}
