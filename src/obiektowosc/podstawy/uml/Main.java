package obiektowosc.podstawy.uml;

public class Main {
    public static void main(String[] args) {
        Uczen u1 = new Uczen("Kuba", "Rajewski", "Oginskiego", "29087");
        Uczen u2 = new Uczen("Kubaaaaa", "Rajewski", "Oginskiego", "29234087");
        Uczen u3 = new Uczen("grzesiek", "popiolek", "warszawa", "295687");

        System.out.println(u1.getImie());
        Szkola s1 = new Szkola(1992, "Liceum", "Wyroznienie", 1923);
        Szkola s2 = new Szkola(2012, "Podstawowka", "brak", 6543);

        // asocjacja 1-*
        s1.dodajUcznia(u1);
        s1.dodajUcznia(u2);
        s1.dodajUcznia(u3);

        System.out.println(s1.getUczniowie());
        System.out.println(u1.getSzkola());

      //  s2.dodajUcznia(u1);

        // PD TODO:
        // stworz swoj biznesowy diagram klas - uml + kod, wszystkie rodzaje atrybutow, dziedizczenie oraz asocajcje

        /*
         *  Klient kupuje produkty. Klient ma imie nazwisko i rozmiar penisa. Pordukt ma nazwe, cene i jesli jest to kondom to wymiar.
         *  Klient moze miec wiele produktow, produkt moze miec jednego klienta.
         *
         *  1) Napisz mrtode ktota znajduje klienta ktory wydal najwiecej.
         *
         *   2) napisz metode ktora zwroci liste klientow ktorzy kupili kondoma
         *
         *   3) napisz metode ktora zwroci liste klientow ktorzy kupili kondoma ale nie na swoj rozmiar :D
         */

        /*
		 * Stwórz klasę Pracownik (imie,nazwisko, adres, pensja i Klient (imie,nazwisko, ulubiony produkt). Klient kupuje produkty (nazwa, cena).
			Pracownik uzywa samochod (model, marka)

			1) Znajdz klienta który wydal najwiecej

			2) Wyswietl dla kazdego klienta jego ulubiony produkt (of cuz ulubiony produkt to ma byc atrybut wyliczalny na podstawie zakupow)

			3) Wyswietl 3 top pracownikow z najwieksza pensja (compartor + sortowanie) DODATKOWE

			4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta
		 */
    }
}
