package testy.test3.zadanie2.exceptions;

import java.util.function.Predicate;

public class ConditionNotMatchedException extends RuntimeException {
    public ConditionNotMatchedException() {
    }

    public ConditionNotMatchedException(String message) {
        super(message);
    }
}
