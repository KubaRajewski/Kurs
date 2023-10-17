package dalsze.podstawy.interfejsy;

import dalsze.podstawy.interfejsy.wstep.Samochod;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        List<String> lista2 = new LinkedList<>();

        Samochod s1 = new Samochod("a", "b", 100);
        System.out.println(Samochod.LICZBA_KOL);
        System.out.println(s1.getLiczbaKol());

        s1.hamuj();
        s1.przyspiesz();

        s1.zwiekszMoc(5);

        System.out.println(s1.getMoc());


        /*
         * Stworz hieararchie dziedziczenia interfejsow tak aby mialy biznesowy sens. Stworz sensowne biznesowe klasy ktore moga je implementowac
         * (niekoniecznie kazda klasa kazdy interfejs). Niech interefejsy maja rozne metody statyczne, defaultowe, abstrakcyjne, tak aby calosc
         * tworzyła wspolna sensowna całosc :)
         */
    }
}
