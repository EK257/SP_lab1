import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите a: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.print("Введите b: ");
        sc = new Scanner(System.in);
        int b = sc.nextInt();
        System.out.println(secondMultiply(a,b));
        System.out.println(simpleMultiply(a,b));
        System.out.println(fastMultiply(a,b));
        System.out.println(bigIntMultiply(String.valueOf(a),String.valueOf(b)));
    }

    public static String bigIntMultiply(String aStr, String bStr) {
        BigInteger a = new BigInteger(aStr);
        BigInteger b = new BigInteger(bStr);
        return a.multiply(b).toString();
    }
    public static int secondMultiply(int a, int b) {
        if (a == 0 || b == 0) return 0;
        boolean negative = (a < 0) ^ (b < 0);
        int x = a < 0 ? -a : a;
        int y = b < 0 ? -b : b;
        int result = 0;
        for (int i = 0; i < y; i++) {
            result += x;
        }
        return negative ? -result : result;
    }
    public static long simpleMultiply(long a, long b) {
        if (b == 0) return 0;
        if (b < 0) return -simpleMultiply(a, -b);
        return a + simpleMultiply(a, b - 1);
    }
    public static long fastMultiply(long a, long b) {
        boolean isNegative = (a < 0) ^ (b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        long result = 0;

        while (b > 0) {
            if ((b & 1) == 1) result += a;
            a <<= 1;
            b >>= 1;
        }
        if (isNegative) {
            return -result;
        } else {
            return result;
        }
    }
}
