import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length > 0) {
            try {
                FileInputStream fstream = new FileInputStream(args[0]);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    System.out.println(strLine);
                }
                fstream.close();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}