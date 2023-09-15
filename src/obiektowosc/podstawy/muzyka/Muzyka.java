package obiektowosc.podstawy.muzyka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Muzyka {
    // ekstensja klasy Muzyka
    static List<Muzyka> ekstensja = new ArrayList<>();
    private final LocalDate dataWydania; // Zmiana na LocalDate
    private final double czasTrwania; // w sekundach
    private String tytul;
    private String autor;
    private String gatunek;
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

    public static void wyswietlEkstensje() {
        System.out.println("Wszystkie utwory: ");
        for (Muzyka m : ekstensja) {
            System.out.println(m);
        }
    }

    public static Muzyka zwrocKonkretnyUtwor(List<Muzyka> lista, String tytul) {
        for (Muzyka m : lista) {
            if (tytul.equalsIgnoreCase(m.getTytul())) {
                return m;
            }
        }
        return null;
    }

    public static List<Muzyka> getEkstensja() {
        return ekstensja;
    }

    // gettery i settery

    public static void setEkstensja(List<Muzyka> ekstensja) {
        Muzyka.ekstensja = ekstensja;
    }

    public static String konkretnyUtwor(List<Muzyka> list, String tytul) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");
        for (Muzyka m : list) {
            if (m.getTytul().equalsIgnoreCase(tytul)) {
                return "Autor: " + m.getAutor() + ", Tytuł: " + m.getTytul() + ", Gatunek " + m.getGatunek() + ", Czas Trwania: " + (m.getCzasTrwania() / 60) + " minuty, Data Wydania: " + m.getDataWydania();
            }
        }
        return null;
    }

    public static void edytujPiosenke(Muzyka m) {
        System.out.println("Co chcesz edytować? (tytul, autor, gatunek, ulubione)");
        Scanner scanner = new Scanner(System.in);
        String wybor = scanner.nextLine();
        wybor = wybor.toLowerCase();

        switch (wybor) {
            case "tytul":
                System.out.println("Stary tytul: " + m.getTytul());
                System.out.println("Podaj nowy tytul: ");
                String nowyT = scanner.nextLine();
                m.setTytul(nowyT);
                System.out.println("Tytul zmieniony na " + nowyT);
                break;
            case "autor":
                System.out.println("Stary autor: " + m.getAutor());
                System.out.println("Podaj nowego autora: ");
                String nowyA = scanner.nextLine();
                m.setAutor(nowyA);
                System.out.println("Autor zmieniony na: " + nowyA);
                break;
            case "gatunek":
                System.out.println("Stary gatunek: " + m.getGatunek());
                System.out.println("Podaj nowy gatunek: ");
                String nowyG = scanner.nextLine();
                m.setGatunek(nowyG);
                System.out.println("gatunek zmieniony na: " + nowyG);
                break;
            case "ulubione":
                if (m.isCzyWUlubionych()) {
                    System.out.println("Piosenka znajduje się w ulubionych, czy chcesz ją usunąć? (tak/nie)");
                    String nowyU = scanner.nextLine();
                    if (nowyU.equalsIgnoreCase("tak")) {
                        m.setCzyWUlubionych(false);
                        System.out.println("Usunięto z ulubionych");
                    } else if (nowyU.equalsIgnoreCase("nie")) {
                        System.out.println("Nie zmieniono statusu piosenki");
                    } else {
                        System.out.println("Coś poszło nie tak");
                    }
                } else {
                    System.out.println("Piosenka nie znajduje się w ulubionych, czy chcesz to zmienić?");
                    String nowyU = scanner.nextLine();
                    if (nowyU.equalsIgnoreCase("tak")) {
                        m.setCzyWUlubionych(true);
                        System.out.println("Dodano do ulubionych");
                    } else if (nowyU.equalsIgnoreCase("nie")) {
                        System.out.println("Nie zmieniono statusu piosenki");
                    } else {
                        System.out.println("Coś poszło nie tak");
                    }
                }
                break;
            default:
                System.out.println("Cos poszlo nie tak, wybierz z: tytul, autor, gatunek, ulubione");
        }
    }

    public static void dodajUtwor(String tytul, String autor, String gatunek, int czasTrwania, LocalDate dataWydania, boolean czyWUlubionych) {
        Muzyka nowyUtwor = new Muzyka(tytul, autor, gatunek, dataWydania, czasTrwania, czyWUlubionych);
    }

    public static void usunUtwor(List<Muzyka> list, String tytul, String autor) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        Iterator<Muzyka> iterator = list.iterator();
        while (iterator.hasNext()) {
            Muzyka m = iterator.next();
            if (m.getAutor().equalsIgnoreCase(autor) && m.getTytul().equalsIgnoreCase(tytul)) {
                iterator.remove();
                System.out.println("usunieto utwor");
            }
        }
    }

    public static List<Muzyka> utworyAutora(List<Muzyka> list, String autor) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.getAutor().equalsIgnoreCase(autor)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static List<Muzyka> utworyGatunku(List<Muzyka> list, String gatunek) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.getGatunek().equalsIgnoreCase(gatunek)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static List<Muzyka> utworyDluzszeNiz(List<Muzyka> list, double czas) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.getCzasTrwania() > (czas * 60)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static List<Muzyka> utworyKrotszeNiz(List<Muzyka> list, double czas) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        List<Muzyka> lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.getCzasTrwania() < (czas * 60)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public static List<Muzyka> utworyWUlubionych(List<Muzyka> list) {
        if (list == null && list.isEmpty())
            throw new IllegalArgumentException("lista nie moze byc nullem ani byc pusta");

        List<Muzyka> ulubione = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.isCzyWUlubionych()) {
                ulubione.add(m);
            }
        }
        return ulubione;
    }

    public static List<Muzyka> wyswietlUtworyStarszeNiz(List<Muzyka> list, int wiek) {
        List<Muzyka> Lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.obliczWiekUtworu() > wiek) {
                Lista.add(m);
            }
        }
        return Lista;
    }

    public static List<Muzyka> wyswietlUtworyMlodszeNiz(List<Muzyka> list, int wiek) {
        List<Muzyka> Lista = new ArrayList<>();
        for (Muzyka m : list) {
            if (m.obliczWiekUtworu() < wiek) {
                Lista.add(m);
            }
        }
        return Lista;
    }

    // metody

    public static void dodajMuzykeDoTestow() {
        dodajUtwor("Bohemian Rhapsody", "Queen", "Rock", 355, LocalDate.parse("1975-10-31"), false);
        dodajUtwor("Shape of You", "Ed Sheeran", "Pop", 233, LocalDate.parse("2017-01-06"), true);
        dodajUtwor("Imagine", "John Lennon", "Rock", 186, LocalDate.parse("1971-09-09"), false);
        dodajUtwor("Billie Jean", "Michael Jackson", "Pop", 295, LocalDate.parse("1983-01-02"), false);
        dodajUtwor("Hotel California", "Eagles", "Rock", 391, LocalDate.parse("1976-02-22"), false);
        dodajUtwor("Like a Rolling Stone", "Bob Dylan", "Rock", 365, LocalDate.parse("1965-07-20"), false);
        dodajUtwor("Hey Jude", "The Beatles", "Rock", 431, LocalDate.parse("1968-08-26"), true);
        dodajUtwor("Uptown Funk", "Mark Ronson ft. Bruno Mars", "Pop", 271, LocalDate.parse("2014-11-10"), false);
        dodajUtwor("Thriller", "Michael Jackson", "Pop", 357, LocalDate.parse("1982-11-30"), false);
        dodajUtwor("Sweet Child O' Mine", "Guns N' Roses", "Rock", 355, LocalDate.parse("1987-08-17"), false);
        dodajUtwor("Smells Like Teen Spirit", "Nirvana", "Grunge", 301, LocalDate.parse("1991-09-10"), false);
        dodajUtwor("Boogie Wonderland", "Earth, Wind & Fire", "Disco", 280, LocalDate.parse("1979-03-20"), true);
        dodajUtwor("Rolling in the Deep", "Adele", "Pop", 228, LocalDate.parse("2010-11-29"), false);
        dodajUtwor("Born to Run", "Bruce Springsteen", "Rock", 274, LocalDate.parse("1975-08-25"), false);
        dodajUtwor("I Want to Hold Your Hand", "The Beatles", "Rock", 153, LocalDate.parse("1963-11-29"), false);
        dodajUtwor("Wonderwall", "Oasis", "Rock", 258, LocalDate.parse("1995-10-30"), false);
        dodajUtwor("Superstition", "Stevie Wonder", "Soul", 240, LocalDate.parse("1972-10-24"), false);
        dodajUtwor("Billie Jean", "Michael Jackson", "Pop", 357, LocalDate.parse("1982-11-30"), false);
        dodajUtwor("Yesterday", "The Beatles", "Rock", 126, LocalDate.parse("1965-08-06"), true);
        dodajUtwor("Boogie Wonderland", "Earth, Wind & Fire", "Disco", 280, LocalDate.parse("1979-03-20"), true);
        dodajUtwor("Dancing Queen", "ABBA", "Disco", 221, LocalDate.parse("1976-08-15"), false);

    }

    // Metoda do wyświetlania informacji o utworze
    @Override
    public String toString() {
        return "Tytuł: " + tytul + ", Autor: " + autor + ", Data wydania: " + dataWydania + "\n";
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

    public double getCzasTrwania() {
        return czasTrwania;
    }

    public boolean isCzyWUlubionych() {
        return czyWUlubionych;
    }

    public void setCzyWUlubionych(boolean czyWUlubionych) {
        this.czyWUlubionych = czyWUlubionych;
    }

    public int obliczWiekUtworu() {
        int aktualnyRok = LocalDate.now().getYear();
        return aktualnyRok - dataWydania.getYear();
    }
}

