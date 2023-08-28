package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class SamochodOsobowy extends Pojazd{

    private int liczbaMiejsc;
    private String rodzajNadwozia;
    private int liczbaDrzwi;
    private int pojemnoscBagaznika;

    private static List<SamochodOsobowy> ekstensja = new ArrayList<>();

    public SamochodOsobowy(String numerRejestracyjny, String marka, String model, int rokProdukcji, int pojemnoscBaku, boolean dostepnosc, int cenaWypozyczenia, int liczbaMiejsc, String rodzajNadwozia, int liczbaDrzwi, int pojemnoscBagaznika) {
        super(numerRejestracyjny, marka, model, rokProdukcji, pojemnoscBaku, dostepnosc, cenaWypozyczenia);
        this.liczbaMiejsc = liczbaMiejsc;
        this.rodzajNadwozia = rodzajNadwozia;
        this.liczbaDrzwi = liczbaDrzwi;
        this.pojemnoscBagaznika = pojemnoscBagaznika;

        ekstensja.add(this);
    }

    public int getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public void setLiczbaMiejsc(int liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public String getRodzajNadwozia() {
        return rodzajNadwozia;
    }

    public void setRodzajNadwozia(String rodzajNadwozia) {
        this.rodzajNadwozia = rodzajNadwozia;
    }

    public int getLiczbaDrzwi() {
        return liczbaDrzwi;
    }

    public void setLiczbaDrzwi(int liczbaDrzwi) {
        this.liczbaDrzwi = liczbaDrzwi;
    }

    public int getPojemnoscBagaznika() {
        return pojemnoscBagaznika;
    }

    public void setPojemnoscBagaznika(int pojemnoscBagaznika) {
        this.pojemnoscBagaznika = pojemnoscBagaznika;
    }
}
