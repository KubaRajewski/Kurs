package metody.i.kolekcje.mapy;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Stwórz HashMapę, w której kluczami będą imiona (String), a wartościami będą wieki (Integer) osób. Dodaj do niej kilka par imię-wiek.
/*
        HashMap<String, Integer> ludzie = new HashMap<String, Integer>();

        ludzie.put("Maciek", 3);
        ludzie.put("Gosia", 19);
        ludzie.put("Kuba", 20);
        ludzie.put("Asia", 33);


        System.out.println("Cała hashmapa");
        System.out.println(ludzie);
        System.out.println();
        System.out.println("Tylko klucze");
        wyswietlKlucze(ludzie);
        System.out.println();
        System.out.println("Tylko wartosci");
        wyswietlWartosci(ludzie);
        System.out.println();

        System.out.println("ile ma lat");
        ileMaLat(ludzie, "Maciek");
        System.out.println();
*/
        // Stwórz metodę, która jako parametr przyjmuje listę Stringów i zwraca mapę, gdzie kluczem jest unikalne imię,
        // a wartością jest liczba wystąpień tego imienia w liście.

        List<String> imiona = new ArrayList<>();

        imiona.add("gozia");
        imiona.add("gosia");
        imiona.add("piłka");
        imiona.add("Kuba");
        imiona.add("ksawery");
        imiona.add("marcin");
        imiona.add("Kuba");
        imiona.add("mikolaj");
        imiona.add("mariusz");
        imiona.add("Kubba");
        imiona.add("gosiaa");
        imiona.add("gosiaa");
        imiona.add("gosiaa");

        System.out.println("Zadanie 1 - ile imion");
        System.out.println("imiona: " + imiona);
        System.out.println("Output: " + liczbaImion(imiona));
        System.out.println();


        // Napisz funkcję, która jako parametr przyjmuje listę liczb całkowitych i zwraca mapę, gdzie kluczem jest liczba,
        // a wartością jest lista indeksów, pod którymi ta liczba występuje w oryginalnej liście.

        List<Integer> Liczby = new ArrayList<>();

        Liczby.add(16);
        Liczby.add(2);
        Liczby.add(4);
        Liczby.add(36);
        Liczby.add(10);
        Liczby.add(1);
        Liczby.add(7);
        Liczby.add(10);
        Liczby.add(4);
        Liczby.add(5);
        Liczby.add(3);
        System.out.println("Zadanie 2 - indeksy liczb");
        System.out.println("Liczby: " + Liczby);
        System.out.println("Output: " + indeksyLiczb(Liczby));
        System.out.println();

        // Stwórz funkcję, która jako parametr przyjmuje listę Stringów i zwraca mapę, gdzie kluczem
        // jest pierwsza litera każdego imienia (jako String), a wartością jest lista imion rozpoczynających się tą literą.

        System.out.println("Zadanie 3 - imiona od litery");
        System.out.println("imiona: " + imiona);
        System.out.println("output: " + ImionaOdLitery(imiona));
        System.out.println();

        // Napisz metodę, która jako parametr przyjmuje mapę z wartościami numerycznymi i zwraca nową mapę, gdzie kluczem
        // jest liczba z pierwotnej mapy, a wartością jest jej pierwiastek kwadratowy zaokrąglony do dwóch miejsc po przecinku.

        System.out.println("Zadanie 4 - pierwiastek kwadratowy");
        HashMap<Integer, Integer> liczby2 = new HashMap<>();
        liczby2.put(1, 1);
        liczby2.put(2, 16);
        liczby2.put(3, 36);
        liczby2.put(4, 64);
        liczby2.put(5, 36);
        liczby2.put(6, 256);

        System.out.println("Liczby: " + liczby2);
        System.out.println("Output: " + pierwiastekKwadratowy(liczby2));
        System.out.println();

        // Stwórz funkcję, która jako parametr przyjmuje listę liczb całkowitych i zwraca mapę, gdzie kluczem jest liczba,
        // a wartością jest informacja, czy liczba jest liczbą pierwszą.

        System.out.println("Zadanie 5 - czy liczba jest pierwsza");
        System.out.println("Liczby: " + Liczby);
        System.out.println("Output: " + czyPierwsza(Liczby));
        System.out.println();

        // Napisz metodę, która jako parametr przyjmuje listę Stringów reprezentujących nazwy kolorów (np. "czerwony", "zielony", "niebieski")
        // i zwraca mapę, gdzie kluczem jest kolor, a wartością jest liczba jego wystąpień.

        System.out.println("Zadanie 6 - ile kolorow");
        List<String> kolory = new ArrayList<>();
        kolory.add("czerwony");
        kolory.add("zielony");
        kolory.add("niebieski");
        kolory.add("czerwony");
        kolory.add("czerwony");
        kolory.add("niebieski");
        kolory.add("czerwony");
        kolory.add("zielony");
        kolory.add("niebieski");

        System.out.println("Kolory: " + kolory);
        System.out.println("Output: " + ileKolorow(kolory));
        System.out.println();

        // Napisz metodę, która jako parametr przyjmuje listę Stringów i zwraca mapę, gdzie kluczem jest imię, a wartością
        // jest zbiór liter występujących w danym imieniu (bez powtórzeń).

        System.out.println("Zadanie 7 - zbior liter");
        System.out.println("imiona: " + imiona);
        System.out.println("Output: " + literyImion(imiona));
        System.out.println();

        // Stwórz funkcję, która jako parametr przyjmuje mapę z wartościami liczbowymi i zwraca listę wartości,
        // które są liczbami pierwszymi.

        System.out.println("Zadanie 8 - liczby pierwsze");
        System.out.println("Liczby: " + liczby2);
        System.out.println("Output: " + liczbyPierwsze(liczby2));
        System.out.println();

        // Napisz metodę, która jako parametr przyjmuje mapę zawierającą imiona jako klucze i wiek jako wartości,
        // a następnie zwraca nową mapę, gdzie kluczem jest imię osoby, a wartością jest jej wiek podniesiony do kwadratu.

        System.out.println("Zadanie 9 - wiek do kwadratu");
        HashMap<String, Integer> wiek = new HashMap<>();
        wiek.put("Jan", 20);
        wiek.put("Anna", 30);
        wiek.put("Kasia", 40);
        wiek.put("Piotr", 50);
        wiek.put("Marek", 60);
        wiek.put("Krzysztof", 70);
        wiek.put("Tomek", 80);
        wiek.put("Kamil", 90);
        wiek.put("Kuba", 100);
        wiek.put("Ola", 110);

        System.out.println("Wiek: " + wiek);
        System.out.println("Output: " + wiekDoKwadratu(wiek));
        System.out.println();

        // Napisz metoda która dodaje słowa do mapy. Kluczem maja byc kolejen liczby
        // naturalne zaczynajac od 0.

        HashMap<Integer, String> imiona2 = new HashMap<>();
