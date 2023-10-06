package dalsze.podstawy.wyjatki.exceptions;

public class NoWomenExeption extends RuntimeException{
    public NoWomenExeption() {
    }

    public NoWomenExeption(String message) {
        super(message);
    }
}
