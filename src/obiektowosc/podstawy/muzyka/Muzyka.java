package obiektowosc.podstawy.muzyka;

import java.util.*;

public class Muzyka {
    private String tytul;
    private String autor;
    private String gatunek;
    private String dataWydania;
    private final int czasTrwania; // w sekundach
    private boolean czyWUlubionych;

    // Konstruktor
    public Muzyka(String tytul, String autor, String gatunek, String dataWydania, int czasTrwania, boolean czyWUlubionych) {
        this.tytul = tytul;
        this.autor = autor;
        this.gatunek = gatunek;
        this.dataWydania = dataWydania;
        this.czasTrwania = czasTrwania;
        this.czyWUlubionych = czyWUlubionych;
        ekstensja.add(this);
    }

    // ekstensja klasy Muzyka
    static List<Muzyka> ekstensja = new ArrayList<>();

    public String getDataWydania() {
        return dataWydania;
    }

    public void setDataWydania(String dataWydania) {
        this.dataWydania = dataWydania;
    }

    public boolean isCzyWUlubionych() {
        return czyWUlubionych;
    }

    public void setCzyWUlubionych(boolean czyWUlubionych) {
        this.czyWUlubionych = czyWUlubionych;
    }

    // Metoda do pobierania tytułu utworu
    public String getTytul() {
        return tytul;
    }

    // Metoda do pobierania artysty
    public String getAutor() {
        return autor;
    }

    // Metoda do pobierania gatunku muzycznego
    public String getGatunek() {
        return gatunek;
    }

    // Metoda do pobierania długości utworu
    public int getCzasTrwania() {
        return czasTrwania;
    }

    // Metoda do wyświetlania informacji o utworze
    @Override
    public String toString() {
        return "Tytuł: " + tytul + ", autor: " + autor + "data wydania: " + dataWydania;
    }

    public static void wyswietlEkstensje() {
        System.out.println("Wszystkie utwory: ");
        for (Muzyka m : ekstensja) {
            System.out.println(m);
        }
    }


    public static void dodajUtwor(String tytul, String autor, String gatunek, int czasTrwania, String dataWydania, boolean czyWUlubionych) {
        Muzyka nowyUtwor = new Muzyka(tytul, autor, gatunek,  dataWydania, czasTrwania, czyWUlubionych);
    }

    public static void usunUtwor(String tytul, String autor) {
        Iterator<Muzyka> iterator = ekstensja.iterator();
        while (iterator.hasNext()) {
            Muzyka m = iterator.next();
            if (m.getTytul().equals(tytul) && m.getAutor().equals(autor)) {
                iterator.remove();
                System.out.println("Usunięto utwór: " + m);
                return;
            }
        }
        System.out.println("Nie znaleziono utworu o podanych parametrach");
    }

    public static List<Muzyka> utworyAutora(List<Muzyka> list, String autor){
        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.getAutor().equals(autor)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static List<Muzyka> utworyGatunku(List<Muzyka> list, String gatunek){
        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.getGatunek().equals(gatunek)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static List<Muzyka> utworyDluzszeNiz(List<Muzyka> list, int czas){
        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.getCzasTrwania() > czas) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static List<Muzyka> utworyKrotszeNiz(List<Muzyka> list, int czas){
        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.getCzasTrwania() < czas) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static List<Muzyka> utworyWUlubionych(List<Muzyka> list){
        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.isCzyWUlubionych()) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static void dodaj20piosenek(){
        dodajUtwor("Bohemian Rhapsody", "Queen", "Rock", 355, "1975-10-31", true);
        dodajUtwor("Shape of You", "Ed Sheeran", "Pop", 233, "2017-01-06", true);
        dodajUtwor("Imagine", "John Lennon", "Rock", 186, "1971-09-09", true);
        dodajUtwor("Billie Jean", "Michael Jackson", "Pop", 295, "1983-01-02", true);
        dodajUtwor("Hotel California", "Eagles", "Rock", 391, "1976-02-22", true);
        dodajUtwor("Like a Rolling Stone", "Bob Dylan", "Rock", 365, "1965-07-20", true);
        dodajUtwor("Hey Jude", "The Beatles", "Rock", 431, "1968-08-26", true);
        dodajUtwor("Uptown Funk", "Mark Ronson ft. Bruno Mars", "Pop", 271, "2014-11-10", true);
        dodajUtwor("Thriller", "Michael Jackson", "Pop", 357, "1982-11-30", true);
        dodajUtwor("Sweet Child O' Mine", "Guns N' Roses", "Rock", 355, "1987-08-17", true);
        dodajUtwor("Smells Like Teen Spirit", "Nirvana", "Grunge", 301, "1991-09-10", true);
        dodajUtwor("Boogie Wonderland", "Earth, Wind & Fire", "Disco", 280, "1979-03-20", true);
        dodajUtwor("Rolling in the Deep", "Adele", "Pop", 228, "2010-11-29", true);
        dodajUtwor("Born to Run", "Bruce Springsteen", "Rock", 274, "1975-08-25", true);
        dodajUtwor("I Want to Hold Your Hand", "The Beatles", "Rock", 153, "1963-11-29", true);
        dodajUtwor("Wonderwall", "Oasis", "Rock", 258, "1995-10-30", true);
        dodajUtwor("Superstition", "Stevie Wonder", "Soul", 240, "1972-10-24", true);
        dodajUtwor("Billie Jean", "Michael Jackson", "Pop", 357, "1982-11-30", true);
        dodajUtwor("Yesterday", "The Beatles", "Rock", 126, "1965-08-06", true);
        dodajUtwor("Boogie Wonderland", "Earth, Wind & Fire", "Disco", 280, "1979-03-20", true);
        dodajUtwor("Dancing Queen", "ABBA", "Disco", 221, "1976-08-15", true);

    }
}

