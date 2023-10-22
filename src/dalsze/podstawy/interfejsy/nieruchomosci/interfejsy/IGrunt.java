package dalsze.podstawy.interfejsy.nieruchomosci.interfejsy;

import dalsze.podstawy.interfejsy.nieruchomosci.klasy.Dzialka;

import java.util.List;

public interface IGrunt extends INieruchomosc {
    double obliczPowierzchnieGruntu();
    IBudynek getBudynek();

    static IGrunt najwiekszyGrunt(List<Dzialka> dzialki) {
        if (dzialki == null || dzialki.isEmpty()) {
            throw new IllegalArgumentException();
        }

        IGrunt max = dzialki.get(0);

        for (IGrunt grunt : dzialki) {
            if (grunt.obliczPowierzchnieGruntu() > max.obliczPowierzchnieGruntu()) {
                max = grunt;
            }
        }

        return max;
    }

    static IGrunt najwiekszyGruntBezBudynku(List<Dzialka> dzialki) {
        if (dzialki == null || dzialki.isEmpty()) {
            throw new IllegalArgumentException();
        }

        IGrunt max = dzialki.get(0);

        for (IGrunt grunt : dzialki) {
            if (grunt.getBudynek() == null && grunt.obliczPowierzchnieGruntu() > max.obliczPowierzchnieGruntu()) {
                max = grunt;
            }
        }

        return max;
    }
}
