import java.io.*;

public class Cat {
    private Cat() {}

    private Cat() {}

import java.io.*;
import java.util.logging.*;

    public class Cat {
        private static final Logger logger = Logger.getLogger(Cat.class.getName());

        public static void cat(String[] args) throws IOException {
            if (args.length != 1) {
                logger.severe("Usage: java Cat <filename>");
                return;
            }

            String filename = args[0];
            try (InputStream inputStream = new FileInputStream(filename)) {
                byte[] buffer = new byte[4096]; // buffer size
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    System.out.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error reading file: " + filename, e);
                String filename = args[0];
                try (InputStream inputStream = new FileInputStream(filename)) {
                    byte[] buffer = new byte[4096]; // buffer size
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        System.out.write(buffer, 0, bytesRead);
                    }
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "Error reading file: " + filename, e);
                }
            }
        }
    }}