package dalsze.podstawy.interfejsy.wstep;

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
    }
}
