package testy.test3.zadanie1;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Node implements Serializable {
    public final String value;
    public Node next;
    public final LocalDateTime date;

    public Node(String value) {
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return value;
    }
}