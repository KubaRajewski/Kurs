package obiektowosc.przedszkole;

/*
 * Stwórz system do zarządzania przedszkolem. W przedszkolu mamy dzieci oraz
 * wychowawcow, dla obu chcemy znac imie, nazwisko oraz date urodzenia. Dzieci
 * dziela sie na posluszne (odznaka) i nieposluszne (przewinienia).
 *
 * Wychowawcy maja pensje (obliczana za pomoca algorytmu) i dziela sie na
 * wychowawcow kwalifikowanych (kwalifikacje) oraz tymczasowych.
 *
 * Wychowacwa odpowiada za grupe (nazwa, max liczba dzieci, obecnie 15).
 * Wychowacwca moze miec wiele grup, grupa ma jednego wychowawce.
 *
 * Kazda grupa ma przypisana sale (nazwa, kolor scian).
 *
 * -narysuj poprawny diagram uml do teog zagadnienia
 * -napisz metode która zwraca dziecko ktore ma najwiecej przewinien
 * -napisz metode ktora zwroci wychowawcow kwliafikowanych z pensja wieksza niz podany parametr
 * -zapisz do pliku imiona nazwiska wszystkich dzieci którzy sa w grupie dla wychowawcy podanego jako parametr
 *
 */
public class Main {
    public static void main(String[] args) {
        Dziecko d1 = new Dziecko("Jan", "Kowalski", "2000-01-01");
        Dziecko d2 = new Dziecko("Anna", "Nowak", "2002-03-15");
        Dziecko d3 = new Dziecko("Piotr", "Zając", "1998-07-20");
        Dziecko d4 = new Dziecko("Katarzyna", "Wójcik", "2005-11-30");
        Dziecko d5 = new Dziecko("Marek", "Lis", "2004-09-05");
        Dziecko d6 = new Dziecko("Ewa", "Kaczmarek", "2001-06-10");
        Dziecko d7 = new Dziecko("Tomasz", "Pawlak", "1999-04-25");
        Dziecko d8 = new Dziecko("Magdalena", "Dąbrowska", "2003-08-12");
        Dziecko d9 = new Dziecko("Grzegorz", "Woźniak", "1997-12-17");
        Dziecko d10 = new Dziecko("Joanna", "Kamińska", "2006-02-28");
        Dziecko d11 = new Dziecko("Marcin", "Adamczyk", "2007-10-09");
        Dziecko d12 = new Dziecko("Agnieszka", "Król", "1996-05-14");
        Dziecko d13 = new Dziecko("Andrzej", "Jaworski", "2008-03-22");
        Dziecko d14 = new Dziecko("Monika", "Pietrzak", "2009-09-03");
        Dziecko d15 = new Dziecko("Łukasz", "Górski", "1995-11-18");

        d1.dodajPrzewinienie("Bicie", "Bil kolege", "2017-01-01");
        d1.dodajOdznake("Rysunek", "Ładnie rysował", "2017-01-02");
        d1.dodajOdznake("Bieganie", "Ładnie biegał", "2017-01-03");
        d2.dodajPrzewinienie("Kopanie pilki", "Wybil okno", "2017-01-04");


        // TODO Testy systemu przewinien i odznak dla dzieci
        //Kim jest d1?
        System.out.println("Dziecko d1: " + d1);

        // Zobaczmy wszystkie uwagi dziecka d1:
        System.out.println("\n" + "Uwagi dla dziecka d1: ");
        d1.getUwagi().forEach(System.out::println);

        // Zobaczmy wszystkie odznaki dziecka d1:
        System.out.println("\n" + "Odznaki dla dziecka d1: ");
        d1.getOdznaki().forEach(System.out::println);

        // Zobaczmy wszystkie przewinienia dziecka d1:
        System.out.println("\n" + "Przewinienia dla dziecka d1: ");
        d1.getPrzewinienia().forEach(System.out::println);

        // zobaczmy czy dziecko d1 jest posluszne:
        System.out.println("\n" + "Czy dziecko d1 jest posluszne? " + d1.czyPosluszne());
        if (d1.czyPosluszne()) {
            System.out.println("Dziecko d1 ma wiecej odznak niz przewinien" + "\n");
        } else {
            System.out.println("Dziecko d1 ma wiecej przewinien niz odznak" + "\n");
        }

        // W systemie mamy 4 uwagi, mozemy wiec zobaczyc 4 uwagi w ekstensji
        System.out.println("Ekstensja uwag: ");
        Uwaga.getEkstensja().forEach(System.out::println);
    }
}
