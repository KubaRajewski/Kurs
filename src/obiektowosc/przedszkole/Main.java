package obiektowosc.przedszkole;

import java.util.List;

/*
 * Stwórz system do zarządzania przedszkolem. W przedszkolu mamy dzieci oraz
 * wychowawcow, dla obu chcemy znac imie, nazwisko oraz date urodzenia. Dzieci
 * dziela sie na posluszne (odznaka) i nieposluszne (przewinienia).
 *
 * Wychowawcy maja pensje (obliczana za pomoca algorytmu) i dziela sie na
 * wychowawcow kwalifikowanych (kwalifikacje) oraz tymczasowych.
 *
 * Wychowawca odpowiada za grupe (nazwa, max liczba dzieci, obecnie 15).
 * Wychowacwca moze miec wiele grup, grupa ma jednego wychowawce.
 *
 * Kazda grupa ma przypisana sale (nazwa, kolor scian).
 *
 * -narysuj poprawny diagram uml do tego zagadnienia
 * -napisz metode która zwraca dziecko ktore ma najwiecej przewinien
 * -napisz metode ktora zwroci wychowawcow kwliafikowanych z pensja wieksza niz podany parametr
 * -zapisz do pliku imiona nazwiska wszystkich dzieci którzy sa w grupie dla wychowawcy podanego jako parametr
 *
 */
public class Main {
    public static void main(String[] args) {

        // TODO Testy systemu przewinien i odznak dla dzieci

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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // TODO Testy systemu wychowawcow, wynagrodzen i kwalifikacji
        Kwalifikacje kw1 = new Kwalifikacje(true, true, true, true, 15);
        Kwalifikowany w1 = new Kwalifikowany("Mariusz", "Pudzianowski", "2000-01-01");
        w1.dodajKwalifikacje(kw1);

        Kwalifikacje kw2 = new Kwalifikacje(true, false, false, false, 3);
        Kwalifikowany w2 = new Kwalifikowany("Marek", "Nowak", "2002-03-15");
        w2.dodajKwalifikacje(kw2);

        // Mamy dwoch Wychowawcow, jedem ma tylko licencjat a drugi doktorat i dlugi staz pracy, obliczStopien w zaleznosci od kwalifikacji
        // przypisuje nauczyciela do jednej z 4 kategorii, a funkcja obliczPensje na jej podstawie oblicza pensje wychowawcy

        System.out.println("Wychowawca w1: " + w1 + ", Pensja: " + w1.obliczPensje());
        System.out.println("Wychowawca w2: " + w2 + ", Pensja: " + w2.obliczPensje());

        // Wychowawcy tymczasowi maja stala pensje niezaleznie od kwalififikacji, obliczPensje zwraca liczbe godzin razy stawka godzinowa
        Tymczasowy t1 = new Tymczasowy("Anna", "Nowak", "2002-03-15", 130);
        System.out.println("\nWychowawca t1: " + t1 + ", Pensja: " + t1.obliczPensje());

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // TODO testy systemu grup i dzieci
        // Grupa ma wychowawce, dzieci i sale, wychowawca ma grupe, dziecko ma grupe, sale i uwagi, uwaga ma dziecko
        Grupa g1 = new Grupa("1A");
        Grupa g2 = new Grupa("2A");
        Grupa g3 = new Grupa("3A");

        Sala s1 = new Sala("1", "Zielony");
        Sala s2 = new Sala("2", "Niebieski");
        Sala s3 = new Sala("3", "Czerwony");

        g1.dodajWychowawce(w1);
        g2.dodajWychowawce(w1);
        g3.dodajWychowawce(w2);

        g1.dodajSale(s1);
        g2.dodajSale(s2);
        g3.dodajSale(s3);

        g1.dodajDziecko(d1);
        g1.dodajDziecko(d2);
        g1.dodajDziecko(d3);
        g1.dodajDziecko(d4);
        g1.dodajDziecko(d5);

        g2.dodajDziecko(d6);
        g2.dodajDziecko(d7);
        g2.dodajDziecko(d8);
        g2.dodajDziecko(d9);
        g2.dodajDziecko(d10);

        g3.dodajDziecko(d11);
        g3.dodajDziecko(d12);
        g3.dodajDziecko(d13);
        g3.dodajDziecko(d14);
        g3.dodajDziecko(d15);

        // wypiszmy wszystkie grupy
        Grupa.getEkstensja().forEach(System.out::println);

        // Wypiszmy dzieci w grupie g1
        System.out.println("\nGrupa g1: "+g1 + "\nDzieci: "+ g1.getDzieci());

        // wypiszmy grupe dziecka g1
        System.out.println("\nGrupa dziecka d1: " + d1.getGrupa());

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // TODO  * - napisz metode która zwraca dziecko ktore ma najwiecej przewinien
        // TODO  * - napisz metode ktora zwroci wychowawcow kwliafikowanych z pensja wieksza niz podany parametr
        // TODO  * - zapisz do pliku imiona nazwiska wszystkich dzieci którzy sa w grupie dla wychowawcy podanego jako parametr
    }
}
