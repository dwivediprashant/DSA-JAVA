import java.util.*;

public class Knapsack01 {

    static int calls = 0;

    public static int knapsack(int[] vals, int[] wt, int remainWt, int currProfit, int currIdx) {
        calls++;
        if (remainWt < 0) {
            return -1;
        }

        if (remainWt == 0 || currIdx == vals.length) {
            return currProfit;
        }

        int left = knapsack(vals, wt, remainWt - wt[currIdx], currProfit + vals[currIdx], currIdx + 1);
        int right = knapsack(vals, wt, remainWt, currProfit, currIdx + 1);

        return Math.max(left, right);
    }

    static int dpCalls = 0;

    public static int knapsack2(int[] vals, int[] wt, int remainWt, int currIdx, int[][] dp) {
        dpCalls++;

        if (remainWt == 0 || currIdx == vals.length) {
            return 0;
        }

        if (dp[currIdx][remainWt] != -1) {
            return dp[currIdx][remainWt];
        }

        int left = 0;
        if (remainWt >= wt[currIdx]) {
            left = vals[currIdx]
                    + knapsack2(vals, wt, remainWt - wt[currIdx], currIdx + 1, dp);
        }
        int right = knapsack2(vals, wt, remainWt, currIdx + 1, dp);

        dp[currIdx][remainWt] = Math.max(left, right);
        return dp[currIdx][remainWt];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        int[] wt = new int[n];

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            vals[i] = v;
            wt[i] = w;
        }
        int maxWeight = sc.nextInt();
        System.out.println(knapsack(vals, wt, maxWeight, 0, 0));
        System.out.println(calls);
        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack2(vals, wt, maxWeight, 0, dp));
        System.out.println(dpCalls);
    }
}