//        imiona2.put(0, "Jan");
//        imiona2.put(1, "Anna");
//        imiona2.put(2, "Kasia");
//        imiona2.put(3, "Piotr");
        System.out.println("Zadanie 10 - dodawanie slow do mapy");
        System.out.println("Imiona: " + imiona2);
        System.out.println("Output: " + dodajSlowo(imiona2, "Basia"));
        System.out.println();

        // Napisz metode ktora pozwala dodawac do mapy kolejne wyrazy. Na koncu ma
        // wyswietlic ile razy jaki s byl dodany

        System.out.println("Zadanie 11 - dodawanie slow do mapy");
        HashMap<String, Integer> mapa = (HashMap<String, Integer>) dodajWyrazy();
        System.out.println(mapa);
        System.out.println();

        // Napisz program, ktory losuje liczby w duzym lotku bez powtorzen, zakres liczb 1-45

        System.out.println("Zadanie 12 - losowanie liczb");
        System.out.println("Output: " + duzyLotek());

        // napisz metode ktora przyjmuje Mape<Integer, String>, zamien wartosci ktorych
        // klucze sa parzystych wartosci na słowo "parzyste"

        System.out.println("Zadanie 13 - zamiana wartosci");
        HashMap<Integer, String> mapa2 = new HashMap<>();
        mapa2.put(0, "Jan");
        mapa2.put(1, "Anna");
        mapa2.put(2, "Kasia");
        mapa2.put(3, "Piotr");
        mapa2.put(4, "Marek");
        mapa2.put(5, "Krzysztof");
        mapa2.put(6, "Tomek");
        mapa2.put(7, "Kamil");
        mapa2.put(8, "Kuba");
        mapa2.put(9, "Ola");
        System.out.println("Mapa: " + mapa2);
        System.out.println("Output: " + zamienParzyste(mapa2));
        System.out.println();

        // Napisz program, ktory symuluje dzialanie slownika
        // polsko-angielskiego. Przykładowy program: Podaj slowko po Polsku: mama Slowko
        // po Angielsku to mother. Program dziala dopoki uzytkownik nie zrezygnuje (cancel)

        System.out.println("Słownik: " + utworzSlownik());
        System.out.println();


        // W systemie przechowujemy nazwe klasy (szkolnej, np 1a, 2b) oraz listę osób
        // (same nazwiska jako Stringi) które uczeszczaja do klasy.

        List<String> klasa1a = List.of("Kowalski", "Nowak", "Wisniewski", "Wojcik", "Kowalczyk",
                "Kaminski", "Lewandowski", "Zielinski", "Szymanski", "Wozniak", "Dabrowski",
                "Kozlowski", "Jankowski", "Mazur", "Wojciechowski", "Kwiatkowski", "Krawczyk",
                "Piotrowski", "Grabowski", "Nowakowski");


        List<String> klasa1b = List.of("Pawlak", "Michalski", "Adamczyk", "Nowicki", "Dudek", "Zajac",
                "Wieczorek", "Jablonski", "Krol", "Majewski", "Olszewski", "Jaworski", "Wrobel", "Malinowski",
                "Pawlak", "Witkowski", "Walczak", "Stepien", "Gorski", "Rutkowski");

        List<String> klasa1c = List.of("Michalak", "Sikora", "Nowicka", "Kaczmarek", "Zalewski", "Wojcik",
                "Swiderski", "Borkowski", "Czarnecki", "Szymczak", "Jakubowski", "Piekarski", "Tomczak", "Wroblewski",
                "Marciniak", "Zawadzki", "Kubiak", "Szewczyk", "Brzezinski", "Bartoszewska");

        // 1) Napisz metode ktora zwraca liste osob o najdluzszych nazwiskach z kazdej klasy
        System.out.println("Najdluższe nazwiska w klasie 1a: " + najdluzszeImionaWKlasach(klasa1a, 3));
        System.out.println("Najdluższe nazwiska w klasie 1b: " + najdluzszeImionaWKlasach(klasa1b, 3));
        System.out.println("Najdluższe nazwiska w klasie 1c: " + najdluzszeImionaWKlasach(klasa1c, 3));

        // 2) Napisz metode która zwraca osobe o najdluzszym nazwisku ze wzystkich klas
