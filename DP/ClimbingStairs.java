import java.util.*;

public class ClimbingStairs {
    static int totalWays = 0;
    static int calls = 0;

    public static void getTotalWaysToClimbStairs(int n, int curr) {
        calls++;
        if (curr > n) {
            return;
        }
        if (curr == n) {
            totalWays++;
            return;
        }
        getTotalWaysToClimbStairs(n, curr + 1);
        getTotalWaysToClimbStairs(n, curr + 2);
    }

    static int dpCalls = 0;

    public static int getTotalWaysToClimbStairs2(int n, int[] dp) {
        dpCalls++;
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] += getTotalWaysToClimbStairs2(n - 1, dp);
        dp[n] += getTotalWaysToClimbStairs2(n - 2, dp);

        return dp[n];
    }

    public static int getTotalWaysToClimbStairs3(int n, int[] dp) {

        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = getTotalWaysToClimbStairs2(n - 1, dp) + getTotalWaysToClimbStairs2(n - 2, dp);

        return dp[n];
    }

    public static int getTotalWaysToClimbStairs4(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Recursion : -");
        getTotalWaysToClimbStairs(n, 0);
        System.out.println("Ways = " + totalWays);
        // System.out.println("calls = " + calls);
        int[] dp = new int[n + 1];
        System.out.println("DP +  recursion : -");
        System.out.println("Ways = " + getTotalWaysToClimbStairs2(n, dp));
        // System.out.println("calls = " + dpCalls);
        int[] dp2 = new int[n + 1];
        System.out.println("DP2 : -");
        System.out.println("ways = " + getTotalWaysToClimbStairs3(n, dp2));
        System.out.println("tabulation dp : -");
        System.out.println(getTotalWaysToClimbStairs4(n));
    }
}
