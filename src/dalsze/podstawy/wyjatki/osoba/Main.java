package dalsze.podstawy.wyjatki.osoba;

// Stworz klase Osoba (imie, nazwisko, miasto, wiek) oraz Sklep (nazwa, miasto)
// - metoda co zwraca najstarsza kobiete lub NoWomenException jesli brak kobiet na liscie
// - kobiety chodza do sklepow, mezczyzni nie, zatem powiazania ze sklepem moga miec tylko kobiety, w przypadku próby dodania powiazania mezyczyzna
//   sklep rzuc wyjatkiem ShopsAreOnlyForWomenException()
// - osoby moga sie umawiac na randki, ale jestesmy homofobami, nie akceptujemy par homo, dodaj osobie plec
//   przy probie umowienia sie na randke pary homo rzuc wyjatkiem NoHomoHereException()
// - nasz system przechowuje tylko osoby pełnoletnie, zatem wiek > 18, pryz próbie tworzenia osoby która ma mniej niz 18 lat
//   progarm powinien to naprawic, ustawiajac danej osobie 18 lat (uzyc wyjatki IllegalArgumentException())

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Osoba o = new Osoba("Jan", "Kowalski", "Warszawa", Plec.MEZCZYZNA, 19);
        Osoba o2 = new Osoba("Gosia", "Nowak", "Warszawa", Plec.KOBIETA, 20);
        Osoba o3 = new Osoba("Grazyna", "Nowak", "Warszawa", Plec.KOBIETA, 50);

        Sklep sklep1 = new Sklep("Biedronka", "Warszawa");

        List<Osoba> osoby = new ArrayList<>(List.of(o));

//        System.out.println(Osoba.najstarszaKobieta(osoby)); // rzuci brakiem kobiet na liscie
        System.out.println(Osoba.najstarszaKobieta(Osoba.getEkstensja()));

//        o.dodajSklep(sklep1); // rzuci wyjatkiem bo sklepy sa tylko dla kobiet
        o2.dodajSklep(sklep1);

        System.out.println(sklep1.getOsoby());
        System.out.println(o2.getSklepy());

        o.dodajRandke(o2, "Kino");
        System.out.println(o.getRandki());
        System.out.println(o2.getRandki());

//        o2.dodajRandke(o3, "Kino"); // rzuci wyjatkiem no homo
    }
}