//        System.out.println("Najdluższe imie w szkole: " + znajdzNajdluzszyString(klasa1a, klasa1b, klasa1c));
        System.out.println(najdluzszeImiona(klasa1a, klasa1b, klasa1c));

    }


    // Napisz metodę, która dla danej HashMapy wyświetli wszystkie klucze (imiona) znajdujące się w niej.
    public static void wyswietlKlucze(HashMap<String, Integer> hashMap) {
        System.out.println(hashMap.keySet());
    }

    // Napisz metodę, która dla danej HashMapy wyświetli wszystkie wartości (wiek) znajdujące się w niej.
    public static void wyswietlWartosci(HashMap<String, Integer> hashMap) {
        System.out.println(hashMap.values());
    }

    public static int ileMaLat(HashMap<String, Integer> hashMap, String imie) {
        System.out.println(hashMap.get(imie));
        return hashMap.get(imie);
    }


//    Stwórz metodę, która jako parametr przyjmuje listę Stringów i zwraca mapę, gdzie kluczem jest unikalne imię,
//    a wartością jest liczba wystąpień tego imienia w liście.

    public static HashMap<String, Integer> liczbaImion(List<String> imiona) {
        HashMap<String, Integer> liczbaImion = new HashMap<>();

        for (String imie : imiona) {
            if (liczbaImion.containsKey(imie)) {
                int count = liczbaImion.get(imie);
                liczbaImion.put(imie, count + 1);
            } else {
                liczbaImion.put(imie, 1);
            }
        }
        return liczbaImion;
    }

