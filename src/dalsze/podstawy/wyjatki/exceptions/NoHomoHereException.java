package dalsze.podstawy.wyjatki.exceptions;

public class NoHomoHereException extends RuntimeException{
    public NoHomoHereException() {
    }

    public NoHomoHereException(String message) {
        super(message);
    }
}
