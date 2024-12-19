import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  // Для английского алфавита. Для русского можно использовать "АБВГДЕЁЖЗИ..."

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Brute Force Decrypt");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter input file name: ");
                    String inputFile = scanner.nextLine();
                    System.out.print("Enter output file name: ");
                    String outputFile = scanner.nextLine();
                    System.out.print("Enter shift key (1-25): ");
                    int key = scanner.nextInt();
                    if (!Validator.isValidKey(key)) {
                        System.out.println("Invalid key.");
                        break;
                    }
                    String inputText = FileHandler.readFile(inputFile);
                    String encryptedText = CaesarCipher.encrypt(inputText, key, alphabet);
                    FileHandler.writeFile(outputFile, encryptedText);
                    System.out.println("Text encrypted and saved to " + outputFile);
                    break;

                case 2:
                    System.out.print("Enter input file name: ");
                    inputFile = scanner.nextLine();
                    System.out.print("Enter output file name: ");
                    outputFile = scanner.nextLine();
                    System.out.print("Enter shift key (1-25): ");
                    key = scanner.nextInt();
                    if (!Validator.isValidKey(key)) {
                        System.out.println("Invalid key.");
                        break;
                    }
                    inputText = FileHandler.readFile(inputFile);
                    String decryptedText = CaesarCipher.decrypt(inputText, key, alphabet);
                    FileHandler.writeFile(outputFile, decryptedText);
                    System.out.println("Text decrypted and saved to " + outputFile);
                    break;

                case 3:
                    System.out.print("Enter encrypted text: ");
                    scanner.nextLine();  // consume the newline character
                    String encryptedMessage = scanner.nextLine();
                    BruteForceDecrypt.bruteForceDecrypt(encryptedMessage, alphabet);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
