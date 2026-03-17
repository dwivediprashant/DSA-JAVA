package GreedyAlgo;

import java.util.Arrays;

public class FractionalKnapsack {
    public static Double[] calcValPerUnitWeight(int[] val, int[] weights) {
        int n = val.length;
        Double[] vpuw = new Double[n];
        for (int i = 0; i < n; i++) {
            vpuw[i] = val[i] / (double) weights[i];
        }
        return vpuw;
    }

    public static double getMaxValInKnapsack(int[] val, int[] weights, int maxCapacity) {

        Double[] vpuw = calcValPerUnitWeight(val, weights);

        // sort array in descending order so that pick maximum vpuw
        double[][] idxPreserveVpuw = new double[vpuw.length][2];
        for (int i = 0; i < vpuw.length; i++) {
            idxPreserveVpuw[i][0] = i;// index preserve
            idxPreserveVpuw[i][1] = vpuw[i];// vpuw val
        }

        Arrays.sort(idxPreserveVpuw, (a, b) -> Double.compare(b[1], a[1]));// descending order

        double maxVal = 0;
        int remainCapacity = maxCapacity;
        int i = 0;
        while (remainCapacity > 0 && i < idxPreserveVpuw.length) {
            // remain capacity is less than current weight => partition required
            if (remainCapacity < weights[(int) idxPreserveVpuw[i][0]]) {
                double fractionalVal = idxPreserveVpuw[i][1] * remainCapacity;
                maxVal += fractionalVal;
                remainCapacity = 0;
                break;
            } else {
                maxVal += val[(int) idxPreserveVpuw[i][0]];
            }

            remainCapacity -= weights[(int) idxPreserveVpuw[i][0]];
            i++;
        }

        return maxVal;

    }

    public static void main(String[] args) {
        int[] val = { 10, 20, 20, 15 };
        int[] weights = { 50, 50, 80, 20 };
        int maxCapacity = 10;
        System.out.println(getMaxValInKnapsack(val, weights, maxCapacity));
    }
}
