package testy.test3.zadanie1.exceptions;

public class InvalidStringContainerValueException extends RuntimeException {
    public InvalidStringContainerValueException() {
    }

    public InvalidStringContainerValueException(String value) {
        super("Invalid value: " + value);
    }
}