package dalsze.podstawy.wyjatki.exceptions;

public class NoHomoHereException extends RuntimeException{
    public NoHomoHereException() {
        System.out.println("No homo here");
    }

    public NoHomoHereException(String message) {
        super(message);
    }
}
