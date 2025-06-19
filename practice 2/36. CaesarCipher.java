import java.util.Random;

public class CaesarCipher {
    private static final int SHIFT = 3; // Сдвиг для шифрования

    public static void main(String[] args) {
        // Генерация зашифрованного текста
        String encryptedText = generateEncryptedText(1000);
        System.out.println("Зашифрованный текст:");
        System.out.println(encryptedText);

        // Расшифровка текста
        String decryptedText = decrypt(encryptedText);
        System.out.println("\nРасшифрованный текст:");
        System.out.println(decryptedText);
    }

    // Генерация зашифрованного текста
    private static String generateEncryptedText(int wordCount) {
        // Массив русских слов
        String[] words = {"пример", "шифр", "текст", "декодирование", "алгоритм", "программа", "язык", "разработка", "код", "информация"};
        StringBuilder encryptedText = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < wordCount; i++) {
            String word = words[random.nextInt(words.length)];
            encryptedText.append(encrypt(word)).append(" ");
        }

        return encryptedText.toString().trim();
    }

    // Метод для шифрования слова
    private static String encrypt(String word) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                // Проверка на кириллицу
                char base = (c >= 'а' && c <= 'я') ? 'а' : 'А';
                c = (char) ((c - base + SHIFT) % 32 + base);
            }
            encrypted.append(c);
        }

        return encrypted.toString();
    }

    // Метод для расшифровки текста
    private static String decrypt(String text) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                // Проверка на кириллицу
                char base = (c >= 'а' && c <= 'я') ? 'а' : 'А';
                c = (char) ((c - base - SHIFT + 32) % 32 + base);
            }
            decrypted.append(c);
        }

        return decrypted.toString();
    }
}
