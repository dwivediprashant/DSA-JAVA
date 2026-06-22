import java.util.*;

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
class MajorityEle {
    public static void main(String[] args) {

        int[] nums = { 3, 3, 3, 6, 5, 5, 5 };
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int times = n / 3;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Set<Integer> keys = map.keySet();
        for (int k : keys) {
            if (map.get(k) > times) {
                res.add(k);
            }
        }
        return res;
    }
}