import java.util.Scanner;

public class TextModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод текста
        System.out.println("Введите текст: ");
        String inputText = scanner.nextLine();
        
        // Изменение текста
        String modifiedText = modifyText(inputText);
        
        // Вывод измененного текста
        System.out.println("Измененный текст: ");
        System.out.println(modifiedText);
        
        scanner.close();
    }

    private static String modifyText(String text) {
        // Разделяем текст на слова
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // Проверяем, является ли слово буквой или содержит знаки препинания
            if (word.length() > 0 && Character.isLetter(word.charAt(0))) {
                // Перемещаем первую букву в конец и добавляем "ауч"
                String modifiedWord = word.substring(1) + word.charAt(0) + "ауч";
                result.append(modifiedWord).append(" ");
            } else {
                // Если это не слово, просто добавляем его в результат
                result.append(word).append(" ");
            }
        }

        // Удаляем последний пробел и возвращаем результат
        return result.toString().trim();
    }
}