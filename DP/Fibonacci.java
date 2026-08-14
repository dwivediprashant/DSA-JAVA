import java.util.*;

public class Fibonacci {
    public static int fibonacci(int n, int[] dp) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (dp[n - 1] != -1) {
            return dp[n - 1];
        }
        dp[n - 1] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        int res = fibonacci(n, dp);
        System.out.println(res);
    }
}
