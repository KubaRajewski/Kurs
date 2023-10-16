package obiektowosc.podstawy.uml;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Szkola {

    private static int MIN_LICZBA_UCZNIOW = 150;
    // ekstensja klasy szkola
    private static List<Szkola> ekstensja = new ArrayList<>();
    // atrybuty
    public final int rokPowstania;
    public String nazwa;
    public String wyroznienie;
    public int numer;
    public List<String> profile = new ArrayList<>();
    // asocjacja licznosci * do klasy Uczen
    private List<Uczen> uczniowie = new ArrayList<>();

    // lista sal (kompozycja z sala)
    private List<Sala> sale = new ArrayList<>();

    public Szkola(int rokPowstania, String nazwa, String wyroznienie, int numer) {
        this.rokPowstania = rokPowstania;
        this.nazwa = nazwa;
        this.wyroznienie = wyroznienie;

        // sprawdzamy unikalnosc numeru
        for (Szkola s : ekstensja) {
            if (s.getNumer() == numer) {
                throw new IllegalArgumentException("szkoła o tym numerze istnieje juz w systemie");
            } else {
                this.numer = numer;
            }
        }
        ekstensja.add(this);
    }

    // metoda tworzaca powiazanie (asocjacje)
    public void dodajUcznia(Uczen u) {
        if (u.getSzkola() != null) {
            throw new IllegalArgumentException("uczen juz jest w innej szkole");
        }
        uczniowie.add(u);
        // informacja zwrotna
        u.setSzkola(this);
    }

    public void usunUcznia(Uczen u) {
        uczniowie.remove(u);
        u.setSzkola(null);
    }

    public static int getMinLiczbaUczniow() {
        return MIN_LICZBA_UCZNIOW;
    }

    public static void setMinLiczbaUczniow(int minLiczbaUczniow) {
        MIN_LICZBA_UCZNIOW = minLiczbaUczniow;
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

    public void dodajProfil(String profil) {
        profile.add(profil);
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