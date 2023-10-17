package dalsze.podstawy.interfejsy.figury;

import java.util.ArrayList;
import java.util.List;

public class Kolo implements Figura {
    private double promien;

    public Kolo(double promien) {
        this.promien = promien;
    }

    @Override
    public double obliczPole() {
        return Math.PI * Math.pow(promien, 2);
    }

    @Override
    public double obliczObwod() {
        return 2 * Math.PI * promien;
    }

    public static List<Kolo> kolaZobwodemMniejszymNiz(List<Kolo> list, int n) {
        if (list == null) {
            throw new IllegalArgumentException();
        }

        List<Kolo> kolaZobwodemMniejszymNiz = new ArrayList<>();

        for (Kolo kolo : list) {
            if (kolo.obliczObwod() < n) {
                kolaZobwodemMniejszymNiz.add(kolo);
            }
        }

        return kolaZobwodemMniejszymNiz;
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    @Override
    public String toString() {
        return "Kolo{" +
                "promien=" + promien +
                '}';
    }
}

