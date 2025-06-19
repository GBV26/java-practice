import java.util.Scanner;

public class SticksGameWithInput {

    public static long calculateTanyaSticks(long n) {
        long tanyaSticks = 0;
        boolean tanyaTurn = true; // Таня ходит первой

        while (n > 0) {
            if (tanyaTurn) {
                // Ход Тани
                if (n % 2 == 0) {
                    // Четное количество палочек
                    if (n / 2 > 1) {
                        // Больше 2 палочек, выгоднее взять половину
                        tanyaSticks += n / 2;
                        n -= n / 2;
                    } else {
                        // Взять одну палочку
                        tanyaSticks += 1;
                        n -= 1;
                    }
                } else {
                    // Нечетное количество палочек - берем одну
                    tanyaSticks += 1;
                    n -= 1;
                }
            } else {
                // Ход Саши (старается взять как можно больше)
                if (n % 2 == 0) {
                    // Четное количество палочек
                    if (n / 2 > 1) {
                        // Берет половину
                        n -= n / 2;
                    } else {
                        // Берет одну
                        n -= 1;
                    }
                } else {
                    // Нечетное количество - берет одну
                    n -= 1;
                }
            }

            tanyaTurn = !tanyaTurn; // Переход хода
        }

        return tanyaSticks;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальное количество палочек (1 <= n <= 10^18): ");
        long n = scanner.nextLong(); // Используем nextLong() для long

        // Добавляем проверку ввода
        if (n < 1) {
            System.out.println("Ошибка: количество палочек должно быть больше 0.");
            scanner.close();
            return;
        }

        long tanyaResult = calculateTanyaSticks(n);
        System.out.println("Количество палочек у Тани: " + tanyaResult);

        scanner.close();
    }
}