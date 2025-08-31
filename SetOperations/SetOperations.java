import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        if (set1 != null) {
            result.addAll(set1);
        }
        if (set2 != null) {
            result.addAll(set2);
        }
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        if (set1 == null || set2 == null) {
            return result;
        }
        if (set1.size() <= set2.size()) {
            for (Integer val : set1) {
                if (set2.contains(val)) {
                    result.add(val);
                }
            }
        } else {
            for (Integer val : set2) {
                if (set1.contains(val)) {
                    result.add(val);
                }
            }
        }
        return result;
    }
}