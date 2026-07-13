import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static int[] getIdxForTargetSum1(int[] nums, int target) {

        int n = nums.length;
        int[] res = new int[2];

        outer: for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break outer;
                }
            }
        }
        return res;
    }

    public static int[] getIdxForTargetSum2(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];

        HashMap<Integer, List<Integer>> map = new HashMap<>();// val:all index

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            } else {
                map.get(nums[i]).add(i);
            }
        }

        Arrays.sort(nums);

        int left = 0, right = n - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                if (nums[left] == nums[right]) {
                    res[0] = map.get(nums[left]).get(0);
                    res[1] = map.get(nums[right]).get(1);
                } else {
                    res[0] = map.get(nums[left]).get(0);
                    res[1] = map.get(nums[right]).get(0);
                }

                break;
            }
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static int[] getIdxForTargetSum3(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();// val: index

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                res[0] = map.get(complement);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int targetSum = 9;
        // 1. brute force : time:O(n sq) space:O(1)
        int[] res = getIdxForTargetSum1(nums, targetSum);
        System.out.println(res[0] + "  " + res[1]);
        // 2. time:O(nlogn) space:O(n)
        res = getIdxForTargetSum2(nums, targetSum);
        System.out.println(res[0] + "  " + res[1]);
        // 3. time:O(n) space:O(n);
        res = getIdxForTargetSum3(nums, targetSum);
        System.out.println(res[0] + "  " + res[1]);
    }
}