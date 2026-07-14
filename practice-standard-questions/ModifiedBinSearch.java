public class ModifiedBinSearch {
    public static void printClosest(int[] nums, int left, int right, int key) {
        int absMinDiff = Integer.MAX_VALUE;
        int absMinDiffIdx = -1;
        for (int i = left; i <= right; i++) {
            if (key == nums[i]) {
                continue;
            }
            if (Math.abs(key - nums[i]) < absMinDiff) {
                absMinDiff = Math.abs(key - nums[i]);
                absMinDiffIdx = i;
            }

        }
        System.out.println(nums[absMinDiffIdx] + " ");

    }

    public static void modifiedBS(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == key) {
                System.out.println(key + " ");
                return;
            } else if (nums[mid] < key) {
                // printClosest(nums, mid, right, key);
                left = mid + 1;
            } else {
                // printClosest(nums, left, mid, key);
                right = mid - 1;
            }
        }

        // case : key not found then print closest
        left = 0;
        right = nums.length - 1;
        int minDiffVal = Integer.MAX_VALUE;
        int minDiffIdx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(key - nums[mid]) < minDiffVal) {
                minDiffVal = Math.abs(key - nums[mid]);
                minDiffIdx = mid;
            }
            if (nums[mid] < key) {

                left = mid + 1;
            } else if (nums[mid] > key) {
                right = mid - 1;
            }
        }
        System.out.println(nums[minDiffIdx]);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 6, 9, 10, 12 };
        int key = 2;
        modifiedBS(nums, key);
    }
}
