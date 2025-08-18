public class CleanExtract {
    public static String extract(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input must not be null");
        }

        String[] parts = s.split("\\|");
        StringBuilder out = new StringBuilder();

        for (String part : parts) {
            int firstDot = part.indexOf('.');
            int lastDot = part.lastIndexOf('.');

            String cleaned;
            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                cleaned = part.substring(firstDot + 1, lastDot).trim();
            } else {
                cleaned = part.trim().replaceAll("^\\.+|\\.+$", "").trim();
            }

            if (!cleaned.isEmpty()) {
                if (out.length() > 0) out.append(' ');
                out.append(cleaned);
            }
        }

        return out.toString();
    }
}