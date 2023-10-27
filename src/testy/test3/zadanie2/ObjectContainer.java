package testy.test3.zadanie2;

import testy.test3.zadanie1.exceptions.EmptyListException;
import testy.test3.zadanie1.exceptions.FileWritingException;
import testy.test3.zadanie2.exceptions.ConditionNotMatchedException;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class ObjectContainer<T> {
    private Node<T> head;
    private Predicate<T> condition;
    private int size;

    public ObjectContainer(Predicate<T> condition) {
        this.condition = condition;
    }

    public ObjectContainer() {
        this.condition = obj -> true;
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

        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;

        size--;
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

    public Node<T> get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (head == null) {
            throw new EmptyListException();
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

    public void storeToFile(String path, Predicate<T> condition, Function<T, String> formatter) {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Node<T> current = head;
            while (current != null) {
                if (condition.test(current.data)) {
                    String formattedData = formatter.apply(current.data);
                    writer.write(formattedData);
                    writer.newLine();
                }
                current = current.next;
            }
        } catch (IOException e) {
            throw new FileWritingException(path);
        }
    }

    public void storeToFile(String path) {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Node<T> current = head;

            if (current != null) {
                writer.write(current.data.getClass().getName());
                writer.newLine();

                Field[] fields = current.data.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    writer.write(fields[i].getName());
                    if (i < fields.length - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }

            while (current != null) {
                Field[] fields = current.data.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    Object value = fields[i].get(current.data);
                    writer.write(value != null ? value.toString() : "null");
                    if (i < fields.length - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
                current = current.next;
            }
        } catch (IOException | IllegalAccessException e) {
            throw new FileWritingException(path);
        }
    }


    public static <T> ObjectContainer<T> fromFile(String path) {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        ObjectContainer<T> container = new ObjectContainer<>();

        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String className = reader.readLine();
            if (className == null) {
                throw new IllegalStateException("File does not contain class name.");
            }

            Class<T> clazz = (Class<T>) Class.forName(className);

            String headerLine = reader.readLine();
            if (headerLine == null) {
                throw new IllegalStateException("File does not contain header.");
            }
            String[] headers = headerLine.split(",");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                T obj = createObjectFromCSV(headers, values, clazz);
                container.add(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to read from file", e);
        }

        return container;
    }


    private static <T> T createObjectFromCSV(String[] headers, String[] values, Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance = constructor.newInstance();

            for (int i = 0; i < headers.length; i++) {
                Field field = clazz.getDeclaredField(headers[i]);
                field.setAccessible(true);

                if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                    int intValue = Integer.parseInt(values[i]);
                    field.set(instance, intValue);
                } else if (field.getType().equals(String.class)) {
                    field.set(instance, values[i]);
                } else {
                    field.set(instance, values[i]);
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create object from CSV", e);
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
