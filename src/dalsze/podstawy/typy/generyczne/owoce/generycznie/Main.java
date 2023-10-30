package dalsze.podstawy.typy.generyczne.owoce.generycznie;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
         * Stwórz klase KoszOwocow ktora jako swoje pole przyjmuje Object. (konstruktor i getter)
         * Stworz klase Pomarancza i KoszPomaranczy która jako pole przyjmuje Pomarancze (konstruktor i getter)
         * Stworz klase Jablko i KoszJabłek ktora jako pole przyjmuje Jablko (konstruktor i getter)
         */

        Jablko j = new Jablko();
        Pomarancza p = new Pomarancza();

        KoszJablek kj = new KoszJablek(j);
        KoszPomaranczy KoszPomaranczy = new KoszPomaranczy(p);

        Jablko jablko = kj.getJablko();
        // Pomarancza pomarancza = kj.getJablko();

        KoszOwocow<Jablko> ko = new KoszOwocow<>(j);
        Jablko jablko1 = ko.getT();
        // Pomarancza pomarancza =  ko.getT();


    }
}
