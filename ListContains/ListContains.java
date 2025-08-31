import java.util.List;

public class ListContains {
    public static Boolean containsValue(List<Integer> list, Integer value) {
        if (list == null){
            return false;
        }
        return list.contains(value);
    }
}