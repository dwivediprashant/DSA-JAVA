import java.util.PriorityQueue;

public class ConnectRopes {
    public static void addToPq(int[] ropeLengths, PriorityQueue<Integer> pq) {
        for (int i = 0; i < ropeLengths.length; i++) {
            pq.add(ropeLengths[i]);
        }
    }

    public static int connectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        addToPq(ropeLengths, pq);

        int minCost = 0;

        while (!pq.isEmpty()) {
            int pop1 = pq.remove();
            if (pq.isEmpty()) {
                break;
            }
            int pop2 = pq.remove();
            int cost = pop1 + pop2;
            minCost += cost;
            pq.add(cost);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] ropeLengths = { 2, 3, 3, 4, 6 };
        int minCost = connectRopes(ropeLengths);
        System.out.println("Min cost : " + minCost);
    }
}
