package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteka {
    private final String nazwa;
    private final LocalDate dataZalozenia;
    private double stawkaZaJedenDzienWypozyczenia;
    private Integer ulgaPracownicza;

    private List<Ksiazka> ksiazki = new ArrayList<>();
    private List<Czytelnik> czytelnicy = new ArrayList<>();
    private List<dalsze.podstawy.interfejsy.dodatkowe.Biblioteka.Pracownik> pracownicy = new ArrayList<>();

    public static List<Biblioteka> ekstensja = new ArrayList<>();

    public Biblioteka(String nazwa, LocalDate dataZalozenia, double stawkaZaJedenDzienWypozyczenia, Integer ulgaPracownicza) {
        this.nazwa = nazwa;
        this.dataZalozenia = dataZalozenia;
        this.stawkaZaJedenDzienWypozyczenia = stawkaZaJedenDzienWypozyczenia;
        this.ulgaPracownicza = ulgaPracownicza;

        ekstensja.add(this);
    }

    public void dodajKsiazke(Ksiazka ksiazka) {
        for (int i = 0; i < ksiazka.getIlosc(); i++) {
            ksiazki.add(ksiazka);
        }
    }

    public void dodajCzytelnika(Czytelnik czytelnik) {
        czytelnicy.add(czytelnik);
        czytelnik.getBiblioteki().add(this);
    }

    public void dodajPracownika(dalsze.podstawy.interfejsy.dodatkowe.Biblioteka.Pracownik pracownik){
        pracownicy.add(pracownik);
        pracownik.setBiblioteka(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public LocalDate getDataZalozenia() {
        return dataZalozenia;
    }

    public double getStawkaZaJedenDzienWypozyczenia() {
        return stawkaZaJedenDzienWypozyczenia;
    }

    public void setStawkaZaJedenDzienWypozyczenia(double stawkaZaJedenDzienWypozyczenia) {
        this.stawkaZaJedenDzienWypozyczenia = stawkaZaJedenDzienWypozyczenia;
    }

    public Integer getUlgaPracownicza() {
        return ulgaPracownicza;
    }

    public void setUlgaPracownicza(Integer ulgaPracownicza) {
        this.ulgaPracownicza = ulgaPracownicza;
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    public List<Czytelnik> getCzytelnicy() {
        return czytelnicy;
    }

    public void setCzytelnicy(List<Czytelnik> czytelnicy) {
        this.czytelnicy = czytelnicy;
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    @Override
    public String toString() {
        return nazwa + " " + dataZalozenia;
    }
}
