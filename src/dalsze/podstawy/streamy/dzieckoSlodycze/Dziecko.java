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

import java.util.ArrayList;
import java.util.List;

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
