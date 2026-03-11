package Stack.questions;

import java.util.Stack;

public class NgeII {
    static Stack<Integer> s = new Stack<>();

    // public static int getNgeOfLast(int[] nums, int lastEle) {
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // if (nums[i] > lastEle) {
    // return nums[i];
    // }
    // }
    // return -1;
    // }

    public static int[] getCircularNge(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        // int ngeLast = getNgeOfLast(nums, nums[n - 1]);

        // if (ngeLast != -1) {
        // s.push(ngeLast);
        // } else {
        // s.push(nums[n - 1]);
        // }

        // nge[n - 1] = ngeLast;

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while (!s.isEmpty() && nums[s.peek()] <= nums[idx]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nge[idx] = -1;
            } else {
                nge[idx] = nums[s.peek()];
            }
            s.push(idx);
        }

        return nge;

    }

    public static void main(String[] args) {
        // int[] nums = { 6, 5, 4, 3, 2, 1 };//decreasing order
        int[] nums = { 8, 11, 3, -6, 13, 9, 12 };//// random order
        // int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };//increasing order
        // int[] nums = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };// same ele order
        // int[] nums = { 3 };// one ele
        // int[] nums = {};// empty arr
        // int[] nums = { 12, 11, 17 };// two-three ele
        if (nums.length == 0) {
            System.out.println("Empty array");
            return;
        }
        int[] nge = getCircularNge(nums);

        // print nge
        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + "  ");
        }
    }
}
