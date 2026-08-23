import java.util.*;

public class Segments {
    private static int getCost(int st, int end, int[] arr) {
        int[] first = new int[35001];
        int[] last = new int[35001];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = st; i <= end; i++) {
            last[arr[i]] = i;
        }
        for (int i = end; i >= st; i--) {
            first[arr[i]] = i;
        }
        int cost = 0;

        for (int i = 0; i <= 35000; i++) {
            if (first[i] != -1 && last[i] != -1) {
                cost += last[i] - first[i];
            }
        }
        return cost;
    }

    static int minCost = Integer.MAX_VALUE;

    static int recCalls = 0;

    public static int minCostOfSegments(int[] arr, int k, int st, int limiter) {
        recCalls++;
        if (limiter == k - 1) {
            return getCost(st, arr.length - 1, arr);
        }

        for (int endCut = st; endCut <= arr.length - (k - limiter); endCut++) {
            int currSegCost = getCost(st, endCut, arr);
            int newLimiter = limiter + 1;
            int cost = currSegCost + minCostOfSegments(arr, k, endCut + 1, newLimiter);

            minCost = Math.min(cost, minCost);
        }

        return minCost;
    }

    static int dpV1Calls = 0;

    public static int minCostOfSegments2(int[] arr, int k, int st, int limiter, int[][] dp, int[][] dp2) {
        dpV1Calls++;
        if (limiter == k - 1) {

            int lastSegCost = 0;

            if (dp[st][arr.length - 1] != -1) {
                lastSegCost = dp[st][arr.length - 1];
            } else {
                lastSegCost = getCost(st, arr.length - 1, arr);
                dp[st][arr.length - 1] = lastSegCost;
            }
            return lastSegCost;

        }

        if (dp2[st][limiter] != -1) {
            return dp2[st][limiter];
        }

        int minCost = Integer.MAX_VALUE;

        for (int endCut = st; endCut <= arr.length - (k - limiter); endCut++) {

            int currSegCost = 0;
            if (dp[st][endCut] != -1) {
                currSegCost = dp[st][endCut];
            } else {
                currSegCost = getCost(st, endCut, arr);
                dp[st][endCut] = currSegCost;
            }
            int newLimiter = limiter + 1;
            int cost = currSegCost + minCostOfSegments2(arr, k, endCut + 1, newLimiter, dp, dp2);

            minCost = Math.min(cost, minCost);
            dp2[st][limiter] = minCost;
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;

        }
        System.out.println("Recursion :-");
        System.out.println(minCostOfSegments(arr, k, 0, 0));
        System.out.println(recCalls);
        System.out.println("DP:-");
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[][] dp2 = new int[n][k - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp2[i], -1);
        }
        System.out.println(minCostOfSegments2(arr, k, 0, 0, dp, dp2));
        System.out.println(dpV1Calls);
    }
}
