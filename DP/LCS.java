import java.util.*;

public class LCS {
    public static int longestCommonSubsequence(String text1, String text2, int ptr1, int ptr2) {
        if (ptr1 == text1.length() || ptr2 == text2.length()) {
            return 0;
        }
        if (text1.charAt(ptr1) == text2.charAt(ptr2)) {
            return 1 + longestCommonSubsequence(text1, text2, ptr1 + 1, ptr2 + 1);
        } else {
            int c1 = longestCommonSubsequence(text1, text2, ptr1 + 1, ptr2);
            int c2 = longestCommonSubsequence(text1, text2, ptr1, ptr2 + 1);

            return Math.max(c1, c2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.next();
        String text2 = sc.next();
        System.out.println(longestCommonSubsequence(text1, text2, 0, 0));
    }
}
