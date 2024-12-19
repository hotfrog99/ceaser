import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class FileHandler {

    // Чтение текста из файла
    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
    }

    // Запись текста в файл
    public static void writeFile(String fileName, String content) throws IOException {
        Files.write(Paths.get(fileName), content.getBytes(StandardCharsets.UTF_8));
    }
}
