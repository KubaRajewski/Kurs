package dalsze.podstawy.typy.generyczne.list.creator;

public interface Mapper<T, S> {
    S mapper(T t);
}
