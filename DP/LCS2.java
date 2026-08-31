import java.util.*;

public class LCS2 {
    public static int getLongestCommonSubstring(String str1, String str2, int ptr1, int ptr2, int currLen) {
        if (ptr1 == str1.length() || ptr2 == str2.length()) {
            return currLen;
        }

        int ans1 = 0;
        if (str1.charAt(ptr1) == str2.charAt(ptr2)) {
            ans1 = getLongestCommonSubstring(str1, str2, ptr1 + 1, ptr2 + 1, currLen + 1);
        }

        int ans2 = getLongestCommonSubstring(str1, str2, ptr1, ptr2 + 1, 0);
        int ans3 = getLongestCommonSubstring(str1, str2, ptr1 + 1, ptr2, 0);

        return Math.max(currLen, Math.max(ans3, Math.max(ans1, ans2)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(getLongestCommonSubstring(str1, str2, 0, 0, 0));
    }
}
