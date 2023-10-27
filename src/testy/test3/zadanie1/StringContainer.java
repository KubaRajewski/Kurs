package testy.test3.zadanie1;

import testy.test3.zadanie1.exceptions.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringContainer implements Serializable {
    private final Pattern pattern;
    private Node head;
    private int size;
    private final boolean duplicatesNotAllowed;

    public StringContainer(String patternString, boolean duplicatesNotAllowed) {
        try {
            this.pattern = Pattern.compile(patternString);
        } catch (PatternSyntaxException e) {
            throw new InvalidStringContainerPatternException(patternString);
        }
        this.duplicatesNotAllowed = duplicatesNotAllowed;
    }

    public StringContainer(String patternString) {
        this(patternString, false);
    }

    public void add(String value) {
        if (!pattern.matcher(value).matches()) {
            throw new InvalidStringContainerValueException(value);
        }

        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }

        Node current = head;
        while (true) {
            if (duplicatesNotAllowed && current.value.equals(value)) {
                throw new DuplicatedElementOnListException(value);
            }

            if (current.next == null) {
                current.next = new Node(value);
                size++;
                return;
            }

            current = current.next;
        }
    }

    public void remove(int index) {
        if (head == null) {
            throw new EmptyListException("List is empty.");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = (current.next != null) ? current.next.next : null;
        }

        size--;
    }

    public void remove(String value) {
        if (head == null) {
            throw new EmptyListException("List is empty.");
        }

        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.value.equals(value)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        } else {
            throw new IllegalArgumentException("Value not found in the list: " + value);
        }
    }


    public Node get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (head == null) {
            throw new EmptyListException("List is empty.");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public StringContainer getDataBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
        if (dateFrom != null && dateTo != null && dateFrom.isAfter(dateTo)) {
            throw new IllegalArgumentException("Start date is after end date.");
        }

        StringContainer st = new StringContainer(pattern.toString());

        Node current = head;
        while (current != null) {
            boolean afterStart = (dateFrom == null || current.getDate().isAfter(dateFrom));
            boolean beforeEnd = (dateTo == null || current.getDate().isBefore(dateTo));

            if (afterStart && beforeEnd) {
                st.add(current.value);
            }

            current = current.next;
        }

        return st;
    }

    public void storeToFile(String path) {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(this);

        } catch (IOException e) {
            e.printStackTrace();
            throw new FileWritingException(path);
        }
    }

    public static StringContainer fromFile(String path) {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        StringContainer stringContainer = null;

        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            stringContainer = (StringContainer) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new FileReadingException(path);
        }
        return stringContainer;
    }

    public int getSize() {
        return size;
    }

    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringContainer that)) return false;
        return size == that.size && Objects.equals(pattern, that.pattern) && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, head, size);
    }

    @Override
    public String toString() {
        return "StringContainer{" + " Pattern: " + pattern + ", Size: " + size + " }";
    }
}