//    Napisz funkcję, która jako parametr przyjmuje listę liczb całkowitych i zwraca mapę, gdzie kluczem jest liczba,
//    a wartością jest lista indeksów, pod którymi ta liczba występuje w oryginalnej liście.

    public static HashMap<Integer, List<Integer>> indeksyLiczb(List<Integer> Liczby) {
        HashMap<Integer, List<Integer>> indeksyLiczb = new HashMap<>();

        for (Integer i : Liczby) {  // i = 1
            List<Integer> indeksy = new ArrayList<>(); // tworzymy nowa liste dla 1
            for (int j = 0; j < Liczby.size(); j++) {  // znowu iterujemy przez wszystkie liczby
                if (i == Liczby.get(j)) { // szukamy takich samych liczb
                    indeksy.add(j); // jesli liczba jest taka sama jak i dodajemy ja do listy indeksow dla jedynki
                }
            }
            indeksyLiczb.put(i, indeksy); // wstawiamy do mapy jedynke i liste indeksow
        }
        return indeksyLiczb;
    }

//    Stwórz funkcję, która jako parametr przyjmuje listę Stringów i zwraca mapę, gdzie kluczem
//    jest pierwsza litera każdego imienia (jako String), a wartością jest lista imion rozpoczynających się tą literą.

    public static HashMap<String, List<String>> ImionaOdLitery(List<String> imiona) {
        HashMap<String, List<String>> imionaOdLitery = new HashMap<>();

        for (String imie : imiona) {
            List<String> imionaOd = new ArrayList<>();
            for (String i : imiona) {
                if (imie.charAt(0) == i.charAt(0)) {
                    imionaOd.add(i);
                }
            }
            imionaOdLitery.put(String.valueOf(imie.charAt(0)), imionaOd);
        }

        return imionaOdLitery;
    }

//    Napisz metodę, która jako parametr przyjmuje mapę z wartościami numerycznymi i zwraca nową mapę, gdzie kluczem
//    jest liczba z pierwotnej mapy, a wartością jest jej pierwiastek kwadratowy zaokrąglony do dwóch miejsc po przecinku.

    public static HashMap<Integer, Double> pierwiastekKwadratowy(HashMap<Integer, Integer> liczby) {
        HashMap<Integer, Double> pierwiastekKwadratowy = new HashMap<>();

        for (Integer i : liczby.keySet()) {
            pierwiastekKwadratowy.put(i, Math.sqrt(liczby.get(i)));
        }
        return pierwiastekKwadratowy;
    }


//    Stwórz funkcję, która jako parametr przyjmuje listę liczb całkowitych i zwraca mapę, gdzie kluczem jest liczba,
//    a wartością jest informacja, czy liczba jest liczbą pierwszą.

    public static HashMap<Integer, Boolean> czyPierwsza(List<Integer> liczby) {
        HashMap<Integer, Boolean> czyPierwsza = new HashMap<>();

        for (Integer i : liczby) {
            Boolean pierwsza = false;

            // warunek czy liczba jest pierwsza
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    pierwsza = false;
                    break;
                } else {
                    pierwsza = true;
                }
            }
            czyPierwsza.put(i, pierwsza);
        }

        return czyPierwsza;
    }

//    Napisz metodę, która jako parametr przyjmuje listę Stringów reprezentujących nazwy kolorów (np. "czerwony", "zielony", "niebieski")
//    i zwraca mapę, gdzie kluczem jest kolor, a wartością jest liczba jego wystąpień.

    public static HashMap<String, Integer> ileKolorow(List<String> kolory) {
        HashMap<String, Integer> Kolory = new HashMap<>();

        for (String kolor : kolory) {
            if (Kolory.containsKey(kolor)) {
                int count = Kolory.get(kolor);
                Kolory.put(kolor, count + 1);
            } else {
                Kolory.put(kolor, 1);
            }
        }

        return Kolory;
    }


