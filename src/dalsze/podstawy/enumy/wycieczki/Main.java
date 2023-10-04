package dalsze.podstawy.enumy.wycieczki;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*TODO
         * Stwórz klase klient i wycieczka, klient moze miec wiele wycieczek, wycieczka
         * moze miec wielu klientow. Wycieczka ma nazwe, kraj, cena i liste dodatkow
         * (kazdy jest dodatkowo platny) Znadz klienta który wydal najwiecej na dodatki
         * do wycieczki uwzgledniajac tez cene wycieczki Znadz klienta który wydal
         * najwiecej na dodatki do wycieczki nieuwzgledniajac tez ceny wycieczki
         */

        Klient klient1 = new Klient("Jan", "Kowalski", "12345678911");
        Klient klient2 = new Klient("Anna", "Nowak", "98765432112");
        Klient klient3 = new Klient("Janusz", "Kowalski", "12345678921");

        Wycieczka wycieczka1 = new Wycieczka("Wycieczka do chin", Kraj.CHINY, 10000);
        Wycieczka wycieczka2 = new Wycieczka("Wycieczka do francji", Kraj.FRANCJA, 5000);
        Wycieczka wycieczka3 = new Wycieczka("Wycieczka do polski", Kraj.POLSKA, 1000);

        List<Dodatek> pakietStandard = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE));
        List<Dodatek> pakietPremium = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE, Dodatek.PIERWSZENSTWO_WEJSCIA));
        List<Dodatek> pakietPremiumPlus = new ArrayList<>(List.of(Dodatek.UBEZPIECZENIE, Dodatek.ZWIEDZANIE, Dodatek.PIERWSZENSTWO_WEJSCIA, Dodatek.NIEOGRANICZONE_DRINKI, Dodatek.WYPOZYCZENIE_ROWERU));

        klient1.dodajZakup(wycieczka1, pakietStandard);
        klient2.dodajZakup(wycieczka2, pakietPremium);
        klient3.dodajZakup(wycieczka3, pakietPremiumPlus);

//        // Znadz klienta który wydal najwiecej na dodatki do wycieczki uwzgledniajac tez cene wycieczki
        System.out.println("\n" + Klient.wydalNajwiecejNaWycieczke(Klient.getEkstensja(), true));

//        // Znadz klienta który wydal * najwiecej na dodatki do wycieczki nieuwzgledniajac ceny wycieczki
        System.out.println(Klient.wydalNajwiecejNaWycieczke(Klient.getEkstensja(), false) + "\n");
    }
}
