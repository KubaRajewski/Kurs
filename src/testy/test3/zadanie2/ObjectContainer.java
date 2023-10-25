package testy.test3.zadanie2;

import java.util.function.Predicate;

public class ObjectContainer<T> {
    private Node<T> head;
    private Predicate<T> condition;
    private int size;

    public ObjectContainer(Predicate<T> condition) {
        this.condition = condition;
    }
}
