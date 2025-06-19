import java.util.Scanner;

public class StickGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество палочек (n):");
        long n = scanner.nextLong();

        if (n < 1 || n > 1000000000000000000L) { // 10^18
            System.out.println("Недопустимое количество палочек.  n должно быть в диапазоне [1, 10^18].");
            return;
        }

        boolean sashaTurn = true; // Начинает Саша
        while (n > 0) {
            if (sashaTurn) {
                System.out.print("Ход Саши.  Доступные действия: ");
            } else {
                System.out.print("Ход Тани. Доступные действия: ");
            }

            if (n % 2 == 0) {
                System.out.print("1, " + (n / 2) + ".  Сколько палочек возьмете? ");
                long take = scanner.nextLong();

                if (take != 1 && take != n / 2) {
                    System.out.println("Недопустимое количество палочек. Можно взять 1 или " + (n / 2));
                    continue; // Повторяем ход текущего игрока
                }
                n -= take;

            } else {
                System.out.println("Только 1. Сколько палочек возьмете? ");
                long take = scanner.nextLong();

                if (take != 1) {
                    System.out.println("Недопустимое количество палочек. Можно взять только 1.");
                    continue; // Повторяем ход текущего игрока
                }
                n -= take;
            }

            System.out.println("Осталось палочек: " + n);
            sashaTurn = !sashaTurn; // Передаем ход
        }


        if (sashaTurn) {
            System.out.println("Таня победила!"); // Саша сделал последний ход, значит Таня победила.
        } else {
            System.out.println("Саша победил!"); // Таня сделала последний ход, значит Саша победила.
        }

        scanner.close();
    }
}