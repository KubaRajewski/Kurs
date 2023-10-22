package dalsze.podstawy.interfejsy.nieruchomosci.interfejsy;

import java.util.List;

public interface iBudynekMieszkalny extends IBudynek{
    int getLiczbaPokoi();

    static iBudynekMieszkalny budynekNajwiecejPokoi(List<iBudynekMieszkalny> budynkiMieszkalne) {
        if (budynkiMieszkalne == null || budynkiMieszkalne.isEmpty()) {
            throw new IllegalArgumentException();
        }

        iBudynekMieszkalny max = budynkiMieszkalne.get(0);

        for (iBudynekMieszkalny bM : budynkiMieszkalne) {
            if (bM.getLiczbaPokoi() > max.getLiczbaPokoi()) {
                max = bM;
            }
        }

        return max;
    }
}
