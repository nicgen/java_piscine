public class RegexReplace {
    public static String removeUnits(String s) {
        if (s == null) return null;
        // Remove "cm" or "€" only when they directly follow a digit and are followed by a space
        String res = s.replaceAll("(?<=\\d)cm(?= )", "");
        res = res.replaceAll("(?<=\\d)€(?= )", "");
        return res;
    }

    public static String obfuscateEmail(String s) {
        if (s == null) return null;
        int at = s.indexOf('@');
        if (at < 0) return s;

        String user = s.substring(0, at);
        String domain = s.substring(at + 1);

        // Obfuscate username
        String maskedUser;
        int lastSepIdx = Math.max(user.lastIndexOf('.'),
                Math.max(user.lastIndexOf('-'), user.lastIndexOf('_')));
        if (lastSepIdx >= 0) {
            String prefix = user.substring(0, lastSepIdx + 1);
            int maskLen = Math.max(0, user.length() - (lastSepIdx + 1));
            maskedUser = prefix + "*".repeat(maskLen);
        } else {
            if (user.length() > 3) {
                maskedUser = user.substring(0, 3) + "*".repeat(user.length() - 3);
            } else {
                maskedUser = user;
            }
        }

        // Obfuscate domain
        String[] parts = domain.split("\\.");
        String maskedDomain;
        if (parts.length == 3) {
            String third = parts[0];
            String second = parts[1];
            String top = parts[2];
            maskedDomain = "*".repeat(third.length()) + "." + second + "." + "*".repeat(top.length());
        } else if (parts.length == 2) {
            String second = parts[0];
            String top = parts[1].toLowerCase();
            String maskedSecond = "*".repeat(second.length());
            if (top.equals("com") || top.equals("org") || top.equals("net")) {
                maskedDomain = maskedSecond + "." + parts[1];
            } else {
                maskedDomain = maskedSecond + "." + "*".repeat(parts[1].length());
            }
        } else {
            // Fallback: if unexpected format, leave as is
            maskedDomain = domain;
        }

        return maskedUser + "@" + maskedDomain;
    }
}