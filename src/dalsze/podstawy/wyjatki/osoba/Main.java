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

        List<Osoba> osoby = new ArrayList<>();

        try {
            osoby.add(new Osoba("Jan", "Kowalski", "Warszawa", Plec.MEZCZYZNA, 18));
            osoby.add(new Osoba("Gosia", "Nowak", "Warszawa", Plec.KOBIETA, 25));
            osoby.add(new Osoba("Grazyna", "Nowak", "Warszawa", Plec.KOBIETA, 50));
        } catch (IllegalArgumentException e) {
            System.out.println("Znaleziono błąd w danych, poprawiamy wiek osoby na 18 lat");
            String[] osoba = e.getMessage().split(" ");
            osoby.add(new Osoba(osoba[0], osoba[1], osoba[2], Plec.valueOf(osoba[3]), 18));
        }

        Sklep sklep1 = new Sklep("Biedronka", "Warszawa");

        // lista tylko mezczyzn zeby przetestowac czy rzuci wyjatkiem
        List<Osoba> tylkoMezczyzni = new ArrayList<>();
        for (Osoba osoba : osoby) {
            if (osoba.getPlec() == Plec.MEZCZYZNA) {
                tylkoMezczyzni.add(osoba);
            }
        }

//        System.out.println(Osoba.najstarszaKobieta(tylkoMezczyzni)); // rzuci brakiem kobiet na liscie
        System.out.println(Osoba.najstarszaKobieta(Osoba.getEkstensja()));

//        osoby.get(0).dodajSklep(sklep1); // rzuci wyjatkiem bo sklepy sa tylko dla kobiet
        osoby.get(1).dodajSklep(sklep1);

        System.out.println(sklep1.getOsoby());
        System.out.println(osoby.get(1).getSklepy());

        Randka r1 = new Randka(osoby.get(0), osoby.get(1), "Kino");
        System.out.println(osoby.get(0).getRandki());
        System.out.println(osoby.get(1).getRandki());

        Randka r2 = new Randka(osoby.get(1), osoby.get(2), "Kino"); // rzuci wyjatkiem nohomo
    }
}
