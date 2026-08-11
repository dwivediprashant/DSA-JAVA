import java.util.*;

public class Knapsack {
    public static int maxProfit(int[][] items, int maxWeight) {
        int[][] valuesPerWeight = new int[items.length][2];
        for (int i = 0; i < items.length; i++) {
            valuesPerWeight[i][0] = items[i][0] / items[i][1];
            valuesPerWeight[i][1] = i;
        }

        Arrays.sort(valuesPerWeight, (a, b) -> {
            return b[0] - a[0];
        });

        int availableWeight = maxWeight;
        int totalProfit = 0;
        for (int i = 0; i < valuesPerWeight.length; i++) {
            int idx = valuesPerWeight[i][1];
            if (availableWeight > items[idx][1]) {
                totalProfit += items[idx][0];
                availableWeight -= items[idx][1];
            } else {
                int fraction = valuesPerWeight[i][0];
                totalProfit += availableWeight * fraction;

            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] items = new int[n][2];// value,weight

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int wt = sc.nextInt();
            items[i][0] = v;
            items[i][1] = wt;
        }

        int maxWeight = sc.nextInt();
        int max = maxProfit(items, maxWeight);
        System.out.println(max);
    }
}
