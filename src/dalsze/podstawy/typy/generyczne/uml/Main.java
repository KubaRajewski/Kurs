package dalsze.podstawy.typy.generyczne.uml;

public class Main {
    public static void main(String[] args) {
        Osoba o1 = new Osoba();
        Pracownik p1 = new Pracownik();
        Menager m1 = new Menager();
        Programista pr1 = new Programista();
        Klient k1 = new Klient();

        metoda1(new OsobaPojemnik<Pracownik>(p1));
        metoda1(new OsobaPojemnik<Menager>(m1));
        metoda1(new OsobaPojemnik<Programista>(pr1));
        metoda1(new OsobaPojemnik<Klient>(k1));
        metoda1(new OsobaPojemnik<Osoba>(o1));

        metoda2(new OsobaPojemnik<Pracownik>(p1));
        metoda2(new OsobaPojemnik<Menager>(m1));
        metoda2(new OsobaPojemnik<Programista>(pr1));
//		metoda2(new OsobaPojemnik<Klient>(k1));
//		metoda2(new OsobaPojemnik<Osoba>(o1));

        metoda3(new OsobaPojemnik<Pracownik>(p1));
        //	metoda3(new OsobaPojemnik<Menager>(m1));
//		metoda3(new OsobaPojemnik<Programista>(pr1));
//		metoda3(new OsobaPojemnik<Klient>(k1));
        metoda3(new OsobaPojemnik<Osoba>(o1));

    }


    public static void metoda1(OsobaPojemnik<?> pojemnik) {

    }

    public static void metoda2(OsobaPojemnik<? extends Pracownik> pojemnik) {

    }

    public static void metoda3(OsobaPojemnik<? super Pracownik> pojemnik) {

    }


}