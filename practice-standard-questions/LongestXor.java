import java.util.*;
import java.util.Stack;

public class LongestXor {
    public static int getGoodSubsequence(int[] arr, int m, int currIdx, int xor, int lastSelected,
            HashMap<String, Integer> dp) {
        if (currIdx == arr.length) {
            if (xor >= m) {
                return 0;
            }
            return -100000;
        }
        String key = currIdx + "-" + xor + "-" + lastSelected;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        // include ele
        int l1 = -100000;

        if (lastSelected <= arr[currIdx]) {
            l1 = 1 + getGoodSubsequence(arr, m, currIdx + 1, xor ^ arr[currIdx], arr[currIdx], dp);
        }

        // exclude case
        int l2 = getGoodSubsequence(arr, m, currIdx + 1, xor, lastSelected, dp);

        int maxLen = Math.max(l1, l2);
        dp.put(key, maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = getGoodSubsequence(arr, m, 0, 0, -1, dp);
        System.out.println(ans < 0 ? 0 : ans);
    }
}
