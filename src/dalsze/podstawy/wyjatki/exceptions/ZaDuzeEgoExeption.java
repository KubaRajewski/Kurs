package dalsze.podstawy.wyjatki.exceptions;

public class ZaDuzeEgoExeption extends RuntimeException{
    public ZaDuzeEgoExeption() {
        super("Za duze ego, szanse spadaja do 30%");
    }

    public ZaDuzeEgoExeption(String message) {
        super(message);
    }
}
