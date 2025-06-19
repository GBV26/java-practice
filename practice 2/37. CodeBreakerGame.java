import java.util.Random;
import java.util.Scanner;

public class CodeBreakerGame {
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 20;

    public static void main(String[] args) {
        int[] secretCode = generateSecretCode();
        System.out.println("Загадан код из " + CODE_LENGTH + " цифр. Попробуйте угадать его!");

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean isCodeGuessed = false;

        while (attempts < MAX_ATTEMPTS && !isCodeGuessed) {
            System.out.print("Введите вашу попытку (4 цифры): ");
            String userInput = scanner.nextLine();

            // Проверка на корректность ввода
            if (!isValidInput(userInput)) {
                System.out.println("Некорректный ввод. Пожалуйста, введите 4 цифры.");
                continue;
            }

            int[] userGuess = parseInput(userInput);
            int matches = countMatches(secretCode, userGuess);

            if (matches == CODE_LENGTH) {
                isCodeGuessed = true;
                System.out.println("Поздравляем! Вы угадали код: " + arrayToString(secretCode));
            } else {
                System.out.println("Совпадения: " + matches + " из " + CODE_LENGTH);
            }

            attempts++;
        }

        if (!isCodeGuessed) {
            System.out.println("Вы исчерпали все попытки. Загаданный код был: " + arrayToString(secretCode));
        }

        scanner.close();
    }

    // Генерация случайного кода
    private static int[] generateSecretCode() {
        Random random = new Random();
        int[] code = new int[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            code[i] = random.nextInt(10); // Генерация цифр от 0 до 9
        }
        return code;
    }

    // Проверка на корректность ввода
    private static boolean isValidInput(String input) {
        return input.matches("\\d{4}");
    }

    // Преобразование строки ввода в массив целых чисел
    private static int[] parseInput(String input) {
        int[] guess = new int[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            guess[i] = Character.getNumericValue(input.charAt(i));
        }
        return guess;
    }

    // Подсчет совпадений между загаданным кодом и попыткой игрока
    private static int countMatches(int[] secretCode, int[] userGuess) {
        int matches = 0;
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode[i] == userGuess[i]) {
                matches++;
            }
        }
        return matches;
    }

    // Преобразование массива в строку для отображения
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num);
        }
        return sb.toString();
    }
}