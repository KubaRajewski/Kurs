package dalsze.podstawy.interfejsy.figury;

import java.util.ArrayList;
import java.util.List;

public interface Figura {


    double obliczPole();

    double obliczObwod();

    static Figura najwiekszePole(List<Figura> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Figura max = list.get(0);

        for (Figura figura : list) {
            if (figura.obliczPole() > max.obliczPole()) {
                max = figura;
            }
        }

        return max;
    }

    static Figura najwiekszyObwod(List<Figura> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Figura max = list.get(0);

        for (Figura figura : list) {
            if (figura.obliczObwod() > max.obliczObwod()) {
                max = figura;
            }
        }

        return max;
    }

    static List<Figura> figuryZPolemWiekszymNiz(List<Figura> list, int n) {
        if (list == null) {
            throw new IllegalArgumentException();
        }

        List<Figura> figuryZPolemWiekszymNiz = new ArrayList<>();

        for (Figura figura : list) {
            if (figura.obliczPole() > n) {
                figuryZPolemWiekszymNiz.add(figura);
            }
        }

        return figuryZPolemWiekszymNiz;
    }
}
