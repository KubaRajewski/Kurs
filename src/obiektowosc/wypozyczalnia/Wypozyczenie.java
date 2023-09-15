package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;

public class Wypozyczenie {
    private static List<Wypozyczenie> ekstensja = new ArrayList<>();
    private String dataOD;
    private String dataDO;
    private int koszt;
    private Pojazd pojazd;
    private Klient klient;
    private Pracownik pracownik;

    public Wypozyczenie(String dataOD, String dataDO, int koszt, Pojazd pojazd, Klient klient, Pracownik pracownik) {
        this.dataOD = dataOD;
        this.dataDO = dataDO;
        this.koszt = koszt;
        this.pojazd = pojazd;
        this.klient = klient;
        this.pracownik = pracownik;

        pojazd.getWypozyczenia().add(this);
        pracownik.getWypozyczenia().add(this);
        klient.getWypozyczenia().add(this);

        ekstensja.add(this);
    }

    public static List<Wypozyczenie> getEksstensja() {
        return ekstensja;
    }

    public static void setEksstensja(List<Wypozyczenie> eksstensja) {
        Wypozyczenie.ekstensja = eksstensja;
    }

    public String getDataOD() {
        return dataOD;
    }

    public void setDataOD(String dataOD) {
        this.dataOD = dataOD;
    }

    public String getDataDO() {
        return dataDO;
    }

    public void setDataDO(String dataDO) {
        this.dataDO = dataDO;
    }

    public int getKoszt() {
        return koszt;
    }

    public void setKoszt(int koszt) {
        this.koszt = koszt;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    @Override
    public String toString() {
        return pojazd + ", Klient: " + klient + ", Pracownik obslugujacy: " + pracownik + ", Od: " + dataOD + ", Do " + dataDO + ", Cena: " + koszt;
    }
}
