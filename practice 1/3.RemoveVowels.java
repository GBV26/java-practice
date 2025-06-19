import java.util.Scanner;

public class RemoveVowels {

    public static String removeVowels(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isVowel(ch)) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char ch) {
        char lowerCh = Character.toLowerCase(ch);
        return lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u' || lowerCh == 'y'
               || lowerCh == 'а' || lowerCh == 'е' || lowerCh == 'ё' || lowerCh == 'и' || lowerCh == 'о'
               || lowerCh == 'у' || lowerCh == 'ы' || lowerCh == 'э' || lowerCh == 'ю' || lowerCh == 'я';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String inputString = scanner.nextLine();

        String stringWithoutVowels = removeVowels(inputString);

        System.out.println("Строка без гласных: " + stringWithoutVowels);

        scanner.close();
    }
}