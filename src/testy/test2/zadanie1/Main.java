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

public class Main {
    public static void main(String[] args) {

        File fileMothers = new File("src/testy/test2/zadanie1/files/mamy.txt");
        File fileChildren = new File("src/testy/test2/zadanie1/files/noworodki.txt");

        //TODO 0) Wczytaj dane z plików do odpowiednich klas.
        Mother.readMothers(fileMothers);
        Child.readChildren(fileChildren);

        //TODO  a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.
        Child tollestBoy = Child.tollestChildByGender(Child.extension, 's');
        Child tollestGirl = Child.tollestChildByGender(Child.extension, 'c');

        System.out.println("\nTollest boy: " + tollestBoy.getChildId() + " " + tollestBoy.getName() + " " + tollestBoy.getHeight());
        System.out.println("Tollest girl: " + tollestGirl.getChildId() + " " + tollestGirl.getName() + " " + tollestGirl.getHeight() + "\n");

        //TODO  b) W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.
        System.out.println("Most popular day of the week: " + Child.mostPopularDay() + "\n");

        //TODO  c) Podaj imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.
        System.out.println("Names of women below the age of 25 who have given birth to babies weighing over 4000g: ");
        for (Mother mother : Mother.womenBelowAgeWithKidsOverWeight(Mother.extension, 25, 4000)) {
            System.out.println(mother.getName());
        }
        System.out.println();

        //TODO  d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce.
        System.out.println("Girls with the same name as their mother: ");
        for (Child child : Child.girlsWithTheSameNameAsMother(Child.extension)) {
            System.out.println(child.getName() + " " + child.getFormattedDateOfBirth());
        }
        System.out.println();

        //TODO  e) Znajdz matki które urodziły bliźnięta.
        System.out.println("Mothers who gave birth to twins: ");
        Mother.mothersWhoGaveBirthToTwins(Mother.extension).forEach(System.out::println);
    }
}
