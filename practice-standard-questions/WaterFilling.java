import java.util.*;

public class WaterFilling {
    static int calls = 0;

    public static int getWaysToTarget(int[] bs, int target, int currIdx) {
        calls++;
        if (target == 0) {
            return 1;
        }
        if (currIdx == bs.length) {
            return 0;
        }
        // include
        int c1 = 0;
        if (target >= bs[currIdx]) {
            c1 = getWaysToTarget(bs, target - bs[currIdx], currIdx);
        }
        // exclude
        int c2 = getWaysToTarget(bs, target, currIdx + 1);
        return c1 + c2;
    }

    static int dpCalls = 0;

    public static int getWaysToTarget2(int[] bs, int target, int currIdx, int[][] dp) {
        dpCalls++;
        if (target == 0) {
            return 1;
        }
        if (currIdx == bs.length) {
            return 0;
        }
        if (dp[currIdx][target] != -1) {
            return dp[currIdx][target];
        }
        // include
        int c1 = 0;
        if (target >= bs[currIdx]) {
            c1 = getWaysToTarget2(bs, target - bs[currIdx], currIdx, dp);
        }
        // exclude
        int c2 = getWaysToTarget2(bs, target, currIdx + 1, dp);
        int total = (c1 + c2) % 1000000007;
        dp[currIdx][target] = total;
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] bottleSize = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            bottleSize[i] = x;
        }
        System.out.println("Recursion : -");
        System.out.println(getWaysToTarget(bottleSize, target, 0));
        System.out.println(calls);
        System.out.println("DP : -");
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(getWaysToTarget2(bottleSize, target, 0, dp));
        System.out.println(dpCalls);
    }
}
