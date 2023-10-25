package testy.test3.zadanie1;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        //TODO Kompilacja
        StringContainer st = new StringContainer("\\d{2}[-]\\d{3}"); // Kompiluje sie
//         StringContainer st2 = new StringContainer("\\d{2[-]\\d{3}"); // InvalidStringContainerPatternException
        System.out.println("Pattern: " + st.getPattern()); // pattern sie zgadza

        // TODO Dodawanie Stringow
        st.add("02-495");
        st.add("01-120");
        st.add("05-123");
        st.add("00-000");
        // st.add("Ala ma kota"); // invalidStringContainerValueException

        // TODO Wyswietlanie wszystkich danych
        System.out.println("\nWszystkie dane:");
        for (int i = 0; i < st.getSize(); i++) {
            System.out.println(st.get(i)); // wypisujemy dodane kody pocztowe
        }

        // TODO Usuwanie danych na dwa sposoby
        st.remove(0);
        st.remove("00-000");

        System.out.println("\nPo usunieciu:");
        for (int i = 0; i < st.getSize(); i++) {
            System.out.println(st.get(i)); // wypisujemy dodane kody pocztowe
        }

        // TODO Brak mozliwosci dodania duplikatow
        StringContainer st3 = new StringContainer("\\d{2}[-]\\d{3}", true);
        st3.add("00-000");
        // st2.add("00-000"); // DuplicatedElementOnListException

        // TODO Implementacja dat i czasu do listy:
        System.out.println("\nSprawdzanie daty dodania elementu:");
        System.out.println(st + ", Element: " + st.get(0) + ", Data i godzina dodania: " + st.get(0).getDate());

        //TODO Metoda getDataBetween
        System.out.println("\nMetoda getDataBetween:");
        StringContainer stBetween = st.getDataBetween(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        for (int i = 0; i < stBetween.getSize(); i++) {
            System.out.println(stBetween.get(i)); // wyrzuca cala liste z st
        }

        System.out.println("\nWersja z nullami: ");
        StringContainer stBetween2 = st.getDataBetween(null, null);
        for (int i = 0; i < stBetween2.getSize(); i++) {
            System.out.println(stBetween2.get(i)); // rowniez wyrzuca cala liste z st
        }

        StringContainer stBetween3 = st.getDataBetween(null, LocalDateTime.now().minusMinutes(1));
        for (int i = 0; i < stBetween3.getSize(); i++) {
            System.out.println(stBetween3.get(i)); // pusta lista
        }

        StringContainer stBetween4 = st.getDataBetween(LocalDateTime.now().plusMinutes(1), null);
        for (int i = 0; i < stBetween4.getSize(); i++) {
            System.out.println(stBetween4.get(i)); // pusta lista
        }

        // TODO zapisywanie i odczyt z pliku
        st.storeToFile("src/testy/test3/zadanie1/file/postalCodes.txt"); // zapisujemy zawartosc pliku oraz pattern w pierwszje linijce
        StringContainer fromFile = StringContainer.fromFile("src/testy/test3/zadanie1/file/postalCodes.txt"); // wczytujemy dane z pliku do nowej instancji klasy

        System.out.println("\nWartosci zapisane do StringContainer fromFile z pliku postalCodes.txt: ");
        for (int i = 0; i < fromFile.getSize(); i++) {
            System.out.println(fromFile.get(i)); // wypisuje ta sama zawartosc co w postalCodes.txt / st
        }

        //TODO test dla innych danych
        StringContainer fromFile2 = StringContainer.fromFile("src/testy/test3/zadanie1/file/test.txt");
        System.out.println("\nWartosci zapisane z pliku postalCodes2 do StringContainer fromFile2 z pliku test.txt " +
                "dla sprawdzenia poprawnosci dzialania programu: ");
        for (int i = 0; i < fromFile2.getSize(); i++) {
            System.out.println(fromFile2.get(i));
        }
    }
}