import java.util.*;

public class MagicString {
    private static int minFreq(int[] freq) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0 && freq[i] < min) {
                min = freq[i];
            }
        }
        return min;
    }

    private static int maxPieces(String str) {
        int n = str.length();
        int[] freq = new int[255];
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        return minFreq(freq);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(maxPieces(str));
    }
}
