package dalsze.podstawy.interfejsy.dodatkowe.animals;

public class Rabbit implements Prey{
    @Override
    public void flee() {
        System.out.println("* The rabbit is running away *");
    }
}
