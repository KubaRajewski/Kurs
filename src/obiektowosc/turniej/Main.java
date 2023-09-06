package obiektowosc.turniej;

// Ok to masz graczy ktorzy graja w turniejach. Turniej ma nazwe i miesiac. Gracz ma imie i nazwisko.

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

        t1.dodajUczestnika(g1);
        t1.dodajUczestnika(g2);
        t1.dodajUczestnika(g3);
        t1.dodajUczestnika(g4);
        t1.dodajUczestnika(g9);

        t2.dodajUczestnika(g4);
        t2.dodajUczestnika(g1);
        t2.dodajUczestnika(g2);
        t2.dodajUczestnika(g3);
        t2.dodajUczestnika(g9);

        t3.dodajUczestnika(g5);
        t3.dodajUczestnika(g6);
        t3.dodajUczestnika(g7);
        t3.dodajUczestnika(g8);
        t3.dodajUczestnika(g9);

        t4.dodajUczestnika(g1);
        t4.dodajUczestnika(g2);
        t4.dodajUczestnika(g3);

        t5.dodajUczestnika(g2);
        t5.dodajUczestnika(g1);
        t5.dodajUczestnika(g4);
        t5.dodajUczestnika(g3);

        Wynik w1 = new Wynik(t1, g1, 1);
        Wynik w2 = new Wynik(t1, g2, 2);
        Wynik w3 = new Wynik(t1, g3, 3);
        Wynik w4 = new Wynik(t1, g4, 4);
        Wynik w5 = new Wynik(t1, g9, 5);

        Wynik w6 = new Wynik(t2, g4, 1);
        Wynik w7 = new Wynik(t2, g1, 2);
        Wynik w8 = new Wynik(t2, g2, 3);
        Wynik w9 = new Wynik(t2, g3, 4);
        Wynik w10 = new Wynik(t2, g9, 5);

        Wynik w11 = new Wynik(t3, g5, 1);
        Wynik w12 = new Wynik(t3, g6, 2);
        Wynik w13 = new Wynik(t3, g7, 3);
        Wynik w14 = new Wynik(t3, g8, 4);
        Wynik w15 = new Wynik(t3, g9, 5);

        Wynik w16 = new Wynik(t4, g1, 1);
        Wynik w17 = new Wynik(t4, g2, 2);
        Wynik w18 = new Wynik(t4, g3, 3);

        Wynik w19 = new Wynik(t5, g2, 1);
        Wynik w20 = new Wynik(t5, g1, 2);
        Wynik w21 = new Wynik(t5, g4, 3);
        Wynik w22 = new Wynik(t5, g3, 4);

        // TODO 1) chcemy przechowywac dla kazdego gracza jakie pozycje zajmowal w jakim turnieju
        // TODO 2) tak samo punkty jakie zdobyl z dnaego turnieju
        System.out.println(Gracz.getEkstensja());

        System.out.println("\n" + "Wyniki turnieju t1: " + t1.getNazwa());
        t1.getWyniki().forEach(System.out::println);


        System.out.println("\n" + "Wyniki gracza g1: " + g1.getNazwisko());
        g1.getWyniki().forEach(System.out::println);

        System.out.println("\n"+"Punkty gracza g1 po wszystkich turniejach: " + g1.getSumaPunktow());

        // TODO 3) znajdz gracza ktory byl najlepszy w turniejach o danej nazwie, jesli nie ma to rzuc wyjatkiem
        System.out.println("\n"+"Najlepszy gracz w turnieju o nazwie Szachy: " + Gracz.najlepszyGraczWTurniejachODanejNazwie("Szachy"));

        // TODO 4) znajdz gracza ktory zodbyl najwiecej 1 miejsc ze wszystkich turniejow
        System.out.println("\n"+"Gracz ktory zdobyl najwiecej 1 miejsc: " + Gracz.zNajwiekszaIlosciaWygranych());

        // TODO 5) znajdz gracza ktory ma najwyzsyz ranking z turrniejow ale nigdy nie mial 1 miejsca
        System.out.println("\n"+"Gracz ktory ma najwyzszy ranking z turniejow ale nigdy nie mial 1 miejsca: " + Gracz.najlepszyGraczBezWygranej());

    }

}
