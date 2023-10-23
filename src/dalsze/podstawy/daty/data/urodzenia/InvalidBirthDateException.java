package dalsze.podstawy.daty.data.urodzenia;

public class InvalidBirthDateException extends RuntimeException{
    public InvalidBirthDateException() {

    }

    public InvalidBirthDateException(String message) {
        super(message);
    }
}
