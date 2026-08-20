import java.util.*;

public class StaircaseFibonacci {
    static int calls = 0;

    public static int getMinCost(int n, int a, int b, int currStep) {
        calls++;
        if (currStep == n) {
            return 0;
        }
        // all possible step moves
        int fib1 = 0, fib2 = 1;
        int minCost = Integer.MAX_VALUE;
        while (currStep + fib1 + fib2 <= n) {
            // include
            int c1 = a + b * (fib1 + fib2) + getMinCost(n, a, b, currStep + fib1 + fib2);
            minCost = Math.min(c1, minCost);
            int temp = fib1;
            fib1 = fib2;
            fib2 = temp + fib1;
        }
        return minCost;
    }

    static int dpcalls = 0;

    public static int getMinCost2(int n, int a, int b, int currStep, int[] dp) {
        dpcalls++;
        if (currStep == n) {
            return 0;
        }
        if (dp[currStep] != -2) {
            return dp[currStep];
        }
        // all possible step moves
        int fib1 = 0, fib2 = 1;
        int minCost = Integer.MAX_VALUE;
        while (currStep + fib1 + fib2 <= n) {
            // include
            int c1 = a + b * (fib1 + fib2) + getMinCost2(n, a, b, currStep + fib1 + fib2, dp);
            minCost = Math.min(c1, minCost);
            int temp = fib1;
            fib1 = fib2;
            fib2 = temp + fib1;
        }
        dp[currStep] = minCost == Integer.MAX_VALUE ? -1 : minCost;
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("recursion : -");
        System.out.println(getMinCost(n, a, b, 1));
        System.out.println("calls =" + calls);
        System.out.println("Dp + memo : -");
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -2);
        System.out.println(getMinCost2(n, a, b, 1, dp));
        System.out.println("Dp calls = " + dpcalls);
    }
}