//    Stwórz funkcję, która jako parametr przyjmuje listę liczb całkowitych i zwraca mapę, gdzie kluczem jest liczba,
//    a wartością jest informacja, czy jest ona liczbą parzystą.

    public static HashMap<Integer, Boolean> czyParzysta(List<Integer> liczby) {
        HashMap<Integer, Boolean> czyParzysta = new HashMap<>();

        for (Integer i : liczby) {
            if (i % 2 == 0) {
                czyParzysta.put(i, true);
            } else {
                czyParzysta.put(i, false);
            }
        }

        return czyParzysta;
    }

//    Napisz metodę, która jako parametr przyjmuje listę Stringów i zwraca mapę, gdzie kluczem jest imię, a wartością
//    jest zbiór liter występujących w danym imieniu (bez powtórzeń).

    public static HashMap<String, Set<Character>> literyImion(List<String> imiona) {
        HashMap<String, Set<Character>> literyImion = new HashMap<>();

        for (String imie : imiona) {
            Set<Character> litery = new HashSet<>();
            for (int i = 0; i < imie.length(); i++) {
                litery.add(imie.charAt(i));
            }
            literyImion.put(imie, litery);
        }

        return literyImion;
    }

//    Stwórz funkcję, która jako parametr przyjmuje mapę z wartościami liczbowymi i zwraca listę wartości,
//    które są liczbami pierwszymi.

        public static List<Integer> liczbyPierwsze(HashMap<Integer, Integer> liczby) {
            List<Integer> liczbyPierwsze = new ArrayList<>();

            for (Integer i : liczby.keySet()) {
                Boolean pierwsza = false;

                // warunek czy liczba jest pierwsza
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        pierwsza = false;
                        break;
                    } else {
                        pierwsza = true;
                    }
                }
                if (pierwsza) {
                    liczbyPierwsze.add(i);
                }
            }

            return liczbyPierwsze;
        }

