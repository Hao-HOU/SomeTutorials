import java.util.Scanner;

/**
 * Created by Hao HOU on 2018/3/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = scanner.nextLong();

        System.out.println(cal(n, m));
    }

    private static long cal(long n, long m) {
        if (n == 1) {
            return m;
        }

        if (n == 2) {
            if (m < 2) {
                return 0;
            }
            return m * (m - 1);
        }

        if (m == 2) {
            return 2;
        }

        return (long) (m * Math.pow((m - 1), (n - 1)) - cal(n - 1, m));
    }
}
