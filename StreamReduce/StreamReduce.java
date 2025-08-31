import java.util.Objects;
import java.util.stream.Stream;

public class StreamReduce {
    public static Integer sumAll(Stream<Integer> s) {
        return s
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        return s
                .filter(Objects::nonNull)
                .mapToInt(i -> i / divider)
                .sum();
    }
}