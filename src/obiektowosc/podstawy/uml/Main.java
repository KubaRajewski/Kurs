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
    }
}
