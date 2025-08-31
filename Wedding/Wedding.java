import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        Map<String, String> couples = new HashMap<>();
        if (first == null || second == null || first.isEmpty() || second.isEmpty()) {
            return couples;
        }

        List<String> list1 = new ArrayList<>(first);
        List<String> list2 = new ArrayList<>(second);

        // Remove potential nulls to avoid null keys/values
        list1.removeIf(Objects::isNull);
        list2.removeIf(Objects::isNull);

        if (list1.isEmpty() || list2.isEmpty()) {
            return couples;
        }

        Collections.shuffle(list1);
        Collections.shuffle(list2);

        int size = Math.min(list1.size(), list2.size());
        for (int i = 0; i < size; i++) {
            couples.put(list1.get(i), list2.get(i));
        }
        return couples;
    }
}