package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

import java.time.LocalDate;

public abstract class Pracownik extends Osoba implements PracownikInt, CzytelnikInt{
    private LocalDate dataRozpoczeciaPracy;
    private double wyplata;
    private Biblioteka biblioteka;

    public Pracownik(String imie, String nazwisko, LocalDate dataRozpoczeciaPracy, double wyplata) {
        super(imie, nazwisko);
        this.dataRozpoczeciaPracy = dataRozpoczeciaPracy;
        this.wyplata = wyplata;
    }

    public LocalDate getDataRozpoczeciaPracy() {
        return dataRozpoczeciaPracy;
    }

    public void setDataRozpoczeciaPracy(LocalDate dataRozpoczeciaPracy) {
        this.dataRozpoczeciaPracy = dataRozpoczeciaPracy;
    }

    public double getWyplata() {
        return wyplata;
    }

    public void setWyplata(double wyplata) {
        this.wyplata = wyplata;
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }

    public void setBiblioteka(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
    }


    @Override
    public boolean czyMaZalegleKsiazki() {
        return false;
    }

    @Override
    public void zglosNieoddanieKsiazki(Ksiazka ksiazka, Czytelnik czytelnik) {

    }
}
