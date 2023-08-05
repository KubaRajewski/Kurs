package kalkulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double a = 0;
        double b = 0;

        System.out.println("Kalkulator");

        while (true) {

            System.out.println();
            System.out.println("Jeśli chcesz przerwać działanie programu wpisz x");
            System.out.println();

            System.out.println("Podaj pierwszą liczbę (A): ");
            boolean flag = true;
            while (flag) {
                try {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("x")) {
                        System.out.println("Koniec programu");
                        System.exit(0);
                    }
                    a = Double.parseDouble(input);
                    flag = false;
                } catch (NumberFormatException e) {
                    System.out.println("Zły format, podaj liczbę");
                }
            }

            System.out.println("Podaj drugą liczbę (B) lub x aby zakończyć: ");
            flag = true;
            while (flag) {
                try {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("x")) {
                        System.out.println("Koniec programu");
                        System.exit(0);
                    }
                    b = Double.parseDouble(input);
                    flag = false;
                } catch (NumberFormatException e) {
                    System.out.println("Zły format, podaj liczbę ");
                }
            }

            System.out.println("Podaj operator (+, -, *, /, %): ");
            String operator = scanner.nextLine();

            while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") && !operator.equals("%")) {
                System.out.println("Nieprawidłowy operator, podaj jeden z tych: +, -, *, /, % ");
                operator = scanner.nextLine();
            }

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
                case "%":
                    System.out.println("Procent (A % B): " + (a * (b / 100)));
                    break;
                default:
                    System.out.println("Coś poszło nie tak.");
                    break;
            }
        }
    }
}
