import java.util.*;

public class UnevenSurface {

    public static int minDaysToMakeDescending(int[] len) {
        int maxDig = 0;
        for (int i = 1; i < len.length; i++) {
            if (len[i] >= len[i - 1]) {
                int tobe = len[i - 1] - 1;
                int req = len[i] - tobe;
                maxDig = Math.max(maxDig, req);
                len[i] = tobe;
            }
        }
        return (int) Math.ceil(Math.sqrt(maxDig));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            len[i] = l;
        }

        System.out.println(minDaysToMakeDescending(len));
    }
}
