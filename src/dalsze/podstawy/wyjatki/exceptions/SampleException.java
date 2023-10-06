package dalsze.podstawy.wyjatki.exceptions;

public class SampleException extends RuntimeException{
    public SampleException() {
    }

    public SampleException(String message) {
        super(message);
    }
}
