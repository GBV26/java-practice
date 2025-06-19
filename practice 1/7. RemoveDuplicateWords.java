import java.util.Scanner;
import java.util.LinkedHashSet; // Сохраняет порядок добавления

public class RemoveDuplicateWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String inputString = scanner.nextLine();

        // Разделяем строку на слова
        String[] words = inputString.split("\\s+"); // "\\s+" - один или несколько пробельных символов

        // Используем LinkedHashSet для удаления дубликатов и сохранения порядка
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        // Собираем строку обратно
        StringBuilder result = new StringBuilder();
        for (String word : uniqueWords) {
            result.append(word).append(" ");
        }

        //Удаляем последний пробел, если строка не пустая
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }


        System.out.println("Результат: " + result.toString());

        scanner.close();
    }
}