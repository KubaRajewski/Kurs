package dalsze.podstawy.enumy.wycieczki;

import java.util.ArrayList;
import java.util.List;

/*TODO
 * Stwórz klase klient i wycieczka, klient moze miec wiele wycieczek, wycieczka
 * moze miec wielu klientow. Wycieczka ma nazwe, kraj, cena i liste dodatkow
 * (kazdy jest dodatkowo platny) Znadz klienta który wydal najwiecej na dodatki
 * do wycieczki uwzgledniajac tez cene wycieczki Znadz klienta który wydal
 * najwiecej na dodatki do wycieczki nieuwzgledniajac tez ceny wycieczki
 */

public class Main {
    public static void main(String[] args) {
        Klient klient1 = new Klient("Jan", "Kowalski", "12345678911");
        Klient klient2 = new Klient("Anna", "Nowak", "98765432112");
        Klient klient3 = new Klient("Janusz", "Kowalski", "12345678921");

        Wycieczka wycieczka1 = new Wycieczka("Wycieczka do Chin", Kraj.CHINY, 10000);
        Wycieczka wycieczka2 = new Wycieczka("Wycieczka do Francji", Kraj.FRANCJA, 5000);
        Wycieczka wycieczka3 = new Wycieczka("Wycieczka do Polski", Kraj.POLSKA, 1000);

        List<Dodatek> pakietBudget = new ArrayList<>();
        List<Dodatek> pakietStandard = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE));
        List<Dodatek> pakietPremium = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE, Dodatek.PIERWSZENSTWO_WEJSCIA));
        List<Dodatek> pakietPremiumPlus = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE, Dodatek.PIERWSZENSTWO_WEJSCIA, Dodatek.NIEOGRANICZONE_DRINKI, Dodatek.WYPOZYCZENIE_ROWERU));

        Zakup z1 = new Zakup(wycieczka1, klient1, pakietBudget);
        Zakup z2 = new Zakup(wycieczka2, klient2, pakietStandard);
        Zakup z3 = new Zakup(wycieczka3, klient3, pakietPremium);
        Zakup z4 = new Zakup(wycieczka1, klient3, pakietPremiumPlus);

        // Znadz klienta który wydal najwiecej na dodatki do wycieczki uwzgledniajac tez cene wycieczki
        System.out.println("\nNajwiecej na dodatki uwzgledniajac cene wycieczki wydał: " +
                Klient.wydalNajwiecejNaDodatki(Klient.getEkstensja()));

        // Znadz klienta który wydal * najwiecej na dodatki do wycieczki nieuwzgledniajac ceny wycieczki
        System.out.println("\nNajwiecej na dodatki nie uwzgledaniajac ceny wycieczki wydał: "
                + Klient.wydalNajwiecejNaDodatkiIWycieczki(Klient.getEkstensja()) + "\n");
    }
}
