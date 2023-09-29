package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

import java.time.LocalDate;
import java.util.List;

public class Pracownik extends Osoba implements PracownikInt, CzytelnikInt{
    private LocalDate dataRozpoczeciaPracy;
    private double wyplata;

    public Pracownik(String imie, String nazwisko, List<Ksiazka> wypozyczoneKsiazki, LocalDate dataRozpoczeciaPracy, double wyplata) {
        super(imie, nazwisko, wypozyczoneKsiazki);
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

    @Override
    public void wypozycz(Ksiazka ksiazka) {

    }

    @Override
    public void zwroc(Ksiazka ksiazka) {

    }

    @Override
    public boolean czyMaZalegleKsiazki() {
        return false;
    }

    @Override
    public void zglosNieoddanieKsiazki(Ksiazka ksiazka, Czytelnik czytelnik) {

    }
}
