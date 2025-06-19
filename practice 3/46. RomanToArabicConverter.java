import java.util.Scanner;

public class RomanToArabicConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод римского числа
        System.out.print("Введите римское число (в диапазоне от I до MMMMCMXCIX): ");
        String romanNumeral = scanner.nextLine().toUpperCase();
        
        // Конвертация в арабские числа
        int arabicNumber = convertToArabic(romanNumeral);
        
        // Проверка на допустимость
        if (arabicNumber < 2 || arabicNumber >= 10000) {
            System.out.println("Ошибка: количество лет должно быть в диапазоне от 2 до 9999.");
        } else {
            System.out.println("Арабское представление: " + arabicNumber);
        }
        
        scanner.close();
    }

    private static int convertToArabic(String roman) {
        int total = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentValue = getRomanValue(currentChar);

            // Если текущее значение меньше предыдущего, вычитаем его, иначе добавляем
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }

        return total;
    }

    private static int getRomanValue(char romanChar) {
        switch (romanChar) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0; // Неверный символ
        }
    }
}
