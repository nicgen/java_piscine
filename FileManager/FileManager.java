import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        Path path = Path.of(fileName);
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        Files.writeString(
                path,
                content == null ? "" : content,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE
        );
    }

    public static String getContentFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        if (!Files.exists(path)) {
            throw new IOException("File not found: " + fileName);
        }
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    public static void deleteFile(String fileName) {
        Path path = Path.of(fileName);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to delete file: " + fileName, e);
        }
    }
}