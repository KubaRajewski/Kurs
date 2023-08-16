package obiektowosc.podstawy.muzyka;

import java.time.LocalDate;
import java.util.*;

public class Muzyka {
    private String tytul;
    private String autor;
    private String gatunek;
    private LocalDate dataWydania; // Zmiana na LocalDate
    private int czasTrwania; // w sekundach
    private boolean czyWUlubionych;

    // Konstruktor
    public Muzyka(String tytul, String autor, String gatunek, LocalDate dataWydania, int czasTrwania, boolean czyWUlubionych) {
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

    // Metoda do wyświetlania informacji o utworze
    @Override
    public String toString() {
        return "Tytuł: " + tytul + ", autor: " + autor + ", data wydania: " + dataWydania;
    }

    public static void wyswietlEkstensje() {
        System.out.println("Wszystkie utwory: ");
        for (Muzyka m : ekstensja) {
            System.out.println(m);
        }
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public LocalDate getDataWydania() {
        return dataWydania;
    }


    public int getCzasTrwania() {
        return czasTrwania;
    }

    public boolean isCzyWUlubionych() {
        return czyWUlubionych;
    }

    public void setCzyWUlubionych(boolean czyWUlubionych) {
        this.czyWUlubionych = czyWUlubionych;
    }

    public static List<Muzyka> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Muzyka> ekstensja) {
        Muzyka.ekstensja = ekstensja;
    }

    public static void dodajUtwor(String tytul, String autor, String gatunek, int czasTrwania, LocalDate dataWydania, boolean czyWUlubionych) {
        Muzyka nowyUtwor = new Muzyka(tytul, autor, gatunek, dataWydania, czasTrwania, czyWUlubionych);
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

    public int obliczWiekUtworu() {
        int aktualnyRok = LocalDate.now().getYear();
        return aktualnyRok - dataWydania.getYear();
    }
    public static void wyswietlUtworyStarszeNiz(List<Muzyka> list, int wiek) {
        System.out.println("Utwory starsze niż " + wiek + " lat:");
        for (Muzyka m : list) {
            if (m.obliczWiekUtworu() > wiek) {
                System.out.println(m);
            }
        }
    }

    public static void wyswietlUtworyMlodszeNiz(List<Muzyka> list, int wiek) {
        System.out.println("Utwory młodsze niż " + wiek + " lat:");
        for (Muzyka m : list) {
            if (m.obliczWiekUtworu() < wiek) {
                System.out.println(m);
            }
        }
    }

    public static void dodaj20piosenek(){
        dodajUtwor("Bohemian Rhapsody", "Queen", "Rock", 355, LocalDate.parse("1975-10-31"), true);
        dodajUtwor("Shape of You", "Ed Sheeran", "Pop", 233, LocalDate.parse("2017-01-06"), true);
        dodajUtwor("Imagine", "John Lennon", "Rock", 186, LocalDate.parse("1971-09-09"), true);
        dodajUtwor("Billie Jean", "Michael Jackson", "Pop", 295, LocalDate.parse("1983-01-02"), true);
        dodajUtwor("Hotel California", "Eagles", "Rock", 391, LocalDate.parse("1976-02-22"), true);
        dodajUtwor("Like a Rolling Stone", "Bob Dylan", "Rock", 365, LocalDate.parse("1965-07-20"), true);
        dodajUtwor("Hey Jude", "The Beatles", "Rock", 431, LocalDate.parse("1968-08-26"), true);
        dodajUtwor("Uptown Funk", "Mark Ronson ft. Bruno Mars", "Pop", 271, LocalDate.parse("2014-11-10"), true);
        dodajUtwor("Thriller", "Michael Jackson", "Pop", 357, LocalDate.parse("1982-11-30"), true);
        dodajUtwor("Sweet Child O' Mine", "Guns N' Roses", "Rock", 355, LocalDate.parse("1987-08-17"), true);
        dodajUtwor("Smells Like Teen Spirit", "Nirvana", "Grunge", 301, LocalDate.parse("1991-09-10"), true);
        dodajUtwor("Boogie Wonderland", "Earth, Wind & Fire", "Disco", 280, LocalDate.parse("1979-03-20"), true);
        dodajUtwor("Rolling in the Deep", "Adele", "Pop", 228, LocalDate.parse("2010-11-29"), true);
        dodajUtwor("Born to Run", "Bruce Springsteen", "Rock", 274, LocalDate.parse("1975-08-25"), true);
        dodajUtwor("I Want to Hold Your Hand", "The Beatles", "Rock", 153, LocalDate.parse("1963-11-29"), true);
        dodajUtwor("Wonderwall", "Oasis", "Rock", 258, LocalDate.parse("1995-10-30"), true);
        dodajUtwor("Superstition", "Stevie Wonder", "Soul", 240, LocalDate.parse("1972-10-24"), true);
        dodajUtwor("Billie Jean", "Michael Jackson", "Pop", 357, LocalDate.parse("1982-11-30"), true);
        dodajUtwor("Yesterday", "The Beatles", "Rock", 126, LocalDate.parse("1965-08-06"), true);
        dodajUtwor("Boogie Wonderland", "Earth, Wind & Fire", "Disco", 280, LocalDate.parse("1979-03-20"), true);
        dodajUtwor("Dancing Queen", "ABBA", "Disco", 221, LocalDate.parse("1976-08-15"), true);

    }
}

