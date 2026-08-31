import java.util.*;

public class SplitString {
    public static int countBalanceString(char[] strArr) {
        int countL = 0;
        int countR = 0;
        int countBalanceStr = 0;
        for (int i = 0; i < strArr.length; i++) {
            char curr = strArr[i];
            if (curr == 'L') {
                countL++;
            } else {
                countR++;
            }

            if (countL == countR) {
                countBalanceStr++;
            }
        }
        return countBalanceStr;
    }

    public static int getMaxBalanceString(char[] strArr) {

        // dont swap and count;
        int maxCount = countBalanceString(strArr);

        for (int i = 1; i < strArr.length; i++) {

            // swap and count
            int c = 0;
            if (strArr[i - 1] != strArr[i]) {
                char temp = strArr[i];
                strArr[i] = strArr[i - 1];
                strArr[i - 1] = temp;
                c = countBalanceString(strArr);
                // reposition
                temp = strArr[i];
                strArr[i] = strArr[i - 1];
                strArr[i - 1] = temp;
            }
            maxCount = Math.max(c, maxCount);
        }
        return maxCount;
    }

    public static int getMaxBalanceString2(char[] strArr) {
        int n = strArr.length;
        // dont swap and count;
        int maxCount = countBalanceString(strArr);
        int[] prefix = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = strArr[i];
            if (ch == 'L') {
                count++;
            } else {
                count--;
            }
            prefix[i] = count;
        }
        for (int i = 1; i < n; i++) {
            if (strArr[i - 1] != strArr[i]) {

                if (strArr[i] == 'L') {
                    prefix[i - 1] += 2;
                } else {
                    prefix[i - 1] -= 2;
                }

                if (prefix[i - 1] == 0) {
                    return maxCount + 1;
                }
                // RESET
                if (strArr[i] == 'L') {
                    prefix[i - 1] -= 2;
                } else {
                    prefix[i - 1] += 2;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] strArr = str.toCharArray();
        System.out.println("Brute force : -");
        System.out.println(getMaxBalanceString(strArr));
        System.out.println("prefix solution :-");
        System.out.println(getMaxBalanceString2(strArr));

    }
}
