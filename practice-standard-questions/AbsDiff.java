import java.util.*;

public class AbsDiff {
    public static int getMinAbsoluteDiff(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int minDiff = 0;

        for (int i = 0; i < arr1.length; i++) {
            minDiff += Math.abs(arr1[i] - arr2[i]);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr1[i] = x;
        }

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr2[i] = x;
        }

        // 1 : O(nlogn) time & O(1) space
        int minDiff = getMinAbsoluteDiff(arr1, arr2);
        System.out.println(minDiff);
    }
}
