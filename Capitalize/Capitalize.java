import java.io.*;
import java.util.logging.*;

public class Capitalize {
    private static final Logger logger = Logger.getLogger(Capitalize.class.getName());

    public static void capitalize(String[] args) throws IOException {
        if (args.length != 2) {
            logger.log(Level.SEVERE, "Usage: java Capitalize <inputFile> <outputFile>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String capitalizedLine = capitalizeLine(line);
                writer.write(capitalizedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error while reading/writing file", e);
        }
    }

    public static String capitalizeLine(String line) {
        String[] words = line.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase()).append(" ");
            }
        }

        return result.toString().trim(); // Remove trailing space
    }

}