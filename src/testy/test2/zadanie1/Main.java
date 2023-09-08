package testy.test2.zadanie1;

//    Zadanie 01:
//    Pliki noworodki.txt oraz mamy.txt zawierają dane o dzieciach i ich matkach.
//    W pliku noworodki.txt każdy wiersz zawiera następujące informacje o jednym dziecku,
//    rozdzielone znakami odstępu: identyfikator, płeć (c – córka, s – syn), imię, data urodzenia, waga [g], wzrost [cm] oraz identyfikator matki.
//    Przykład:
//    1 c Agnieszka 20-lis-1999 2450 48 33
//    W pliku mamy.txt każdy wiersz zawiera informacje o jednej kobiecie, rozdzielone znakami odstępu: identyfikator matki, imię, wiek.
//    Przykład:
//    1 Agata 25
//    Identyfikator matki z pliku noworodki.txt odpowiada identyfikatorowi w pliku mamy.txt.
//    Wykorzystując dane zawarte w plikach mamy.txt i noworodki.txt wykonaj ponizsze podpunkty:
//
//    a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.
//    b) W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.
//    c) Podaj imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.
//    d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce.
//    e) Znajdz matki które urodziły bliźnięta.
//
//    uwaga: nalezy zaimplementowac 2 kierunkowe relacje i uzywac tych relacji do podpunktow,
//    pamietaj tez ze Matka ma liste dzieci a dziecko ma MATKE nie id Matki tylko matke.
//    jesli mimo tych uwag popelnisz ktoras z gaf opisanych powyzej, tracisz mozliwosc poprawki :(
//    dodatkowo pamiętaj o małych metodach i o zasadach z poprzednich testów.


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File fileMothers = new File("src/testy/test2/zadanie1/files/mamy.txt");
        File fileChildren = new File("src/testy/test2/zadanie1/files/noworodki.txt");

        Mother.readMothers(fileMothers);
        Child.readChildren(fileChildren);

//TODO  Checking if everything loaded correctly:
//        Mother.getExtension().forEach(System.out::println);

//TODO  We can access the relation from both sides:
//        System.out.println(Mother.getExtension().get(1).getChildren());
//        System.out.println(Child.getExtension().get(68).getMum());

//TODO  a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.
        Child tollestBoy = Child.tollestChildByGender(Child.extension, 's');
        Child tollestGirl = Child.tollestChildByGender(Child.extension, 'c');

        System.out.println("Tollest boy" + tollestBoy.getChildId() + " " + tollestBoy.getName() + " " + tollestBoy.getHeight());
        System.out.println("Tollest girl" + tollestGirl.getChildId() + " " + tollestGirl.getName() + " " + tollestGirl.getHeight());

//TODO  b) W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.
        System.out.println(mostPopularDay(Child.extension));

//TODO  c) Podaj imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.
        for (Mother mother : Mother.mothersCertainAgeWithKidsCertainWeight(Mother.extension, 25, 4000.00)) {
            System.out.println(mother.getName());
        }
//TODO  d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce.
//TODO  e) Znajdz matki które urodziły bliźnięta.


    }

// b) W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.
    public static Map.Entry<String, Integer> mostPopularDay(List<Child> children) {
        Map<String, Integer> dayOfWeekCount = new HashMap<>();

        for (Child child : children) {
            Date dateOfBirth = child.getDateOfBirth();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOfBirth);

            String dayOfWeek = new SimpleDateFormat("EEEE").format(dateOfBirth);

            dayOfWeekCount.put(dayOfWeek, dayOfWeekCount.getOrDefault(dayOfWeek, 0) + 1);
        }

        return Collections.max(dayOfWeekCount.entrySet(), Map.Entry.comparingByValue());
    }
}
