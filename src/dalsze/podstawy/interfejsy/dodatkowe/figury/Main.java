package dalsze.podstawy.interfejsy.dodatkowe.figury;

public class Main {
    public static void main(String[] args) {
        Figura kolo = new Kolo(5.0);
        Figura kwadrat = new Kwadrat(4.0);
        Figura trojkat = new Trojkat(3.0, 4.0, 5.0);

        System.out.println("Pole powierzchni koła: " + kolo.obliczPole());
        System.out.println("Obwód koła: " + kolo.obliczObwod());

        System.out.println("Pole powierzchni kwadratu: " + kwadrat.obliczPole());
        System.out.println("Obwód kwadratu: " + kwadrat.obliczObwod());

        System.out.println("Pole powierzchni trójkąta: " + trojkat.obliczPole());
        System.out.println("Obwód trójkąta: " + trojkat.obliczObwod());
    }
}
