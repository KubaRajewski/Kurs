package dalsze.podstawy.interfejsy.zbiornik;

//        Stworz klase Zbiornik
//        zbiornik posiada nastepujace atrybuty: nazwę oraz pojemność.
//        należy stworzyć następujące operacje:
//        - void dolanieWody(ile) - ale w zbiorniku nie moze byc wiecej wody niz wynosi pojemnosc
//        - void odlanieWody(ile) - ale nie możesz odlać więcej niż masz
//        - void przelanieWody(skad, ile) - przelewa wode ze zbiornika skąd do naszego (pod warunkiem, że przelew jest możliwy)
//        stworz metody ktore pozwalaja:
//        - znalezc zbiornik w ktorym jest najwiecej wody
//        - znalezc zbiornik ktory jest najbardziej zapelniony
//        - znalezc wszystkie puste zbiorniki.
//
//
//        Każda operacja na zbiorniku jest rejestrowana,
//        dla każdej operacji pamiętamy: datę i czas jej wykonania, jej nazwę, zbiornik na którym była ona wykonana
//        oraz ilość wody jaka była brana pod uwagę, oraz to czy operacja się powiodła czy nie.
//
//        Należy zaimplementować taką funkcjonalność oraz dodatkowo stworzyć metody które:
//        - pozwalają znaleźć zbiornik na którym było najwiecej operacji zakonczonych niepowodzeniem
//        - pozwalają znaleźć zbiornik w którym było najwięcej operacji danego typu (typ podajemy jako argument metody)

public class Main {
    public static void main(String[] args) {
        Zbiornik z1 = new Zbiornik("Zbiornik Stalowy", 300);
        Zbiornik z2 = new Zbiornik("Zbiornik Drewniany", 200);
        Zbiornik z3 = new Zbiornik("Zbiornik Plastikowy", 100);

        z1.dolej(250);
        z2.dolej(200);


        // - znalezc zbiornik w ktorym jest najwiecej wody
        // - znalezc zbiornik ktory jest najbardziej zapelniony
        // - znalezc wszystkie puste zbiorniki.

        System.out.println("najwiecej wody: " + IZbiornik.zNajwiekszaIlosciaWody(Zbiornik.getEkstensja()));
        System.out.println("najpelniejszu " + IZbiornik.najbardziejZapelniony(Zbiornik.getEkstensja()));
        System.out.println("puste: " + IZbiornik.pusteZbiorniki(Zbiornik.getEkstensja()));

        // - zbiornik na którym było najwiecej operacji zakonczonych niepowodzeniem
        // - najwięcej operacji danego typu (typ podajemy jako argument metody)

        z1.odlej(10000);
        z1.odlej(10000);
        z1.odlej(10000);
        z1.odlej(10000);
        z1.odlej(10000);
        z2.odlej(500);
        z2.odlej(500);

        System.out.println("najwiecej niepowodzen: " + IZbiornik.najwiecejZlychOperacji(Zbiornik.getEkstensja()));
        System.out.println("najwiecej operacji danego typu: " + IZbiornik.najwiecejOperacjiDanegoTypu(Zbiornik.getEkstensja(), TypOperacji.ODLEWANIE));

    }
}
