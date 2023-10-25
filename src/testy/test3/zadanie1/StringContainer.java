package testy.test3.zadanie1;

import testy.test3.zadanie1.exceptions.DuplicatedElementOnListException;
import testy.test3.zadanie1.exceptions.InvalidStringContainerPatternException;
import testy.test3.zadanie1.exceptions.InvalidStringContainerValueException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringContainer {
    private final Pattern pattern;
    private Node head;
    private int size;
    private final boolean duplicatesNotAllowed;

    public StringContainer(String patternString) {
        try {
            this.pattern = Pattern.compile(patternString);
        } catch (PatternSyntaxException e) {
            throw new InvalidStringContainerPatternException(patternString);
        }
        this.duplicatesNotAllowed = false;
    }

    public StringContainer(String patternString, boolean duplicatesNotAllowed) {
        try {
            this.pattern = Pattern.compile(patternString);
        } catch (PatternSyntaxException e) {
            throw new InvalidStringContainerPatternException(patternString);
        }
        this.duplicatesNotAllowed = duplicatesNotAllowed;
    }

    public Node get(int index) {
        Node current = head;
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
            head = new Node(value);
            size++;
            return;
        }

        Node current = head;
        if (duplicatesNotAllowed && current.value.equals(value)) {
            throw new DuplicatedElementOnListException(value);
        }

        while (current.next != null) {
            if (duplicatesNotAllowed && current.next.value.equals(value)) {
                throw new DuplicatedElementOnListException(value);
            }
            current = current.next;
        }

        current.next = new Node(value);
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void remove(String value) {
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
        }
    }

    public StringContainer getDataBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
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
        File file = new File(path);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Node current = head;
            while (current != null) {
                writer.write(current.value);
                writer.newLine();
                current = current.next;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static StringContainer fromFile(String path) throws IOException {
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String patternString = reader.readLine();
            if (patternString == null) {
                throw new IOException("The file is empty. Expected a pattern on the first line.");
            }

            StringContainer container = new StringContainer(patternString);

            String line;
            while ((line = reader.readLine()) != null) {
                container.add(line);
            }

            return container;
        }
    }


    public Pattern getPattern() {
        return pattern;
    }

    public int getSize() {
        return size;
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