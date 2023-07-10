package instrukcja.warunkowa.zadania;

public class Main {
    public static void main(String[] args) {

// Zrób intstrukcje switch case, dla wartosci String niech bedzie to reprezentacja miesiecy i w zaleznosci od
// podanego miesiaca podac klimat

        String miesiac = "Styczeń";

        switch (miesiac) {
            case "Styczeń":
            case "Luty":
            case "Grudzień":
                System.out.println("Klimat: Zimowy");
                break;
            case "Marzec":
            case "Kwiecień":
            case "Maj":
                System.out.println("Klimat: Wiosenny");
                break;
            case "Czerwiec":
            case "Lipiec":
            case "Sierpień":
                System.out.println("Klimat: Letni");
                break;
            case "Wrzesień":
            case "Październik":
            case "Listopad":
                System.out.println("Klimat: Jesienny");
                break;
            default:
                System.out.println("Nieznany miesiąc");
        }
        System.out.println();

// Sprawdz czy podana liczba typu double jest dodatnia, czy jest rowna 0, czy
// jest ujemna

        double a = 9;
        if (a > 0) {
            System.out.println("dodatnia");
        } else if (a == 0) {
            System.out.println("rowna zeru");
        } else {
            System.out.println("ujemna");
        }
        System.out.println();

// Zadeklaruj 2 zmienne typu int, wyswietl która z tych dwoch liczb jest
// wieszka i o ile, np dla 4 i 1 chcemy wyswietlic: 4 jest wieksze od 1 o 3

        int b = -30;
        int c = 15;

        if (b > c) {
            System.out.println(b + " jest większe od " + c + " o " + (b - c));
        } else if (b == c) {
            System.out.println(b + " jest równe " + c);
        } else {
            System.out.println(c + " jest większe od " + b + " o " + (c - b));
        }
        System.out.println();

// Napisz program sprawdzajacy czy podana liczba jest parzysta

        double liczba = 7;

        if (liczba % 2 == 0) {
            System.out.println("Liczba jest parzysta");
        } else {
            System.out.println("Liczba jest nieparzysta");
        }
        System.out.println();

// Sprawdzmy czy zadeklarowana liczba typu double, nalezy do przedzialu (1,4)
// czy moze [6,8], czy jest spoza przedzialu

        boolean nalezy = false;

        if (liczba > 4 && liczba < 1) {
            nalezy = true;
        } else if (liczba >= 7 && liczba <= 8) {
            nalezy = true;
        }

        if (nalezy) {
            System.out.println("Liczba nalezy do przedziału");
        }
        System.out.println();

// Sprawdz czy srednia dwoch liczb typu double jest wieksza od 4

        double liczba2 = 14;
        if ((liczba + liczba2) / 2 > 4) {
            System.out.println("Średnia jest wieksza od 4");
        } else {
            System.out.println("Średnia nie jest wieksza od 4");
        }
        System.out.println();

// Sprawdz czy suma 3 liczb jest podzielna przez 3

        double liczba3 = 15;
        boolean jestPodzielna = false;

        if ((liczba + liczba2 + liczba3) % 3 == 0) {
            System.out.println("suma 3 liczb jest podzielna przez 3");
        }
        else {
            System.out.println("suma 3 liczb nie jest podzielna przez 3");
        }
        System.out.println();

// Sprawdz czy dlugosc podanego Stringa jest wieksza od 5

        String str = "czesc!";
        if (str.length() > 5) {
            System.out.println("dlugosc stringa jest wieksza od 5");
        }
        else {
            System.out.println("długość stringa jest mniejsza lub rowna 5");
        }
        System.out.println();

// Sprawdz czy pierwszy znak stringa to literka A

        char firstChar = str.charAt(0);

        if (Character.toString(firstChar).equals("A")) {
            System.out.println("Pierwszy znak to litera A");
        } else {
            System.out.println("Pierwszy znak nie jest literą A");
        }
        System.out.println();

// sprawdz czy string zawiera literke a

        if (str.contains("a")) {
            System.out.println("String zawiera literę 'a'");
        } else {
            System.out.println("String nie zawiera litery 'a'");
        }
    }
}
