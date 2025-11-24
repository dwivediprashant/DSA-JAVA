import java.util.Scanner;

public class JumpGame {
    
    // Method to find the index with the "best" jump within a range
    public static int getGreater(int[] nums, int start, int end) {
        int greaterIdx = end;
        for (int i = end; i > start; i--) {
            int stepBack = greaterIdx - i; // track steps we take back
            if (nums[i] - stepBack > nums[greaterIdx]) {
                greaterIdx = i;
            }
        }
        return greaterIdx;
    }

    // Method to calculate minimum jumps to reach the end
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0; // already at the end
        }

        int start = 0;
        int jumps = 0;

        while (start < n) {
            int end = start + nums[start];
            jumps++;

            if (end >= n - 1) {
                return jumps; // can reach the end from here
            }

            int greaterIdx = getGreater(nums, start, end);
            start = greaterIdx;
        }

        return jumps;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt(); 

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = jump(nums);
        System.out.println("Minimum number of jumps to reach the end: " + result);

        sc.close();
    }
}
