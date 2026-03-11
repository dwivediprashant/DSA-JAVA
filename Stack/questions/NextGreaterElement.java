package Stack.questions;

import java.util.Stack;

public class NextGreaterElement {

    public static int[] getNGE(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nge[i] = -1;// -1: means no nge exist

            } else {
                nge[i] = s.peek();
            }

            s.push(nums[i]);

        }

        return nge;

    }

    public static void main(String[] args) {
        int[] nums = { 6, 8, 0, 1, 3 };
        int[] nge = getNGE(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nge[i] + "  ");
        }
    }
}
