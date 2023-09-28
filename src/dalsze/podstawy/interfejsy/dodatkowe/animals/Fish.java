package dalsze.podstawy.interfejsy.dodatkowe.animals;

public class Fish implements Prey, Predator{
    @Override
    public void hunt() {
        System.out.println("* The fish is hunting a smaller fish *");
    }

    @Override
    public void flee() {
        System.out.println("* The fish is running away from a larger fish *");
    }
}
