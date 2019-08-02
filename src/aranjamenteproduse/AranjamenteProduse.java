package aranjamenteproduse;

import java.math.BigInteger;
import java.util.Scanner;

public class AranjamenteProduse {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    
        //true = will use hardcoded input instead of console; false for console input
        boolean debug = true;
        
        String input;

        if (debug) {
//             input = "10 10000"; //0
             input = "5 1000000"; //17
//             input = "4 900000"; //32
        } else {
            input = scanner.nextLine();
        }

        long k = Long.valueOf(input.split(" ")[0]);
        long M = Long.valueOf(input.split(" ")[1]);

        System.out.println(calculate(k,M));
    }

    private static long calculate(long k, long M) {

        // 1. k <= n; k [1,12]; M <= 4_294_967_295
        // 2. A(n,k) = n! / (n-k)!

        if (k < 1 || M < 0 || M > 4_294_967_295L || k > 12) {
            return 0L;
        }

        // k <= n
        long n = k;

        boolean hasElements = false;

            while ( arrangements(n, k) <= 4_294_967_295L
                    && arrangements(n, k) <= M) {

                hasElements = true;
                n++;
            }

            if (!hasElements) return 0;

            // return previous n
            return --n;
    }

    private static String factorial(long n) {

        BigInteger fact = new BigInteger("1");

        for(long i = 1; i <= n; i++) {

            BigInteger iBig = new BigInteger(String.valueOf(i));
            fact = fact.multiply(iBig);

        }

        return fact.toString();
    }

    private static long arrangements(long n, long k) {

        BigInteger a = new BigInteger(factorial(n));
        BigInteger b = new BigInteger(factorial(n-k));

        return Long.valueOf(a.divide(b).toString());

    }

}
