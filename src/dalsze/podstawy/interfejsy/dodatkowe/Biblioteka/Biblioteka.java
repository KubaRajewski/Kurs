package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

import obiektowosc.zadania.drugie.Pracownik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteka {
    private String nazwa;
    private LocalDate dataZalozenia;
    private double stawkaZaJedenDzienWypozyczenia;
    private Integer ulgaPracownicza;

    private List<Ksiazka> ksiazki = new ArrayList<>();
    private List<Czytelnik> czytelnicy = new ArrayList<>();
    private List<Pracownik> pracownicy = new ArrayList<>();

    public Biblioteka(String nazwa, LocalDate dataZalozenia, double stawkaZaJedenDzienWypozyczenia, Integer ulgaPracownicza, List<Ksiazka> ksiazki, List<Czytelnik> czytelnicy, List<Pracownik> pracownicy) {
        this.nazwa = nazwa;
        this.dataZalozenia = dataZalozenia;
        this.stawkaZaJedenDzienWypozyczenia = stawkaZaJedenDzienWypozyczenia;
        this.ulgaPracownicza = ulgaPracownicza;
        this.ksiazki = ksiazki;
        this.czytelnicy = czytelnicy;
        this.pracownicy = pracownicy;
    }
}
