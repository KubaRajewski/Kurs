package testy.test3.exceptions;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
    }

    public EmptyListException(String message) {
        super(message);
    }
}