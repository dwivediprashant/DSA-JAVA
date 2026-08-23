import java.util.*;

public class Food implements Comparable<Food> {
    int v;
    int d;

    Food(int _v, int _d) {
        this.v = _v;
        this.d = _d;
    }

    @Override
    public int compareTo(Food f) {
        return f.v - this.v;
    }
}

public class FoodStamp2 {
    public static int maxTastePoint(int[] v, int[] d, int m, int currIdx, int[] times, int tastePoint) {
        // limit reached || food exhausted
        if (m == 0 || currIdx == v.length) {
            return tastePoint;
        }

        // buy food
        int currTastePoint = v[currIdx] - d[currIdx] * (times[currIdx] - 1);
        times[currIdx]++;
        int res1 = maxTastePoint(v, d, m - 1, currIdx, times, tastePoint + currTastePoint);

        // dont buy food
        times[currIdx]--;
        int res2 = maxTastePoint(v, d, m, currIdx + 1, times, tastePoint);

        return Math.max(res1, res2);

    }

    public static int maxTastePoint2(int[] v, int[] d, int m) {
        int n = v.length;
        ArrayList<Integer> tastePoints = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                int taste = v[i] - d[i] * (j - 1);
                tastePoints.add(taste);
            }
        }

        Collections.sort(tastePoints, Comparator.reverseOrder());

        int maxTastePoints = 0;

        for (int i = 0; i < m; i++) {
            maxTastePoints += tastePoints.get(i);
        }
        return maxTastePoints;
    }

    public static int maxTastePoint3(int[] v, int[] d, int m) {
        PriorityQueue<Food> pq = new PriorityQueue<>();

        for (int i = 0; i < v.length; i++) {
            int _v = v[i];
            int _d = d[i];
            Food f = new Food(_v, _d);
            pq.add(f);
        }
        int tastePoint = 0;
        while (m > 0 && !pq.isEmpty()) {
            Food maxF = pq.remove();
            if (maxF.v < 0) {
                break;
            }
            tastePoint += maxF.v;
            maxF.v = maxF.v - maxF.d;
            pq.add(maxF);
            m--;
        }
        return tastePoint;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] v = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            v[i] = x;
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            d[i] = x;
        }
        System.out.println("Recursion : -");
        int[] times = new int[n];
        Arrays.fill(times, 1);
        // 1. time : O(2^(n*m)) exponential , space :O(n*m) quadratic call stack
        System.out.println(maxTastePoint(v, d, m, 0, times, 0));
        // 2. time:O(n*m*log(n*m)) quadratic , space : O(n*m) quadratic list
        System.out.println("Iterative approach : -");
        System.out.println(maxTastePoint2(v, d, m));
        // 3. time : O((n+m)log(n)) near linear , space : O(n) heap size
        System.out.println("PriorityQ : -");
        System.out.println(maxTastePoint3(v, d, m));
    }
}
