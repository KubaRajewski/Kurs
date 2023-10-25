package testy.test3.zadanie1;

import java.time.LocalDateTime;

public class Element {
    public final String value;
    public Element next;
    public final LocalDateTime date;

    public Element(String value) {
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}