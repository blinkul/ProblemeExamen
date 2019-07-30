package filtrucuvinte;

import java.util.Scanner;

public class AranjamenteProduse {


    // TODO: 10 4294967295 will fail
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String input = scanner.nextLine();
        int k = Integer.valueOf(input.split(" ")[0]);
        int M = Integer.parseUnsignedInt(input.split(" ")[1]);

        if (k < 1 || k > 12) {
            System.out.println("value of k should be between 1 and 12");
        }

        if (M < 0 || M > Integer.MAX_VALUE) {
            System.out.println("value of M should be between 0 and " + Integer.MAX_VALUE);
        }


    }

    private static int calculate(int k, int M) {
        int n = 0;

        // M = n! / (n-k)!

        return n;
    }

}
