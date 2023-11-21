package dalsze.podstawy.streamy.dzieckoSlodycze;

import java.util.ArrayList;
import java.util.List;

public class Slodycz {
    private final String nazwa;
    private List<Dziecko> dzieci = new ArrayList<>();

    public Slodycz(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Dziecko> getDzieci() {
        return dzieci;
    }

    @Override
    public String toString() {
        return "Slodycz{" +
                "nazwa='" + nazwa + '\'' +
                '}';
    }
}
