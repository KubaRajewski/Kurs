package testy.test3.exceptions;

public class DuplicatedElementOnListException extends RuntimeException {
    public DuplicatedElementOnListException() {
    }

    public DuplicatedElementOnListException(String value) {
        super("Duplicated value: " + value);
    }
}