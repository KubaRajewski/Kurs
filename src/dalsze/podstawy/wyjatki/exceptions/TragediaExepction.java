package dalsze.podstawy.wyjatki.exceptions;

public class TragediaExepction extends RuntimeException{
    public TragediaExepction() {
        super("Brak szans, ustawiamy 0%");
    }

    public TragediaExepction(String message) {
        super(message);
    }
}
