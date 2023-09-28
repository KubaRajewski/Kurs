package dalsze.podstawy.interfejsy.dodatkowe.kalkulator;

public class Main {
    public static void main(String[] args) {
        Kalkulator kalkulator = new KalkulatorPodstawowy();

        double wynikDodawania = kalkulator.dodawanie(5.0, 3.0);
        double wynikOdejmowania = kalkulator.odejmowanie(5.0, 3.0);
        double wynikMnozenia = kalkulator.mnozenie(5.0, 3.0);
        double wynikDzielenia = kalkulator.dzielenie(5.0, 3.0);

        System.out.println("Wynik dodawania: " + wynikDodawania);
        System.out.println("Wynik odejmowania: " + wynikOdejmowania);
        System.out.println("Wynik mnożenia: " + wynikMnozenia);
        System.out.println("Wynik dzielenia: " + wynikDzielenia);
    }
}

