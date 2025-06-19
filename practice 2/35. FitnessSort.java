import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FitnessSort {

    public static void main(String[] args) {
        String weights = "56 65 74 100 99 68 86 180 90";
        String sortedWeights = sortWeights(weights);
        System.out.println("Отсортированный список: " + sortedWeights);
    }

    public static String sortWeights(String weights) {
        if (weights == null || weights.isEmpty()) {
            return "";
        }

        String[] weightArray = weights.split(" ");

        // Преобразуем строки в числа и сортируем по сумме цифр
        Arrays.sort(weightArray, Comparator.comparingInt(FitnessSort::digitSum));

        // Собираем отсортированные числа обратно в строку
        return Arrays.stream(weightArray)
                .collect(Collectors.joining(" "));
    }

    // Вспомогательный метод для вычисления суммы цифр числа
    private static int digitSum(String number) {
        int sum = 0;
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) { // Проверка на цифру.
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }
}