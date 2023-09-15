package metody.i.kolekcje.metody;

//// metoda typu void - nic nie zwraca
//public static void wyswietlSlowo() {
//        System.out.println("witam");
//        }
//
//// metoda ktora deklaruje typ zwracany
//public static String zwrocSlowo() {
//        return "siema";
//        }
//
//// przeciazanie metod
//public static double obliczPensje(int liczbaGodzin, double stawka) {
//        return liczbaGodzin * stawka;
//        }

public class Main {
    public static void main(String[] args) {
        // Testy dla funkcji obliczPensje()
        System.out.println("obliczPensje()");
        System.out.println(obliczPensje(40, 15.50, 100)); // Powinno wyświetlić: 720.0
        System.out.println(obliczPensje(30, 20, 50)); // Powinno wyświetlić: 650.0
        System.out.println();

        // Testy dla funkcji dzienDobry()
        System.out.println("dzienDobry()");
        System.out.println(dzienDobry("Jan")); // Powinno wyświetlić: Dzień dobry Jan
        System.out.println(dzienDobry("Anna")); // Powinno wyświetlić: Dzień dobry Anna
        System.out.println();

        // Testy dla funkcji suma()
        System.out.println("suma()");
        System.out.println(suma(5, 10)); // Powinno wyświetlić: 15
        System.out.println(suma(-3, 7)); // Powinno wyświetlić: 4
        System.out.println();

        // Testy dla funkcji dlugosc()
        System.out.println("dlugosc()");
        System.out.println(dlugosc("Hello")); // Powinno wyświetlić: 5
        System.out.println(dlugosc("Lorem ipsum dolor sit amet")); // Powinno wyświetlić: 27
        System.out.println();

        // Testy dla funkcji dluzszy()
        System.out.println("dluzszy()");
        System.out.println(dluzszy("Kot", "Pies")); // Powinno wyświetlić: Pies
        System.out.println(dluzszy("Programowanie", "Java")); // Powinno wyświetlić: Programowanie
        System.out.println();

        // Testy dla funkcji wieksza()
        System.out.println("wieksza()");
        System.out.println(wieksza(10.5, 8.2)); // Powinno wyświetlić: 10.5
        System.out.println(wieksza(5.5, 5.5)); // Powinno wyświetlić: 0
        System.out.println(wieksza(7.8, 9.1)); // Powinno wyświetlić: 9.1
        System.out.println();

        // Testy dla funkcji mnozenie()
        System.out.println("mnozenie()");
        System.out.println(mnozenie(2, 3, 4)); // Powinno wyświetlić: 20
        System.out.println(mnozenie(-5, 2, 3)); // Powinno wyświetlić: -9
        System.out.println();

        // Testy dla funkcji czyParzysta()
        System.out.println("czyParzysta()");
        System.out.println(czyParzysta(10)); // Powinno wyświetlić: true
        System.out.println(czyParzysta(7)); // Powinno wyświetlić: false
        System.out.println();

        // Testy dla funkcji sumaZUwaga()
        System.out.println("sumaZUwaga()");
        System.out.println(sumaZUwaga(5, 15)); // Powinno wyświetlić: 19
        System.out.println(sumaZUwaga(10, 20)); // Powinno wyświetlić: 30
        System.out.println(sumaZUwaga(15, 25)); // Powinno wyświetlić: 19
        System.out.println();

        // Testy dla funkcji zzzYyy()
        System.out.println("zzzYyy()");
        System.out.println(zzzYyy("zddy")); // Powinno wyświetlić: zzyy
        System.out.println(zzzYyy("zasd")); // Powinno wyświetlić: zzz
        System.out.println(zzzYyy("asdy")); // Powinno wyświetlić: yyy
        System.out.println(zzzYyy("pusty string")); // Powinno wyświetlić: pusty string
        System.out.println(zzzYyy("z")); // Powinno wyświetlić: zzz
        System.out.println(zzzYyy("y")); // Powinno wyświetlić: yyy
        System.out.println(zzzYyy("zy")); // Powinno wyświetlić: zzyy
        System.out.println(zzzYyy("a")); // Powinno wyświetlić: a
        System.out.println(zzzYyy("bb")); // Powinno wyświetlić: bb
        System.out.println();

        // Testy dla funkcji czyZawieraBad()
        System.out.println("czyZawieraBad()");
        System.out.println(czyZawieraBad("xbadxxx")); // Powinno wyświetlić: true
        System.out.println(czyZawieraBad("badxxx")); // Powinno wyświetlić: true
        System.out.println(czyZawieraBad("xxbadxx")); // Powinno wyświetlić: false
        System.out.println();

        // Testy dla funkcji ileRazy()
        System.out.println("ileRazy()");
        System.out.println(ileRazy("Hello World", 'o')); // Powinno wyświetlić: 2
        System.out.println(ileRazy("abracadabra", 'a')); // Powinno wyświetlić: 4
        System.out.println();

        // Testy dla funkcji silnia()
        System.out.println("silnia()");
        System.out.println(silnia(5)); // Powinno wyświetlić: 120
        System.out.println(silnia(0)); // Powinno wyświetlić: 1
        System.out.println();

        // Testy dla funkcji czyWiekszaCyfraJednosci()
        System.out.println("czyWiekszaCyfraJednosci()");
        System.out.println(czyWiekszaCyfraJednosci(45)); // Powinno wyświetlić: true
        System.out.println(czyWiekszaCyfraJednosci(23)); // Powinno wyświetlić: false
        System.out.println();


        // Testy dla funkcji sumaCyfr()
        System.out.println("sumaCyfr()");
        System.out.println(sumaCyfr(123)); // Powinno wyświetlić: 6
        System.out.println(sumaCyfr(98765)); // Powinno wyświetlić: 35
        System.out.println();

        // Testy dla funkcji potega()
        System.out.println("potega()");
        System.out.println(potega(2, 3)); // Powinno wyświetlić: 8.0
        System.out.println(potega(5, -2)); // Powinno wyświetlić: 0.04
        System.out.println();

        // Testy dla funkcji czyKwadrat()
        System.out.println("czyKwadrat()");
        System.out.println(czyKwadrat(16)); // Powinno wyświetlić: true
        System.out.println(czyKwadrat(17)); // Powinno wyświetlić: false
        System.out.println();

        // Testy dla funkcji wypiszDzielniki()
        System.out.println("wypiszDzielniki()");
        wypiszDzielniki(16); // Powinno wyświetlić: 1, 2, 4, 8, 16
        System.out.println();
        wypiszDzielniki(27); // Powinno wyświetlić: 1, 3, 9, 27
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Napisz metodę ktora oblicza pensje pracownika na podstawie liczby przepracowanych godzin, stawki godzinowej oraz bonusu
    public static double obliczPensje(int liczbaGodzin, double stawka, double bonus) {
        return liczbaGodzin * stawka + bonus;
    }

// Napisz metodę, która dodaje do Stringa podanego jako parametr napis "dzien dobry"

    public static String dzienDobry(String imie) {
        return "Dzień dobry " + imie;
    }

// Stwórz metodę, która liczy sumę dwóch liczb, które są podane jako parametr

    public static int suma(int a, int b) {
        return a + b;
    }

// Stwórz metodę, która zwraca długość Stringa podanego jako parametr

    public static int dlugosc(String slowo) {
        return slowo.length();
    }

// Stwórz metodę, która zwraca dłuższy z dwóch podanych jako parametr Stringów

    public static String dluzszy(String slowo1, String slowo2) {
        return slowo1.length() > slowo2.length() ? slowo1 : slowo2;
    }

// Stwórz metodę, która zwraca większą z dwóch podanych liczb typu double jako
// parametr. Gdy liczby są równe, zwracamy 0.

    public static double wieksza(double a, double b) {
        return a > b ? a : a == b ? 0 : b;
    }

// Napisz metodę, która jako argument (parametr) przyjmuje
// 3 zmienne typu int i liczy sumę pierwszej i drugiej, a następnie mnoży przez trzecią

    public static int mnozenie(int x, int y, int z) {
        return (x + y) * z;
    }

// Napisz metodę, która przyjmuje jako argument liczbę i sprawdza, czy jest to liczba parzysta

    public static boolean czyParzysta(int liczba) {
        return liczba % 2 == 0;
    }

// Napisz metodę, która zwraca sumę dwóch liczb, ale z uwagą, że jeśli któraś z podanych liczb jest z przedziału [13,19],
// to zwrócona wartość to zawsze 19

    public static int sumaZUwaga(int a, int b) {
        return (a >= 13 && a <= 19) || (b >= 13 && b <= 19) ? 19 : a + b;
    }

// Napisz metodę, która jako parametr przyjmuje Stringa. Jeśli String zaczyna się na "z", zwróć napis "zzz".
// Jeśli kończy się na "y", zwróć napis "yyy". Jeśli zaczyna się na "z" i kończy na "y", zwróć "zzyy".
// W każdym innym przypadku zwróć niezmieniony String.

    public static String zzzYyy(String s) {
        if (s.startsWith("z") && s.endsWith("y")) {
            return "zzyy";
        } else if (s.startsWith("z")) {
            return "zzz";
        } else if (s.endsWith("y")) {
            return "yyy";
        }
        return s;
    }

// Sprawdź, czy podany String jako parametr, zaczynając od indeksu 0 lub 1, zawiera słowo "bad"

    public static boolean czyZawieraBad(String s) {
        return s.startsWith("bad") || s.startsWith("bad", 1);
    }

// Napisz metodę, która liczy ile razy podany znak występuje w podanym Stringu.

    public static int ileRazy(String s, char c) {
        int licznik = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                licznik++;
            }
        }
        return licznik;
    }

