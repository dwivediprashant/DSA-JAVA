import java.util.*;

public class PairInArr {
    public static void pair(int[] arr) {
        int tp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("( " + arr[i] + " , " + arr[j] + " )");
                tp++;
            }
            System.out.println();
        }
        System.out.print("total pairs : " + tp);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 3, 4, 2, 8, 6, 7 };
        pair(arr);
        sc.close();
    }

}