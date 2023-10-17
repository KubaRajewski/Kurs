package dalsze.podstawy.interfejsy.kalkulator;

public class Main {
    public static void main(String[] args) {
        // Stworz kalkulator oparty o interfejs Dzialanie w ktorym mamy jedna metode licz(double d1, double d2)

        Dzialanie d1 = new Dodawanie();
        System.out.println(d1.licz(1, 3));
    }
}
