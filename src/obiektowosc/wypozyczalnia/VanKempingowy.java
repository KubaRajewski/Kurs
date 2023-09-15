package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class VanKempingowy extends Van {
    private static List<VanKempingowy> ekstensja = new ArrayList<>();
    private int iloscMiejscDoSpania;

    public VanKempingowy(String numerRejestracyjny, String marka, String model, int rokProdukcji, int pojemnoscBaku, boolean dostepnosc, int cenaWypozyczenia, int dlugoscBagaznika, int iloscMiejscDoSpania) {
        super(numerRejestracyjny, marka, model, rokProdukcji, pojemnoscBaku, dostepnosc, cenaWypozyczenia, dlugoscBagaznika);
        this.iloscMiejscDoSpania = iloscMiejscDoSpania;

        ekstensja.add(this);
    }

    public int getIloscMiejscDoSpania() {
        return iloscMiejscDoSpania;
    }

    public void setIloscMiejscDoSpania(int iloscMiejscDoSpania) {
        this.iloscMiejscDoSpania = iloscMiejscDoSpania;
    }
}
