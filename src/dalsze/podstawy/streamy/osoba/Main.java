package dalsze.podstawy.streamy.osoba;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Osoba osoba1 = new Osoba("Jan", "Warszawa", 30);
        Osoba osoba2 = new Osoba("Anna", "Kraków", 25);
        Osoba osoba3 = new Osoba("Mateusz", "Warszawa", 35);
        Osoba osoba4 = new Osoba("Katarzyna", "Kraków", 40);
        Osoba osoba5 = new Osoba("Adam", "Gdańsk", 28);

        List<Osoba> listaOsob = Arrays.asList(osoba1, osoba2, osoba3, osoba4, osoba5);

        // Testujemy wszystkie funkcje
        System.out.println("Ilość osób starszych niż 30: " + Osoba.ileOsobStarszychNiz(listaOsob, 30));
        try {
            System.out.println("Najstarsza osoba: " + Osoba.najstarszaOsoba(listaOsob).getImie());
        } catch (NoOldestException e) {
            System.out.println("Nie znaleziono najstarszej osoby.");
        }

        try {
            System.out.println("Najstarsza kobieta: " + Osoba.najstarszaKobieta(listaOsob).getImie());
        } catch (NoOldestException e) {
            System.out.println("Nie znaleziono najstarszej kobiety.");
        }

        System.out.println("Średni wiek mężczyzn: " + Osoba.sredniWiekMezczyzn(listaOsob));
        System.out.println("Średni wiek kobiet: " + Osoba.sredniWiekKobiet(listaOsob));

        System.out.println("Średni wiek mężczyzn (metoda 2): " + Osoba.sredniWiekMezczyzn2(listaOsob));
        System.out.println("Średni wiek kobiet (metoda 2): " + Osoba.sredniWiekKobiet2(listaOsob));

        System.out.println("Różne miasta z listy osób: " + Osoba.distinctMiasta(listaOsob));

        try {
            System.out.println("Najludniejsze miasto: " + Osoba.najludniejszeMiasto(listaOsob));
        } catch (NoOldestException e) {
            System.out.println("Nie znaleziono najludniejszego miasta.");
        }
    }
}
