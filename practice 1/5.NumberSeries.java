import java.util.Scanner;

public class NumberSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начало ряда: ");
        int start = scanner.nextInt();

        System.out.print("Введите шаг: ");
        int step = scanner.nextInt();

        System.out.print("Введите количество шагов: ");
        int count = scanner.nextInt();

        System.out.print("Ряд чисел: ");
        for (int i = 0; i < count; i++) {
            int number = start + i * step; // Вычисляем текущее число
            System.out.print(number + " ");
        }
        System.out.println(); // Перевод строки

        scanner.close();
    }
}