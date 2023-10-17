package dalsze.podstawy.interfejsy.figury;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // stworz Kwadrat (bok), Kolo (promien), Prostokat (dl,szer)
        // - znajdz figure z najwieskszym polem
        // - znajdz figure z najwiekszym obwodem
        // - zwroc liste wszystkich figur które maja pole wieksze niz 30cm^2
        // - zwróc liste koł ktore maja promien mniejszy niz 7cm

        Kwadrat k1 = new Kwadrat(20);
        Kolo k2 = new Kolo(20);
        Prostokat p1 = new Prostokat(10, 20);

        List<Figura> figury = new ArrayList<>();
        List<Kolo> kola = new ArrayList<>();
        figury.add(k1);
        figury.add(k2);
        figury.add(p1);

        kola.add(k2);

        System.out.println(k2.obliczObwod());

        System.out.println(Figura.najwiekszePole(figury));
        System.out.println(Figura.najwiekszyObwod(figury));
        System.out.println(Figura.figuryZPolemWiekszymNiz(figury, 9));
        System.out.println(Kolo.kolaZobwodemMniejszymNiz(kola, 126));
    }
}
