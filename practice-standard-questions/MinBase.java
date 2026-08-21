import java.util.*;

public class MinBase {
    public static boolean isAllSameDigit(int num, int base) {
        int requireRem = num % base;

        while (num >= base) {
            int rem = num % base;
            if (rem != requireRem) {
                return false;
            }
            num /= base;
        }
        if (num != requireRem) {
            return false;
        }
        return true;
    }

    public static int getMinBase(int m) {
        int minBase = m - 1;

        for (int b = 2; b < m; b++) {
            if (isAllSameDigit(m, b)) {
                return b;
            }
        }
        return minBase;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(getMinBase(m));
    }
}
