package dalsze.podstawy.typy.generyczne.list.creator;

public interface Selector<T> {
    boolean select(T t); // funkcja przyjmuje typ T, zwraca boolean
}
