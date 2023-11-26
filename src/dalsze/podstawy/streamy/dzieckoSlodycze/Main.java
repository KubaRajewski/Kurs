package dalsze.podstawy.streamy.dzieckoSlodycze;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dziecko dziecko1 = new Dziecko("Jan");
        Dziecko dziecko2 = new Dziecko("Anna");
        Dziecko dziecko3 = new Dziecko("Mateusz");
        Slodycz slodycz1 = new Slodycz("Czekolada");
        Slodycz slodycz2 = new Slodycz("Guma");
        Slodycz slodycz3 = new Slodycz("Lizak");

        dziecko1.dodajSlodycz(slodycz1);
        dziecko1.dodajSlodycz(slodycz2);
        dziecko2.dodajSlodycz(slodycz1);
        dziecko2.dodajSlodycz(slodycz3);
        dziecko3.dodajSlodycz(slodycz2);

        List<Dziecko> dzieci = Arrays.asList(dziecko1, dziecko2, dziecko3);

        System.out.println("Wszystkie słodycze kupione przez dzieci: " + Dziecko.wszystkieSlodyczeKupionePrzezDzieci(dzieci));
        System.out.println("Unikalne nazwy słodyczy kupionych przez dzieci: " + Dziecko.unikalneNazwySlodyczyKupionychPrzezDzieci(dzieci));
        System.out.println("Ilość słodyczy 'Czekolada' kupionych przez dzieci: " + Dziecko.ileDanychSlodyczyKupilyDzieci(dzieci, "Czekolada"));

        try {
            System.out.println("Pierwsze dziecko z przynajmniej 2 słodyczami: " + Dziecko.pierwszeDzieckoZNSlodyczami(dzieci, 2).getImie());
        } catch (KidNotFoundException e) {
            System.out.println("Nie znaleziono dziecka z przynajmniej 2 słodyczami.");
        }

        System.out.println("Czy któreś dziecko kupiło gumę? " + Dziecko.czyKtosKupilGume(dzieci));

        try {
            System.out.println("Dziecko, które kupiło najwięcej słodyczy 'Guma': " + Dziecko.ktoKupilNajwiecejDanejSlodyczy(dzieci, slodycz2).getImie());
        } catch (KidNotFoundException e) {
            System.out.println("Nie znaleziono dziecka, które kupiło najwięcej 'Guma'.");
        }

        int n = 2;
        try {
            System.out.println("N-ty najpopularniejszy słodycz: " + Dziecko.nNajpopularniejszySlodyczWsrodDzieci(dzieci, n).getNazwa());
        } catch (CandyNotFoundException e) {
            System.out.println("Nie znaleziono N-tego najpopularniejszego słodycza.");
        }

        System.out.println("Wszystkie nazwy słodyczy: " + Dziecko.wszystkieNazwySlodyczy(dzieci));
    }
}
