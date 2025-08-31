public class RegexMatch {
    public static boolean containsOnlyAlpha(String s) {
        if (s == null) return false;
        return s.matches("^[A-Za-z]+$");
    }

    public static boolean startWithLetterAndEndWithNumber(String s) {
        if (s == null) return false;
        return s.matches("^[A-Za-z].*[0-9]$");
    }

    public static boolean containsAtLeast3SuccessiveA(String s) {
        if (s == null) return false;
        return s.matches(".*A{3,}.*");
    }
}