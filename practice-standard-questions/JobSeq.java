import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class JobSeq {
    public static void main(String[] args) {
        // char[] jobs = { 'A', 'B', 'C', 'D' };// jobs
        int[] deadlines = { 4, 1, 1, 1 };
        int[] profits = { 20, 10, 40, 30 };

        System.out.println("Max profit : " + getMaxProfit(deadlines, profits));
    }

    public static int getMaxProfit(int[] deadlines, int[] profits) {
        int n = deadlines.length;
        int[][] deadlinesPlusProfits = new int[n][2];

        // store deadlines and profits
        for (int i = 0; i < n; i++) {
            deadlinesPlusProfits[i][0] = deadlines[i];
            deadlinesPlusProfits[i][1] = profits[i];
        }

        // sort according to profit in ascending order
        Arrays.sort(deadlinesPlusProfits, Comparator.comparingInt(a -> a[1]));
        // for (int i = 0; i < n; i++) {
        // System.out.println(deadlinesPlusProfits[i][0] + " - " +
        // deadlinesPlusProfits[i][1]);
        // }

        int profit = deadlinesPlusProfits[n - 1][1];

        int lastProfitIdx = n - 1;

        ArrayList<String> maxProfitJobs = new ArrayList<>();
        maxProfitJobs.add("J" + lastProfitIdx);

        for (int i = n - 2; i >= 0; i--) {
            if (deadlinesPlusProfits[i][0] > deadlinesPlusProfits[lastProfitIdx][0]) {
                profit += deadlinesPlusProfits[i][1];
                maxProfitJobs.add("J" + i);
                lastProfitIdx = i;
            }
        }

        // maxProfitJobs are (job indexing is based on deadlinesPlusProfits matrix):
        for (int i = 0; i < maxProfitJobs.size(); i++) {
            System.out.println(maxProfitJobs.get(i));
        }
        return profit;
    }
}
