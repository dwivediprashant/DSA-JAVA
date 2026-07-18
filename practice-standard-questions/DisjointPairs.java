public class DisjointPairs {
    public static int getDisjointPairs(int[] nums, int k) {
        int n = nums.length;
        boolean[] isUSed = new boolean[n];
        int pairs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (!isUSed[i] && !isUSed[j] && (nums[i] + nums[j]) % k == 0) {
                    isUSed[i] = true;
                    isUSed[j] = true;
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 7, 13, -3, 5 };
        int k = 10;
        int res = getDisjointPairs(nums, k);
        System.out.println(res);
    }
}