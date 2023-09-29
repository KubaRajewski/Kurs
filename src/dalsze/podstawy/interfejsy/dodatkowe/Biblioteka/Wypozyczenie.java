package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Wypozyczenie {
    private final Czytelnik czytelnik;
    private List<Ksiazka> ksiazki = new ArrayList<>();
    private final LocalDate dataWypozyczenia;

    public Wypozyczenie(Czytelnik czytelnik, List<Ksiazka> ksiazki, LocalDate dataWypozyczenia) {
        this.czytelnik = czytelnik;
        this.ksiazki = ksiazki;
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public LocalDate getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    @Override
    public String toString() {
        return "Wypozyczenie{" +
                "czytelnik=" + czytelnik +
                ", ksiazki=" + ksiazki +
                ", dataWypozyczenia=" + dataWypozyczenia +
                '}';
    }
}
