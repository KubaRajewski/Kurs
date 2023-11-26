package dalsze.podstawy.streamy.osoba;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Osoba {
    private String imie;
    private String miasto;
    private int wiek;

    public Osoba(String imie, String miasto, int wiek) {
        this.imie = imie;
        this.miasto = miasto;
        this.wiek = wiek;
    }

    //// policz ile jest osob starszych niz podany wiek
    public static long ileOsobStarszychNiz(List<Osoba> list, int wiek) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(o -> o.getWiek() > wiek)
                .count();
    }

    //// znajdz najstarsza osobe z listy, jesli nie ma to rzuc wyjatkiem NoOldestException
    public static Osoba najstarszaOsoba(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Osoba::getWiek))
                .orElseThrow(NoOldestException::new);
    }

    ////znajdz najstarsza kobiete, jesli takiej ni ema to rzuc wyjatkiem NoWomenException
    public static Osoba najstarszaKobieta(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(o -> o.getImie().endsWith("a"))
                .max(Comparator.comparing(Osoba::getWiek))
                .orElseThrow(NoOldestException::new);
    }

    ////oblicz sredni wiek mezczyzn
    public static double sredniWiekMezczyzn(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(o -> !o.getImie().endsWith("a"))
                .mapToDouble(Osoba::getWiek)
                .average()
                .orElseThrow(IllegalArgumentException::new);
    }

    ////oblicz sredni wiek kobiet
    public static double sredniWiekKobiet(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(o -> o.getImie().endsWith("a"))
                .mapToDouble(Osoba::getWiek)
                .average()
                .orElseThrow(IllegalArgumentException::new);
    }

    //// * - metode ktora agreguje dwie metody powyzej (tzn: jako drugi parametr
    // przyjmuje funkcje ktora okresla plec)

    public static double obliczSredniWiek(List<Osoba> list, Predicate<Osoba> genderPredicate) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(genderPredicate)
                .mapToDouble(Osoba::getWiek)
                .average()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static double sredniWiekMezczyzn2(List<Osoba> list) {
        return obliczSredniWiek(list, o -> !o.getImie().endsWith("a"));
    }

    public static double sredniWiekKobiet2(List<Osoba> list) {
        return obliczSredniWiek(list, o -> o.getImie().endsWith("a"));
    }

    //// metode ktora zwroci wszystkie rozne miasta z listy osob(rozne tzn: bez powtorzen)
    public static List<String> distinctMiasta(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Osoba::getMiasto)
                .distinct()
                .toList();
    }

    //// Metoda, która zwraca miasto, w którym żyje najwięcej ludzi
    public static String najludniejszeMiasto(List<Osoba> list) {
        Map<String, Long> counting = Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Osoba::getMiasto, Collectors.counting()));

        return counting.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", miasto='" + miasto + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
