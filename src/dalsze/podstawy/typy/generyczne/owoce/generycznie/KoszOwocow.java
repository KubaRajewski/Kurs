package dalsze.podstawy.typy.generyczne.owoce.generycznie;

public class KoszOwocow<T> { // T,S,Q,V
    private T t;

    public KoszOwocow(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