// Napisz metodę obliczającą silnię z podanej liczby

    public static int silnia(int n) {
        int wynik = 1;
        for (int i = 1; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }

// Napisz metodę, która sprawdza, czy podana liczba dwucyfrowa ma większą cyfrę jedności od cyfry dziesiątek

    public static boolean czyWiekszaCyfraJednosci(int liczba) {
        int jednosci = liczba % 10;
        int dziesiatki = liczba / 10;
        return jednosci > dziesiatki;
    }

// Napisz funkcję, która wyznacza sumę cyfr podanej liczby całkowitej.

    public static int sumaCyfr(int liczba) {
        int suma = 0;
        while (liczba > 0) {
            suma += liczba % 10; // dodajemy ostatnia cyfre
            liczba /= 10; // zmniejszamy liczbe o ostatnia cyfre
        }
        return suma;
    }

// Napisz metodę, która jako argumenty przyjmuje dwie liczby i liczy ich potęgi,
// dla argumentów 3^4 ma obliczyć 3*3*3*3 = 81
// Uwzględnij, że a^0 = 1 oraz a^-b = 1/(a^b)

    public static double potega(double a, int b) {

        if (b == 0) {
            return 1;
        } else if (b < 0) {
            return 1 / potega(a, -b);
        }

        double wynik = 1;
        for (int i = 0; i < Math.abs(b); i++) {
            wynik *= a;
        }
        return wynik;
    }

// Napisz funkcję, która stwierdza, czy podana jako parametr liczba całkowita
// jest kwadratem pewnej liczby całkowitej. Liczby będące kwadratami liczb całkowitych to 1, 4, 9, 16 itd.
// Wartość funkcji ma być prawda, jeśli liczba spełnia warunek oraz fałsz w przeciwnym wypadku.

    public static boolean czyKwadrat(int liczba) {
        double pierwiastek = Math.sqrt(liczba);
        return pierwiastek == (int) pierwiastek;
    }

// Wypisz dzielniki liczby naturalnej podanej jako parametr
// np. dla 16 wynik to 1, 2, 4, 8, 16

    public static void wypiszDzielniki(int liczba) {
        System.out.println("Dzielniki liczby " + liczba + ":");
        for (int i = 1; i <= liczba; i++) {
            if (liczba % i == 0) {
                System.out.println(i);
            }
        }
    }
}