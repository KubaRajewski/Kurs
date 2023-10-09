package dalsze.podstawy.wyjatki.exceptions;

public class NoJavaProgrammerHere extends RuntimeException{
    public NoJavaProgrammerHere() {
        super("No Java programmer here!");
    }

    public NoJavaProgrammerHere(String message) {
        super(message);
    }
}
