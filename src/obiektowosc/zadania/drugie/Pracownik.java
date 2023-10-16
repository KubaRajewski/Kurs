package obiektowosc.zadania.drugie;

import java.util.*;

public class Pracownik extends Osoba {
    private static List<Pracownik> ekstensja = new ArrayList<>();
    private String adres;
    private double pensja;
    private Map<Pracownik, Map<Samochod, List<String>>> uzytkowaneSamochody = new HashMap<>();

    public Pracownik(String imie, String nazwisko, String adres, double pensja) {
        super(imie, nazwisko);
        this.pensja = pensja;
        this.adres = adres;

        ekstensja.add(this);
    }

    //TODO 3) Wyswietl 3 top pracownikow z najwieksza pensja (compartor + sortowanie) DODATKOWE
    public static List<Pracownik> najlepiejZarabiajacy(int limit) {
        if (Pracownik.getEkstensja() == null)
            throw new IllegalArgumentException("Brak pracownikow");
        if (limit > Pracownik.getEkstensja().size())
            throw new IllegalArgumentException("Niewystarczająco pracownikow");

        List<Pracownik> copy = new ArrayList<>(Pracownik.getEkstensja());
        Collections.sort(copy, Comparator.comparing(Pracownik::getPensja).reversed());

        return copy.subList(0, limit);
    }

    public static List<Pracownik> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Pracownik> ekstensja) {
        Pracownik.ekstensja = ekstensja;
    }

    //TODO 4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta
    public void uzywalSamochodu(Samochod samochod, String data) {
        uzytkowaneSamochody.putIfAbsent(this, new HashMap<>());
        Map<Samochod, List<String>> samochodyIDaty = uzytkowaneSamochody.get(this);
        samochodyIDaty.putIfAbsent(samochod, new ArrayList<>());
        samochodyIDaty.get(samochod).add(data);

        if (!samochod.getUzytkownicy().contains(this)) {
            samochod.getUzytkownicy().add(this);
        }
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Map<Pracownik, Map<Samochod, List<String>>> getUzytkowaneSamochody() {
        return uzytkowaneSamochody;
    }

    public void setUzytkowaneSamochody(Map<Pracownik, Map<Samochod, List<String>>> uzytkowaneSamochody) {
        this.uzytkowaneSamochody = uzytkowaneSamochody;
    }

    @Override
    public String toString() {
        return getImie() + " " + getNazwisko();
    }
}
