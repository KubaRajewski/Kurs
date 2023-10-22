package dalsze.podstawy.interfejsy.nieruchomosci.interfejsy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface IBudynek extends INieruchomosc {
    int getLiczbaPieter();
    BigDecimal powierzchnia();
    boolean getCzyJestGaraz();

    static IBudynek najwyzszyBudynek(List<IBudynek> budynki) {
        if (budynki == null || budynki.isEmpty()) {
            throw new IllegalArgumentException();
        }

        IBudynek max = budynki.get(0);

        for (IBudynek budynek : budynki) {
            if (budynek.getLiczbaPieter() > max.getLiczbaPieter()) {
                max = budynek;
            }
        }

        return max;
    }

    static IBudynek najwiekszyBudynek(List<IBudynek> budynki) {
        if (budynki == null || budynki.isEmpty()) {
            throw new IllegalArgumentException();
        }

        IBudynek max = budynki.get(0);

        for (IBudynek budynek : budynki) {
            if (budynek.powierzchnia().compareTo(max.powierzchnia()) > 0) {
                max = budynek;
            }
        }

        return max;
    }

    static List<IBudynek> budynkiZGarazem(List<IBudynek> budynki) {
        if (budynki == null) {
            throw new IllegalArgumentException();
        }

        List<IBudynek> budynkiZGarazem = new ArrayList<>();

        for (IBudynek budynek : budynki) {
            if (budynek.getCzyJestGaraz()) {
                budynkiZGarazem.add(budynek);
            }
        }

        return budynkiZGarazem;
    }
}
