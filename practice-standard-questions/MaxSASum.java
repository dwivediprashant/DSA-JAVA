public class MaxSASum {

    public static int getMaxSubSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int kadaneApproach(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 38, 12, -5, -10 };

        int maxSum = getMaxSubSum(arr);
        int maxKadane = kadaneApproach(arr);
        System.out.println("Brute force : " + maxSum);
        System.out.println("Kadane algo : " + maxKadane);
    }
}
