package Hashing;

import java.util.*;

public class LargestSubArrWithSumZero {
    public static int getLenOfLargestSubarrayWithSumZero1(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == 0) {
                    maxLen = (int) Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static int getLenOfLargestSubarrayWithSumZero2(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();// sum:index
        int len = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                len = (int) Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 6, -5, 0, -1, 1, 5, -3, 2, 4, -4 };
        // int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
        // int[] nums = { 3, 4, 7, 0 };
        // 1st way : time O(n sq) , space :O(1)
        System.out.println(getLenOfLargestSubarrayWithSumZero1(nums));
        // 2nd way , time:O(n), space:O(n)
        System.out.println(getLenOfLargestSubarrayWithSumZero2(nums));

    }
}
