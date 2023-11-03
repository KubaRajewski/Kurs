package dalsze.podstawy.typy.generyczne.list.creator;

public interface Mapper<T, S> { // przyjmujemy dwa typy: jeden ktory funkcja przyjmuje, drugi ktory zwraca
    S map(T t); // funkcja przyjmuje typ T, zwraca typ S
}
