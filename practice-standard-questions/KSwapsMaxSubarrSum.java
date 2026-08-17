import java.util.*;

public class KSwapsMaxSubarrSum {
    public static int getMaxSubarrSum(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSum += arr[i];
            if (maxSum < 0) {
                maxSum = 0;
            }
        }
        return maxSum;
    }

    public static int getKSwapsMaxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int swapCount = 0;
            for (int j = i + 1; j < n; j++) {
                // swap;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                swapCount++;
                if (swapCount == k) {
                    int res = getMaxSubarrSum(arr);
                    maxSum = Math.max(maxSum, res);
                    swapCount = 0;
                }
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }
        if (k == 0) {
            System.out.println(getMaxSubarrSum(arr));
            return;
        }
        System.out.println(getKSwapsMaxSubarraySum(arr, k));
    }
}
