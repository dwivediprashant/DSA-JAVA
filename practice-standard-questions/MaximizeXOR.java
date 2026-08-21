import java.util.*;

public class MaximizeXOR {
    static int calls = 0;

    public static int maximizeXor(int[] nums, int currIdx, int selected, int currXor, int maxXor) {
        calls++;
        if (currIdx == nums.length || selected == nums.length / 2) {
            maxXor = Math.max(maxXor, currXor);
            return maxXor;
        }

        int res1 = maximizeXor(nums, currIdx + 1, selected + 1, currXor ^ nums[currIdx], maxXor);
        int res2 = maximizeXor(nums, currIdx + 1, selected, currXor, maxXor);
        return Math.max(res1, res2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            nums[i] = x;
        }
        System.out.println("Recursion :-");
        System.out.println(maximizeXor(nums, 0, 0, 0, 0));
        System.out.println(calls);
    }
}
