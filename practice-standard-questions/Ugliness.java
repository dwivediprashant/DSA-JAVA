import java.util.*;

public class Ugliness {
    public static int binToDec(char[] bin) {
        long dec = 0;
        int n = bin.length;
        long multi = 1;
        long mod = 1000000007;

        for (int i = n - 1; i >= 0; i--) {
            if (bin[i] == '1') {
                dec = (dec + multi) % mod;
            }
            multi = (multi * 2) % mod;
        }

        return (int) dec;

    }

    public static int applySwaps(char[] strArr, int cash, int swapCost) {
        int n = strArr.length;
        int ptr1 = 0, ptr2 = n - 1;

        while (ptr1 < ptr2 && cash >= swapCost) {
            while (ptr2 > ptr1 && strArr[ptr2] == '1') {
                ptr2--;
            }
            if (strArr[ptr1] == '1' && ptr1 < ptr2) {
                char temp = strArr[ptr1];
                strArr[ptr1] = strArr[ptr2];
                strArr[ptr2] = temp;
                cash -= swapCost;
            }
            ptr1++;
        }
        return cash;
    }

    public static int applyFlips(char[] strArr, int cash, int flipCost) {
        int n = strArr.length;
        int left = 0;
        while (left < n && cash >= flipCost) {
            char ch = strArr[left];
            if (ch == '1') {
                strArr[left] = '0';
                cash -= flipCost;
            }
            left++;
        }
        return cash;
    }

    public static int minimizeUgliness(String str, int cash, int swapCost, int flipCost) {
        char[] strArr = str.toCharArray();

        if (swapCost < flipCost) {
            cash = applySwaps(strArr, cash, swapCost);
            cash = applyFlips(strArr, cash, flipCost);
        } else {
            cash = applyFlips(strArr, cash, flipCost);
            cash = applySwaps(strArr, cash, swapCost);
        }

        return binToDec(strArr);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int cash = sc.nextInt();
        int swapCost = sc.nextInt();
        int flipCost = sc.nextInt();

        System.out.println(minimizeUgliness(str, cash, swapCost, flipCost));
    }
}
