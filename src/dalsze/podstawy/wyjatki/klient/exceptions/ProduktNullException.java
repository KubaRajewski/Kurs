package dalsze.podstawy.wyjatki.klient.exceptions;

public class ProduktNullException extends RuntimeException{

    public ProduktNullException() {
    }

    public ProduktNullException(String message) {
        super(message);
    }
}
