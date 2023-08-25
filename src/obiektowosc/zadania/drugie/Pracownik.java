package obiektowosc.zadania.drugie;

import java.time.LocalDate;
import java.util.*;

public class Pracownik {
    private String imie;
    private String nazwisko;
    private String adres;
    private int pensja;

    private static List<Pracownik> ekstensja = new ArrayList<>();
    private Map<Pracownik, Map<Samochod, List<String>>> uzytkowaneSamochody = new HashMap<>();

    public Pracownik(String imie, String nazwisko, String adres, int pensja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.pensja = pensja;

        ekstensja.add(this);
    }

//TODO 3) Wyswietl 3 top pracownikow z najwieksza pensja (compartor + sortowanie) DODATKOWE

    public static List<Pracownik> najlepiejZarabiajacy(List<Pracownik> pracownicy, int limit) {
        Collections.sort(pracownicy, (p1, p2) -> p2.getPensja() - p1.getPensja());
        return pracownicy.subList(0, limit);
    }

//TODO 4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta

    public void uzywalSamochodu(Samochod samochod, String data) {
        uzytkowaneSamochody.putIfAbsent(this, new HashMap<>());
        Map<Samochod, List<String>> samochody = uzytkowaneSamochody.get(this);

        samochody.putIfAbsent(samochod, new ArrayList<>());
        samochody.get(samochod).add(data);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public static List<Pracownik> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Pracownik> ekstensja) {
        Pracownik.ekstensja = ekstensja;
    }

    public Map<Pracownik, Map<Samochod, List<String>>> getUzytkowaneSamochody() {
        return uzytkowaneSamochody;
    }

    public void setUzytkowaneSamochody(Map<Pracownik, Map<Samochod, List<String>>> uzytkowaneSamochody) {
        this.uzytkowaneSamochody = uzytkowaneSamochody;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
