package obiektowosc.turniej;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gracz {
    private String imie;
    private String nazwisko;
    private int punkty;

    private List<Turniej> turnieje = new ArrayList<>();
    private List<Wynik> wyniki = new ArrayList<>();

    private static List<Gracz> ekstensja = new ArrayList<>();

    public Gracz(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;

        ekstensja.add(this);
    }

    public void dodajTurniej(Turniej turniej) {
        if (turnieje.contains(turniej)) {
            System.out.println("Ten gracz jest juz zapisany na ten turniej");
            return;
        }
        turnieje.add(turniej);
    }

    // TODO 3) znajdz gracza ktory byl najlepszy w turniejach o danej nazwie, jesli nie ma to rzuc wyjatkiem
    public static List<Turniej> turniejeODanejNazwie(String nazwa) {
        List<Turniej> turnieje = new ArrayList<>();

        for (Turniej turniej : Turniej.getEkstensja()) {
            if (turniej.getNazwa().equals(nazwa)) {
                turnieje.add(turniej);
            }
        }
        return turnieje;
    }

    public static Gracz najlepszyGraczWTurniejachODanejNazwie(String nazwa){
        List<Turniej> turniejeODanejNazwie = turniejeODanejNazwie(nazwa);
        Gracz najlepszyGracz = null;
        int maxPunkty = 0;

        for (Turniej turniej : turniejeODanejNazwie) {
            for (Wynik wynik : turniej.getWyniki()) {
                if (wynik.getPunkty() > maxPunkty) {
                    maxPunkty = wynik.getPunkty();
                    najlepszyGracz = wynik.getGracz();
                }
            }
        }

        if (najlepszyGracz == null) {
            throw new RuntimeException("Nie ma gracza ktory bylby najlepszy w turniejach o nazwie " + nazwa);
        }

        return najlepszyGracz;
    }

    // TODO 4) znajdz gracza ktory zodbyl najwiecej 1 miejsc ze wszystkich turniejow
    public static Gracz graczZNajwiekszaIlosciaWygranych(){
        Gracz najlepszyGracz = null;
        int maxIloscWygranych = 0;

        for (Gracz gracz : ekstensja) {
            int iloscWygranych = 0;
            for (Wynik wynik : gracz.getWyniki()) {
                if (wynik.getPozycja() == 1) {
                    iloscWygranych++;
                }
            }
            if (iloscWygranych > maxIloscWygranych) {
                maxIloscWygranych = iloscWygranych;
                najlepszyGracz = gracz;
            }
        }

        if (najlepszyGracz == null) {
            throw new RuntimeException("Nie ma gracza ktory bylby najlepszy");
        }

        return najlepszyGracz;
    }

    // TODO 5) znajdz gracza ktory ma najwyzsyz ranking z turrniejow ale nigdy nie mial 1 miejsca
    public static Gracz najlepszyGraczBezWygranej(){
        Gracz najlepszyGracz = null;
        int maxRanking = 0;

        for (Gracz gracz : ekstensja) {
            int ranking = 0;
            for (Wynik wynik : gracz.getWyniki()) {
                ranking += wynik.getPozycja();
            }
            if ((ranking > maxRanking) && !gracz.posiadaWygrana()) {
                maxRanking = ranking;
                najlepszyGracz = gracz;
            }
        }

        if (najlepszyGracz == null) {
            throw new RuntimeException("Nie ma gracza ktory bylby najlepszy");
        }

        return najlepszyGracz;
    }

    private boolean posiadaWygrana() {
        for (Wynik wynik : wyniki) {
            if (wynik.getPozycja() == 1) {
                return true;
            }
        }
        return false;
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

    public List<Turniej> getTurnieje() {
        return turnieje;
    }

    public void setTurnieje(List<Turniej> turnieje) {
        this.turnieje = turnieje;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
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
    public String toString() {
        return imie + " " + nazwisko;
    }


}
