package dalsze.podstawy.interfejsy.zbiornik;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Operacja {
    private final Zbiornik zbiornik;
    private final TypOperacji typOperacji;
    private final String nazwa;
    private final LocalDateTime data;
    private final double ilosc;
    private final boolean czyPowiodloSie;

    private static List<Operacja> ekstensja = new ArrayList<>();

    public Operacja(TypOperacji typOperacji, String nazwa, Zbiornik zbiornik, double ilosc, boolean czyPowiodloSie) {
        this.typOperacji = typOperacji;
        this.nazwa = nazwa;
        this.data = LocalDateTime.now();
        this.zbiornik = zbiornik;
        this.ilosc = ilosc;
        this.czyPowiodloSie = czyPowiodloSie;

        ekstensja.add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Zbiornik getZbiornik() {
        return zbiornik;
    }

    public double getIlosc() {
        return ilosc;
    }

    public boolean isCzyPowiodloSie() {
        return czyPowiodloSie;
    }

    public TypOperacji getTypOperacji() {
        return typOperacji;
    }

    public static List<Operacja> getEkstensja() {
        return new ArrayList<>(ekstensja);
    }

    @Override
    public String toString() {
        if (czyPowiodloSie) {
            return nazwa + ", powiodla sie";
        }
        return nazwa + ", nie powiodla sie";
    }
}
