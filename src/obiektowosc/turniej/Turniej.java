package obiektowosc.turniej;

import java.util.*;

public class Turniej {
    private String nazwa;
    private String miesiac;

    private List <Gracz> uczestnicy = new ArrayList<>();

    private Map<Gracz, Map<Integer, Integer>> wynikiTurnieju = new HashMap<>();

    private static List<Turniej> ekstensja = new ArrayList<>();

    public Turniej(String nazwa, String miesiac) {
        this.nazwa = nazwa;
        this.miesiac = miesiac;

        ekstensja.add(this);
    }

    public void dodajUczestnikaIPozycje(Gracz gracz, int pozycja) {
        if (uczestnicy.contains(gracz)) {
            System.out.println("Gracz " + gracz + " już jest na liście uczestników");
            return;
        } else if (pozycja > gracz.getEkstensja().size()){
            System.out.println("Coś poszło nie tak, pozycja gracza jest większa niż liczba graczy");
            return;
        }

        int punkty = 0;
        if (pozycja == 1) {
            punkty = 10;
        } else if (pozycja == 9) {
            punkty = 8;
        } else if (pozycja == 8) {
            punkty = 6;
        } else if (pozycja == 7) {
            punkty = 4;
        } else if (pozycja == 6) {
            punkty = 2;
        } else if (pozycja == 5) {
            punkty = 1;
        }

        uczestnicy.add(gracz);
        wynikiTurnieju.put(gracz, new HashMap<>());
        wynikiTurnieju.get(gracz).put(pozycja, punkty);

        gracz.dodajTurniej(this);
        gracz.dodajWynik(this, pozycja, punkty);
    }

    // TODO 3) znajdz gracza ktory byl najlepszy w turniejach o danej nazwie, jesli nie ma to rzuc wyjatkiem
    public static List<Turniej> turniejeODanejNazwie(String nazwa){
        List<Turniej> turniejeODanejNazwie = new ArrayList<>();

        for (Turniej t : ekstensja) {
            if (t.nazwa.equalsIgnoreCase(nazwa)){
                turniejeODanejNazwie.add(t);
            }
        }
        return turniejeODanejNazwie;
    }

    public static Gracz najlepszyGraczWTurniejachODanejNazwie(String nazwa) throws IllegalArgumentException {
        List<Turniej> turniejeOdanejNazwie = turniejeODanejNazwie(nazwa);

        if (turniejeOdanejNazwie.isEmpty()) {
            throw new IllegalArgumentException("Brak turniejów o podanej nazwie: " + nazwa);
        }

        Gracz najlepszyGracz = null;
        int sumaPunktowNajlepszegoGracza = Integer.MIN_VALUE;

        for (Turniej turniej : turniejeOdanejNazwie) {
            for (Gracz gracz : turniej.getUczestnicy()) {
                int sumaPunktowGracza = 0;
                Map<Integer, Integer> wynikiGracza = turniej.getWynikiTurnieju().get(gracz);

                for (Integer punkty : wynikiGracza.values()) {
                    sumaPunktowGracza += punkty;
                }

                if (sumaPunktowGracza > sumaPunktowNajlepszegoGracza) {
                    sumaPunktowNajlepszegoGracza = sumaPunktowGracza;
                    najlepszyGracz = gracz;
                }
            }
        }

        if (najlepszyGracz == null) {
            throw new IllegalArgumentException("Brak najlepszego gracza w turniejach o nazwie: " + nazwa);
        }

        return najlepszyGracz;
    }
    
    // TODO 4) znajdz gracza ktory zodbyl najwiecej 1 miejsc ze wszystkich turniejow
    public static Gracz najczesciejNaPierwszymMiejscu() throws IllegalArgumentException {
        if (ekstensja.isEmpty()) {
            throw new IllegalArgumentException("Brak dostępnych turniejów.");
        }

        Map<Gracz, Integer> liczbaPierwszychMiejscGracza = new HashMap<>();
        Gracz najlepszyGracz = null;
        int maksymalnaLiczbaPierwszychMiejsc = 0;

        for (Turniej turniej : ekstensja) {
            for (Gracz gracz : turniej.getUczestnicy()) {
                Map<Integer, Integer> wynikiGracza = turniej.getWynikiTurnieju().get(gracz);
                if (wynikiGracza != null && wynikiGracza.containsKey(1)) {
                    int iloscPierwszychMiejsc = wynikiGracza.get(1);
                    liczbaPierwszychMiejscGracza.put(gracz, liczbaPierwszychMiejscGracza.getOrDefault(gracz, 0) + iloscPierwszychMiejsc);
                }
            }
        }

        for (Map.Entry<Gracz, Integer> entry : liczbaPierwszychMiejscGracza.entrySet()) {
            if (entry.getValue() > maksymalnaLiczbaPierwszychMiejsc) {
                maksymalnaLiczbaPierwszychMiejsc = entry.getValue();
                najlepszyGracz = entry.getKey();
            }
        }

        if (najlepszyGracz == null) {
            throw new IllegalArgumentException("Brak gracza, który zdobył pierwsze miejsce w żadnym z turniejów.");
        }

        return najlepszyGracz;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(String miesiac) {
        this.miesiac = miesiac;
    }

    public List<Gracz> getUczestnicy() {
        return uczestnicy;
    }

    public void setUczestnicy(List<Gracz> uczestnicy) {
        this.uczestnicy = uczestnicy;
    }

    public Map<Gracz, Map<Integer, Integer>> getWynikiTurnieju() {
        return wynikiTurnieju;
    }

    public void setWynikiTurnieju(Map<Gracz, Map<Integer, Integer>> wynikiTurnieju) {
        this.wynikiTurnieju = wynikiTurnieju;
    }

    public static List<Turniej> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Turniej> ekstensja) {
        Turniej.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return nazwa + " " + miesiac;
    }
}
