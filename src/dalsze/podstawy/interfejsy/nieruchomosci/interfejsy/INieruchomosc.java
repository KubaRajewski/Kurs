package dalsze.podstawy.interfejsy.nieruchomosci.interfejsy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface INieruchomosc {
    String getAdres();
    BigDecimal obliczCeneNieruchomosci();
    BigDecimal PODATEK = new BigDecimal("0.05");

    default BigDecimal obliczPodatekNieruchomosci() {
        return obliczCeneNieruchomosci().multiply(PODATEK);
    }

    static INieruchomosc NajdrozszaNieruchomosc(List<INieruchomosc> nieruchomosci) {
        if (nieruchomosci == null || nieruchomosci.isEmpty()) {
            throw new IllegalArgumentException();
        }

        INieruchomosc max = nieruchomosci.get(0);

        for (INieruchomosc n : nieruchomosci) {
            if (n.obliczCeneNieruchomosci().compareTo(max.obliczCeneNieruchomosci()) > 0) {
                max = n;
            }
        }

        return max;
    }

    static List<INieruchomosc> nieruchomosciDrozszeNiz(List<INieruchomosc> nieruchomosci, BigDecimal cena) {
        if (nieruchomosci == null) {
            throw new IllegalArgumentException();
        }

        List<INieruchomosc> nieruchomosciDrozszeNiz = new ArrayList<>();

        for (INieruchomosc n : nieruchomosci) {
            if (n.obliczCeneNieruchomosci().compareTo(cena) < 0) {
                nieruchomosciDrozszeNiz.add(n);
            }
        }

        return nieruchomosciDrozszeNiz;
    }
}
