package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;
//        TODO Zadanie: System zarządzania biblioteką
//
//        Zaprojektuj system zarządzania biblioteką, który umożliwia dodawanie, usuwanie i wypożyczanie książek.
//        System powinien obsługiwać różne typy czytelników, takie jak studenci, nauczyciele i pracownicy biblioteki.
//
//        1) Stwórz interfejs Książka z metodami do pobierania tytułu, autora i roku wydania książki.
//
//        2) Stwórz interfejs Czytelnik z metodami do wypożyczania i zwracania książek oraz do sprawdzania,
//        czy czytelnik ma zaległe książki.
//
//        3) Stwórz klasy implementujące interfejs Książka, takie jak KsiążkaFikcyjna i KsiążkaNaukowa,
//        oraz klasy implementujące interfejs Czytelnik, takie jak Student, Nauczyciel i PracownikBiblioteki.
//
//        4) Zaimplementuj mechanizm dodawania i usuwania książek z biblioteki.
//
//        5) Zaimplementuj funkcje wypożyczania i zwracania książek przez czytelników.
//        Dostarcz mechanizm śledzenia zaległych książek i ewentualnej kary dla czytelników zalegających z oddaniem książek.
//
//        6) Stwórz klasę Biblioteka, która będzie zarządzać książkami i czytelnikami.
//        Biblioteka powinna umożliwiać dodawanie nowych książek, rejestrację nowych czytelników oraz obsługę wypożyczeń
//        i zwrotów książek.
//
//        7) Przygotuj interfejs użytkownika (konsolowy lub graficzny), który umożliwia dodawanie książek,
//        rejestrację czytelników, wypożyczanie i zwracanie książek oraz sprawdzanie zaległych książek i kar.
//
//        8) Zapewnij obsługę wielu równoczesnych wypożyczeń i zwrotów.
//
//        9) Użyj interfejsów do abstrakcji operacji związanych z książkami i czytelnikami,
//        aby umożliwić elastyczne rozszerzanie systemu w przyszłości.

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2020, 10, 10);
        LocalDate data2 = LocalDate.of(2010, 10, 10);
        Biblioteka b1 = new Biblioteka("Biblioteka nr 1", data, 10, 10);

        Ksiazka k1 = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", Rodzaj.DRAMAT, data, 2);
        Ksiazka k2 = new Ksiazka("harry potter", "jk rowaling", Rodzaj.FICKJA, data, 10);

        Pracownik p1 = new Pracownik("Jan", "Kowalski", data, 2500);

        b1.dodajPracownika(p1);

        System.out.println(b1);
        System.out.println(p1);
    }
}
