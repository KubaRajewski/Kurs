package dalsze.podstawy.enumy.dyplom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dyplom {
    private String imie;
    private String nazwisko;
    private Date dataWystawienia;
    private List<Ocena> oceny;

    public static List<Dyplom> ekstensja = new ArrayList<>();

    public Dyplom(String imie, String nazwisko, Date dataWystawienia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataWystawienia = dataWystawienia;
        this.oceny = new ArrayList<>();

        ekstensja.add(this);
    }

    public void dodajOcene(Ocena ocena) {
        oceny.add(ocena);
    }

    public static Dyplom dyplomZNajwiekszaSrednia(List<Dyplom> dyplomy) {
        if (dyplomy == null) {
            throw new IllegalArgumentException("Brak dyplomow");
        }
        Dyplom najlepszyDyplom = dyplomy.get(0);
        double najlepszaSrednia = najlepszyDyplom.sredniaOcen();

        for (Dyplom dyplom : dyplomy) {
            double srednia = dyplom.sredniaOcen();
            if (srednia > najlepszaSrednia) {
                najlepszyDyplom = dyplom;
                najlepszaSrednia = srednia;
            }
        }
        return najlepszyDyplom;
    }

    public double sredniaOcen() {
        if (oceny.isEmpty()) {
            return 0.0;
        }
        double sumaOcen = 0;
        for (Ocena ocena : oceny) {
            sumaOcen += ocena.getOcena().getWartosc();
        }
        return sumaOcen / oceny.size();
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getDataWystawienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(Date dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public List<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(List<Ocena> oceny) {
        this.oceny = oceny;
    }

    public static List<Dyplom> getEkstensja() {
        return ekstensja;
    }

    @Override
    public String toString() {
        return "Dyplom{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataWystawienia=" + dataWystawienia +
                ", oceny=" + oceny +
                '}';
    }
}