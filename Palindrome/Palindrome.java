public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String ls = s.toLowerCase(); // Convert to lower case
        String reversed = new StringBuilder(ls).reverse().toString();
        return ls.equals(reversed);
    }
}