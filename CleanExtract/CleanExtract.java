public class CleanExtract {
    public static String extract(String s) {
        String[] arr = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String str : arr) {
            str = str.trim();
            int first = str.indexOf(".");
            int last = str.lastIndexOf(".");

            if (first != -1 && last != -1 && first < last) {
                result.append(str.substring(first + 1, last)).append(" ");
            } else if (first != -1 && last == first) {
                result.append(str.substring(first + 1)).append(" ");
            } else if (first == -1 && last != -1) {
                result.append(str.substring(0, last)).append(" ");
            } else if (first == -1 && last == -1) {
                result.append(str).append(" ");
            }
        }

        return result.toString().replaceAll("\\s+", " ").trim();
    }
}