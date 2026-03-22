import java.util.*;

public class InvertAndRotatedPyramid {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int row = sc.nextInt();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (i + j >= row - 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        sc.close();
    }

}