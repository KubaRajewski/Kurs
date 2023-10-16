package obiektowosc.turniej;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gracz {
    private String imie;
    private String nazwisko;
    private int sumaPunktow;
    private List<Wynik> wyniki = new ArrayList<>();

    private static List<Gracz> ekstensja = new ArrayList<>();

    public Gracz(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;

        ekstensja.add(this);
    }

    public static Gracz najlepszyGraczWTurniejachODanejNazwie(List<Gracz> gracze, String nazwa) {
        if (gracze == null || gracze.isEmpty())
            throw new IllegalArgumentException("Lista nie moze byc pusta ani byc nullem");

        Gracz najlepszyGracz = gracze.get(0);

        for (Gracz gracz : gracze) {
            if (gracz.ileGraczMialPunktow(nazwa) > najlepszyGracz.ileGraczMialPunktow(nazwa)) {
                najlepszyGracz = gracz;
            }
        }

        return najlepszyGracz;
    }

    public static Gracz zNajwiekszaIlosciaDanychPozycji(List<Gracz> gracze, int pozycja) {
        Gracz najlepszyGracz = gracze.get(0);

        for (Gracz g : gracze) {
            if (g.ileMialDanychPozycji(pozycja) > najlepszyGracz.ileMialDanychPozycji(pozycja)) {
                najlepszyGracz = g;
            }
        }

        return najlepszyGracz;
    }

    public static Gracz najlepszyGraczBezDanejPozycji(List<Gracz> gracze, int pozycja) {
        if (gracze == null || gracze.isEmpty())
            throw new IllegalArgumentException("Lista nie moze byc pusta ani byc nullem");

        Gracz najlepszyGracz = gracze.get(0);

        for (Gracz g : gracze) {
            if (g.ileGraczMialPunktowBezWygranej(pozycja) > najlepszyGracz.ileGraczMialPunktowBezWygranej(pozycja)) {
                najlepszyGracz = g;
            }
        }

        return najlepszyGracz;
    }

    // TODO 3) znajdz gracza ktory byl najlepszy w turniejach o danej nazwie, jesli nie ma to rzuc wyjatkiem
    public int ileGraczMialPunktow(String nazwa) {
        int punkty = 0;
        for (Wynik w : wyniki) {
            if (w.getTurniej().getNazwa().equalsIgnoreCase(nazwa)) {
                punkty += w.getPunkty();
            }
        }
        return punkty;
    }

    // TODO 4) znajdz gracza ktory zodbyl najwiecej 1 miejsc ze wszystkich turniejow
    public int ileMialDanychPozycji(int pozycja) {
        int iloscPozycji = 0;
        for (Wynik wynik : wyniki) {
            if (wynik.getPozycja() == pozycja) {
                iloscPozycji++;
            }
        }
        return iloscPozycji;
    }

    // TODO 5) znajdz gracza ktory ma najwyzsyz ranking z turrniejow ale nigdy nie mial 1 miejsca
    public int ileGraczMialPunktowBezWygranej(int pozycja) {
        int punkty = 0;
        for (Wynik w : wyniki) {
            if (w.getPozycja() != pozycja) {
                punkty += w.getPunkty();
            }
        }
        return punkty;
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

    public int getSumaPunktow() {
        return sumaPunktow;
    }

    public void setSumaPunktow(int sumaPunktow) {
        this.sumaPunktow = sumaPunktow;
    }

    public List<Wynik> getWyniki() {
        return wyniki;
    }

    public void setWyniki(List<Wynik> wyniki) {
        this.wyniki = wyniki;
    }

    public static List<Gracz> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Gracz> ekstensja) {
        Gracz.ekstensja = ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gracz gracz = (Gracz) o;
        return Objects.equals(imie, gracz.imie) &&
                Objects.equals(nazwisko, gracz.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }

}
