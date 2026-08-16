import java.util.*;

public class Unboundedknapsack {
    public static int getMaxProfit(int[] vals, int[] wt, int remainWt, int currIdx) {
        if (currIdx == vals.length || remainWt == 0) {
            return 0;
        }

        // include multiple times
        int ans1 = 0;
        if (remainWt >= wt[currIdx]) {
            ans1 = vals[currIdx] + getMaxProfit(vals, wt, remainWt - wt[currIdx], currIdx);
        }
        // exclude
        int ans2 = getMaxProfit(vals, wt, remainWt, currIdx + 1);

        return Math.max(ans1, ans2);
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
        int maxWt = sc.nextInt();

        System.out.println(getMaxProfit(vals, wt, maxWt, 0));
    }
}
