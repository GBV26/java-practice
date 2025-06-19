import java.util.Scanner;

public class EndOfString {

    public static boolean isEnding(String str1, String str2) {
        // Проверяем, что вторая строка не длиннее первой.  Если это так, то она точно не может быть окончанием.
        if (str2.length() > str1.length()) {
            return false;
        }

        // Получаем подстроку из первой строки, которая имеет ту же длину, что и вторая строка,
        // и начинается с позиции, вычисленной так, чтобы проверить окончание.
        String ending = str1.substring(str1.length() - str2.length());

        // Сравниваем подстроку с второй строкой.  Если они равны, значит, вторая строка является окончанием первой.
        return ending.equals(str2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();

        System.out.print("Введите вторую строку (проверяемое окончание): ");
        String str2 = scanner.nextLine();

        System.out.println(isEnding(str1, str2)); // Вывод: true

        scanner.close(); // Закрываем Scanner во избежание утечек ресурсов.
    }
}