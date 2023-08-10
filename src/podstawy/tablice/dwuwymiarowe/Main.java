package iteracja.pierwsza.tablice.dwuwymiarowe;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

//Zadeklaruj tablice dwuwymiarowa 4x6 typu String. Przypisz do niej kilka elementów,
//wypisz jej liczbe wierszy i liczbę kolumn, wypisz jakis przykladowy wyraz Wypisz cała macierz

        System.out.println("Zadanie 1 - tablica dwuwymiarowa");
        String[][] macierz = new String[4][6];

        macierz[0][0] = "kuba";
        macierz[0][1] = "gosia";
        macierz[3][4] = "piesek";

        // wypisz liczbe wierszy w macierzy
        System.out.println("liczba wierszy:" + macierz.length);

        // wypisz liczbe kolumn w macierzy
        System.out.println("liczba kolumn" + macierz[0].length);

        // wypisz przykladowy wyraz
        System.out.println("przykladowy wyraz [3][5] " + macierz[3][5]);

        // wypisz cala macierz
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                System.out.print(macierz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

//Zadeklaruj macierz 6x6 i wypełnij ja liczbami od 10 w gore
//policzyc sume wszystkich elementow w macierzy

        System.out.println("Zadanie 2 - macierz 6x6, suma elementow w macierzy");
        int[][] macierz2 = new int[6][6];

        int licznik = 10;
        for (int i = 0; i < macierz2.length; i++) {
            for (int j = 0; j < macierz2[i].length; j++) {
                macierz2[i][j] = licznik;
                licznik++;
            }
        }

        int suma = 0;
        for (int i = 0; i < macierz2.length; i++) {
            for (int j = 0; j < macierz2[i].length; j++) {
                suma += macierz2[i][j];
            }
        }
        System.out.println(suma);
        System.out.println();

//wypisac powyzsza macierz w odwrotnej kolejnosci

        System.out.println("Zadanie 3 - macierz 6x6 odwrotnie");

        for (int i = macierz2.length - 1; i >= 0; i--) {
            for (int j = macierz2[i].length - 1; j >= 0; j--) {
                System.out.print(macierz2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
//wypisz z powyzszej macierzy przekatna od lewej górnej do prawej dolnej
        System.out.println("Zadanie 4 - przekatna macierzy 6x6");
        for (int i = 0; i < macierz2.length; i++) {
            for (int j = 0; j < macierz2[i].length; j++) {
                if (i == j) {
                    System.out.print(macierz2[i][j] + " ");
                }
            }
        }
        System.out.println();
        System.out.println();

// Stwórzmy macierz 4x4 i wpiszmy do niej liczby podzielne przez 3 zaczynajac od 10
// Wszystkie liczby niepodzielne przez 4 zastąp -1, wypisz cala macierz

        System.out.println("Zadanie 5 - macierz 4x4, zastepowanie liczb");
        int[][] macierz3 = new int[4][4];

        int liczba = 10;
        for (int i = 0; i < macierz3.length; i++) {
            for (int j = 0; j < macierz3[i].length; j++) {
                while (liczba % 3 != 0) {
                    liczba++;
                }
                macierz3[i][j] = liczba;
                liczba += 3;
            }
        }

        // wypisz macierz przed zamiana
        for (int i = 0; i < macierz3.length; i++) {
            for (int j = 0; j < macierz3[i].length; j++) {
                System.out.print(macierz3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < macierz3.length; i++) {
            for (int j = 0; j < macierz3[i].length; j++) {
                if (macierz3[i][j] % 4 != 0) {
                    macierz3[i][j] = -1;
                }
                System.out.print(macierz3[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

//zadeklaruj macierz o wymiarach 5x8, wypelnij ja liczbami losowymi z zakresu
//10-90, znajdz najwieksza i najmniejsza wartosc oraz srednia arytmetyczna
//sprawdz czy wiecej jest liczb mniejszych od 50 czy wiekszych badz rownych 50

        System.out.println("Zadanie 6 - macierz 5x8, liczby losowe");
        int[][] macierz4 = new int[5][8];
        int min = 10;
        int max = 90;

        Random random = new Random();

        for (int i = 0; i < macierz4.length; i++) {
            for (int j = 0; j < macierz4[i].length; j++) {
                macierz4[i][j] = random.nextInt(10, 91); // math.random zwraca liczby z zakresu 0-1
                // Wykorzystujemy tę wartość i mnożymy ją przez (max - min + 1), aby uzyskać liczbę losową z przedziału [0, max - min + 1).
                // Następnie dodajemy min, aby przesunąć przedział do wartości [min, max - min + 1 + min), czyli [min, max + 1).
            }
        }

        // wypisz macierz
        for (int i = 0; i < macierz4.length; i++) {
            for (int j = 0; j < macierz4[i].length; j++) {
                System.out.print(macierz4[i][j] + " ");
            }
            System.out.println();
        }

        znajdzMin(macierz4);
        znajdzMax(macierz4);
        znajdzSrednia(macierz4);
        wiekszeMniejszeRowne(macierz4, 50);

    }

    public static void znajdzMin(int[][] macierz) {
        int min = macierz[0][0];
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                if (macierz[i][j] < min) {
                    min = macierz[i][j];
                }
            }
        }
        System.out.println("Najmniejsza wartosc w macierzy to: " + min);
    }

    public static void znajdzMax(int[][] macierz) {
        int max = macierz[0][0];
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                if (macierz[i][j] > max) {
                    max = macierz[i][j];
                }
            }
        }
        System.out.println("Najwieksza wartosc w macierzy to: " + max);
    }

    public static void znajdzSrednia(int[][] macierz) {
        int suma = 0;
        int licznik = 0;
        double srednia = 0;
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                suma += macierz[i][j];
                licznik++;
            }
        }
        srednia = (double) suma / licznik;
        System.out.println("Srednia wartosc w macierzy to: " + srednia);
    }

    public static void wiekszeMniejszeRowne(int[][] macierz, int liczba) {
        int wieksze = 0;
        int mniejsze = 0;
        int rowne = 0;

        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                if (macierz[i][j] >= liczba) {
                    wieksze++;
                } else {
                    mniejsze++;
                }
            }
        }

        System.out.println("Liczba większych: " + wieksze);
        System.out.println("Liczba mniejszych: " + mniejsze);
        System.out.println("Liczba równych: " + rowne);
    }

}
