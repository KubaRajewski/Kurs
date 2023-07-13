package iteracjaPierwsza.zmienne.kalkulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b;

        System.out.println("Kalkulator");

        System.out.println("Podaj pierwszą liczbę");
        while (true) {
            try {
                System.out.print("A: ");
                a = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Zły format, Podaj liczbe");
            }
        }

        System.out.println("Podaj drugą liczbę");
        while (true) {
            try {
                System.out.print("B: ");
                b = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Zły format, Podaj liczbe");
            }
        }

        String operator;

        while (true) {
            System.out.println("Podaj operator:");
            System.out.print("(+, -, *, /): ");
            operator = scanner.nextLine();

            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                break;
            } else {
                System.out.println("Nieprawidłowy operator, podaj jeden z tych: +, -, *, /");
            }
        }

        scanner.close();

        System.out.print("Wynik: ");
        switch (operator) {
            case "+":
                System.out.println("Suma: " + (a + b));
                break;
            case "-":
                System.out.println("Różnica: " + (a - b));
                break;
            case "*":
                System.out.println("Iloczyn: " + (a * b));
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Nie mozna dzielic przez zero.");
                } else {
                    System.out.println("Iloraz: " + (a / b));
                }
                break;
            default:
                System.out.println("Coś poszło nie tak.");
                break;
        }
    }
}
