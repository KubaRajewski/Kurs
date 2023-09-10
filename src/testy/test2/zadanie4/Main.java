package testy.test2.zadanie4;

//    Zadanie 04
//    a) Napisz kod w taki sposób aby poniższy fragment zadziałał i dał dokładnie taki wynik jak oczekuje:
//
//    Figura[] figury = {Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10,20)};
//    for(Figura f : figury {
//    System.out.println(f);
//    }
//    System.out powinien wypisac:
//    Figura nr 1: Kwadrat o boku 10.
//    Figura nr 2: Koło o promienu 10.
//    Figura nr 3: Prostokat o bokach 10x20.
//
//    b) Następnie:
//    - znajdź figurę z największym obwodem
//    - znajdź figurę z największym polem
//
//    c) System.out.println(figuryPunktA.contains(new Kwadrat(10)); // powinno wypisc true
//
//    UWAGA: tylko figury tworzone metodą fabryczną powinny mieć nadawany sekwencyjnie numer, w przypadku gdy uzywamy konstruktora to kazda
//    figura ma numer 0.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Figura[] figury = {Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10, 20)};

        for (Figura f : figury) {
            System.out.println(f);
        }

        Figura figuraZNajwiekszymObwodem = Figura.znajdzNajwiekszyObwod(figury);
        Figura figuraZNajwiekszymPolem = Figura.znajdzNajwiekszePole(figury);

        System.out.println("\nFigura z największym obwodem: " + figuraZNajwiekszymObwodem + ", Obwod: " + figuraZNajwiekszymObwodem.obwod());
        System.out.println("Figura z największym polem: " + figuraZNajwiekszymPolem + ", Pole: " + figuraZNajwiekszymPolem.pole() + "\n");

        List<Figura> figuryCopy = new ArrayList<>();
        for (int i = 0; i < figury.length; i++) {
            figuryCopy.add(figury[i]);
        }

        System.out.println(figuryCopy.contains(new Kwadrat(10)));
    }
}
