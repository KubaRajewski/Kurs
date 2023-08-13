package dalsze.podstawy.wyjatki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {

        // 1. Write a Java program that throws an exception and catch it using a try-catch block.
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally { // nie ważne czy wystąpi wyjątek czy nie, kod w finally wykona się zawsze
            System.out.println("The 'try catch' is finished.");
        }
    }

    // 2. Create a method that takes an integer as a parameter and throws
    // an exception if the number is odd.

    public static void checkNumber(int number) throws Exception {
        if (number % 2 != 0) {
            throw new Exception("Number is odd");
        }
    }

    // 3. Create a method that reads a file and throws an exception if the file is not found.

    public static void readFile(String fileName) throws Exception {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new Exception("File not found");
        }
    }

    // 4. Write a Java program that reads a list of numbers from a file and throws an exception if any of the numbers are positive.

    public static void checkNumbers(String fileName) throws Exception {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new Exception("File not found");
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line);
            if (number > 0) {
                throw new Exception("Number is positive");
            }
        }
    }

    // 5. Write a Java program that reads a file and throws an exception if the file is empty.

    public static void checkFile(String fileName) throws Exception {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new Exception("File not found");
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                throw new Exception("File is empty");
            }
        }
    }

    // 6. Write a Java program that reads a list of integers from the user and throws an exception if any numbers are duplicates.

    public static void checkDuplicates(int[] numbers) throws Exception {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (number == numbers[j]) {
                    throw new Exception("Duplicate number");
                }
            }
        }
    }

    // 7. Write a Java program to create a method that takes a string as input and throws an exception if the string does not contain vowels.

    public static void checkVowels(String text) throws Exception {
        if (!text.contains("a") && !text.contains("e") && !text.contains("i") && !text.contains("o") && !text.contains("u")) {
            throw new Exception("String does not contain vowels");
        }
    }
}
