package iteracja.pierwsza.metody;

public class Main {
    public static void main(String[] args) {
        wyswietlSlowo();
        System.out.println(zwrocSlowo());

        String s = zwrocSlowo();

        System.out.println(obliczPensje(160, 45));
        System.out.println(obliczPensje(150, 30, 2000));

        System.out.println(dzienDobry("kuba"));
        System.out.println(suma(2, 2));
        System.out.println(dlugosc("kuba"));
        System.out.println(dluzszy("kuba", "gosia"));
    }

    // metoda typu void - nic nie zwraca
    public static void wyswietlSlowo() {
        System.out.println("witam");
    }

    // metoda ktora deklaruje typ zwracany
    public static String zwrocSlowo() {
        return "siema";
    }

    // przeciazanie metod
    public static double obliczPensje(int liczbaGodzin, double stawka) {
        return liczbaGodzin * stawka;
    }

    public static double obliczPensje(int liczbaGodzin, double stawka, double bonus) {
        return liczbaGodzin * stawka + bonus;
    }

    // Napisz metode, ktora dodaje do Stringa podanego jako parametr napis "dzien dobry"

    public static String dzienDobry(String imie) {
        return "Dzień dobry " + imie;
    }

    // Stworz metode ktora liczy sume dwoch liczb ktore sa podane jako parametr

    public static int suma(int a, int b) {
        return a + b;
    }

    // Stwórz metode ktora zwraca dlugosc Stringa podanego jako parametr

    public static int dlugosc(String slowo) {
        return slowo.length();
    }

    // Stworz metode ktora zwraca dluszzy z dwoch podanych jako parametr Stringow

    public static String dluzszy(String slowo1, String slowo2) {
        // warunek   ? co gdy true : co gdy false
        return slowo1.length() > slowo2.length() ? slowo1 : slowo2;

//        if (slowo1.length() > slowo2.length()) {
//            return slowo1;
//        }
//        return slowo2;

    }

    // Stworz metode ktora zwraca wieksza z dwoch podanych liczb typu double jako
    // parametr gdy liczby są równe zwracamy 0

    public static double wieksza(double a, double b) {
        return a > b ? a : a == b ? 0 : b;
//        if (a > b) {
//            return a;
//        } else if (a == b) {
//            return 0;
//        }
//        return b;
    }


    // Napisz metode ktora jako argument (parametr) przyjmuje

    // 3 zmienne typu int i liczy sume pierwszej i drugiej i mnozy przez trzecia

    public static int mnozenie(int x, int y, int z) {
        return (x + y) * z;
    }

    // Napisz metode ktora przyjmuje jako argument liczbe i sprawdza czy jest to liczba parzysta

    // Napisz metode ktora zwraca sume dwoch liczb ale z uwaga ze jesli ktoras z podanych liczb jest z przedzialu [13,19]
    // to zwrocona wartosc to zawsze 19

    //Napisz metode ktora przyjmuje jako parametr Stringa, jesli String zaczyna sie na z zwroc napis zzz, jesli konczy sie na y zwroc napis yyy
    // jesli zaczyna sie na z i konczy na y zwroc zzyy, w kazdym innym przypadku zwroc stringa niezmienionego
    // metoda startsWith() i endsWith() <- sprawdzenie czy string konczy/zaczyna sie na dany literał łancuchowy

    // zddy -> zzyy
    // zasd -> zzz
    // asdy -> yyy
    // pusty string -> pusty string
    // z -> zzz
    // y -> yyy
    // zy -> zzyy
    // a -> a
    // bb -> bb

    //Sprawdz czy podany String jako parametr zaczynajac od 0 lub 1 indeksu ma w sobie slowo bad
    //xbadxxx - true
    //badxxx - true
    //xxbadxx - false

    // Napisz metode ktora liczy ile razy podany znak wystepuje w podanym Stringu.

    //Napisz metodę obliczająca silnię z podanej liczby

    // napisz metoda ktora sprawdza czy podana liczba dwucyfrowa ma wieksza cyfre
    // jednosci od cyfry dziesiatek

    // Napisz funkcję, która wyznacza sumę cyfr podanej liczby całkowitej.

    // Napisz metode ktora jako argument przyjmuje dwie liczby i liczy ich potegi,
    // dla argumentow 3^4 ma obliczyc 3*3*3*3 = 81
    // uwzglednic ze a^0 = 1
    // uwzglednic ze a^-b = 1/(a^b)

    // Napisz funkcje, ktora stwierdza, czy zadana jako parametr liczba calkowita
    // jest kwadratem
    // pewnej liczby calkowitej. Liczby bedace kwadratami liczb calkowitych to 1, 4,
    // 9, 16 itd.
    // Wartosci funkcji ma byc prawda, jesli liczba spelnia warunek oraz falsz w
    // przeciwnym wypadku. Math.sqrt(x) zwraca pierwiastek z x
    // sqrt(16) = 4 czyli ok bo liczba całkowita
    // sqrt(17) - 4.2 czyli nie ok bo liczba niecałkowita :)

    // Wypisz dzielniki liczby naturalnej podanej jako parametr
    // np dla 16 wynik to 1,2,4,8,16
}
