package dalsze.podstawy.daty.turniej;

/*
 * Stwórz klasę gracz (imię, nazwisko, nick)
 * Stworz klasę turniej. Musimy przechowywac nazwe, wpisowe, data, punkty
 *
 * Gracz dostaje punkty za dane miejsce w turnieju, w roznych turniejach moga byc rozne ilosci
 * punktow za rozne miejsca.
 *
 *
 * Napisz metode która znajduje najlepszego gracza z danego miesiąca.
 * Napisz metode ktora znajduje najlepszego gracza z danego okresu czasu.
 * Napisz metode ktora znajduje graczy z danego okresu czasu.
 * Napisz metoda która zwraca liste graczy którzy zajeli 1 miejsce przynajmniej w dwoch roznych miesiącach
 */

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Jan", "Kowalski", "Kowal");
        Player p2 = new Player("Anna", "Nowak", "Ania123");
        Player p3 = new Player("Piotr", "Zieliński", "Piter");
        Player p4 = new Player("Magda", "Lewandowska", "Maggie");
        Player p5 = new Player("Michał", "Borowski", "Boro");

        Tournament t1 = new Tournament("Mistrzostwa Świata", 50.0, LocalDate.of(2023, 3, 5));
        Tournament t2 = new Tournament("Krajowe Zawody", 20.0, LocalDate.of(2023, 11, 12));
        Tournament t3 = new Tournament("Krajowe Zawody 2 ", 20.0, LocalDate.of(2024, 12, 12));

        Result r1 = new Result(p1, t1, 1, 10);
        Result r2 = new Result(p2, t1, 2, 8);
        Result r3 = new Result(p3, t1, 3, 6);
        Result r4 = new Result(p4, t1, 4, 4);
        Result r5 = new Result(p5, t1, 5, 2);

        Result r6 = new Result(p1, t2, 5, 2);
        Result e7 = new Result(p2, t2, 4, 4);
        Result r8 = new Result(p3, t2, 3, 6);
        Result r9 = new Result(p4, t2, 2, 8);
        Result r10 = new Result(p5, t2, 1, 150);

        Result r11 = new Result(p1, t3, 1, 10);

        // t1.getResults().forEach(System.out::println);
        // System.out.println("===============================================================================================");
        // t2.getResults().forEach(System.out::println);

        // Napisz metode która znajduje najlepszego gracza z danego miesiąca.
        System.out.println("\nBest player in March: " + Player.bestPlayerCertainMonth(Player.getExtension(), Month.MARCH));

        // Napisz metode ktora znajduje najlepszego gracza z danego okresu czasu.
        System.out.println("Best player in 2023: " + Player.bestPlayerCertainPeriod(Player.getExtension(), LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));

        // Napisz metode ktora znajduje graczy z danego okresu czasu.
        System.out.println("Players in 2023: " + Player.playersCertainPeriod(Player.getExtension(), LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));

        // Napisz metoda która zwraca liste graczy którzy zajeli 1 miejsce przynajmniej w dwoch roznych miesiącach
        System.out.println("Players who took 1st place in at least two different months: " + Player.hadCertainPositionInNDifferentMonths(Player.getExtension(), 1, 2));

        // werjsa ze Streamem
        // System.out.println("STREAM Players who took 1st place in at least two different months: " + Player.hadCertainPositionInNDifferentMonthsSTREAM(Player.getExtension(), 1, 2));

    }
}
