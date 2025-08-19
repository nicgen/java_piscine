import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return; // nothing to do
        }

        try (InputStream in = new BufferedInputStream(new FileInputStream(args[0]))) {
            OutputStream out = System.out;
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            out.flush();
        }
    }
}