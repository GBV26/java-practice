import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CityTrip {

    /**
     * Находит комбинацию из `num_cities` городов, сумма расстояний между которыми
     * максимальна и не превышает `maxDistance`.
     *
     * @param maxDistance Максимально допустимое расстояние.
     * @param numCities   Количество городов, которые нужно посетить.
     * @param distances   Список расстояний между городами.
     * @return Максимальную сумму расстояний, не превышающую `maxDistance`,
     *         или `null`, если такой комбинации не существует.  Возвращает также список оптимальных городов.
     */
    public static Result chooseBestSum(int maxDistance, int numCities, List<Integer> distances) {
        int bestSum = -1; // Используем -1, чтобы обозначить, что лучшей суммы пока нет
        List<Integer> bestCities = null;

        List<List<Integer>> combinations = generateCombinations(distances, numCities);

        for (List<Integer> combination : combinations) {
            int currentSum = combination.stream().mapToInt(Integer::intValue).sum();
            if (currentSum <= maxDistance) {
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestCities = combination;
                }
            }
        }

        if (bestSum == -1) {
            return new Result(null, null); // Нет подходящих комбинаций
        } else {
            return new Result(bestSum, bestCities);
        }
    }


    /**
     * Генерирует все комбинации элементов из списка `input` длиной `k`.
     *
     * @param input Список элементов.
     * @param k     Длина комбинации.
     * @return Список списков, представляющих комбинации.
     */
    private static <T> List<List<T>> generateCombinations(List<T> input, int k) {
        List<List<T>> result = new ArrayList<>();
        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        if (input.isEmpty()) {
            return result;
        }

        T first = input.get(0);
        List<T> rest = input.subList(1, input.size());

        // Рекурсивно получаем комбинации, включающие первый элемент
        for (List<T> comb : generateCombinations(rest, k - 1)) {
            List<T> newComb = new ArrayList<>();
            newComb.add(first);
            newComb.addAll(comb);
            result.add(newComb);
        }

        // Рекурсивно получаем комбинации, исключающие первый элемент
        result.addAll(generateCombinations(rest, k));

        return result;
    }


    // Вспомогательный класс для хранения результата
    public static class Result {
        public Integer sum;
        public List<Integer> cities;

        public Result(Integer sum, List<Integer> cities) {
            this.sum = sum;
            this.cities = cities;
        }

        @Override
        public String toString() {
            if (sum == null) {
                return "Невозможно выбрать города.";
            }
            return "Максимальная сумма: " + sum + ", Города: " + cities;
        }
    }


    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(50, 55, 57, 58, 60);
        int maxDistance = 175;
        int numCities = 3;
        Result result1 = chooseBestSum(maxDistance, numCities, l);
        System.out.println("Для l = " + l + ", maxDistance=" + maxDistance + ", numCities=" + numCities + ": " + result1);


        List<Integer> ts = Arrays.asList(50, 55, 56, 57, 58);
        maxDistance = 163;
        numCities = 3;
        Result result2 = chooseBestSum(maxDistance, numCities, ts);
        System.out.println("Для ts = " + ts + ", maxDistance=" + maxDistance + ", numCities=" + numCities + ": " + result2);
    }
}