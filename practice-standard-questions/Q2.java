import java.util.*;

public class Q2 {
    public static int longestSubarrWithLimit(int[] arr, int limit) {
        int n = arr.length;
        int maxLen = 1;
        int currLen = 1;
        int j = 1;
        while (j < n) {
            int diff = (int) Math.abs(arr[j] - arr[j - 1]);
            if (diff > limit) {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            } else {
                currLen++;
            }
            j++;
        }
        maxLen = Math.max(maxLen, currLen);
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int limit = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }
        System.out.println(longestSubarrWithLimit(arr, limit));
    }
}
