package dalsze.podstawy.interfejsy.dodatkowe.animals;

public class Hawk implements Predator{
    @Override
    public void hunt() {
        System.out.println("* The hawk is hunting *");
    }
}
