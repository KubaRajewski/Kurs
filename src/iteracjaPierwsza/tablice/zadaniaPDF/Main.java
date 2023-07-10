package iteracjaPierwsza.tablice.zadaniaPDF;

public class Main {
    public static void main(String[] args) {

// Napisz program, który dla danej tablicy intów oblicza sumę elementów tej tablicy

        int[] table = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        int sum = 0;
        for (int i : table) {
            sum = sum + table[i];
        }
        System.out.println(sum);

// Napisz program, który dla danej tablicy intów długości 3 wyświetli tablicę 2 razy dłuższą,
// wypełnioną wartością 0 poza ostatnim elementem, ostatni element tablicy ma mieć wartość odpowiadającą długości tablicy.

//                                      {4, 5, 6} → {0, 0, 0, 0, 0, 6}

        int[] table2 = {4, 5, 6};
        int last = table2[table2.length - 1];
        System.out.println(last);

// Napisz program, który dla danej tablicy intów zwraca sume elementów po lewej od zadanego indeksu. Np. dla danych:
// {1,2,3,4,5} i indeksu = 2 suma wynosi 3 bo 1 + 2 = 3


// Zadeklaruj tablice stringów dlugosci 4, dodaj do niej 4 wyrazy.
// W pętli przypisz każdy wyraz do wcześniej utworzonej zmiennej typu String. Wyświetl tą zmienną.

// Zadeklaruj dwie tablice intów róznej długości. Przypisz obu na indeksie 0 jakąś liczbę.
// Wyświetl tę tablicę, która jest dłuzsza (oczywiscie zmiana długosci danej tablicy powinna wpływać na wypisanie tablic).


// Dla podanej tablicy intow oblicz czy więcej jest elementów dodatnych czy podzielnych przez 3

// Z podanej tablicy Stringów wypisz te których długość jest większ niż 7 (długość Stringa zwróci nam metoda length(),
// czyli np dla Stringa imie = ”Ania”; imie.length() zwraca 4)


// Oblicz iloczyn liczb podanych w tablicy intów


// Dla podanej tablicy Stringów, wypisz te, które kończą się na literę ‘a’, (metoda charAt() lub endsWith(), wygoogluj
// co one robią i jak działają)
    }
}
