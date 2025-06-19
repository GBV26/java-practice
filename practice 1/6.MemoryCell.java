import java.util.Scanner;
import java.util.Arrays;

public class MemoryCell {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ячейка памяти (массив)
        int[] memory = new int[3];
        Arrays.fill(memory, Integer.MAX_VALUE); // Инициализация MAX_VALUE, чтобы считать ячейку пустой

        System.out.println("Введите числа (для завершения введите 'стоп'):");

        while (true) {
            System.out.print("Введите число: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("стоп")) {
                break; // Завершение ввода
            }

            try {
                int number = Integer.parseInt(input);

                // Поиск пустой ячейки
                int emptyIndex = -1;
                for (int i = 0; i < memory.length; i++) {
                    if (memory[i] == Integer.MAX_VALUE) {
                        emptyIndex = i;
                        break;
                    }
                }

                if (emptyIndex != -1) {
                    // Есть пустая ячейка - заполняем
                    memory[emptyIndex] = number;
                    System.out.println("Число " + number + " добавлено в ячейку " + emptyIndex);
                } else {
                    // Нет пустых ячеек - заменяем наименьшее
                    int minIndex = 0;
                    for (int i = 1; i < memory.length; i++) {
                        if (memory[i] < memory[minIndex]) {
                            minIndex = i;
                        }
                    }

                    if (number > memory[minIndex]) {
                        memory[minIndex] = number;
                        System.out.println("Число " + number + " заменило число " + memory[minIndex] + " в ячейке " + minIndex);
                    } else {
                        System.out.println("Число " + number + " меньше наименьшего в памяти, замена не произведена.");
                    }
                }

                System.out.println("Текущее состояние памяти: " + Arrays.toString(memory));

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите целое число или 'стоп'.");
            }
        }

        System.out.println("Финальное состояние памяти: " + Arrays.toString(memory));
        scanner.close();
    }
}