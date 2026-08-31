import java.util.*;

public class Beauty {
    public static void perfectSqPairs(int[] val) {
        for (int i = 0; i < val.length - 1; i++) {
            for (int j = i + 1; j < val.length; j++) {
                long prod = val[i] * val[j];

            }
        }
    }

    public static int getBeauty(int[] par, int[] val) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] par = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            par[i] = x;
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            val[i] = x;
        }

        getBeauty(par, val);
    }
}
