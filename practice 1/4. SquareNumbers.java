import java.util.Scanner;

public class SquareNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        // Определяем начало (наименьшее число) и шаг
        int start = Math.min(num1, num2);
        int step = Math.abs(num1 - num2);

        // Выводим ряд чисел
        System.out.print("Числа: ");
        int count = 0; // Счетчик выведенных чисел (ограничим количество)
        for (int i = start; count < 10; i += step) { // Выводим не более 10 чисел
            System.out.print(i + " ");
            count++;
        }
        System.out.println(); // Перевод строки

        // Выводим квадраты этих чисел
        System.out.print("Квадраты: ");
        count = 0; // Сбрасываем счетчик
        for (int i = start; count < 10; i += step) { // Выводим не более 10 чисел
            System.out.print((long)i * i + " ");
            count++;
        }
        System.out.println(); // Перевод строки

        scanner.close();
    }
}