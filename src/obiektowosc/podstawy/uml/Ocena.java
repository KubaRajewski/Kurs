package obiektowosc.podstawy.uml;

import java.time.LocalDate;

public class Ocena {
    private final int wartosc;
    private final LocalDate dataWystawienia;
    private final Uczen uczen;
    private final Sprawdzian sprawdzian;

    public Ocena(int wartosc, LocalDate dataWystawienia, Uczen uczen, Sprawdzian sprawdzian) {

        if (uczen == null || sprawdzian == null)
            throw new IllegalArgumentException("uczen lub sprawdzian nie istnieja!");

        this.wartosc = wartosc;
        this.dataWystawienia = dataWystawienia;
        this.uczen = uczen;
        this.sprawdzian = sprawdzian;

        // informacja zwrotna
        uczen.getOceny().add(this);
        sprawdzian.getOceny().add(this);
    }

    public int getWartosc() {
        return wartosc;
    }

    public LocalDate getDataWystawienia() {
        return dataWystawienia;
    }

    public Uczen getUczen() {
        return uczen;
    }

    public Sprawdzian getSprawdzian() {
        return sprawdzian;
    }
}
