package iteracja.pierwsza.tablice.jednowymiarowe.zadaniaPDF;

public class Main {
    public static void main(String[] args) {

// Napisz program, który dla danej tablicy intów oblicza sumę elementów tej tablicy
        System.out.println("Zadanie 1 - oblicz sume elementow tablicy");

        int[] table = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        int sum = 0;
        for (int i : table) {
            sum = sum + table[i];
        }
        System.out.println(sum);
        System.out.println();

// Oblicz iloczyn liczb podanych w tablicy intów
        System.out.println("Zadanie 2 - oblicz iloczyn elementow tablicy");

        int[] t5 = {1, 2, 3, 6};

        int iloczyn = 1;

        for (int i = 0; i < t5.length; i++) {
            iloczyn *= t5[i];
        }
        System.out.println(iloczyn);
        System.out.println();

// Napisz program, który dla danej tablicy intów długości 3 wyświetli tablicę 2 razy dłuższą,
// wypełnioną wartością 0 poza ostatnim elementem, ostatni element tablicy ma mieć wartość odpowiadającą długości tablicy.
        System.out.println("Zadanie 3 - tablice dwa razy dluzsza wypelniona zerami poza ostatnim elementem");

//                                      {4, 5, 6} → {0, 0, 0, 0, 0, 6}

        int[] t = {4, 5, 6, 9};

        int[] dluzsza = new int[t.length * 2];
        dluzsza[dluzsza.length - 1] = dluzsza.length;
        for (int i = 0; i < dluzsza.length; i++) {
            System.out.print(dluzsza[i] + " ");
        }
        System.out.println();
        System.out.println();

// Napisz program, który dla danej tablicy intów zwraca sume elementów po lewej od zadanego indeksu. Np. dla danych:
// {1,2,3,4,5} i indeksu = 2 suma wynosi 3 bo 1 + 2 = 3
        System.out.println("Zadanie 4 - suma elementow po lewej od zadanego indeksu");

        int[] t3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int indx = 2;
        int sum3 = 0;

        for (int i = 0; i < indx; i++) {
            sum3 += t3[i];
        }
        System.out.println(sum3);
        System.out.println();

// Zadeklaruj tablice stringów dlugosci 4, dodaj do niej 4 wyrazy.
// W pętli przypisz każdy wyraz do wcześniej utworzonej zmiennej typu String. Wyświetl tą zmienną.
        System.out.println("Zadanie 5 - tablica stringow");

        String[] words = {"pies", "kot", "wiewiorka", "zegarek"};
        String result = "";


        for (int i = 0; i < words.length; i++) {
            result += words[i] + " ";
        }

        System.out.println(result);
        System.out.println();


// Zadeklaruj dwie tablice intów róznej długości. Przypisz obu na indeksie 0 jakąś liczbę.
// Wyświetl tę tablicę, która jest dłuzsza (oczywiscie zmiana długosci danej tablicy powinna wpływać na wypisanie tablic).
        System.out.println("Zadanie 6 - dwie tablice intow roznej dlugosci");

        int[] table1 = new int[5];
        int[] table2 = new int[10];

        table1[0] = 12;
        table2[0] = 5;

        if (table1.length > table2.length) {
            drukujTablice(table1);
        } else if (table1.length == table2.length) {
            System.out.println("tablice sa tej samej dlugosci");
        } else {
            drukujTablice(table2);
        }


// Dla podanej tablicy intow oblicz czy więcej jest elementów dodatnich czy podzielnych przez 3
        System.out.println("Zadanie 7 - wiecej elementow dodatnich czy podzielnych przez 3");

        int[] t4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int podzielne = 0;
        int dodatnie = 0;

        for (int i = 0; i < t4.length; i++) {
            if (t4[i] > 0) {
                dodatnie = dodatnie + 1;
            }
            if (t4[i] % 3 == 0) {
                podzielne = podzielne + 1;
            }
        }


        if (dodatnie > podzielne) {
            System.out.println("liczb dodatnich jest wiecej niz liczb podzielnych przez 3, " +
                    "Liczby dodatnie: " + dodatnie + ", liczby podzielne przez 3: " + podzielne);
        } else if (dodatnie == podzielne) {
            System.out.println("liczb dodatnich jest tyle samo co podzielnych przez 3: " + dodatnie);
        } else {
            System.out.println("liczb podzielnych przez 3 jest wiecej niz liczb dodatnich, liczby podzielne przez 3: " + podzielne
                    + "liczby dodatnie: " + dodatnie);
        }
        System.out.println();

// Z podanej tablicy Stringów wypisz te których długość jest większ niż 7 (długość Stringa zwróci nam metoda length(),
// czyli np dla Stringa imie = ”Ania”; imie.length() zwraca 4)
        System.out.println("Zadanie 8 - wypisz te ktorych dlugosc jest wieksza niz 7");

        String[] s1 = {"kuba", "gosia", "warszawa", "katowice", "pies"};
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].length() > 7) {
                System.out.println(s1[i]);
            }
        }
        System.out.println();

// Dla podanej tablicy Stringów, wypisz te, które kończą się na literę ‘a’, (metoda charAt() lub endsWith(), wygoogluj
// co one robią i jak działają)
        System.out.println("Zadanie 9 - wypisz te ktore koncza sie na litere a");

        // Wersja z endsWith
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].endsWith("a")) {
                System.out.println(s1[i]);
            }
        }

        System.out.println();

        // Wersja z charAt
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].charAt(s1[i].length() - 1) == 'a') {
                System.out.println(s1[i]);
            }
        }

    }

    public static void drukujTablice(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println();

    }
}