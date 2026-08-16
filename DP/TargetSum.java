import java.util.*;

public class TargetSum {
    // ArrayList<Integer> targetSum = new ArrayList<>();

    static int calls = 0;

    public static boolean getAllSubSeqForTargetSum(int[] nums, int target, int currIdx, int currSum) {
        calls++;
        if (currSum == target) {
            return true;
        }
        if (currSum > target || currIdx == nums.length) {
            return false;
        }
        return getAllSubSeqForTargetSum(nums, target, currIdx + 1, currSum + nums[currIdx])
                || getAllSubSeqForTargetSum(nums, target, currIdx + 1, currSum);

    }

    static int dpCalls = 0;

    public static boolean getAllSubSeqForTargetSum2(int[] nums, int target, int currIdx, int currSum, Boolean[][] dp) {
        dpCalls++;
        if (currSum == target) {
            return true;
        }
        if (currSum > target || currIdx == nums.length) {
            return false;
        }
        if (dp[currIdx][currSum] != null) {
            return dp[currIdx][currSum];
        }
        dp[currIdx][currSum] = getAllSubSeqForTargetSum2(nums, target, currIdx + 1, currSum + nums[currIdx], dp)
                || getAllSubSeqForTargetSum2(nums, target, currIdx + 1, currSum, dp);

        return dp[currIdx][currSum];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = num;
        }
        int target = sc.nextInt();
        boolean hasTargetSubseq = getAllSubSeqForTargetSum(nums, target, 0, 0);
        System.out.println(hasTargetSubseq ? "True" : "False");
        System.out.println(calls);
        // dp
        Boolean[][] dp = new Boolean[n + 1][target + 1];
        System.out.println(getAllSubSeqForTargetSum2(nums, target, 0, 0, dp) ? "True" : "False");
        System.out.println(dpCalls);

    }
}
