package GreedyAlgo;

import java.util.Arrays;

public class MinAbsDiffPair {
    public static int getMinAbsDiff(int[] arr1, int[] arr2) {
        // intution behind sorting : diff will be minimum closest ele pairs
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n = arr1.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(arr1[i] - arr2[i]);
            sum += diff;
        }

        return sum;
    }

    public static void main(String[] args) {
        // given two array in which we have to make pairs of arr1 to arr2 such a way
        // absolute difference is minimum
        int[] arr1 = { 1, 3, -5, 10, 4, 1 };
        int[] arr2 = { 5, 6, 1, 10, -2, 7 };

        System.out.println(getMinAbsDiff(arr1, arr2));
    }
}
