package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Dziecko extends Osoba{
    private List<Uwaga> uwagi = new ArrayList<>();
    private Grupa grupa;

    public static List<Dziecko> ekstensja = new ArrayList<>();

    public Dziecko(String imie, String nazwisko, String dataUrodzenia) {
        super(imie, nazwisko, dataUrodzenia);
    }

    public void dodajDoGrupy(Grupa grupa) {
        this.grupa = grupa;
    }

    public void dodajOdznake(String nazwa, String opis, String dataWystawienia){
        Odznaka odznaka = new Odznaka(nazwa, opis, dataWystawienia, this);
        uwagi.add(odznaka);
        Uwaga.getEkstensja().add(odznaka);
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

    public void dodajPrzewinienie(String nazwa, String opis, String dataWystawienia){
        Przewinienie przewinienie = new Przewinienie(nazwa, opis, dataWystawienia, this);
        uwagi.add(przewinienie);
        Uwaga.getEkstensja().add(przewinienie);
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

    public boolean czyPosluszne(){
        if (getPrzewinienia().size() > getOdznaki().size()){
            return false;
        }
        return true;
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
        this.grupa = grupa;
    }

    public static List<Dziecko> getEkstensjaDziecko() {
        return ekstensja;
    }

}
