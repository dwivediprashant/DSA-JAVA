import java.util.*;

public class CountCommas {
    public static int getDigitCount(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static int putCommas(int n) {
        int digitCount = getDigitCount(n);
        if (digitCount <= 3) {
            return 0;
        }
        int commaCount = (digitCount - 1) / 3;
        return commaCount + putCommas(n - 1);
    }

    public static int putCommas2(int n) {
        int digitCount = getDigitCount(n);
        if (digitCount <= 3) {
            return 0;
        }
        int lowerBound = (int) Math.pow(10, digitCount - 1);
        int numbersInBlock = n - lowerBound + 1;
        int commaPerNumber = (digitCount - 1) / 3;
        int commaForBlock = commaPerNumber * numbersInBlock;
        return commaForBlock + putCommas2(lowerBound - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // System.out.println(putCommas(n));
        System.out.println(putCommas2(n));
    }

}