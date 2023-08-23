package obiektowosc.zadania.pierwsze;

import java.util.*;

public class Klient {
    private String imie;
    private String nazwisko;
    private int rozmiarPenisa;

    private List<Produkt> produkty = new ArrayList<>();
    private static List<Klient> ekstensja = new ArrayList<>();

    public Klient(String imie, String nazwisko, int rozmiarPenisa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rozmiarPenisa = rozmiarPenisa;

        ekstensja.add(this);
    }

    // 1) Napisz metode ktota znajduje ka ktory wydal najwiecej.
    public static double obliczWartoscZakupow(List<Produkt> list) {
        double wartosc = 0;
        for (Produkt produkt : list) {
            wartosc += produkt.getCena();
        }
        return wartosc;
    }

    public static Klient ktoWydalNajwiecej(List<Klient> list){
        Klient nk = new Klient(" ", " ", 0);
        for (Klient k : list) {
            if (obliczWartoscZakupow(k.getProdukty()) > obliczWartoscZakupow(nk.getProdukty())) {
                nk = k;
            }
        }
        return nk;
    }


    //TODO Rozbic to na dwie funkcje, niech jedna zwraca liste klientow ktorzy kupili dany produkt

//       2) napisz metode ktora zwroci liste klientow ktorzy kupili kondoma
    public static List<Klient> klienciKtorzyKupiliDanyProdukt(List<Klient> list, String nazwa){
        List<Klient> klienciZDanymProduktem = new ArrayList<>();
        for (Klient k : list) {
            for (Produkt p : k.getProdukty()) {
                if (Helpers.containsIgnoreCase(p.getNazwa(), nazwa)) {
                    if (klienciZDanymProduktem.contains(k)){
                        break;
                    }
                    klienciZDanymProduktem.add(k);
                }
            }
        }
        return klienciZDanymProduktem;
    }
//
//       3) napisz metode ktora zwroci liste klientow ktorzy kupili kondoma ale nie na swoj rozmiar :D
public static List<Klient> kupiliZlegoKondoma(List<Klient> klienci) {
    List<Klient> kupiliZlegoKondoma = new ArrayList<>();

    for (Klient k : klienci) {
        for (Produkt p : k.getProdukty()) {
            if (Helpers.containsIgnoreCase(p.getNazwa(), "kondom")) {
                Optional<Double> wymiarKondoma = p.getWymiar();
                if (wymiarKondoma.isPresent() && k.getRozmiarPenisa() != wymiarKondoma.get() && !kupiliZlegoKondoma.contains(k)) {
                    kupiliZlegoKondoma.add(k);
                }
            }
        }
    }
    return kupiliZlegoKondoma;
}

    public void dodajProdukt(List<Produkt> list) {
        produkty.addAll(list);
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

    public int getRozmiarPenisa() {
        return rozmiarPenisa;
    }

    public void setRozmiarPenisa(int rozmiarPenisa) {
        this.rozmiarPenisa = rozmiarPenisa;
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    public static List<Klient> getEkstensja() {
        return ekstensja;
    }

    public void setEkstensja(List<Klient> ekstensja) {
        this.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
