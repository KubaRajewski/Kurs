package testy.test3.exceptions;

public class ConditionNotMatchedException extends RuntimeException {
    public ConditionNotMatchedException() {
    }

    public ConditionNotMatchedException(String message) {
        super(message);
    }
}
