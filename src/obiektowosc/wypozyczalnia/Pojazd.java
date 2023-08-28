package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public abstract class Pojazd {
    private String numerRejestracyjny;
    private String marka;
    private String model;
    private int rokProdukcji;
    private int pojemnoscBaku;
    private boolean dostepnosc;
    private int cenaWypozyczenia; // cena za dobę

    private Silnik silnik;

    private static List<Pojazd> ekstensja = new ArrayList<>();

    public Pojazd(String numerRejestracyjny, String marka, String model, int rokProdukcji, int pojemnoscBaku, boolean dostepnosc, int cenaWypozyczenia) {
        if (numerRejestracyjny == null || numerRejestracyjny.isEmpty()) throw new IllegalArgumentException("Numer rejestracyjny nie może być pusty");
        if (ekstensja.contains(numerRejestracyjny)) throw new IllegalArgumentException("Pojazd o podanym numerze rejestracyjnym już istnieje");

        this.numerRejestracyjny = numerRejestracyjny;
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscBaku = pojemnoscBaku;
        this.dostepnosc = dostepnosc;
        this.cenaWypozyczenia = cenaWypozyczenia;

        ekstensja.add(this);
    }

    public void dodajSilnik(Silnik silnik) {
        this.silnik = silnik;
        silnik.getPojazdyZDanymSilnikiem().add(this);
    }

    public static List<Pojazd> pojazdyMocniejszeNiz(List<Pojazd> pojazdy, int mocMinimalna){
        List<Pojazd> mocniejszeNiz = new ArrayList<>();
        for (Pojazd p : pojazdy) {
            if(p.getSilnik().getMoc() > mocMinimalna){
                mocniejszeNiz.add(p);
            }
        }
        return mocniejszeNiz;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public int getPojemnoscBaku() {
        return pojemnoscBaku;
    }

    public void setPojemnoscBaku(int pojemnoscBaku) {
        this.pojemnoscBaku = pojemnoscBaku;
    }

    public boolean isDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(boolean dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    public int getCenaWypozyczenia() {
        return cenaWypozyczenia;
    }

    public void setCenaWypozyczenia(int cenaWypozyczenia) {
        this.cenaWypozyczenia = cenaWypozyczenia;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public static List<Pojazd> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Pojazd> ekstensja) {
        Pojazd.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        if (dostepnosc) {
            return marka + " " + model + " " + numerRejestracyjny + " - Dostępny";
        }
        return marka + " " + model +  " " + numerRejestracyjny + " - Niedostępny";
    }
}
