public class CaesarCipher {

    public static String caesarCipher(String text, int shift, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        if (!encrypt) {
            shift = -shift; // Если дешифрование, меняем знак сдвига
        }

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                int offset = currentChar - base;
                int newOffset = (offset + shift) % 26;

                // Обработка отрицательных значений (для дешифрования)
                if (newOffset < 0) {
                    newOffset += 26;
                }

                char encryptedChar = (char) (base + newOffset);
                result.append(encryptedChar);
            } else {
                result.append(currentChar); // Не изменяем символы, не являющиеся буквами
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        int shift = 3;

        String encryptedText = caesarCipher(text, shift, true);
        System.out.println("Зашифрованный текст: " + encryptedText); // KHOOR, ZRUOG!

        String decryptedText = caesarCipher(encryptedText, shift, false);
        System.out.println("Дешифрованный текст: " + decryptedText); // Hello, World!
    }
}