package obiektowosc.podstawy.szkola;

import java.util.ArrayList;
import java.util.List;

public class Nauczyciel extends Osoba {
    private String przedmiot;
    private List<Szkola> szkoly = new ArrayList<>();
    private List<Szkolenie> szkolenia = new ArrayList<>();

    private static List<Nauczyciel> ekstensja =  new ArrayList<>();

    public Nauczyciel(String imie, String nazwisko, String adres, String przedmiot) {
        super(imie, nazwisko, adres);
        this.przedmiot = przedmiot;
        this.szkolenia = new ArrayList<>();
        ekstensja.add(this);
    }

    public List<Szkolenie> getSzkolenia() {
        return szkolenia;
    }

    public void setSzkolenia(List<Szkolenie> szkolenia) {
        this.szkolenia = szkolenia;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public List<Szkola> getSzkoly() {
        return szkoly;
    }

    public void setSzkoly(List<Szkola> szkoly) {
        this.szkoly = szkoly;
    }


    public List<Nauczyciel> getEkstensja() {
        return ekstensja;
    }

    @Override
    public String toString() {
        return getImie() + " " +  getNazwisko() + " " +  getPrzedmiot();
    }

    @Override
    public double obliczDochod() {
        return 1000;
    }
}
