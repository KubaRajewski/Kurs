package dalsze.podstawy.streamy.dzieckoSlodycze;

public class CandyNotFoundException extends RuntimeException {
    public CandyNotFoundException() {
    }

    public CandyNotFoundException(String message) {
        super(message);
    }
}
