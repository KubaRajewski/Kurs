//Stworzyc prosty kalkulator, zadeklaruj dwie zmienne typu double
//Stworzyc mozliwosc wypisania na konsoli dzialan matematycznych +,-,*,/
//double x=4, y=8;
//double suma=x+y; syso(suma)
//Suma 4 i 8 wynosi 12
//Roznica 4 i 8 wynosi -4

package zmienne.kalkulator;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get and validate user input
        System.out.print("A: ");
        double a = scanner.nextInt();

        System.out.print("B: ");
        double b = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        // Check for the operator and keep promting the user if it's incorrect
        String operator = "";
        String[] validOperators = {"*", "/", "+", "-"};
        while (true) {
            System.out.print("Operator: ");
            String op = scanner.nextLine();

            if (Arrays.asList(validOperators).contains(op)) {
                operator = op;
                break; // Exit the loop if a valid operator is entered
            } else {
                System.out.println("Invalid operator. Try again.");
            }
        }

        scanner.close();

    /* Check if the data is correct

        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("Operator: " + operator);
    */

        if (Objects.equals(operator, "+")) {
            System.out.println("a + b = " + (a + b));
        }
        else if (Objects.equals(operator, "-")) {
            System.out.println("a - b = " + (a - b));
        }
        else if (Objects.equals(operator, "*")) {
            System.out.println("a * b = " + (a * b));
        }
        else if (Objects.equals(operator, "/")) {
            System.out.println("a / b = " + (a / b));
        }
    }
}

