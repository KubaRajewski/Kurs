package testy.test3.zadanie2.exceptions;

public class FileWritingException extends RuntimeException {
    public FileWritingException() {
    }

    public FileWritingException(String path) {
        super("Error writing data to file: " + path);
    }
}