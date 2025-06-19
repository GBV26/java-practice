import java.util.Scanner;

public class Greeting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine(); // Считываем всю строку (имя)

        // Преобразуем первую букву имени в верхний регистр, а остальные в нижний
        String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        System.out.println("Привет, " + formattedName + "!");

        scanner.close(); // Закрываем Scanner, чтобы освободить ресурсы
    }
}