package dalsze.podstawy.interfejsy.nieruchomosci;

//    * Stworz hieararchie dziedziczenia interfejsow tak aby mialy biznesowy sens. Stworz sensowne biznesowe klasy ktore moga je implementowac
//    * (niekoniecznie kazda klasa kazdy interfejs). Niech interefejsy maja rozne metody statyczne, defaultowe, abstrakcyjne, tak aby calosc
//    * tworzyła wspolna sensowna całosc :)

import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IBudynek;
import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.IGrunt;
import dalsze.podstawy.interfejsy.nieruchomosci.interfejsy.INieruchomosc;
import dalsze.podstawy.interfejsy.nieruchomosci.klasy.DomJednorodzinny;
import dalsze.podstawy.interfejsy.nieruchomosci.klasy.Dzialka;
import dalsze.podstawy.interfejsy.nieruchomosci.klasy.Magazyn;
import dalsze.podstawy.interfejsy.nieruchomosci.klasy.Mieszkanie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Dzialka dzialka1 = new Dzialka("ul. Słoneczna 10, 00-001 Warszawa", 50.0, 100.0, new BigDecimal("250000.00"));
        Dzialka dzialka2 = new Dzialka("ul. Leśna 15, 02-123 Kraków", 40.0, 80.0, new BigDecimal("200000.00"));
        Dzialka dzialka3 = new Dzialka("ul. Rzeczna 7, 03-234 Gdańsk", 45.0, 90.0, new BigDecimal("220000.00"));
        Dzialka dzialka4 = new Dzialka("ul. Górska 20, 04-567 Wrocław", 60.0, 110.0, new BigDecimal("280000.00"));
        Dzialka dzialka5 = new Dzialka("ul. Górska 25, 04-567 Wrocław", 60.0, 110.0, new BigDecimal("300000.00"));

        DomJednorodzinny dom1 = new DomJednorodzinny("ul. Słoneczna 10, 00-001 Warszawa", 4, 5, new BigDecimal("150.00"), true, true, dzialka1, new BigDecimal("500000.00"));
        DomJednorodzinny dom2 = new DomJednorodzinny("ul. Leśna 15, 02-123 Kraków", 1, 4, new BigDecimal("120.00"), false, true, dzialka2, new BigDecimal("450000.00"));

        Mieszkanie mieszkanie1 = new Mieszkanie("ul. Miejska 5, 00-123 Warszawa", new BigDecimal("80.00"), 3, 1, false, true, new BigDecimal("350000.00"));
        Mieszkanie mieszkanie2 = new Mieszkanie("ul. Widokowa 8, 02-345 Kraków", new BigDecimal("95.00"), 4, 2, true, false, new BigDecimal("420000.00"));
        Mieszkanie mieszkanie3 = new Mieszkanie("ul. Stawna 2, 03-456 Wrocław", new BigDecimal("60.00"), 2, 0, false, true, new BigDecimal("280000.00"));

        Magazyn magazyn1 = new Magazyn("ul. Rzeczna 7, 03-234 Gdańsk", 1, true, new BigDecimal("500.00"), dzialka3, new BigDecimal("650000.00"));

        List<INieruchomosc> wszystkieNieruchomosci = new ArrayList<>();
        wszystkieNieruchomosci.addAll(Dzialka.getEkstensja());
        wszystkieNieruchomosci.addAll(DomJednorodzinny.getEkstensja());
        wszystkieNieruchomosci.addAll(Mieszkanie.getEkstensja());
        wszystkieNieruchomosci.addAll(Magazyn.getEkstensja());

        List<IBudynek> wszystkieBudynki = new ArrayList<>();
        wszystkieBudynki.addAll(DomJednorodzinny.getEkstensja());
        wszystkieBudynki.addAll(Mieszkanie.getEkstensja());
        wszystkieBudynki.addAll(Magazyn.getEkstensja());


        System.out.println("Najdrozsza nieruchomosc: " + INieruchomosc.NajdrozszaNieruchomosc(wszystkieNieruchomosci));

        System.out.println("Nieruchomosci drozsze niz n " + INieruchomosc.nieruchomosciDrozszeNiz(wszystkieNieruchomosci, new BigDecimal("400000.00")));

        System.out.println("Najwyzszy budenek: " + IBudynek.najwyzszyBudynek(wszystkieBudynki));

        System.out.println("Najwieksza dzialka bez budynku: " + IGrunt.najwiekszyGruntBezBudynku(Dzialka.getEkstensja()));

        System.out.println("Obliczanie podatku: " + dom1.obliczPodatekNieruchomosci());


    }
}
