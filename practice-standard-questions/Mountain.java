import java.util.*;

public class Mountain {
    public static int minChangeRequired(int[] height) {
        int n = height.length;
        int midIdx = n / 2;

        int op = 0;
        int leftMidIdx = midIdx;
        if (n % 2 == 0) {
            leftMidIdx--;
        }

        for (int i = leftMidIdx - 1; i >= 0; i--) {
            if (height[i + 1] - height[i] != 1) {
                height[i] = height[i + 1] - 1;
                op++;
            }
        }

        if (height[leftMidIdx] != height[midIdx]) {
            op++;
        }
        for (int i = midIdx + 1; i < n; i++) {
            int leftIdx = n - 1 - i;
            if (height[leftIdx] != height[i]) {
                op++;
            }
        }
        return op;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            height[i] = h;
        }

        System.out.println(minChangeRequired(height));
    }
}
