package obiektowosc.podstawy.szkola;

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

    // lista sal (kompozycja z sala)
    private List<Sala> sale = new ArrayList<>();
    // Todo jaka to relacja?
    private List<Klasa> klasy = new ArrayList<>();

    // asocjacja licznosci * do klasy Uczen
    private List<Uczen> uczniowie = new ArrayList<>();
    // asocjacja licznosci * do klasy Nauczyciel
    private List<Nauczyciel> nauczyciele = new ArrayList<>();

    // ekstensja klasy szkola
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


    public void dodajUcznia(Uczen u){
        // TODO Czy to w mojej implementacji jest potrzebne?, dlaczego wywala błąd?
//        if (u.getSzkola() != null) {
//            throw new IllegalArgumentException("uczen juz jest w innej szkole");
//        }

        uczniowie.add(u);
        u.setSzkola(this);
    }

    public void usunUcznia(Uczen u) {
        uczniowie.remove(u);
        u.setSzkola(null);
    }

    public void dodajNauczyciela(Nauczyciel n){
        nauczyciele.add(n);
        n.getSzkoly().add(this);
    }

    public void usunNauczyciela(Nauczyciel n) {
        nauczyciele.remove(n);
        n.getSzkoly().remove(this);
    }

//    public void dodajSale(Sala s){
//        sale.add(s);
//        s.setSzkola(this);
//    }
//
//    public void usunSale(Sala s){
//        sale.remove(s);
//        s.setSzkola(null);
//    }
//
//    public void dodajKlase(Klasa k){
//        klasy.add(k);
//        k.setSzkola(this);
//    }
//
//    public void usunKlase(Klasa k){
//        klasy.remove(k);
//        k.setSzkola(null);
//    }

    public void dodajProfil(String profil){
        profile.add(profil);
    }

    public void usunProfil(String profil){
        profile.remove(profil);
    }

    public int obliczWiek() {
        return LocalDate.now().getYear() - rokPowstania;
    }

    public static List<Uczen> uczniowieZDanejSzkoly(Szkola s){
        return s.uczniowie;
    }

    public static List<Nauczyciel> nauczycieleZDanejSzkoly(Szkola s){
        return s.nauczyciele;
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

    public static int getMinLiczbaUczniow() {
        return MIN_LICZBA_UCZNIOW;
    }

    public static void setMinLiczbaUczniow(int minLiczbaUczniow) {
        MIN_LICZBA_UCZNIOW = minLiczbaUczniow;
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

    public static List<Szkola> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Szkola> ekstensja) {
        Szkola.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}

