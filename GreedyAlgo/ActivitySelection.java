package GreedyAlgo;

import java.util.ArrayList;

public class ActivitySelection {

    public static ArrayList<Integer> removeOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int lastIntervalEndIdx = intervals[0][1];
        int removedIntervalCount = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);// store start index of activity that has been occurred
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < lastIntervalEndIdx) {
                removedIntervalCount++;
            } else {
                lastIntervalEndIdx = intervals[i][1];
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // End time is in soreted order
        int[][] intervals = { { 1, 2 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 2, 3 }, { 1, 3 }, { 3, 4 }, { 3, 4 },
                { 20, 30 } };

        System.out.println(removeOverlapIntervals(intervals));
    }

}
