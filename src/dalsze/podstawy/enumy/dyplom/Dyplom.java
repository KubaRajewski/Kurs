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

    public static Dyplom dyplomZNajwiekszaSrednia(List<Dyplom> dyplomy) {
        if (dyplomy == null || dyplomy.isEmpty()) {
            throw new IllegalArgumentException("Brak dyplomow");
        }
        Dyplom najlepszyDyplom = dyplomy.get(0);

        for (Dyplom dyplom : dyplomy) {
            if (dyplom.sredniaOcen() > najlepszyDyplom.sredniaOcen()) {
                najlepszyDyplom = dyplom;
            }
        }
        return najlepszyDyplom;
    }

    public double sredniaOcen() {
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