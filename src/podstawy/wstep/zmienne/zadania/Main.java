package podstawy.wstep.zmienne.zadania;

public class Main {
    public static void main(String[] args) {
/*
//		Przetestuj operatory +,-,*,/ dla innyc zmiennych np pomiedzy doublem i Stringiem, Stringiem i booleanem, intem i doublem
//		i intem i booleanem

        int i = 5;
        double d = 3.3;
        String s = "kuba";
        boolean b = true;

//      String a double
        System.out.println(s+d);
        System.out.println(s-d);
        System.out.println(s*d);
        System.out.println(s/d);

//      String a bool
        System.out.println(s+b);
        System.out.println(s-b);
        System.out.println(s*b);
        System.out.println(s/b);

//      int a double
        System.out.println(i+d);
        System.out.println(i-d);
        System.out.println(i*d);
        System.out.println(i/d);

//      int a bool
        System.out.println(i+b);
        System.out.println(i-b);
        System.out.println(i*b);
        System.out.println(i/b);

 */
//      Stwórz zmienna typu String. Wyswietl jej dlugosc (metoda length()->wygoogluj)
        System.out.println("Zadanie 1 - długość stringa");

        String str = "czesc";
        int length = str.length();
        System.out.println("długość stringa str to: " + length);
        System.out.println();

//		Stwórz zmienna typu String i wyswietl jej pierwszy i trzeci znak (metoda charAt() -> wygoogluj)
        System.out.println("Zadanie 2 - pierwszy i trzeci znak");
        char pierwszy = str.charAt(0);
        char trzeci = str.charAt(2);

        System.out.println("Pierwszy znak: " + pierwszy);
        System.out.println("Trzeci znak: " + trzeci);
        System.out.println();

//		Stwórz zmienna typu String i wyswietl tego stringa od 1 do 3 znaku (metoda substring() -> wygoogluj)
        System.out.println("Zadanie 3 - fragment od 1 do 3 znaku");

        String substring = str.substring(0, 3);
        System.out.println("Fragment od 1 do 3 znaku: " + substring);
        System.out.println();

//      Stwórz zmienna typu String i sprawdz czy zawiera ciag znakow "abc" (metoda contains())
        System.out.println("Zadanie 4 - czy zawiera ciąg znaków 'abc'");
        boolean containsABC = str.contains("abc");

        if (containsABC) {
            System.out.println("Zmienna zawiera ciąg znaków 'abc'.");
        } else {
            System.out.println("Zmienna nie zawiera ciągu znaków 'abc'.");
        }
        System.out.println();

//		Stwórz zmienne imie, nazwisko, adres, wiek i wypisz informacje które w nich
//		przechowujesz w jednym syso ale tak zeby kazda informacja byla w nowej linijce
        System.out.println("Zadanie 5 - informacje o osobie");

        String imie = "Kuba";
        String nazwisko = "Rajewski";
        String adres = "Wapienna";
        int wiek = 20;

        System.out.println(
                "Imię: " + imie
                        + "\nNazwisko: " + nazwisko
                        + "\nAdres: " + adres
                        + "\nWiek: " + wiek);
        System.out.println();

//		Stwórz dwie zmienne typu int i w jednej linii wypisz ich sume, roznice,
//		iloczyn i iloraz, uzyj znakow specjalnych
        System.out.println("Zadanie 6 - suma, różnica, iloczyn, iloraz");

        int a = 9;
        int b = 3;
        System.out.println("Zmienne to: " + a + ", " + b + ", Suma: " + (a + b) + ", " +
                "Różnica: " + (a - b) + ", Iloraz: " + (a / b) + ", Iloczyn: " + (a * b));

        System.out.println();

//      Zalozmy ze masz String liczba = "10" i chcemy tego Stringa zamienic na inta mmetoda parseInt() -> wygoogluj
        System.out.println("Zadanie 7 - zamiana Stringa na inta");

        String liczba = "10";
        int liczbaInt = Integer.parseInt(liczba);
        if (liczbaInt == 10) {
            System.out.println("działa");
        } else {
            System.out.println("Nie działa");
        }

        System.out.println();

//      Masz dwa stringi i chcesz je porównac, jak to zrobimy? co sie stanie jak zrobimy str1 == str2? googlowanko
        System.out.println("Zadanie 8 - porównanie Stringów");

        String x = "Kuba";
        String y = "Gosia";
        String z = new String("Kuba");

        if (x == z) { // w tym przypadku sa to dwa rozne obiekty bo == wskazuje na miejsce w pamieci komputera
            System.out.println("są równe");
        } else {
            System.out.println("nie sa rowne");
        }

        // zeby poprawnie porownac dwa stringi uzywamy metody quals
        boolean areEqual = x.equals(z);
        System.out.println(areEqual);

    }
}
