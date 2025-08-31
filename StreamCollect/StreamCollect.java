import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        return s
                .filter(str -> str != null && !str.isEmpty())
                .collect(Collectors.groupingBy(str -> Character.toUpperCase(str.charAt(0))));
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        return s
                .filter(i -> i != null)
                .collect(Collectors.groupingBy(
                        i -> Math.floorMod(i, 4),
                        Collectors.maxBy(Comparator.naturalOrder())
                ));
    }

    public static String orderAndConcatWithSharp(Stream<String> s) {
        return s
                .filter(str -> str != null)
                .sorted()
                .collect(Collectors.joining(" # ", "{", "}"));
    }
}