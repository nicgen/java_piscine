import java.io.*;
import java.nio.charset.StandardCharsets;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length < 2) {
            return;
        }
        String inputPath = args[0];
        String outputPath = args[1];

        try (
                Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8));
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath), StandardCharsets.UTF_8))
        ) {
            int codePoint;
            boolean startOfWord = true;

            while ((codePoint = reader.read()) != -1) {
                char ch = (char) codePoint;

                if (Character.isLetter(ch)) {
                    if (startOfWord) {
                        ch = Character.toUpperCase(ch);
                    } else {
                        ch = Character.toLowerCase(ch);
                    }
                    startOfWord = false;
                } else {
                    // Any non-letter character breaks the word
                    startOfWord = true;
                }

                writer.write(ch);
            }
        }
    }
}