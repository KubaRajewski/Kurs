package dalsze.podstawy.wielkie.liczby;

import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // stale reprezentujace 0,1,2,10
        System.out.println(BigInteger.ZERO);
        System.out.println(BigInteger.ONE);
        System.out.println(BigInteger.TWO);
        System.out.println(BigInteger.TEN);

        // string zeby moglo wykraczac poza zakres intow longow
        BigInteger a = new BigInteger("17");
        BigInteger b = new BigInteger("5");


        // drugi sposob z metoda valueOf, tylko tutaj mamy max longa
        BigInteger wielkaLiczba = BigInteger.valueOf(123123);

        // dodawanie
        BigInteger suma = a.add(b);
        System.out.println("Suma " + suma);

        // odejmowanie
        BigInteger roznica = a.subtract(b);
        System.out.println("Roznica " + roznica);

        // mnozenie
        BigInteger iloczyn = a.multiply(b);
        System.out.println("Iloczyn " + iloczyn);

        // dzielenie
        BigInteger dzielenie = b.divide(a);
        System.out.println("Dzielenie " + dzielenie);



        // porownuje dwa BigInty
        // 1 jesli a > b
        // 0 jesli a = b
        // -1 jesli a < b

        System.out.println(a.compareTo(b));


        // zwraca wieksza z dwoch
        System.out.println("wieksza " + a.max(b));
        // mniejsza z dwoch
        System.out.println("mniejsza " + b.min(a));

        // reszta z dzielenia
        System.out.println("modulo " + a.mod(b));

        // wartosc bezwzgledna
        System.out.println(a.abs());

        // podnosi a do potegi int
        System.out.println(a.pow(4));

        // liczba przeciwna
        System.out.println(a.negate());

        // zwraca signum,
        // czyli 1 jesli > 0
        // 0 jesli =0
        // -1 jesli < 0
        System.out.println(a.signum());

        // pierwiastek

        System.out.println(a.sqrt());

        BigDecimal bd = new BigDecimal("-4.543");
        // laczna liczba cyfr
        System.out.println(bd.precision());

        // liczba cyfr na prawo od kropki
        System.out.println(bd.scale());

        // Stworz liste BigItnow, stworz pare obiektow BigInt, dodaj je do listy,
        // wyswietl w kolejnosci rosnacej
        List<BigInteger> bigIntegers = new ArrayList<>();

        bigIntegers.add(new BigInteger("5412341234333312341234"));
        bigIntegers.add(BigInteger.valueOf(1541));
        bigIntegers.add(BigInteger.valueOf(14541));
        bigIntegers.add(BigInteger.valueOf(123));
        bigIntegers.add(BigInteger.valueOf(451));
        Collections.sort(bigIntegers);

//        bigIntegers.sort(Comparator.comparing(BigInteger::intValue));
        System.out.println(bigIntegers);


        // Stwórz metode która znajduje najwieksza liczbe typu BigInt na liscie

        // Stworz metode ktora przyjmuje jako parametr liste bigitnow oraz dwa inty a i
        // b i zwroci liste wszystkich elementow z listy ktorych wartosc modulo a = b.
        // element listy=17, a = 5, b=2 17mod5 =2

        //napisz metode która zwroci wspolne elementy z dwoch list wielkich liczb

        // Stworz metode ktora przyjmuje jako parametr liste list big intow :). Z kazdej
        // listy znajdz najwieksza wartosc i oblicz sume najwiekszych wartosci.


        //		stworz sobie jakis plik z liczbami, 100 liczb stucyfrowych (roznych, losowych!)
//		Wczytaj te liczby z pliku i zapisz iloczyn tych liczb to pliku wynik.txt



        // Stworz krotki system bankowy oparty na klasie BigDecimal. Stworz klase Klient
        // i Konto. Klient moze miec wiele kont. Konto powinno miec metody
        // deposit(BigDecimal b) i withdraw(BigDecimal b). Przeprowadz symulacje
        // wplacania i wyplacania pieniedzy.
        // Dodaj swoje metody pozwalajace na ciekawe operacje na koncie np naliczenie
        // odsetek gdy stan konta jest ujemny, dodanie odsetek gdy ktos ma duzo pieniedzy itp
        // Znajdz konto ktore ma najwiecej hajsu
        // Znajdz konto ktore miało najwiecej transakcji
        // Znajdz znajdz wszystkie konta z ujemnym balansem

    }

    //napisz metode ktora przyjmuje jako parametr Liste BigIntow i zwraca Liste
    // liczb wiekszych od podanego parametru
    public static List<BigInteger> listaLiczbWiekszychNiz(List<BigInteger> lista, BigInteger liczba){
        List<BigInteger> listaLiczbWiekszychNiz = new ArrayList<>();

        for (BigInteger bigInteger : lista) {
            if (bigInteger.compareTo(liczba) > 0){
                listaLiczbWiekszychNiz.add(liczba);

            }
        }

        return listaLiczbWiekszychNiz;
    }

    // Stwórz metode która znajduje najwieksza liczbe typu BigInt na liscie

    public static BigInteger najwiekszLiczbaNaLiscie(List<BigInteger> lista){
        if (lista == null){
            throw new IllegalArgumentException("Lista jest pusta");
        }
        BigInteger najwiekszLiczbaNaLiscie = lista.get(0);

        for (BigInteger bigInteger : lista) {
            if (bigInteger.compareTo(najwiekszLiczbaNaLiscie) > 0){
                najwiekszLiczbaNaLiscie = bigInteger;
            }
        }

        return najwiekszLiczbaNaLiscie;
    }

}
