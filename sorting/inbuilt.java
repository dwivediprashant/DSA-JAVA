import java.util.*;

public class Inbuilt {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 5, 6, 3, -2, 5, 0 };
        // Arrays.sort(arr);//nlogn ---dual pivot quicksort=t
        Arrays.sort(arr, 3, 6);// Arrays.sort(arr,star index, end index(exclusive))
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        sc.close();
    }

}