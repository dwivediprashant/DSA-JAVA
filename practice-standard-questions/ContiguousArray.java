import java.util.*;;

//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
public class ContiguousArray {
    public static int countZero(int start, int end, int[] nums) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == 0)
                count++;
        }
        return count;
    }

    public static int getMaxLength1(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int zeroCount = countZero(i, j, nums);
                int oneCount = j - i + 1 - zeroCount;
                if (zeroCount == oneCount) {
                    maxLen = (int) Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public static int getMaxLength2(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int countZero = 0;
            int countOne = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    countZero++;
                } else {
                    countOne++;
                }

                if (countOne == countZero) {
                    maxLen = (int) Math.max(maxLen, j - i + 1);
                }

            }

        }

        return maxLen;

    }

    // target sum 0 approach
    public static int getMaxLength3(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        map.put(0, -1);// intial

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                sum += -1;// 0 trated as -1
            } else {
                sum += nums[i];
            }

            if (map.containsKey(sum)) {
                maxLen = (int) Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }

        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 1, 1, 0, 0, 0 };
        // 1st way : time:O(n cube) space:O(1)
        System.out.println(getMaxLength1(nums));
        // 2nd way : time:O(n sq) space:O(1)
        System.out.println(getMaxLength2(nums));
        // 3rd way using map : time:O(n) space :O(n)
        System.out.println(getMaxLength3(nums));
    }
}
