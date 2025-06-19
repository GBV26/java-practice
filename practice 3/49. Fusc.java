public class Fusc {

    public static int fusc(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] f = new int[n + 1]; // Массив для хранения значений fusc
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                f[i] = f[i / 2];
            } else {
                f[i] = f[i / 2] + f[i / 2 + 1];
            }
        }

        return f[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            System.out.println("fusc(" + i + ") = " + fusc(i));
        }
    }
}