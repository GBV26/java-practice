import java.util.Scanner;

public class SquareDifference {

    public static void findSquares(int n) {
        if (n <= 0 || n >= 100000) {
            System.out.println("Число должно быть в диапазоне (0, 100000)");
            return;
        }

        // n = (x+1)^2 - x^2
        // n = x^2 + 2x + 1 - x^2
        // n = 2x + 1
        // 2x = n - 1
        // x = (n - 1) / 2

        if ((n - 1) % 2 != 0) {
            System.out.println("Невозможно представить число " + n + " как разность двух последовательных квадратов целых чисел.");
            return;
        }

        int x = (n - 1) / 2;
        int square1 = (x + 1) * (x + 1);
        int square2 = x * x;

        System.out.println(n + " = " + square1 + " - " + square2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число (0 < n < 100000): ");
        int n = scanner.nextInt();
        scanner.close();

        findSquares(n);
    }
}