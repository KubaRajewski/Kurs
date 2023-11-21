package dalsze.podstawy.streamy.produkt;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Produkt {
    private String nazwa;
    private BigDecimal cena;
    private double waga;
    private int ocena;

    public Produkt(String nazwa, BigDecimal cena, double waga, int ocena) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.waga = waga;
        this.ocena = ocena;
    }

    //// znajdz najdrozszy produkt
    public static Produkt najdrozszyProdukt(List<Produkt> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getCena() != null)
                .max(Comparator.comparing(Produkt::getCena))
                .orElseThrow(IllegalArgumentException::new);

    }

    //// znajdz najtanszy produkt ale lzejszy niz podana waga
    public static Produkt najtanszyProduktLzejszyNiz(List<Produkt> list, double waga) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getCena() != null)
                .filter(p -> p.getWaga() < waga)
                .min(Comparator.comparing(Produkt::getCena))
                .orElseThrow(IllegalArgumentException::new);

    }

    //// napisz metode która zwróci liste produktow o cena > 3000, ocena > 6, waga < 23
    public static List<Produkt> wybraneProdukty(List<Produkt> list, BigDecimal cena, double waga, int ocena) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getCena() != null)
                .filter(p -> p.getWaga() < waga)
                .filter(p -> p.getCena().compareTo(cena) > 0)
                .filter(p -> p.getOcena() > ocena)
                .toList();
    }

    //// oblicz srednia wage produktow z listy
    public static double sredniaWaga(List<Produkt> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getCena() != null)
                .collect(Collectors.averagingDouble(Produkt::getWaga));
    }

    //// napisz metode która zwroci liste nazw produktow z wielkich liter, tych
    // ktorych dlugosc nazwy jest dluzsza niz 5 oraz waga > 10
    // wszystko pisane z wielkich liter
    public static List<String> wybraneNazwyProduktow(List<Produkt> list, double waga) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getWaga() > waga)
                .map(Produkt::getNazwa)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .toList();

    }

    //// zwroc liste produktow posortowanych po nazwie
    public static List<Produkt> produktyPosortowanePoNazwie(List<Produkt> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Produkt::getNazwa))
                .toList();
    }

    //// zwroc liste produktow posorotwanych w zaleznosci od parametru
    public static List<Produkt> produktyPosortowanePoParametrze(List<Produkt> list, Comparator<Produkt> comperator) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .sorted(comperator)
                .toList();
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", waga=" + waga +
                ", ocena=" + ocena +
                '}';
    }
}
