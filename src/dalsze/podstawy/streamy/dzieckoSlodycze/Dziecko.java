package dalsze.podstawy.streamy.dzieckoSlodycze;


// stworz klase dziecko (imie) oraz slodycz (nazwa) i asocjacje * -- * pomiedzy nimi

// zwroc lista wszystkich slodyczy ktore kupily dzieci

// zwroc liste unikalnych nazw wszystkich slodyczy ktore kupily dzieci

// ile słodyczy podanego typu kupily dzieci

// znajdz pierwsze dziecko które ma przynajmniej 2 slodycze

// sprawdz czy ktorekolwiek dziecko ma gume

// chcemy zwrócic dziecko które ma najwiecej slodyczy podanego typu
// czyli np d1 ma s1,s1,s2,s3,s4,s4,s4
// d2 ma s1,s1,s1,s1,s3,s4,s5
// to metoda dla parametru s1 powinna dac d2, dla parametru s4 powinna dac d1

// znajdz n-ty najpopularniejszy slodycz wsrod dzieci

// zwroc wszystkie nazwy slodyczy, bezpowtórzen, scalone w jednego stringa z
// malych liter


import java.util.*;
import java.util.stream.Collectors;

public class Dziecko {
    private final String imie;
    private List<Slodycz> slodycze = new ArrayList<>();

    public Dziecko(String imie) {
        this.imie = imie;
    }

    public void dodajSlodycz(Slodycz s) {
        slodycze.add(s);
        s.getDzieci().add(this);
    }

    public static List<Slodycz> wszystkieSlodyczeKupionePrzezDzieci(List<Dziecko> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Dziecko::getSlodycze)
                .flatMap(Collection::stream)
                .toList();
    }

    public static List<String> unikalneNazwySlodyczyKupionychPrzezDzieci(List<Dziecko> list) {
        return wszystkieSlodyczeKupionePrzezDzieci(list).stream()
                .distinct()
                .map(Slodycz::getNazwa)
                .toList();
    }

    public static long ileDanychSlodyczyKupilyDzieci(List<Dziecko> list, String nazwa) {
        return wszystkieSlodyczeKupionePrzezDzieci(list).stream()
                .filter(s -> s.getNazwa().equals(nazwa))
                .count();
    }

    public static Dziecko pierwszeDzieckoZNSlodyczami(List<Dziecko> list, int n) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(d -> d.getSlodycze().size() >= n)
                .findFirst()
                .orElseThrow(KidNotFoundException::new);
    }

    public static boolean czyKtosKupilGume(List<Dziecko> list) {
        long count = wszystkieSlodyczeKupionePrzezDzieci(list).stream()
                .filter(s -> s.getNazwa().equals("Guma"))
                .count();

        return count > 0;
    }

    public static Dziecko ktoKupilNajwiecejDanejSlodyczy(List<Dziecko> list, Slodycz s) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(dziecko -> ileKupiloDanejSlodyczy(dziecko, s)))
                .orElseThrow(KidNotFoundException::new);
    }

    public static long ileKupiloDanejSlodyczy(Dziecko dziecko, Slodycz s) {
        return dziecko.getSlodycze().stream()
                .filter(sl -> sl.equals(s))
                .count();
    }

    public static Slodycz nNajpopularniejszySlodyczWsrodDzieci(List<Dziecko> list, int n){
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMap(dziecko -> dziecko.getSlodycze().stream())
                .collect(Collectors.groupingBy(slodycz -> slodycz, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Slodycz, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(CandyNotFoundException::new);
    }

    public static String wszystkieNazwySlodyczy(List<Dziecko> dzieci) {
        return dzieci.stream()
                .flatMap(dziecko -> dziecko.getSlodycze().stream())
                .map(Slodycz::getNazwa)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.joining(", "));
    }

    public String getImie() {
        return imie;
    }

    public List<Slodycz> getSlodycze() {
        return slodycze;
    }

    @Override
    public String toString() {
        return "Dziecko{" +
                "imie='" + imie + '\'' +
                '}';
    }
}
