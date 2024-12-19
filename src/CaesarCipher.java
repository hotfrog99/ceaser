public class CaesarCipher {

    // Метод для сдвига символа на определенное количество позиций
    public static char shiftChar(char ch, int shift, String alphabet) {
        if (Character.isLetter(ch)) {
            int alphabetSize = alphabet.length();
            int idx = alphabet.indexOf(Character.toUpperCase(ch));
            int newIdx = (idx + shift) % alphabetSize;
            if (newIdx < 0) newIdx += alphabetSize;  // Обработка цикличности

            char newChar = alphabet.charAt(newIdx);
            return Character.isLowerCase(ch) ? Character.toLowerCase(newChar) : newChar;
        }
        return ch;  // Если не буква, возвращаем как есть
    }

    // Метод для шифрования текста
    public static String encrypt(String text, int shift, String alphabet) {
        StringBuilder encryptedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encryptedText.append(shiftChar(ch, shift, alphabet));
        }
        return encryptedText.toString();
    }

    // Метод для расшифровки текста
    public static String decrypt(String text, int shift, String alphabet) {
        return encrypt(text, -shift, alphabet);  // Для расшифровки достаточно инвертировать сдвиг
    }
}
