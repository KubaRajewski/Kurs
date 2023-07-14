package iteracja.pierwsza.zmienne.kalkulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 0, b = 0;

        System.out.println("Kalkulator");

        System.out.println("Podaj pierwszą liczbę (A):");
        boolean flag = true;
        while (flag) {
            try {
                a = Double.parseDouble(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Zły format, podaj liczbę");
            }
        }

        System.out.println("Podaj drugą liczbę (B):");
        flag = true;
        while (flag) {
            try {
                b = Double.parseDouble(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Zły format, podaj liczbę");
            }
        }

        System.out.println("Podaj operator (+, -, *, /):");
        String operator = scanner.nextLine();

        while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            System.out.println("Nieprawidłowy operator, podaj jeden z tych: +, -, *, /");
            operator = scanner.nextLine();
        }

        scanner.close();

        System.out.print("Wynik: ");
        switch (operator) {
            case "+":
                System.out.println("Suma (A + B): " + (a + b));
                break;
            case "-":
                System.out.println("Różnica (A - B): " + (a - b));
                break;
            case "*":
                System.out.println("Iloczyn (A * B): " + (a * b));
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Nie można dzielić przez zero.");
                } else {
                    System.out.println("Iloraz (A / B): " + (a / b));
                }
                break;
            default:
                System.out.println("Coś poszło nie tak.");
                break;
        }
    }
}
