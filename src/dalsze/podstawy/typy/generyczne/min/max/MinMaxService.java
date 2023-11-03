package dalsze.podstawy.typy.generyczne.min.max;

import java.util.Collections;
import java.util.List;

public class MinMaxService<T> {
    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        return new MinMax<>(Collections.min(elements), Collections.max(elements));
    }
}
