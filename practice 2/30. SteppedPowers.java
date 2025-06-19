import java.util.Scanner;

public class SteppedPowers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите положительное число: ");
        int number = scanner.nextInt();

        System.out.print("Введите число для начала ряда: ");
        int startPower = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Число должно быть положительным.");
            scanner.close();
            return;
        }

        long sumOfPowers = 0;
        String numStr = String.valueOf(number);
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sumOfPowers += Math.pow(digit, startPower + i);
        }

        boolean possible = false;
        for (int i = 1; i <= 64; i++) { // Проверяем множители 2^0, 2^1, ..., 2^6
            long multiplier = (long) Math.pow(2, i); // Используем long для больших степеней двойки

            if (sumOfPowers == (long)number * (multiplier/2)) { // (long) cast to avoid potential overflow
                possible = true;
                System.out.println(numStr + ", " + startPower + " => " + sumOfPowers + " = " + number + " * " + (multiplier/2));
                break;
            }
        }

        if (!possible) {
            System.out.println(numStr + ", " + startPower + " => Сумма степеней не является произведением числа на множитель 2^k (k <= 6)");
        }


        scanner.close();
    }
}