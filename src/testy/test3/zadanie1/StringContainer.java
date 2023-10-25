package testy.test3.zadanie1;

import testy.test3.zadanie1.exceptions.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringContainer {
    private final Pattern pattern;
    private Element head;
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

    public Element get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (head == null) {
            throw new EmptyListException("List is empty.");
        }

        Element current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void add(String value) {
        if (!pattern.matcher(value).matches()) {
            throw new InvalidStringContainerValueException(value);
        }

        if (head == null) {
            head = new Element(value);
            size++;
            return;
        }

        Element current = head;
        while (true) {
            if (duplicatesNotAllowed && current.value.equals(value)) {
                throw new DuplicatedElementOnListException(value);
            }

            if (current.next == null) {
                current.next = new Element(value);
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
            Element current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void remove(String value) {
        if (head == null) {
            throw new NullPointerException("List is empty.");
        }

        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return;
        }

        Element current = head;
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

    public StringContainer getDataBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
        if (dateFrom != null && dateTo != null && dateFrom.isAfter(dateTo)) {
            throw new IllegalArgumentException("Start date is after end date.");
        }

        StringContainer st = new StringContainer(pattern.toString());

        Element current = head;
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

        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(pattern.toString());
            writer.newLine();

            Element current = head;
            while (current != null) {
                writer.write(current.value);
                writer.newLine();
                current = current.next;
            }
        } catch (IOException e) {
            throw new FileWritingException(path);
        }
    }

    public static StringContainer fromFile(String path) {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String patternString = reader.readLine();
            if (patternString == null) {
                throw new FileReadingException("The file is empty. Expected a pattern on the first line.");
            }
            StringContainer container = new StringContainer(patternString);
            String line;
            while ((line = reader.readLine()) != null) {
                container.add(line);
            }
            return container;
        } catch (IOException e) {
            throw new FileReadingException(path);
        }
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