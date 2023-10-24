package testy.test3.zadanie1.exceptions;

public class InvalidStringContainerPatternException extends RuntimeException {
    public InvalidStringContainerPatternException() {
    }

    public InvalidStringContainerPatternException(String badPattern) {
        super("Invalid pattern: " + badPattern);
    }
}