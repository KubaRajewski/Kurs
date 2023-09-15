package obiektowosc.szkola;

public class Ocena {
    private final int wartosc;
    private final String dataWystawienia;
    private final Uczen uczen;
    private final Sprawdzian sprawdzian;

    public Ocena(int wartosc, String dataWystawienia, Uczen uczen, Sprawdzian sprawdzian) {

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

    public String getDataWystawienia() {
        return dataWystawienia;
    }

    public Uczen getUczen() {
        return uczen;
    }

    public Sprawdzian getSprawdzian() {
        return sprawdzian;
    }

    @Override
    public String toString() {
        return "Ocena: " + wartosc + " Sprawdzian: " + sprawdzian;
    }
}
