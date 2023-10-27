package testy.test3.zadanie2;

//        TODO Zadanie 02:
//        Bez uzycia struktur danych typu kolekcje, tablice, mapy czy zapisywania do pliku, nalezy stworzyc klase ObjectContainer w taki sposob aby wykonal
//        sie ponizszy kod: (przyklad dla klasy Person (name, city, age) - ale ma dzialac dla dowolnej klasy)
//
//        ObjectContainer<Person> peopleFromWarsaw = new ObjectContainer(p -> p.getCity().equals("Warsaw"));//tu w konstruktorze podajemy warunek do dodawania osoby do kontenera.
//        peopleFromWarsaw.add(new Person("Jan", "Warsaw", 30)); // powinno byc ok, Jan jest z warszawy
//        peopleFromWarsaw.add(new Person("Weronika","Warsaw", 20)); // powinno byc tez okej, Weronika jest z warszawy
//        peopleFromWarsaw.add(new Person("Waldek", "Monaco", 34));// waldka niedoda, jest z Monaco, wiec tu powinno albo rzucic wyjatkiem,
//        albo metoda add powinna zwrocic po prostu false - co wybierzesz to twoja decyzja.
//
//        do tego ponizej mozesz juz stosowac liste, no bo masz zwrocic liste :)
//        List<Person> females = peopleFromWarsaw.getWithFilter(p -> p.getName().endsWith("a")); // zwraca nam wszystkie osoby spelniajace dany warunek.
//
//        peopleFromWarsaw.removeIf(p -> p.getAge() > 50); // powinno nam usuwac ludzi spelniajacy dany warunek w nawiasie.
//
//        tu naturalnie mozesz stosowac zapis do pliku bo wymaga tego polecenie
//        peopleFromWarsaw.storeToFile("youngPeopleFromWarsaw.txt", p -> p.getAge() < 30, p -> p.getName()+";"+p.getAge()+";"+p.getCity());
//        metoda powinna zapisac obiekty do pliku z pierwszego argumenty metody, tylko te co spelniaja drugi warunek metody, w formacie z trzeciego warunku metody
//
//        Dobrze by było mieć warstwe persystencji, zrobmy np:
//        peopleFromWarsaw.storeToFile("warsawPeople.txt"); // powinno nam zapisac dane trwale do pliku.
//
//        i np:
//        ObjectContainer<Person> peopleFromWarsawFromFile = ObjectContainer.fromFile("warsawPeople.txt"); //powinno wczytac caly obiekt tak jak zostal zapisay w metodzie storeToFile,
//        caly stan obiektu powinien byc odwzrowowany


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO Utworzenie struktury danych
        ObjectContainer<Person> peopleFromWarsaw = new ObjectContainer<>(p -> p.getCity().equals("Warsaw"));

        // TODO Mozliwosc dodawania obiektow
        peopleFromWarsaw.add(new Person("Jan", "Warsaw", 30));
        peopleFromWarsaw.add(new Person("Weronika", "Warsaw", 21));
        peopleFromWarsaw.add(new Person("Gosia", "Warsaw", 22));
        peopleFromWarsaw.add(new Person("Marta", "Warsaw", 20));
        peopleFromWarsaw.add(new Person("Marcin", "Warsaw", 60));
        // peopleFromWarsaw.add(new Person("Waldek", "Monaco", 34)); // rzucamy wyjatkiem ConditionNotMatchedException

        System.out.println("Cala lista: ");
        for (int i = 0; i < peopleFromWarsaw.getSize(); i++) {
            System.out.println(peopleFromWarsaw.get(i));
        }

        // TODO Mozliwosc zwracania obiektow spelniajacych warunek
        System.out.println("\nTylko kobiety");
        List<Person> females = peopleFromWarsaw.getWithFilter(p -> p.getName().endsWith("a"));
        for (Person female : females) {
            System.out.println(female); // wyrzuci wszystkie osoby z imieniem konczacym sie na "a"
        }

        // TODO Mozliwosc usuwania obiektow spelniajacych warunek
        System.out.println("\nTylko mlodzi ludzie: ");
        peopleFromWarsaw.removeIf(p -> p.getAge() > 50); // usuwamy marcina z warszawy bo ma wiecej niz 50 lat
        for (int i = 0; i < peopleFromWarsaw.getSize(); i++) {
            System.out.println(peopleFromWarsaw.get(i)); //
        }

        // TODO Mozliwosc zapisu do pliku
        // Ponizsza funkcja zapisuje do pliku tylko obiekty spelniajace warunek podany jako drugi parametr, wedlug formatu wskazanego w trzecim parametrze
        peopleFromWarsaw.storeToFile("src/testy/test3/zadanie2/files/youngPeopleFromWarsaw.txt", p -> p.getAge() < 30, p -> p.getName() + ";" + p.getAge() + ";" + p.getCity());

        // Ta funkcja zapisuje do pliku wszystkie obiekty ze struktury na podstawie toStringa danych obiektow
        peopleFromWarsaw.storeToFile("src/testy/test3/zadanie2/files/warsawPeople.txt");


        System.out.println("\n\n\n\n\n");
        System.out.println("ChujkurwaJebac");
        for (int i = 0; i < peopleFromWarsaw.getSize(); i++) {
            System.out.println(peopleFromWarsaw.get(i));
        }

        System.out.println();

        // TODO wczytywanie danych z pliku
        ObjectContainer<Person> peopleFromWarsawFromFile = ObjectContainer.fromFile("src/testy/test3/zadanie2/files/warsawPeople.txt");

        for (int i = 0; i < peopleFromWarsawFromFile.getSize(); i++) {
            System.out.println(peopleFromWarsawFromFile.get(i));
        }


        ObjectContainer<Car> cars = new ObjectContainer<>();
        cars.add(new Car(2009, "audi", "a5"));
        cars.add(new Car(2022, "lambo", "huracan"));
        cars.add(new Car(1992, "ferrari", "f40"));

        cars.storeToFile("src/testy/test3/zadanie2/files/cars.txt");

        ObjectContainer<Car> carsfromFile = ObjectContainer.fromFile("src/testy/test3/zadanie2/files/cars.txt");

        for (int i = 0; i < carsfromFile.getSize(); i++) {
            System.out.println(carsfromFile.get(i));
        }
    }
}
