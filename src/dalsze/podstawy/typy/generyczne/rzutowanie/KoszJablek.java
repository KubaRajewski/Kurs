package dalsze.podstawy.typy.generyczne.rzutowanie;

public class KoszJablek {
    private Jablko jablko;

    public KoszJablek(Jablko jablko) {
        this.jablko = jablko;
    }

    public Jablko getJablko() {
        return jablko;
    }

    public void setJablko(Jablko jablko) {
        this.jablko = jablko;
    }
}
