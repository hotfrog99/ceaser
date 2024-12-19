import java.io.File;

public class Validator {

    // Проверка на существование файла
    public static boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.isFile();
    }

    // Проверка допустимости ключа
    public static boolean isValidKey(int key) {
        return key >= 1 && key <= 25;  // Для шифра Цезаря ключ может быть только от 1 до 25
    }
}
