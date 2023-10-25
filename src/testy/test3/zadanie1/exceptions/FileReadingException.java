package testy.test3.zadanie1.exceptions;

import java.io.File;

public class FileReadingException extends RuntimeException {
    public FileReadingException() {
    }

    public FileReadingException(String path) {
        super("Error while reading file: " + path);
    }
}
