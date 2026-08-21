import java.util.*;

public class MaxVacation {
    public static int countConsecutive(boolean[] arr) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                curr++;
            } else {
                curr = 0;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

    private static int getMaxVacationDays(boolean[] days, int k, int currIdx, int cancelCount) {
        if (cancelCount == k || currIdx == days.length) {
            return countConsecutive(days);
        }

        int maxVacations = getMaxVacationDays(days, k, currIdx + 1, cancelCount);

        if (days[currIdx]) {
            days[currIdx] = false;
            maxVacations = Math.max(maxVacations, getMaxVacationDays(days, k, currIdx + 1, cancelCount + 1));
            days[currIdx] = true;
        }

        return maxVacations;
    }

    public static int getMaxVacationDays2(int[] obligations, int k, int m, int n) {
        if (k >= m) {
            return n;
        }

        Arrays.sort(obligations);

        int maxVacation = 0;
        for (int i = k + 1; i < obligations.length; i++) {
            int currVacation = obligations[i] - obligations[i - k - 1] - 1;
            maxVacation = Math.max(maxVacation, currVacation);
        }
        return maxVacation;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        boolean[] days = new boolean[n];
        int[] obligations = new int[m + 2];

        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            days[x - 1] = true;
            obligations[i] = x;
        }
        obligations[0] = 0;
        obligations[m + 1] = n + 1;
        System.out.println("Recursion :-");
        System.out.println(getMaxVacationDays(days, k, 0, 0));
        System.out.println("Iterative approach :- ");
        System.out.println(getMaxVacationDays2(obligations, k, m, n));
    }
}
