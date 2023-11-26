package dalsze.podstawy.streamy.dzieckoSlodycze;

public class KidNotFoundException extends RuntimeException{
    public KidNotFoundException() {
    }

    public KidNotFoundException(String message) {
        super(message);
    }
}