//    Napisz metodę, która jako parametr przyjmuje mapę zawierającą imiona jako klucze i wiek jako wartości,
//    a następnie zwraca nową mapę, gdzie kluczem jest imię osoby, a wartością jest jej wiek podniesiony do kwadratu.

        public static Map<String, Integer> wiekDoKwadratu(HashMap<String, Integer> wiek) {
            Map<String, Integer> wiekDoKwadratu = new HashMap<>();

            for (String imie : wiek.keySet()) {
                wiekDoKwadratu.put(imie, wiek.get(imie) * wiek.get(imie));
            }

            return wiekDoKwadratu;
        }

    // Napisz metoda która dodaje słowa do mapy. Kluczem maja byc kolejen liczby
    // naturalne zaczynajac od 0.

    public static Map<Integer, String> dodajSlowo(HashMap<Integer, String> mapa, String slowo) {
        mapa.put(mapa.size(), slowo);
        return mapa;
    }

    // Napisz metode ktora pozwala dodawac do mapy kolejne wyrazy. Na koncu ma
    // wyswietlic ile razy jaki s byl dodany

    public static Map<String, Integer> dodajWyrazy() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mapa = new HashMap<>();

        String slowo;
        do {
            System.out.print("Podaj słowo (wpisz 'koniec' aby zakończyć): ");
            slowo = scanner.nextLine();
            if (!slowo.equalsIgnoreCase("koniec")) {
                mapa.put(slowo, mapa.getOrDefault(slowo, 0) + 1);
            }
        } while (!slowo.equalsIgnoreCase("koniec"));

        return mapa;
    }


    // Napisz program, ktory losuje liczby w duzym lotku bez powtorzen, zakres liczb 1-45

    public static List<Integer> duzyLotek() {
        List<Integer> liczby = new ArrayList<>();
        Random random = new Random();

        while (liczby.size() < 6) {
            int losowaLiczba = random.nextInt(45) + 1;
            if (!liczby.contains(losowaLiczba)) {
                liczby.add(losowaLiczba);
            }
        }

        return liczby;
    }

    // napisz metode ktora przyjmuje Mape<Integer, String>, zamien wartosci ktorych
    // klucze sa parzystych wartosci na słowo "parzyste"

    public static HashMap<Integer, String> zamienParzyste(HashMap<Integer, String> mapa) {
        HashMap<Integer, String> nowaMapa = new HashMap<>();

        for (Integer i : mapa.keySet()) {
            if (i % 2 == 0) {
                nowaMapa.put(i, "parzyste");
            } else {
                nowaMapa.put(i, mapa.get(i));
            }
        }

        return nowaMapa;
    }

    // Napisz program, ktory symuluje dzialanie slownika
    // polsko-angielskiego. Przykładowy program: Podaj slowko po Polsku: mama Slowko
    // po Angielsku to mother. Program dziala dopoki uzytkownik nie zrezygnuje (cancel)

    public static Map<String, String> utworzSlownik() {
        Map<String, String> slownik = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w słowniku polsko-angielskim!");

        while (true) {
            System.out.print("Podaj słowo po Polsku (lub wpisz 'cancel' aby zrezygnować): ");
            String slowoPolskie = scanner.nextLine();

            if (slowoPolskie.equalsIgnoreCase("cancel")) {
                System.out.println("Zrezygnowano z korzystania ze słownika.");
                break;
            }

            if (slownik.containsKey(slowoPolskie)) {
                System.out.println("To słowo już istnieje w słowniku.");
            } else {
                System.out.print("Podaj tłumaczenie słowa '" + slowoPolskie + "' po Angielsku: ");
                String slowoAngielskie = scanner.nextLine();
                slownik.put(slowoPolskie, slowoAngielskie);
                System.out.println("Dodano nowe tłumaczenie do słownika.");
            }
        }
        return slownik;
    }

    // W systemie przechowujemy nazwe klasy (szkolnej, np 1a, 2b) oraz listę osób
    // (same nazwiska jako Stringi) które uczeszczaja do klasy.

//    // 1) Napisz metode ktora zwraca liste osob o najdluzszych nazwiskach z kazdej klasy
//    public static String najdluzszyString(List<String> list){
//        String najdluzszy = "";
//        for (String s : list) {
//            if (s.length() > najdluzszy.length()) {
//                najdluzszy = s;
//            }
//        }
//        return najdluzszy;
//    }
//
//    public static List<String> najdluzszeImiona(Map<String, List<String>> mapa) {
//        List<String> najdluzszeImiona = new ArrayList<>();
//
//        for (List<String> list : mapa.values()) {
//            najdluzszeImiona.add(najdluzszyString(list));
//        }
//        return najdluzszeImiona;
//    }
//
//    //   2) Napisz metode która zwraca osobe o najdluzszym nazwisku ze wzystkich klas
//    public static String najdluzszeNazwisko (Map<String, List<String>> mapa) {
//        return najdluzszyString(najdluzszeImiona(mapa));
//    }



    public static List<String> najdluzszeImionaWKlasach(List<String> klasa, int limit) {
        List<String> Najdluzsze = new ArrayList<>(limit);

        List<String> klasaCopy = new ArrayList<>(klasa);

        for (int i = 0; i < limit; i++) {
            String najdluzsze = "";
            for (String s : klasaCopy) {
                if (s.length() > najdluzsze.length()) {
                    najdluzsze = s;
                }
            }
            Najdluzsze.add(najdluzsze);
            klasaCopy.remove(najdluzsze);
        }
        return Najdluzsze;
    }


    public static List<String> najdluzszeImiona(List<String>... lists) {
        List<String> najdluzszeImiona = new ArrayList<>();
        int maks = 0;

        for (List<String> list : lists) {
            for (String str : list) {
                if (str.length() > maks) {
                    najdluzszeImiona.clear();
                    najdluzszeImiona.add(str);
                    maks = str.length();
                } else if (str.length() == maks) {
                    najdluzszeImiona.add(str);
                }
            }
        }

        return najdluzszeImiona;
    }
}