package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class Pracownik extends Osoba{
    public int pensja;
    public String rodzajUmowy;

    private List<Szkolenie> szkolenia = new ArrayList<>();

    private static List<Pracownik> ekstensja = new ArrayList<>();

    public Pracownik(String imie, String nazwisko, String adres, String numerDowodu, int pensja, String rodzajUmowy) {
        super(imie, nazwisko, adres, numerDowodu);
        this.pensja = pensja;
        this.rodzajUmowy = rodzajUmowy;

        ekstensja.add(this);
    }

    public static List<Pracownik> zarabiajacyWiecejNiz(List<Pracownik> pracownicy, int minPensja){
        List<Pracownik> zarabiajacyWiecejNiz = new ArrayList<>();
        for (Pracownik p : pracownicy) {
            if (p.getPensja() > minPensja) {
                zarabiajacyWiecejNiz.add(p);
            }
        }
        return zarabiajacyWiecejNiz;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public String getRodzajUmowy() {
        return rodzajUmowy;
    }

    public void setRodzajUmowy(String rodzajUmowy) {
        this.rodzajUmowy = rodzajUmowy;
    }

    public static List<Pracownik> getEkstensjaPracownik() {
        return ekstensja;
    }
}
