package iteracja.pierwsza.kolekcje.tablice;

public class Main {
    public static void main(String[] args) {

        int[] array = {3, 5, 1, 8};
        wyswietlTablice(array);
        System.out.println();
        wyswietlTablice(zwrocTablice());

        sumaTablicy(array);

    }

    public static void wyswietlTablice(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static int[] zwrocTablice() {
        int[] array = {1, 2, 3, 4, 5};
        return array;
    }

    // Napisz metode ktora za swoj parametr przyjmuje tablice intow a nastepnie
    // zwraca sume wszystkich liczb ktore sa umieszczone w tej tablicy.

    public static int sumaTablicy(int[] array) {
        int suma = 0;
        for (int i : array) {
            suma += i;
        }

        return (suma);
    }

    // Napisz metode ktora za swoj parametr przyjmuje tablice intów, a nastepnie
    // zwraca tablice liczb  większych od 5
    // 8 1 4 9 10 6 -> 8 9 10 6
    public static int[] sumaTablicy5(int[] array, int n) {

        int licznik = 0;
        for (int i : array) {
            if (i > n) {
                licznik++;
            }
        }

        int[] array2 = new int[licznik];
        int j = 0;

        for (int i : array) {
            if (i > n) {
                array[j] = i;
                j++;
            }
        }
        return array;
    }

    // Napisz metode ktora za swoj parametr przyjmuje tablice intow, a nastepnie
    // wypisuje wszystkie liczby podzielne przez 2 ktore sa wieksze niz 7

    // Napisz metode ktora za swoj parametr przyjmuje tablice stringow, a nastepnie
    // wypisuje najdluzszy ze stringow

    /*
     * Napisz metode ktora jako parametr przyjmuje tablice intow, a nastepnie zwraca
     * tablice intow ktora zawiera wartosci: dla liczb nieparzystych dodaje do nich
     * 3 dla liczb parzystych odejmuje od nich 1
     *
     * Przyklad: dla tablicy {2,3,4,5} nasza metoda powinna zwrocic tablice
     * {1,6,3,8}
     */

    /*
     * Napisz metode, ktora jako parametr przyjmuje tablice intow i zwraca rowniez
     * tablice intow zmieniona w nastepujacy sposob: -liczby podzielne przez 3
     * zamienia na -1 -liczby niepodzielne przez 3 podnosi do kwadratu Dla tablicy =
     * {2,3,4,5,6} wynik to {4,-1,16,25,-1}
     */

    // napisz metode ktora przyjmuje jako parametr tablice Stringow oraz chara,
    // wypisuje te
    // slowa z tablicy ktore maja przynajmniej dwa podane chary
    // Ania Tomek Magda Krzys Ania i char a
    // output Ania Magda Ania

    // dla podanej tablicy intów sprawdz czy liczba elementów ujemnych jest większa
    // od liczby elementow nieujemnych

    // Napisz metode ktora wypelnia tablice losowymi (ilosc elementow podana jako
    // parametr) wartosciami z przedzialu 1-9 i
    // zwraca tablice posortowana w kolejnosci rosnacej
    // napisz metode ktora obliczy ile jest elementow parzystych z tablicy
}
