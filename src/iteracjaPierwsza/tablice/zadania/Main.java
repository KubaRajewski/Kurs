package tablice.zadania;

public class Main {
    public static void main(String[] args) {

// zadeklaruj tablicę długosci 20 i przypisz do niej liczby od 1 do 20

        int[] tablica = new int[20];

        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = i + 1;
        }
        System.out.println();

// wypiszmy te tablice odwrotnie, czyli od 20 do 1

        for (int i = tablica.length - 1; i >= 0; i--) {
            System.out.print(tablica[i] + " ");
        }

        System.out.println();

// wypiszmy liczby od 1 do 20 ale oddzielone przecinkiem

        for (int i = 1; i <= 20; i++) {
            System.out.print(i);
            if (i < 20) {
                System.out.print(", ");
            }
        }
        System.out.println();

// wypiszmy te liczby które sa parzyste z tej tablicy

        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] % 2 == 0) {
                System.out.print(tablica[i] + " ");
            }
        }
        System.out.println();

// Oblicz sume elementow tablicy doubli ale tylko tych ktore sa wieksze niz 3.8

        double sum = 0;
        double[] tablicaDouble = {1.45, 67.23, 8.8, 2.45, 4.9, 3.8, 4.7, 22.67, 5.67, 12.6, 2.4, 4.6, 5.7, 3.9, 3.5};
        for (int i = 0; i < tablicaDouble.length; i++) {
            if (tablicaDouble[i] > 3.8) {
                sum = sum + tablicaDouble[i];
            }
        }
        System.out.println("suma wynosi: " + sum);

// oblicz sumę elementów ktore sa podzielne przez 3

        int sum2 = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] % 3 == 0) {
                sum2 = sum2 + tablica[i];
            }
        }
        System.out.println("suma elementow podzielnych przez 3 wynosi: " + sum2);

// Oblicz sume elementow ale tylko tych ktore stoja na nieparzystych indeksach

        double sum3 = 0;
        for (int i = 1; i < tablica.length; i += 2) {
            sum3 += tablica[i];
        }

        System.out.println("Suma elementów na nieparzystych indeksach: " + sum3);
    }
}

