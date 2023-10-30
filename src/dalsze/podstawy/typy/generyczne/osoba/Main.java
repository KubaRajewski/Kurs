package dalsze.podstawy.typy.generyczne.osoba;

public class Main {
    public static void main(String[] args) {

        //Napisz klase Osoba która ma 2 parametry ktore moga byc roznymi typami, np String int, String String.

        Osoba<String, Integer> o = new Osoba<>("blb", 9);
    }
}
