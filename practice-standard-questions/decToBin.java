import java.util.*;

public class DecToBin {
    public static void dec2Bin(int dec) {
        int bin = 0;
        int multiplyBy10 = 1;
        int remainder;
        while (dec > 0) {
            remainder = dec % 2;
            remainder *= multiplyBy10;

            bin += remainder;
            dec /= 2;
            multiplyBy10 *= 10;
        }
        System.out.print("Binary value : " + bin);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal value :");
        int dec = sc.nextInt();
        dec2Bin(dec);
        sc.close();
    }

}