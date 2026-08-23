import java.util.*;

public class Santa {
    public static int getBoxValue(int st, int end, int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = st; i <= end; i++) {
            set.add(a[i]);
        }

        return set.size();
    }

    public static int maximizeBoxesVal(int[] a, int b, int st, int limiter, int[][] dp1, int[][] dp2) {
        if (limiter == b - 1) {
            int lastBoxVal = 0;
            if (dp1[st][a.length - 1] != -1) {
                lastBoxVal = dp1[st][a.length - 1];
            } else {
                lastBoxVal = getBoxValue(st, a.length - 1, a);
                dp1[st][a.length - 1] = lastBoxVal;
            }
            return lastBoxVal;
        }

        if (dp2[st][limiter] != -1) {
            return dp2[st][limiter];
        }

        int max = Integer.MIN_VALUE;

        for (int end = st; end <= a.length - (b - limiter); end++) {
            int currBoxVal = 0;
            if (dp1[st][end] != -1) {
                currBoxVal = dp1[st][end];
            } else {
                currBoxVal = getBoxValue(st, end, a);
                dp1[st][end] = currBoxVal;
            }
            int newLimiter = limiter + 1;
            int totalBoxVal = currBoxVal + maximizeBoxesVal(a, b, end + 1, newLimiter, dp1, dp2);
            max = Math.max(max, totalBoxVal);
            dp2[st][limiter] = max;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a[i] = x;
        }
        int[][] dp1 = new int[n][n];
        int[][] dp2 = new int[n][b - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp1[i], -1);
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp2[i], -1);
        }
        System.out.println(maximizeBoxesVal(a, b, 0, 0, dp1, dp2));
    }
}
