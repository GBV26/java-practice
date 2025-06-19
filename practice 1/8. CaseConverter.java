import java.util.Scanner;

public class CaseConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String inputString = scanner.nextLine();

        int upperCaseCount = 0;
        int lowerCaseCount = 0;

        // Подсчет количества заглавных и строчных символов
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            }
        }

        // Преобразование строки
        String resultString;
        if (upperCaseCount > lowerCaseCount) {
            resultString = inputString.toUpperCase();
        } else {
            resultString = inputString.toLowerCase();
        }

        System.out.println("Результат: " + resultString);

        scanner.close();
    }
}