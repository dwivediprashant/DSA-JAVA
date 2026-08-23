import java.util.*;

public class XorSum2 {
    public static int getMaxXORSum1(int[] arr, int k) {
        long maxXorSum = 0L;
        int maxK = 0;
        long mod = 1000000007;
        for (int i = 0; i <= k; i++) {
            long xorSum = 0L;
            for (int j = 0; j < arr.length; j++) {
                xorSum = (xorSum + (i ^ arr[j])) % mod;
            }
            if (xorSum > maxXorSum) {
                maxXorSum = xorSum;
                maxK = i;
            }
        }
        System.out.println(maxXorSum);
        return maxK;
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static long getMaxXORSum2(int[] arr, int k) {
        long maxXorSum = 0L;
        int maxK = 0;
        long mod = 1000000007;
        int max = Math.max(k, getMax(arr));
        long[][] dp = new long[max + 1][max + 1];
        for (int i = 0; i <= max; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i <= k; i++) {
            long xorSum = 0L;
            for (int j = 0; j < arr.length; j++) {
                int currXor = 0;
                if (dp[i][arr[j]] != -1) {
                    currXor = (int) dp[i][arr[j]];
                } else {
                    currXor = i ^ arr[j];
                    dp[i][arr[j]] = currXor;
                    dp[arr[j]][i] = currXor;
                }

                xorSum = (xorSum + currXor) % mod;
            }
            if (xorSum > maxXorSum) {
                maxXorSum = xorSum;
                maxK = i;
            }
        }
        System.out.println(maxXorSum);
        return maxK;
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
        // 1st approach time : O(n*K) space O(1)
        System.out.println("Brute force : -");
        System.out.println(getMaxXORSum1(arr, k));
        System.out.println("Dp version1 :-");
        System.out.println(getMaxXORSum2(arr, k));
    }
}
