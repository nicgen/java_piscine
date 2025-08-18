public class StringReplace {
    public static String replace(String s, char target, char replacement) {
        if (s == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }
        return s.replace(target, replacement);
    }

    public static String replace(String s, String target, String replacement) {
        if (s == null || target == null || replacement == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        return s.replace(target, replacement);
    }
}
