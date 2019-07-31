package filtrucuvinte;

import java.util.Scanner;

public class AranjamenteProduse {


    // TODO: 10 4294967295 will fail
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String input = scanner.nextLine();
        long k = Long.valueOf(input.split(" ")[0]);
        long M = Long.parseUnsignedLong(input.split(" ")[1]);

        System.out.println(calculate(k,M));


//        System.out.println(Long.MAX_VALUE);
//        int i = 1;
//
//        while (i < 40) {
//            System.out.println("i = " + i + "; Factorial = " + factorial(i));
//
//            i++;
//        }

    }

    private static long calculate(long k, long M) {
        long n = k;
        long result = 0;

        result = factorial(n) / factorial(n-k);

        while (M < 4294967295L && result < M) {

            System.out.println("DEBUG: k = " + k + "; n = " + n);
            result = factorial(n) / factorial(n-k);

            if (result > M) {
                return n - 1;
            }

            n++;
        }

        return 0;
    }

    private static long factorial(long n) {

        long fact = 1;

        for(long i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

}
