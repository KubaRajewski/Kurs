package obiektowosc.podstawy.uml;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Szkola {
    // atrybuty
    public final int rokPowstania;
    public String nazwa;
    public String wyroznienie;
    public int numer;
    private static int MIN_LICZBA_UCZNIOW = 150;

    public List<String> profile = new ArrayList<>();

    // asocjacja licznosci * do klasy Uczen
    private List<Uczen> uczniowie = new ArrayList<>();

    // lista sal (kompozycja z sala)
    private List<Sala> sale = new ArrayList<>();

    public Szkola(int rokPowstania, String nazwa, String wyroznienie, int numer) {
        this.rokPowstania = rokPowstania;
        this.nazwa = nazwa;
        this.wyroznienie = wyroznienie;
        this.numer = numer; // zeby byl unikalny

    }

    // metoda tworzaca powiazanie (asocjacje)
    public void dodajUcznia(Uczen u) {
        // sprawdzamy czy uczen nie chodzi juz do innej szkoly
        if (u.getSzkola() != null) throw new IllegalArgumentException("Uczen ma jzu szkole");

        uczniowie.add(u);
        // informacja zwrotna
        u.setSzkola(this);
    }

    public void usunUcznia(Uczen u) {
        uczniowie.remove(u);
        u.setSzkola(null);
    }

    public List<Sala> getSale() {
        return sale;
    }

    public int getNumer() {
        return numer;
    }

    public List<String> getProfile() {
        return profile;
    }

    public List<Uczen> getUczniowie() {
        return uczniowie;
    }

    public String getWyroznienie() {
        return wyroznienie;
    }

    public int obliczWiek() {
        return LocalDate.now().getYear() - rokPowstania;
    }

    // konstruktor
    public Szkola(int rokPowstania, String nazwa) {
        this.rokPowstania = rokPowstania;
        this.nazwa = nazwa;
    }

    public void dodajProfil(String profil) {
        profile.add(profil);
    }

    // gettery / settery


    public static int getMinLiczbaUczniow() {
        return MIN_LICZBA_UCZNIOW;
    }

    public static void setMinLiczbaUczniow(int minLiczbaUczniow) {
        MIN_LICZBA_UCZNIOW = minLiczbaUczniow;
    }

    public int getRokPowstania() {
        return rokPowstania;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }


}
