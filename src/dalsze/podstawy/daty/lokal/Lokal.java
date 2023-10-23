package dalsze.podstawy.daty.lokal;

import java.util.ArrayList;
import java.util.List;

public class Lokal {
    private String nazwa;
    private String miejsce;
    private int minimalnyWiek;

    private List<Osoba> osoby = new ArrayList<>();

    public Lokal(String nazwa, String miejsce, int minimalnyWiek) {
        this.nazwa = nazwa;
        this.miejsce = miejsce;
        this.minimalnyWiek = minimalnyWiek;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public int getMinimalnyWiek() {
        return minimalnyWiek;
    }

    public void setMinimalnyWiek(int minimalnyWiek) {
        this.minimalnyWiek = minimalnyWiek;
    }

    public List<Osoba> getOsoby() {
        return osoby;
    }

    public void setOsoby(List<Osoba> osoby) {
        this.osoby = osoby;
    }

    @Override
    public String toString() {
        return "Lokal{" +
                "nazwa='" + nazwa + '\'' +
                ", miejsce='" + miejsce + '\'' +
                ", minimalnyWiek=" + minimalnyWiek +
                '}';
    }
}
