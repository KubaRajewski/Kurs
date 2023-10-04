package dalsze.podstawy.enumy.wstep;

public class Main {
    public static void main(String[] args) {
        Koszulka kk1 = new Koszulka("adidas", "czerwona", Rozmiar.M);

        System.out.println(kk1.getRozmiar().name());
        System.out.println(kk1.getRozmiar().ordinal());

        System.out.println(Rozmiar.valueOf("M"));

        for (Rozmiar r : Rozmiar.values()) {
            System.out.println(r);
        }
    }
}
