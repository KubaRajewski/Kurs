package testy.test3.zadanie1.exceptions;

import java.io.File;

public class FileWritingException extends RuntimeException {
    public FileWritingException() {
    }

    public FileWritingException(String path) {
        super("Error writing data to file: " + path);
    }
}
