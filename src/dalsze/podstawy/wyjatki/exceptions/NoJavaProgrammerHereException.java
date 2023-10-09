package dalsze.podstawy.wyjatki.exceptions;

public class NoJavaProgrammerHereException extends RuntimeException{
    public NoJavaProgrammerHereException() {
        super("No Java programmer here!");
    }

    public NoJavaProgrammerHereException(String message) {
        super(message);
    }
}
