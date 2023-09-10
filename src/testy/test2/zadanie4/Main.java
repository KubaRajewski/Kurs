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
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Figura[] figury = {Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10, 20)};

        for (Figura f : figury) {
            System.out.println(f);
        }

        System.out.println("\nFigura z największym obwodem: " + Figura.znajdzNajwiekszyObwod(figury) + ", Obwod: " + Figura.znajdzNajwiekszyObwod(figury).obwod());
        System.out.println("Figura z największym polem: " + Figura.znajdzNajwiekszePole(figury) + ", Pole: " + Figura.znajdzNajwiekszePole(figury).pole() + "\n");

        //Tutaj musialem zamienic tablice na liste zeby moc uzyc metody contains
        List<Figura> figuryAsList = new ArrayList<>(Arrays.asList(figury));

        System.out.println(figuryAsList.contains(new Kwadrat(10)));
    }
}
