import java.util.*;

public class Binomial {
    public static int fact(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        int fact = 1;

        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int binoCoeff(int n, int r) {
        int numerator = fact(n);
        int deno1 = fact(r);
        int deno2 = fact(n - r);
        int deno = deno1 * deno2;

        return numerator / deno;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n = ");
        int n = sc.nextInt();
        System.out.print("Enter r = ");
        int r = sc.nextInt();
        int res = binoCoeff(n, r);
        System.out.print(n + "C" + r + " = " + res);
        sc.close();
    }

}