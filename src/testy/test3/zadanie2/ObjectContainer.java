package testy.test3.zadanie2;

import testy.test3.zadanie1.exceptions.EmptyListException;
import testy.test3.zadanie2.exceptions.ConditionNotMatchedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


public class ObjectContainer<T> {
    private Node<T> head;
    private final Predicate<T> condition;
    private int size;

    public ObjectContainer(Predicate<T> condition) {
        this.condition = condition;
    }

    public void add(T object) {
        if (!condition.test(object)) {
            throw new ConditionNotMatchedException();
        }

        size++;

        if (head == null) {
            head = new Node<>(object);
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node<>(object);
    }

    public void remove(int index) {
        if (head == null) {
            throw new EmptyListException();
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        size--;

        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
    }

    public Node<T> get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (head == null) {
            throw new EmptyListException();
        }

        if (index == 0) {
            return head;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public List<T> getWithFilter(Predicate<T> condition) {
        if (head == null) {
            throw new EmptyListException();
        }

        List<T> withFilter = new ArrayList<>();

        Node<T> current = head;
        while (current != null) {
            if (condition.test(current.data)) {
                withFilter.add(current.data);
            }
            current = current.next;
        }

        return withFilter;

    }

    public void removeIf(Predicate<T> condition) {
        if (head == null) {
            throw new EmptyListException();
        }

        Node<T> current = head;
        while (current != null && current.next != null) {
            if (condition.test(current.next.data)) {
                current.next = current.next.next;
                size--;
            }
            current = current.next;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Predicate<T> getCondition() {
        return condition;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectContainer<?> that)) return false;
        return size == that.size && Objects.equals(head, that.head) && Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, condition, size);
    }

    @Override
    public String toString() {
        return "ObjectContainer - type: " + getHead().getClass() + ", size: " + getSize() + ", condition: " + getCondition();
    }
}
