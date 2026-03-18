//Brute force time : O(n^2) space : O(1)
public class MinAbsDif {
    public static int getMaxAbsDiff(int[] arr, int x) {

        int n = arr.length;

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + x; j < n; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                minDiff = Math.min(minDiff, diff);
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 4 };
        int x = 2;// at least x idx apart
        System.out.println(getMaxAbsDiff(arr, x));
    }
}
