package testy.test3.exceptions;

public class InvalidStringContainerPatternException extends RuntimeException {
    public InvalidStringContainerPatternException() {
    }

    public InvalidStringContainerPatternException(String badPattern) {
        super("Invalid pattern: " + badPattern);
    }
}