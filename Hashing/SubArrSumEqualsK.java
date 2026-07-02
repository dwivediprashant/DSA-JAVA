import java.util.*;

//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
public class SubArrSumEqualsK {
    public static int getSubarraySumEqualsTarget1(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int getSubarraySumEqualsTarget2(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();// sum:freq
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 11, -11, 0, 0 };
        int target = 0;

        // 1st way => time: O(n sq) ,space: O(1)
        System.out.println(getSubarraySumEqualsTarget1(nums, target));
        // 2nd way => time:O(n) , space:O(n)
        System.out.println(getSubarraySumEqualsTarget2(nums, target));
    }
}