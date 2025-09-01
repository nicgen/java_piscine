import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null || stringDate.isBlank()) {
            return  null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null || stringDate.isBlank()) {
            return  null
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM uuuu", Locale.FRENCH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null || stringDate.isBlank()) {
            return  null
        }
        // Extract hours, minutes, seconds
        Matcher m = Pattern.compile("(\\d{1,2}).*?(\\d{1,2}).*?(\\d{1,2})").matcher(stringDate);
        if (!m.find()) {
            throw new IllegalArgumentException("Invalid time format: " + stringDate);
        }
        int hour = Integer.parseInt(m.group(1));
        int minute = Integer.parseInt(m.group(2));
        int second = Integer.parseInt(m.group(3));

        String lower = stringDate.toLowerCase(Locale.ROOT);
        boolean isEvening = lower.contains("soir");
        boolean isMorning = lower.contains("matin");

        // If explicitly evening and hour in 1..11, convert to 24h format
        if (isEvening && hour >= 1 && hour <= 11) {
            hour = (hour % 12) + 12; // 12h -> 12, 1..11 -> 13..23
        }
        // If explicitly morning and hour == 12, convert to 0 (midnight in 12h notation, just in case)
        if (isMorning && hour == 12) {
            hour = 0;
        }

        return LocalTime.of(hour, minute, second);
    }

}