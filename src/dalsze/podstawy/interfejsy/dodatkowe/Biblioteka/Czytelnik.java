package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

import java.util.List;

public class Czytelnik extends Osoba implements CzytelnikInt{

    private List<Biblioteka> biblioteki;
    private List<Ksiazka> wypozyczoneKsiazki;


    public Czytelnik(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public List<Biblioteka> getBiblioteki() {
        return biblioteki;
    }

    public void setBiblioteki(List<Biblioteka> biblioteki) {
        this.biblioteki = biblioteki;
    }

    @Override
    public List<Ksiazka> getWypozyczoneKsiazki() {
        return wypozyczoneKsiazki;
    }

    @Override
    public void setWypozyczoneKsiazki(List<Ksiazka> wypozyczoneKsiazki) {
        this.wypozyczoneKsiazki = wypozyczoneKsiazki;
    }


    @Override
    public void wypozycz(Ksiazka ksiazka, Biblioteka biblioteka) {
        if (biblioteka.getKsiazki().contains(ksiazka)){
            biblioteka.getKsiazki().remove(ksiazka);
            this.wypozyczoneKsiazki.add(ksiazka);
        }
    }

    @Override
    public void zwroc(Ksiazka ksiazka, Biblioteka biblioteka) {
        if (this.wypozyczoneKsiazki.contains(ksiazka)){
            this.wypozyczoneKsiazki.remove(ksiazka);
            biblioteka.getKsiazki().add(ksiazka);
        }
    }

    @Override
    public boolean czyMaZalegleKsiazki() {
        return false;
    }
}
