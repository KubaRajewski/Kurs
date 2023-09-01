package obiektowosc.zadania.drugie;

import java.time.LocalDate;
import java.util.*;

public class Pracownik extends Osoba {
    private String adres;
    private double pensja;

    private static List<Pracownik> ekstensja = new ArrayList<>();
    private Map<Pracownik, Map<Samochod, List<String>>> uzytkowaneSamochody = new HashMap<>();

    public Pracownik(String imie, String nazwisko, String adres, double pensja) {
        super(imie, nazwisko);
        this.adres = adres;
        this.pensja = pensja;

        ekstensja.add(this);
    }

    //TODO 3) Wyswietl 3 top pracownikow z najwieksza pensja (compartor + sortowanie) DODATKOWE

    public static List<Pracownik> najlepiejZarabiajacy(List<Pracownik> pracownicy, int limit) {

        if (pracownicy == null) throw new IllegalArgumentException();

        if (limit > pracownicy.size()) throw new IllegalArgumentException();

        List<Pracownik> copy = new ArrayList<>(pracownicy);

        Collections.sort(copy, Comparator.comparing(Pracownik::getPensja).reversed());

        // metoda sort przyjmuje dwa argumenty - pierwszy to lista, drugi to comparator
        // 'p2.getPensja() - p1.getPensja() oblicza różnicę pensji między p2 a p1' jesli roznica bedzie dodatnia
        // oznacza to ze p2 zarabia wiecej niz p1, wiec p2 jest wiekszy i powinien byc przed p1

        return copy.subList(0, limit);
    }

//TODO 4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta

    public void uzywalSamochodu(Samochod samochod, String data) {

        uzytkowaneSamochody.putIfAbsent(this, new HashMap<>());
        // this w tym przypadku wstawia klienta do mapy, jeśli go tam nie ma

        Map<Samochod, List<String>> samochodyIDaty = uzytkowaneSamochody.get(this);
        // pobiera mapę samochodów i dat dla konkretnego pracownika  z mapy uzytkowaneSamochody.
        // Otrzymujemy mapę, gdzie kluczem jest obiekt Samochod, a wartością jest lista dat.

        samochodyIDaty.putIfAbsent(samochod, new ArrayList<>());
        // Sprawdzamy, czy dla danego samochodu (samochod) istnieje już wpis w mapie samochodyIDaty.
        // Jeśli nie istnieje, tworzymy wpis z pustą listą dat.

        samochodyIDaty.get(samochod).add(data);
        // dodajemy nową datę (data) do listy dat w mapie samochodyIDaty,
        // która jest przypisana do konkretnego samochodu (samochod)
    }


    public void uzywalSamochoduOryginal(Samochod samochod, String data) {
        if (uzytkowaneSamochody.containsKey(this)) {
            Map<Samochod, List<String>> samochodyIDaty = uzytkowaneSamochody.get(this);
            if (samochodyIDaty.containsKey(samochod)) {
                List<String> daty = samochodyIDaty.get(samochod);
                daty.add(data);
            } else {
                List<String> daty = new ArrayList<>();
                daty.add(data);
                samochodyIDaty.put(samochod, daty);
            }
        } else {
            Map<Samochod, List<String>> samochodyIDaty = new HashMap<>();
            List<String> daty = new ArrayList<>();
            daty.add(data);
            samochodyIDaty.put(samochod, daty);
            uzytkowaneSamochody.put(this, samochodyIDaty);
        }
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public double getPensja() {
        return pensja;
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


}
