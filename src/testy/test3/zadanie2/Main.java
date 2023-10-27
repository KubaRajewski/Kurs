package testy.test3.zadanie2;

import testy.test3.zadanie2.test.classes.Car;
import testy.test3.zadanie2.test.classes.Person;

import java.time.LocalDate;
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

        // TODO wczytywanie danych z pliku
        // Sprawdzmy poprawnosc danych, wypisujemy wszystkie obiekty z peopleFromWarsaw a potem wszystkie obiekty z peopleFromWarsawFromFile
        ObjectContainer<Person> peopleFromWarsawFromFile = ObjectContainer.fromFile("src/testy/test3/zadanie2/files/warsawPeople.txt");

        System.out.println("\nSprawdzanie poprawnosci serializacji / deserializacji\n\npeopleFromWarsaw: ");
        for (int i = 0; i < peopleFromWarsaw.getSize(); i++) {
            System.out.println(peopleFromWarsaw.get(i));
        }
        System.out.println("\npeopleFromWarsawFromFile: ");
        for (int i = 0; i < peopleFromWarsawFromFile.getSize(); i++) {
            System.out.println(peopleFromWarsawFromFile.get(i)); //Sprawdzamy poprawsc
        }

        // peopleFromWarsawFromFile.add(new Person("Kuba", "Wroclaw", 20)); // sprawdzamy czy condition zostalo odpowiednio wczytane, ta linia powinna rzucic exception

        //TODO Sprawdzanie dzialania zapisu/odczytu danych dla innej klasy:
        ObjectContainer<Car> cars = new ObjectContainer<>(p -> true);
        cars.add(new Car(2009, "audi", "a5", 20.4, LocalDate.now(), true));
        cars.add(new Car(2022, "lambo", "huracan", 23.41, LocalDate.now(), false));
        cars.add(new Car(1992, "ferrari", "f40", 234.6, LocalDate.now(), true));

        cars.storeToFile("src/testy/test3/zadanie2/files/cars.txt");

        ObjectContainer<Car> carsfromFile = ObjectContainer.fromFile("src/testy/test3/zadanie2/files/cars.txt");

        System.out.println("\nSprawdzenia poprawnosci serializacji / deserializacji dla innej klasy: \n\ncars:");
        for (int i = 0; i < cars.getSize(); i++) {
            System.out.println(cars.get(i));
        }

        System.out.println("\ncarsFromFile: ");
        for (int i = 0; i < carsfromFile.getSize(); i++) {
            System.out.println(carsfromFile.get(i));
        }
    }
}
