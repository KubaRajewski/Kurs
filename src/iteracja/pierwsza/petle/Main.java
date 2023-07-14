package iteracja.pierwsza.petle;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(a);

        a = a + 2;
        System.out.println(a);

        a += 2;// to dokladnie to samo co w linijce 9
        System.out.println(a);

        a++;// zwiekszenie zmiennej a o 1
        System.out.println(a);

        a--;// zmniejszenie zmiennej a o 1
        System.out.println(a);


        for (int i = 0; i < 10; i++) {
            System.out.print("Hej ");
        }
        System.out.println();

        int y = 0;

        while (y < 10) {
            System.out.print("Czesc ");
            y++;
        }
    }
}

