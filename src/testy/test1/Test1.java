package testy.test1;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
//      TODO Zadanie 01:
//      wypisz wszystkie liczby 3 cyfrowe ktorych suma cyfr dziesiatek i setek jest rowna cyfrze jednosci. np: 314 bo 3+1=4
        System.out.println("Liczby trzycyfrowe ktorych suma cyfr dziesiatek i setek jest rowna cyfrze jednosci: \n" + cyfry() + "\n");

//      TODO Zadanie 02:
//      dla każdej liczby dwucyfrowej wypisz jej ilosc dzielników.
        System.out.println("Liczby dwucyfrowe i ich ilość dzielników (Liczba = Ilość Dzielników): \n" + liczbyIIloscIchDzielnikow() + "\n");

//      TODO Zadanie 03:
//      Poproś użytkownika o podanie 10ciu roznych napisów
//      Wpisz je wszystkie do tablicy a następnie:
//      - wypisz najdłuższy napis i ile ma znaków.
//      - wypisz najkrótszy napis i ile ma znaków.
//      - wypisz ile jest palindromów wśród napisów.
//      (palindrom to taki wyraz czytany od tyłu jest taki sam jak czytany od przodu np: kajak) [podczas porownania ignoruj wielkosc liter]
        String[] napisy = pobierzNapisy(10);
        System.out.println("Napisy: " + Arrays.toString(napisy) + "\n");
        System.out.println("Najdluzszy napis: " + najdluzszyNapis(napisy) + "\n");
        System.out.println("Najkrotszy napis: " + najkrotszyNapis(napisy) + "\n");
        System.out.println("Ilość palidromow: " + iloscPalidromow(napisy) + "\n");

//      TODO Zadanie 04:
//      Zapytaj użytkownika o liczby rozdzielone spacją, następnie:
//      - wypisz medianę wprowadzonych liczb.
//      - wypisz liczbę z największą ilością dzielników.
//      - wypisz wszystkie liczby pierwsze.
        List<Integer> liczby = pobierzLiczby();
        System.out.println("\nMediana: " + policzMediane(liczby) + "\n");
        System.out.println("Liczba z największą ilością dzielników: " + najwiecejDzielnikow(liczby) + "\n");
        System.out.println("Liczby pierwsze: " + liczbyPierwsze(liczby) + "\n");
    }

    private static List<Integer> cyfry() {
        List<Integer> cyfry = new ArrayList<>();
        for (int i = 100; i < 1000; i++) {
            int jednosci = i % 10;
            int dziesiatki = (i / 10) % 10;
            int setki = i / 100;

            if (dziesiatki + setki == jednosci) {
                cyfry.add(i);
            }
        }
        return cyfry;
    }

    private static Map<Integer, Integer> liczbyIIloscIchDzielnikow() {
        Map<Integer, Integer> liczbyIIloscIchDzielnikow = new HashMap<>();

        for (int i = 10; i < 100; i++) {
            int iloscDzielnikow = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    iloscDzielnikow++;
                }
            }
            liczbyIIloscIchDzielnikow.put(i, iloscDzielnikow);
        }
        return liczbyIIloscIchDzielnikow;
    }

    private static String[] pobierzNapisy(Integer iloscNapisow) {
        String[] napisy = new String[iloscNapisow];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < iloscNapisow; i++) {
            System.out.println("Podaj napis nr " + (i + 1) + ": ");
            String napis = scanner.nextLine();

            while (napis.isEmpty() || napis.isBlank()) {
                System.out.println("Napis nie może być pusty. Podaj napis nr " + (i + 1) + " ponownie: ");
                napis = scanner.nextLine();
            }

            for (String s : napisy) {
                if (s != null && s.equalsIgnoreCase(napis)) {
                    System.out.println("Napis nie może się powtarzać. Podaj napis nr " + (i + 1) + " ponownie: ");
                    napis = scanner.nextLine();
                }
            }

            napisy[i] = napis;
        }
        return napisy;
    }

    private static String najdluzszyNapis(String[] napisy) {
        String najdluzszyNapis = napisy[0];
        for (String s : napisy) {
            if (s.length() > najdluzszyNapis.length()) {
                najdluzszyNapis = s;
            }
        }
        return najdluzszyNapis;
    }

    private static String najkrotszyNapis(String[] napisy) {
        String najkrotszyNapis = napisy[0];
        for (String s : napisy) {
            if (s.length() < najkrotszyNapis.length()) {
                najkrotszyNapis = s;
            }
        }
        return najkrotszyNapis;
    }

    private static int iloscPalidromow(String[] napisy) {
        int iloscPalindromow = 0;
        for (String s : napisy) {
            if (s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())) {
                iloscPalindromow++;
            }
        }
        return iloscPalindromow;
    }

    private static List<Integer> pobierzLiczby() {
        List<Integer> liczby = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj co najmniej dwie liczby rozdzielone spacją: ");
            String input = scanner.nextLine();

            String[] inputArray = input.split(" ");

            boolean czyPoprawne = true;
            for (String s : inputArray) {
                try {
                    int num = Integer.parseInt(s);
                    liczby.add(num);
                } catch (NumberFormatException e) {
                    czyPoprawne = false;
                    break;
                }
            }

            if (czyPoprawne && liczby.size() >= 2) {
                break;
            } else {
                System.out.println("Nieprawidłowy format danych lub za mało liczb");
                liczby.clear();
            }
        }
        return liczby;
    }

    private static double policzMediane(List<Integer> liczby) {
        Collections.sort(liczby);
        if (liczby.size() % 2 == 0) {
            return (liczby.get(liczby.size() / 2) + liczby.get(liczby.size() / 2 - 1)) / 2.0;
        } else {
            return liczby.get(liczby.size() / 2);
        }
    }

    private static int policzDzielniki(int liczba) {
        int dzielniki = 0;
        for (int i = 1; i <= liczba; i++) {
            if (liczba % i == 0) {
                dzielniki++;
            }
        }
        return dzielniki;
    }

    private static int najwiecejDzielnikow(List<Integer> liczby) {
        int najwiecejDzielnikow = liczby.get(0);
        for (int liczba : liczby) {
            if (policzDzielniki(liczba) > policzDzielniki(najwiecejDzielnikow)) {
                najwiecejDzielnikow = liczba;
            }
        }
        return najwiecejDzielnikow;
    }

    private static boolean czyPierwsza(int liczba) {
        if (liczba < 2) {
            return false;
        }
        for (int i = 2; i < liczba; i++) {
            if (liczba % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> liczbyPierwsze(List<Integer> liczby) {
        List<Integer> liczbyPierwsze = new ArrayList<>();
        for (int liczba : liczby) {
            if (czyPierwsza(liczba)) {
                liczbyPierwsze.add(liczba);
            }
        }
        return liczbyPierwsze;
    }
}