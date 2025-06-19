import java.util.Scanner;

public class ArabicToRomanConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод количества лет
        System.out.print("Введите количество лет (1 < n < 10000): ");
        int years = scanner.nextInt();
        
        // Проверка диапазона
        if (years <= 1 || years >= 10000) {
            System.out.println("Ошибка: количество лет должно быть в диапазоне от 2 до 9999.");
        } else {
            // Конвертация в римские числа
            String romanNumeral = convertToRoman(years);
            System.out.println("Римское представление: " + romanNumeral);
        }
        
        scanner.close();
    }

    private static String convertToRoman(int number) {
        // Массивы для римских чисел
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // Конвертация числа в римские числа
        String roman = "";
        roman += thousands[number / 1000];
        roman += hundreds[(number % 1000) / 100];
        roman += tens[(number % 100) / 10];
        roman += units[number % 10];

        return roman;
    }
}