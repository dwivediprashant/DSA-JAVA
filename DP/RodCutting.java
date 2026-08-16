import java.util.*;

public class RodCutting {
    static int calls = 0;

    public static int getMaxPrice(int[] length, int[] price, int currIdx, int remainLen) {
        calls++;
        if (remainLen == 0 || currIdx == length.length) {
            return 0;
        }

        int ans1 = 0;
        if (remainLen >= length[currIdx]) {
            ans1 = price[currIdx] + getMaxPrice(length, price, currIdx, remainLen - length[currIdx]);
        }
        int ans2 = getMaxPrice(length, price, currIdx + 1, remainLen);
        // System.out.println(ans1 + " - " + ans2);
        return Math.max(ans1, ans2);
    }

    static int dpCalls = 0;

    public static int getMaxPrice2(int[] length, int[] price, int currIdx, int remainLen, Map<String, Integer> dp) {
        dpCalls++;
        if (remainLen == 0 || currIdx == length.length) {
            return 0;
        }
        String key = currIdx + "," + remainLen;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int ans1 = 0;
        if (remainLen >= length[currIdx]) {
            ans1 = price[currIdx] + getMaxPrice2(length, price, currIdx, remainLen - length[currIdx], dp);
        }
        int ans2 = getMaxPrice2(length, price, currIdx + 1, remainLen, dp);
        // System.out.println(ans1 + " - " + ans2);
        int max = Math.max(ans1, ans2);
        dp.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] length = new int[n];
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int p = sc.nextInt();
            length[i] = l;
            price[i] = p;
        }
        System.out.println("recursion : -");
        System.out.println(getMaxPrice(length, price, 0, n));
        System.out.println(calls);
        System.out.println("memoization + recursion : -");
        Map<String, Integer> dp = new HashMap<>();
        System.out.println(getMaxPrice2(length, price, 0, n, dp));
        System.out.println(dpCalls);
    }
}
