package dalsze.podstawy.wyjatki.exceptions;


public class BadPlaceForDateException extends RuntimeException{
    public BadPlaceForDateException() {
        System.out.println("Miejsce ktore wybrales nie zgadza sie z ulubionym miejscem kobiety.");
    }

    public BadPlaceForDateException(String message) {
        super(message);
    }
}

