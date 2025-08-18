public class CleanExtract {
    public static String extract(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input must not be null");
        }

        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String rawPart : parts) {
            String part = rawPart;
            int firstDot = part.indexOf('.');
            int lastDot = part.lastIndexOf('.');

            if (firstDot == -1 || lastDot == -1 || firstDot == lastDot) {
                continue;
            }

            String between = part.substring(firstDot + 1, lastDot).trim();
            if (!between.isEmpty()) {
                if (result.length() > 0) {
                    result.append(' ');
                }
                result.append(between);
            }
        }

        return result.toString();
    }
}