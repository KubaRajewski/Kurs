package dalsze.podstawy.wyjatki.lista;

// Stwórz liste i dodaj jej 3 eleemtny np Stringi. Losujemy liczbe z zakrezu 0-5
// i do zmiennej typu String
// przypisujemy wylosowany element listy, obsluz sytuacje gdy wylosowana wartosc
// jest poza zakresem listy

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> imiona = new ArrayList<>(List.of("Kuba", "Marcin", "Gosia"));

        Random rand = new Random();
        int losowa = rand.nextInt(6);

        try {
            String imie = imiona.get(losowa);
            System.out.println(imie);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wylosowana liczba jest poza zakresem listy.");
        }
    }
}
