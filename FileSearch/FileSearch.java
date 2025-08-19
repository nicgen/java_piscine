import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FileSearch {
    public static String searchFile(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            return null;
        }

        Path root = Paths.get("documents");
        if (!Files.isDirectory(root)) {
            return null;
        }

        try (Stream<Path> paths = Files.walk(root)) {
            Optional<Path> found = paths
                .filter(Files::isRegularFile)
                .filter(p -> p.getFileName().toString().equals(fileName))
                .findFirst();

            return found.map(Path::toString).orElse(null);
        } catch (IOException e) {
            // Could log the exception if needed
            return null;
        }
    }
}