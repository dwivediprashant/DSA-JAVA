import java.util.*;;

public class LCI {
    static int calls = 0;

    public static int getLongestIncreasingSubsequence(int[] arr, int currIdx, int prev) {
        calls++;
        if (currIdx == arr.length) {
            return 0;
        }
        if (prev == -1) {
            int c1 = 1 + getLongestIncreasingSubsequence(arr, currIdx + 1, currIdx);
            int c2 = getLongestIncreasingSubsequence(arr, currIdx + 1, prev);
            return Math.max(c1, c2);
        }
        int c3 = 0;
        if ((arr[prev] < arr[currIdx]) && (arr[prev] & arr[currIdx]) * 2 < (arr[prev] | arr[currIdx])) {
            c3 = 1 + getLongestIncreasingSubsequence(arr, currIdx + 1, currIdx);
        }
        int c4 = getLongestIncreasingSubsequence(arr, currIdx + 1, prev);
        return Math.max(c3, c4);
    }

    static int dpCalls = 0;

    public static int getLongestIncreasingSubsequence2(int[] arr, int currIdx, int prev, int[][] dp) {
        dpCalls++;
        if (currIdx == arr.length) {
            return 0;
        }

        if (prev != -1 && dp[currIdx][prev] != -1) {
            return dp[currIdx][prev];
        }

        if (prev == -1) {
            int c1 = 1 + getLongestIncreasingSubsequence2(arr, currIdx + 1, currIdx, dp);
            int c2 = getLongestIncreasingSubsequence2(arr, currIdx + 1, prev, dp);
            int max = Math.max(c1, c2);
            if (prev != -1) {
                dp[currIdx][prev] = max;
            }
            return max;
        }

        int c3 = 0;

        if ((arr[prev] < arr[currIdx]) && (arr[prev] & arr[currIdx]) * 2 < (arr[prev] | arr[currIdx])) {
            c3 = 1 + getLongestIncreasingSubsequence2(arr, currIdx + 1, currIdx, dp);
        }
        int c4 = getLongestIncreasingSubsequence2(arr, currIdx + 1, prev, dp);
        int max2 = Math.max(c3, c4);
        if (prev != -1) {
            dp[currIdx][prev] = max2;
        }

        return max2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }
        System.out.println("recursion : -");
        System.out.println(getLongestIncreasingSubsequence(arr, 0, -1));
        System.out.println(calls);
        System.out.println("DP:-");
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(getLongestIncreasingSubsequence2(arr, 0, -1, dp));
        System.out.println(dpCalls);
    }
}
