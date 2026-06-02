import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakest {

    public static class Soldier implements Comparable<Soldier> {
        int idx;
        int count;

        Soldier(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Soldier s) {
            return this.count - s.count;
        }
    }

    public int countSoldiers(int[] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i] == 1) {
                count++;
            }
        }

        return count;
    }

    public int getWeakPoint(int[][] mat, int row) {
        int weakPoint = 0;
        int soldiersInRow = countSoldiers(mat[row]);
        for (int i = 0; i < mat.length; i++) {
            if (i == row) {
                continue;
            }

            int soldiersInIth = countSoldiers(mat[i]);
            if (soldiersInRow < soldiersInIth) {
                weakPoint++;
            } else if (soldiersInRow == soldiersInIth && row < i) {
                weakPoint++;
            }
        }

        return weakPoint;
    }

    public void addWeakPointsInPQ(PriorityQueue<Soldier> pq, int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            int weakPoint = getWeakPoint(mat, i);
            Soldier s = new Soldier(i, weakPoint);
            pq.add(s);
        }
    }

    public int[] getKWeakestRows(PriorityQueue<Soldier> pq, int k) {
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().idx;
        }

        return res;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Soldier> pq = new PriorityQueue<>(Comparator.reverseOrder());

        addWeakPointsInPQ(pq, mat);

        int[] res = getKWeakestRows(pq, k);

        return res;
    }

    public static void main(String[] args) {
        KWeakest obj = new KWeakest();
        int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
        int k = 3;

        int[] res = obj.kWeakestRows(mat, k);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}