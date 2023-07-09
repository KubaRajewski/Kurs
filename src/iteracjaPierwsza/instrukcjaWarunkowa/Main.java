package iteracjaPierwsza.instrukcjaWarunkowa;

public class Main {
    public static void main(String[] args) {

        /*
         * = przypisanie
         * == równa sie
         * != nierówna się
         * >, >=, <, <= wieksze, wieksze badz rowne itd
         * && and (logiczne i, koniunkcja)
         * || or (logiczne lub, alternatywa)
         * % - modulo, reszta z dzielenia
         */

        // słowo kluczowe if(warunek){ instrukcja co ma sie wydarzyc gdy jest spelniony
        // warunek }

        int i = 5;

        if (i < 10) {
            System.out.println("Podana liczba jest mniejsza niz 10");
        } else if (i == 10) {
            System.out.println("Podana liczba jest równa 10");
        } else {
            System.out.println("Podana liczba jest wieksza 10");
        }

        // switch case

        int ocena = 3;

        switch (ocena) {
            case 2:
                System.out.println("Nie zaliczyłeś");
                break;
            case 3:
                System.out.println("Zdałes dostatecznie");
                break;
            case 4:
                System.out.println("Zdales dobrze");
                break;
            case 5:
                System.out.println("Zdales bardzo dobrze");
                break;
            default:
                System.out.println("Nierozpoznana ocena");
        }
    }
}
