import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class SnailSort {

    public static void main(String[] args) {
        int N = 9; // Количество чисел для генерации (например, для матрицы 3x3)
        int side = (int) Math.sqrt(N); // Определяем размер стороны квадратной матрицы
        if (side * side != N) {
            System.out.println("Количество чисел должно быть квадратом целого числа для создания квадратной матрицы.");
            return;
        }


        int[][] array = generateRandomArray(side, side, N);

        System.out.println("Исходный массив:");
        printArray(array);


        List<Integer> snailArray = snail(array);

        System.out.println("Snail массив: " + snailArray);
    }

    // Метод для генерации двумерного массива случайных чисел
    public static int[][] generateRandomArray(int rows, int cols, int numElements) {
        int[][] array = new int[rows][cols];
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= numElements; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = random.nextInt(numbers.size());
                array[i][j] = numbers.get(index);
                numbers.remove(index);
            }
        }
        return array;
    }

    // Метод для печати двумерного массива
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static List<Integer> snail(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int rows = array.length;
        int cols = array[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int dir = 0; // 0: right, 1: down, 2: left, 3: up

        while (top <= bottom && left <= right) {
            if (dir == 0) { // Traverse right
                for (int i = left; i <= right; i++) {
                    result.add(array[top][i]);
                }
                top++;
            } else if (dir == 1) { // Traverse down
                for (int i = top; i <= bottom; i++) {
                    result.add(array[i][right]);
                }
                right--;
            } else if (dir == 2) { // Traverse left
                for (int i = right; i >= left; i--) {
                    result.add(array[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) { // Traverse up
                for (int i = bottom; i >= top; i--) {
                    result.add(array[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }
}