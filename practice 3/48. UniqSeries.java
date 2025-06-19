import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.Queue;

public class UniqSeries {

    public static Set<Integer> generateUniqSeries(int limit) {
        Set<Integer> series = new TreeSet<>(); // TreeSet для автоматической сортировки и отсутствия дубликатов
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1); // Начинаем с u(0) = 1
        series.add(1);

        while (series.size() < limit) {  //Генерируем до достижения limit уникальных чисел
            int current = queue.poll(); // Извлекаем текущий элемент из очереди

            int y = 2 * current + 1; // Вычисляем y
            int z = 3 * current + 1; // Вычисляем z

            if (!series.contains(y) && series.size() < limit) {
                series.add(y);
                queue.offer(y);
            }
            if (!series.contains(z) && series.size() < limit) {
                series.add(z);
                queue.offer(z);
            }
        }

        return series;
    }

    public static void main(String[] args) {
        int x = 15; // Пример: сгенерировать первые 15 уникальных чисел
        Set<Integer> uniqSeries = generateUniqSeries(x);

        System.out.println("Уникальный ряд чисел u до " + x + " элементов: " + uniqSeries);
    }
}