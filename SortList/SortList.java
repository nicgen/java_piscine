import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        List<Integer> mutableList = new ArrayList<>(list); // Create a mutable copy
        Collections.sort(mutableList);
        return mutableList; // Return the sorted list
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        List<Integer> mutableList = new ArrayList<>(list); // Create a mutable copy
        Collections.sort(mutableList, Collections.reverseOrder());
        return mutableList; // Return the sorted list in reverse
    }
}
