import java.util.*;

public class Q1 {
    static int calls = 0;

    public static int countPossibleArrays(int n, int k, int currPos, int placedNum) {
        calls++;
        if (currPos == k) {
            return 1;
        }

        int ways = 0;
        for (int num = 1; num <= n; num++) {
            if (placedNum == -1) {
                ways = (ways + countPossibleArrays(n, k, currPos + 1, num)) % 10000;
            } else if (num % placedNum == 0) {
                ways = (ways + countPossibleArrays(n, k, currPos + 1, num)) % 10000;
            }

        }
        return ways;
    }

    static int dpCalls = 0;

    public static int countPossibleArrays2(int n, int k, int currPos, int placedNum, int[][] dp) {

        dpCalls++;

        if (currPos == k) {
            return 1;
        }
        if (placedNum != -1 && dp[currPos][placedNum] != -1) {
            return dp[currPos][placedNum];

        }
        int ways = 0;
        for (int num = 1; num <= n; num++) {
            if (placedNum == -1) {
                ways += countPossibleArrays2(n, k, currPos + 1, num, dp);
            } else {
                if (num % placedNum == 0) {
                    ways += countPossibleArrays2(n, k, currPos + 1, num, dp);
                }
            }
            ways %= 10000;
        }
        if (placedNum != -1) {
            dp[currPos][placedNum] = ways;
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// range of arr[i]
        int k = sc.nextInt();// len of arrays required
        System.out.println("Recursion : -");
        System.out.println(countPossibleArrays(n, k, 0, -1));
        System.out.println(calls);
        System.out.println("Dp : -");
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(countPossibleArrays2(n, k, 0, -1, dp));
        System.out.println(dpCalls);
    }
}
