package obiektowosc.szkola;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Szkola {

    private static int MIN_LICZBA_UCZNIOW = 150;

    public final int rokPowstania;
    public String nazwa;
    public String wyroznienie;
    public int numer;

    public List<String> profile = new ArrayList<>();
    private List<Sala> sale = new ArrayList<>();
    private List<Klasa> klasy = new ArrayList<>();
    private List<Uczen> uczniowie = new ArrayList<>();
    private List<Nauczyciel> nauczyciele = new ArrayList<>();

    private static List<Szkola> ekstensja = new ArrayList<>();


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

    public void dodajUcznia(Uczen u) {
        if (u.getSzkola() != null) {
            throw new IllegalArgumentException("uczen juz jest w innej szkole");
        }

        uczniowie.add(u);
        u.setSzkola(this);
    }

    public void usunUcznia(Uczen u) {
        uczniowie.remove(u);
        u.setSzkola(null);
    }

    public void dodajNauczyciela(Nauczyciel n) {
        nauczyciele.add(n);
        n.getSzkoly().add(this);
    }

    public void usunNauczyciela(Nauczyciel n) {
        nauczyciele.remove(n);
        n.getSzkoly().remove(this);
    }

    public static List<Uczen> uczniowieZDanejSzkoly(Szkola s) {
        return s.uczniowie;
    }

    public static List<Nauczyciel> nauczycieleZDanejSzkoly(Szkola s) {
        return s.nauczyciele;
    }

    public static int getMinLiczbaUczniow() {
        return MIN_LICZBA_UCZNIOW;
    }

    public static void setMinLiczbaUczniow(int minLiczbaUczniow) {
        MIN_LICZBA_UCZNIOW = minLiczbaUczniow;
    }

    public static List<Szkola> getEkstensja() {
        return ekstensja;
    }

    public void dodajProfil(String profil) {
        profile.add(profil);
    }

    public void usunProfil(String profil) {
        profile.remove(profil);
    }

    public int obliczWiek() {
        return LocalDate.now().getYear() - rokPowstania;
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

    public String getWyroznienie() {
        return wyroznienie;
    }

    public void setWyroznienie(String wyroznienie) {
        this.wyroznienie = wyroznienie;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public List<String> getProfile() {
        return profile;
    }

    public void setProfile(List<String> profile) {
        this.profile = profile;
    }

    public List<Uczen> getUczniowie() {
        return uczniowie;
    }

    public void setUczniowie(List<Uczen> uczniowie) {
        this.uczniowie = uczniowie;
    }

    public List<Nauczyciel> getNauczyciele() {
        return nauczyciele;
    }

    public void setNauczyciele(List<Nauczyciel> nauczyciele) {
        this.nauczyciele = nauczyciele;
    }

    public List<Klasa> getKlasy() {
        return klasy;
    }

    public void setKlasy(List<Klasa> klasy) {
        this.klasy = klasy;
    }

    public List<Sala> getSale() {
        return sale;
    }

    public void setSale(List<Sala> sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}

