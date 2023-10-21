package dalsze.podstawy.interfejsy.zbiornik;

import java.util.ArrayList;
import java.util.List;

public interface IZbiornik {
    void dolej(double ilosc);
    void odlej(double ilosc);
    void przelej(Zbiornik zbiornik, double ilosc);

    static Zbiornik zNajwiekszaIlosciaWody(List<Zbiornik> zbiorniki) {
        if (zbiorniki == null || zbiorniki.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta");
        }

        Zbiornik max = zbiorniki.get(0);

        for (Zbiornik zbiornik : zbiorniki) {
            if (zbiornik.getStan() > max.getStan()) {
                max = zbiornik;
            }
        }

        return max;
    }

    static Zbiornik najbardziejZapelniony(List<Zbiornik> zbiorniki) {
        if (zbiorniki == null || zbiorniki.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta");
        }

        Zbiornik max = zbiorniki.get(0);

        for (Zbiornik zbiornik : zbiorniki) {
            if (zbiornik.getStan() / zbiornik.getPojemnosc() > max.getStan() / max.getPojemnosc() && zbiornik.getStan() != 0) {
                max = zbiornik;
            }
        }

        return max;
    }

    static List<Zbiornik> pusteZbiorniki(List<Zbiornik> zbiorniki) {
        if (zbiorniki == null) {
            throw new IllegalArgumentException("Lista jest pusta");
        }

        List<Zbiornik> pusteZbiorniki = new ArrayList<>();

        for (Zbiornik zbiornik : zbiorniki) {
            if (zbiornik.getStan() == 0) {
                pusteZbiorniki.add(zbiornik);
            }
        }

        return pusteZbiorniki;
    }

    static Zbiornik najwiecejZlychOperacji(List<Zbiornik> zbiorniki) {
        if (zbiorniki == null || zbiorniki.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta");
        }

        Zbiornik max = zbiorniki.get(0);

        for (Zbiornik zbiornik : zbiorniki) {
            if (zbiornik.getIloscZlychOperacji() > max.getIloscZlychOperacji()) {
                max = zbiornik;
            }
        }

        return max;
    }

    static Zbiornik najwiecejOperacjiDanegoTypu(List<Zbiornik> zbiorniki, TypOperacji typOperacji) {
        if (zbiorniki == null || zbiorniki.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta");
        }

        Zbiornik max = zbiorniki.get(0);

        for (Zbiornik zbiornik : zbiorniki) {
            if (zbiornik.getIloscOperacjiDanegoTypu(typOperacji) > max.getIloscOperacjiDanegoTypu(typOperacji)) {
                max = zbiornik;
            }
        }

        return max;
    }
}
