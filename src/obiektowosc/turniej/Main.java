package obiektowosc.turniej;

//          Ok to masz graczy ktorzy graja w turniejach. Turniej ma nazwe i miesiac. Gracz ma imie i nazwisko.
//
//
//
//
//			5) znajdz gracza ktory ma najwyzsyz ranking z turrniejow ale nigdycnie mial 1 miejsca

public class Main {
    public static void main(String[] args) {

        Turniej t1 = new Turniej("Szachy", "styczen");
        Turniej t2 = new Turniej("Poker", "luty");
        Turniej t3 = new Turniej("Pilka nozna", "marzec");
        Turniej t4 = new Turniej("Szachy", "kwiecien");
        Turniej t5 = new Turniej("Poker", "maj");

        Gracz g1 = new Gracz("Jan", "Kowalski");
        Gracz g2 = new Gracz("Marek", "Nowak");
        Gracz g3 = new Gracz("Anna", "Nowak");
        Gracz g4 = new Gracz("Piotr", "Kowalczyk");
        Gracz g5 = new Gracz("Magdalena", "Wójcik");
        Gracz g6 = new Gracz("Krzysztof", "Lewandowski");
        Gracz g7 = new Gracz("Alicja", "Wojciechowska");
        Gracz g8 = new Gracz("Marcin", "Kowalczyk");
        Gracz g9 = new Gracz("Ewa", "Zając");
        Gracz g10 = new Gracz("Michał", "Szymański");

        t1.dodajUczestnikaIPozycje(g1, 1, 10);
        t1.dodajUczestnikaIPozycje(g2, 2, 8);
        t1.dodajUczestnikaIPozycje(g3, 3, 6);
        t1.dodajUczestnikaIPozycje(g4, 4, 4);
        t1.dodajUczestnikaIPozycje(g9, 5, 2);

        t2.dodajUczestnikaIPozycje(g4, 1, 10);
        t2.dodajUczestnikaIPozycje(g1, 2, 8);
        t2.dodajUczestnikaIPozycje(g2, 3, 6);
        t2.dodajUczestnikaIPozycje(g3, 4, 4);
        t2.dodajUczestnikaIPozycje(g9, 5, 2);

        t3.dodajUczestnikaIPozycje(g5, 1, 10);
        t3.dodajUczestnikaIPozycje(g6, 2, 8);
        t3.dodajUczestnikaIPozycje(g7, 3, 6);
        t3.dodajUczestnikaIPozycje(g8, 4, 4);
        t3.dodajUczestnikaIPozycje(g9, 5, 2);

        t4.dodajUczestnikaIPozycje(g1, 1, 10);
        t4.dodajUczestnikaIPozycje(g2, 2, 8);
        t4.dodajUczestnikaIPozycje(g3, 3, 6);

        t5.dodajUczestnikaIPozycje(g2, 1, 10);
        t5.dodajUczestnikaIPozycje(g1, 2, 8);
        t5.dodajUczestnikaIPozycje(g4, 3, 6);
        t5.dodajUczestnikaIPozycje(g3, 4, 4);

        // TODO 1) chcemy przechowywac dla kazdego gracza jakie pozycje zajmowal w jakim turnieju
        // TODO 2) tak samo punkty jakie zdobyl z dnaego turnieju
//        System.out.println(Gracz.getEkstensja());

        // Wyswietlmy wszystkie turnieje i pozycje w nich zajmowane przez jednego gracza:
        System.out.println("Wszystkie turnieje gracza g1: " + g1.getTurnieje());
        System.out.println("Pozycje Zajmowane w tych turniejach gracza g1 i punkty: " + g1.getWynikiGracza() + "\n");

        // Wyswietlamy rankingi w danym turnieju
        System.out.println("Ranking w turnieju t1: " + t1 + " (Gracz = (Pozycja = Punkty)) " + t1.getWynikiTurnieju());
        System.out.println("Ranking w turnieju t2: " + t2 + " (Gracz = (Pozycja = Punkty)) " + t2.getWynikiTurnieju());
        System.out.println("Ranking w turnieju t3: " + t3 + " (Gracz = (Pozycja = Punkty)) " + t3.getWynikiTurnieju());

        // TODO 3) znajdz gracza ktory byl najlepszy w turniejach o danej nazwie, jesli nie ma to rzuc wyjatkiem
        System.out.println("Gracz Ktory zdobył najwiecej punktow w turniejach o danej nazwie " + Turniej.najlepszyGraczWTurniejachODanejNazwie("Pilka nozna"));

        // TODO 4) znajdz gracza ktory zodbyl najwiecej 1 miejsc ze wszystkich turniejow
        System.out.println("Gracz ktory najczesciej wygrywa: " + Turniej.najczesciejNaPierwszymMiejscu());

    }

}
