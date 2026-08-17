import java.util.*;

public class XorSum {
    public static int getMaxXORSum1(int[] arr, int k) {
        int maxXORSum = 0;
        int x = 0;
        for (int i = 0; i < k; i++) {
            int xorSum = 0;
            for (int j = 0; j < arr.length; j++) {
                xorSum += i ^ arr[j];
            }
            if (maxXORSum < xorSum) {
                maxXORSum = xorSum;
                x = i;
            }
        }
        System.out.println("x = " + x);
        return maxXORSum;
    }

    // public static int getMaxXORSum2(int[] arr, int k) {

    // // int left = 0, right = k;
    // // while (left <= right) {
    // // int mid = left + (right - left) / 2;

    // // }
    // // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }
        int k = sc.nextInt();
        // 1st approach time : O(n*K) space O(1)
        System.out.println(getMaxXORSum1(arr, k));
        // System.out.println(getMaxXORSum2(arr, k));
    }
}
