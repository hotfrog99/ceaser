public class BruteForceDecrypt {

    public static void bruteForceDecrypt(String encryptedText, String alphabet) {
        for (int shift = 1; shift < alphabet.length(); shift++) {
            String decryptedText = CaesarCipher.decrypt(encryptedText, shift, alphabet);
            System.out.println("Shift " + shift + ": " + decryptedText);
        }
    }
}
