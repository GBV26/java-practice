import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EveryThirdGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод количества игроков
        System.out.print("Введите количество игроков: ");
        int numberOfPlayers = scanner.nextInt();
        
        // Ввод номера игрока, с которого начинается игра
        System.out.print("Введите номер игрока, с которого начинается игра: ");
        int startPlayer = scanner.nextInt();
        
        // Создание списка игроков
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(i);
        }
        
        // Начало игры
        List<Integer> eliminatedPlayers = new ArrayList<>();
        int currentIndex = startPlayer - 1; // Индекс текущего игрока

        while (players.size() > 1) {
            // Находим индекс игрока, который будет выбывать
            currentIndex = (currentIndex + 2) % players.size(); // +2, чтобы считать каждого третьего
            int eliminatedPlayer = players.remove(currentIndex); // Удаляем игрока
            eliminatedPlayers.add(eliminatedPlayer); // Добавляем в список выбывших
            System.out.println("Выбывает игрок: " + eliminatedPlayer);
        }

        // Последний оставшийся игрок
        int winner = players.get(0);
        eliminatedPlayers.add(winner); // Добавляем победителя в список выбывших
        System.out.println("Победитель: " + winner);

        // Вывод всех выбывших игроков
        System.out.println("Список выбывших игроков: " + eliminatedPlayers);
        
        scanner.close();
    }
}