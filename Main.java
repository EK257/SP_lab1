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
        System.out.println(divideAndConquerMultiply(a,b));
        System.out.println(simpleMultiply(a,b));
        System.out.println(fastMultiply(a,b));
        System.out.println(bigIntMultiply(String.valueOf(a),String.valueOf(b)));
    }

    public static String bigIntMultiply(String aStr, String bStr) {
        BigInteger a = new BigInteger(aStr);
        BigInteger b = new BigInteger(bStr);
        return a.multiply(b).toString();
    }
    public static long divideAndConquerMultiply(long a, long b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return divideAndConquerMultiply((a << 1), (b >> 1));
        return a + divideAndConquerMultiply(a, b - 1);
    }
    public static long simpleMultiply(long a, long b) {
        if (b == 0) return 0;
        if (b < 0) return -simpleMultiply(a, -b);
        return a + simpleMultiply(a, b - 1);
    }
    public static long fastMultiply(long a, long b) {
        long result = 0L;
        while (b > 0) {
            if ((b & 1) == 1) {
                result += a;
            }
            a <<= 1;
            b >>>= 1;
        }
        return result;
    }
}