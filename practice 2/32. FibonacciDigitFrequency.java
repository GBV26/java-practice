import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDigitFrequency {

    public static void main(String[] args) {
        int i = 10;
        BigInteger fibonacciNumber = fibonacci(i);
        System.out.println("Fibonacci(" + i + ") = " + fibonacciNumber);
        System.out.println("Наибольшее вхождение цифры: " + findMostFrequentDigit(fibonacciNumber));

        i = 100;
        fibonacciNumber = fibonacci(i);
        System.out.println("Fibonacci(" + i + ") = " + fibonacciNumber);
        System.out.println("Наибольшее вхождение цифры: " + findMostFrequentDigit(fibonacciNumber));


        i = 1000;
        fibonacciNumber = fibonacci(i);
        System.out.println("Fibonacci(" + i + ") = " + fibonacciNumber);
        System.out.println("Наибольшее вхождение цифры: " + findMostFrequentDigit(fibonacciNumber));
    }

    /**
     * Вычисляет i-ый элемент ряда Фибоначчи. Использует BigInteger для
     * обработки больших чисел.
     *
     * @param n Индекс элемента Фибоначчи (10 <= n <= 100000).
     * @return i-ый элемент ряда Фибоначчи.
     * @throws IllegalArgumentException Если n выходит за пределы допустимого диапазона.
     */
    public static BigInteger fibonacci(int n) {
        if (n < 10 || n > 100000) {
            throw new IllegalArgumentException("n должно быть в диапазоне [10, 100000]");
        }

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c;

        for (int j = 2; j <= n; j++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return b;
    }

    /**
     * Находит наиболее часто встречающуюся цифру в числе. Если несколько цифр
     * встречаются одинаковое количество раз, возвращает наибольшую из них.
     *
     * @param number Число, в котором нужно найти наиболее часто встречающуюся цифру.
     * @return Строка, представляющая цифру с максимальной частотой и ее частоту,
     *         или пустая строка, если число равно нулю.
     */
    public static String findMostFrequentDigit(BigInteger number) {
        String numberStr = number.toString();
        Map<Character, Integer> digitCounts = new HashMap<>();

        // Подсчитываем частоту каждой цифры
        for (int i = 0; i < numberStr.length(); i++) {
            char digit = numberStr.charAt(i);
            digitCounts.put(digit, digitCounts.getOrDefault(digit, 0) + 1);
        }

        // Находим цифру с максимальной частотой
        char mostFrequentDigit = '0';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : digitCounts.entrySet()) {
            char digit = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                mostFrequentDigit = digit;
            } else if (count == maxCount && digit > mostFrequentDigit) {
                mostFrequentDigit = digit; // Выбираем большую цифру при равенстве частот
            }
        }

        // Преобразуем char в int перед формированием результата
        if (maxCount > 0) { // Проверяем, что число не равно 0.  Иначе вернется 0,0, что неправильно
            return "[" + "(" + maxCount + ", " + mostFrequentDigit + ")" + "]";
        } else {
            return ""; // Или можно бросить исключение, если ноль не должен обрабатываться
        }
    }
}