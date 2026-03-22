import java.util.*;

public class Selection {
    public static int minimum(int[] arr, int stIdx, int endIdx) {
        // int left=stIdx,right=endIdx;
        // while(left<right){
        // if(arr[left]<arr[right]){
        // right--;
        // }else{
        // left++;
        // }
        // }
        // return left;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = stIdx; i <= endIdx; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void selectionSort(int[] arr) {
        int lastIdx = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            int minIdx = minimum(arr, i, lastIdx);
            // swap min and ith index
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 3, 3, 1, 9, -3, 0 };
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        sc.close();
    }

}