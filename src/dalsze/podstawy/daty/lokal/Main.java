package dalsze.podstawy.daty.lokal;

/*
 * Stwórz klase Osoba, która ma imie, nazisko, pesel (na jego podstawie tworzymy
 * date urodzenia). Stwórz klase Lokal, który ma nazwe, miejsce i minimalny wiek
 * zeby wejsc.
 *
 * Przy próbie wejscia, jesli osoba sie nie łapie na minimalny wiek (ustalamy go
 * z peselu podanego jako string) rzuc wyjatkiem ze jestesZaMlodyZiom().
 */

public class Main {
    public static void main(String[] args) {
        Lokal l = new Lokal("aaa", "bbb", 18);

        Osoba o1 = new Osoba("Jan", "Kowalski", "03232801654");
        Osoba o2 = new Osoba("Jan", "Kowalski", "09232801654");

        System.out.println(o1.getWiek());

        o1.dodajLokal(l);
        o2.dodajLokal(l); // rzuci wyjatkiem
    }
}
