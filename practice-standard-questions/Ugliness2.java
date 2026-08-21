import java.util.*;

public class Ugliness2 {
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

    static int calls = 0;

    public static int minimizeUgliness(char[] strArr, int cash, int swapCost, int flipCost, int currIdx) {
        calls++;
        // base case
        if (currIdx == strArr.length) {
            return binToDec(strArr);
        }
        // if bit is 0 move next
        int minUgliness = minimizeUgliness(strArr, cash, swapCost, flipCost, currIdx + 1);

        if (strArr[currIdx] == '1') {
            // flip option
            if (cash >= flipCost) {
                strArr[currIdx] = '0';
                minUgliness = Math.min(minUgliness,
                        minimizeUgliness(strArr, cash - flipCost, swapCost, flipCost, currIdx + 1));
                strArr[currIdx] = '1';
            }
            // swap options
            if (cash >= swapCost) {
                for (int i = currIdx + 1; i < strArr.length; i++) {
                    if (strArr[i] == '0') {
                        char temp = strArr[i];
                        strArr[i] = strArr[currIdx];
                        strArr[currIdx] = temp;
                        minUgliness = Math.min(minUgliness,
                                minimizeUgliness(strArr, cash - swapCost, swapCost, flipCost, currIdx + 1));
                        char temp2 = strArr[i];
                        strArr[i] = strArr[currIdx];
                        strArr[currIdx] = temp2;
                    }
                }
            }
        }
        return minUgliness;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int cash = sc.nextInt();
        int swapCost = sc.nextInt();
        int flipCost = sc.nextInt();

        System.out.println("Recursion : -");
        System.out.println(minimizeUgliness(str.toCharArray(), cash, swapCost, flipCost, 0));
        System.out.println(calls);
    }
}
