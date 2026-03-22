import java.util.*;

public class Bubble {
    public static void bubbleSort(int[] arr) {
        int temp;// to swap
        for (int pass = 0; pass <= arr.length - 1; pass++) {// optimized code
            for (int i = 0; i <= arr.length - 2 - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 5, -4, 0, 12, 8, 11 };
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        sc.close();
    }

}