package testy.test3.zadanie1;

//        TODO Zadanie 01:
//        napisz kod tak aby fragment ponizej dzialal.
//        Nie mozesz uzywac tablic, list, setow, zadnych kolekcji czy kolejek, ani konkatenowac to w Stringi czy appendowac
//        w string buildery
//
//        tworzymy klaske String container ktora bedzie mogla przyjmowac tylko Stringi z okreslonym Patternem podanym jako argument.
//        podczas tworzenia obiektu nalezy zdefinowac poprawnosc patternu i jesli pattern bedzie "zly- czyli taki ktory sie nie kompiluje"
//        to ma zostac rzucony wyjatek InvalidStringContainerPatternException(badPattern)
//        wszystkie wyjatki w programie maja dziedziczyc RuntimeException.
//        tu w przykladzie dodajemy kody pocztowe
//        StringContainer st = new StringContainer("\\d{2}[-]\\d{3}");

//        st.add("02-495");//git
//        st.add("01-120");//git
//        st.add("05-123");//git
//        st.add("00-000");//git
//        st.add("ala ma kota"); //powinno sie wywalic wyjatkiem InvalidStringContainerValueException(badValue)
//        for(int i=0; i<st.size(); i++){
//        System.out.println(st.get(i)); //powinno wypisac dodane kody pocztowe
//        }

//        st.remove(0); // usuwa "02-495"
//        st.remove("00-000"); // usuwa "00-000"
//
//        System.out.println("po usunieciu");
//        for(int i=0; i<st.size(); i++){
//        System.out.println(st.get(i)); //powinno wypisac dodane kody pocztowe
//        }

//        Nasza liste mozna tez parametryzowac tak aby nie dalo sie wrzucac powtorzen np:
//        StringContainer st = new StringContainer("\\d{2}[-]\\d{3}", true); //jakis parametr np: duplicatedNotAllowed - domyslnie false
//        wtedy np:
//        st.add("02-495");//git
//        st.add("02-495");//powinno rzucic wyjatkiem DuplicatedElementOnListException

//        kazdy element w StringContainer powinien miec date+czas dodania elementu do niego,
//        TODO nalezy zaimplementowac metode:
//        StringContainer stBetween = st.getDataBetween(dateFrom, dateTo);
//        ktora zwroci elementy dodane pomiedzy dateFrom a dateTo
//        gdzie dateFrom i dateTo to obiekty LocalDateTime i moga byc nullami.

//        Dodatkowo pomysl o persystencji StringContainer tj:
//        st.storeToFile("postalCodes.txt"); // powinno zapisac zawartosc
//        StringContainer fromFile = StringContainer.fromFile("postalCodes.txt"); // powinno wczytac zawartosc z pliku i "fromFile" musi miec te same dane co "st"

public class Main {
    public static void main(String[] args) {

        //TODO Kompilacja
        StringContainer st = new StringContainer("\\d{2}[-]\\d{3}"); // Kompiluje sie
        // StringContainer st2 = new StringContainer("\\d{2[-]\\d{3}"); // InvalidStringContainerPatternException

        // TODO Dodawanie Stringow
        st.add("02-495");
        st.add("01-120");
        st.add("05-123");
        st.add("00-000");
        // st.add("Ala ma kota"); // invalidStringContainerValueException

        // TODO Wyswietlanie wszystkich danych
        System.out.println("Wszystkie dane:");
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
        StringContainer st2 = new StringContainer("\\d{2}[-]\\d{3}", true);
        st2.add("00-000");
        // st2.add("00-000"); // DuplicatedElementOnListException

        // TODO Implementacja dat i czasu do listy:
        System.out.println("\nSprawdzanie daty dodania elementu: ");
        System.out.println(st.get(0).getDate());
    }
}


























