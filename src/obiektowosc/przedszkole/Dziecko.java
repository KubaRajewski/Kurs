package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Dziecko extends Osoba {
    private Grupa grupa;
    private List<Uwaga> uwagi = new ArrayList<>();

    public static List<Dziecko> ekstensja = new ArrayList<>();

    public Dziecko(String imie, String nazwisko, String dataUrodzenia) {
        super(imie, nazwisko, dataUrodzenia);

        ekstensja.add(this);
    }

    public void dodajOdznake(String nazwa, String opis, String dataWystawienia){
        Odznaka odznaka = new Odznaka(nazwa, opis, dataWystawienia, this);
        uwagi.add(odznaka);
        Uwaga.getEkstensja().add(odznaka);
    }

    public void dodajPrzewinienie(String nazwa, String opis, String dataWystawienia){
        Przewinienie przewinienie = new Przewinienie(nazwa, opis, dataWystawienia, this);
        uwagi.add(przewinienie);
        Uwaga.getEkstensja().add(przewinienie);
    }

    public boolean czyPosluszne(){
        return getPrzewinienia().size() <= getOdznaki().size();
    }

    // TODO  * - napisz metode która zwraca dziecko ktore ma najwiecej przewinien
    public static Dziecko najmniejPosluszne() {
        Dziecko najmniejPosluszne = null;
        int najwiecejPrzewinien = 0;

        for (Dziecko d : ekstensja) {
            if (!d.czyPosluszne()) {
                int iloscPrzewinien = d.getPrzewinienia().size();
                if (iloscPrzewinien > najwiecejPrzewinien) {
                    najwiecejPrzewinien = iloscPrzewinien;
                    najmniejPosluszne = d;
                }
            }
        }

        return najmniejPosluszne;
    }

    public List<Uwaga> getUwagi() {
        return uwagi;
    }

    public void setUwagi(List<Uwaga> uwagi) {
        this.uwagi = uwagi;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        if (this.grupa == null){
            this.grupa = grupa;
        } else {
            System.out.println("Dziecko juz jest w innej grupie");
        }
    }

    public List<Przewinienie> getPrzewinienia(){
        List<Przewinienie> przewinienia = new ArrayList<>();
        for(Uwaga uwaga : uwagi){
            if(uwaga instanceof Przewinienie){
                przewinienia.add((Przewinienie) uwaga);
            }
        }
        return przewinienia;
    }

    public List<Odznaka> getOdznaki(){
        List<Odznaka> odznaki = new ArrayList<>();
        for(Uwaga uwaga : uwagi){
            if(uwaga instanceof Odznaka){
                odznaki.add((Odznaka) uwaga);
            }
        }
        return odznaki;
    }

    public static List<Dziecko> getEkstensjaDziecko() {
        return ekstensja;
    }
}
