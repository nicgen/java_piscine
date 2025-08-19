import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length != 1 || args[0] == null) {
            throw new IllegalArgumentException("Exactly one output file path must be provided.");
        }
        try (InputStream in = System.in;
             OutputStream out = new FileOutputStream(args[0])) {
            byte[] buffer = new byte[8192]; // Read in chunks to handle large/binary input efficiently
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            out.flush();
        }
    }
}