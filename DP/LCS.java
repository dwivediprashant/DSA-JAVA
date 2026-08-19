import java.util.*;

public class LCS {
    static int calls = 0;

    public static int longestCommonSubsequence(String text1, String text2, int ptr1, int ptr2) {
        calls++;
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

    static int dpCalls = 0;

    public static int getLongestCommonSubsequence(String text1, String text2, int ptr1, int ptr2,
            HashMap<String, Integer> dp) {
        dpCalls++;
        if (ptr1 == text1.length() || ptr2 == text2.length()) {
            return 0;
        }
        String key = ptr1 + "," + ptr2;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (text1.charAt(ptr1) == text2.charAt(ptr2)) {
            int c = 1 + getLongestCommonSubsequence(text1, text2, ptr1 + 1, ptr2 + 1, dp);
            dp.put(key, c);
            return c;
        } else {
            int c1 = getLongestCommonSubsequence(text1, text2, ptr1 + 1, ptr2, dp);
            int c2 = getLongestCommonSubsequence(text1, text2, ptr1, ptr2 + 1, dp);

            int max = Math.max(c1, c2);
            dp.put(key, max);
            return max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.next();
        String text2 = sc.next();
        System.out.println("recursion : ");
        System.out.println(longestCommonSubsequence(text1, text2, 0, 0));
        System.out.println(calls);
        System.out.println("Dp recursion : -");
        System.out.println(getLongestCommonSubsequence(text1, text2, 0, 0, new HashMap<>()));
        System.out.println(dpCalls);
    }
}
