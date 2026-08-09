import java.util.*;

class Edge {
    int dest;
    int weight;

    Edge(int d, int w) {
        this.weight = w;
        this.dest = d;
    }
}

public class CheapestFlight {
    static ArrayList<Integer> costsWithinKStops = new ArrayList<>();

    public static int cheapestFlightCostWithMaxKStops(ArrayList<Edge>[] graph, int src, int dest, int k,
            int currK, int cost) {

        if (currK > k) {
            return -1;
        }
        if (src == dest) {
            return cost;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            int c = cheapestFlightCostWithMaxKStops(graph, e.dest, dest, k, currK + 1, cost + e.weight);
            if (c != -1) {
                costsWithinKStops.add(c);
            }
        }
        return -1;
    }

    public static int getMinCost(ArrayList<Integer> costsWithinKStops) {
        int min = Integer.MAX_VALUE;

        for (int c : costsWithinKStops) {
            if (min > c) {
                min = c;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            Edge e = new Edge(v, wt);
            graph[u].add(e);
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();
        int k = sc.nextInt();

        cheapestFlightCostWithMaxKStops(graph, src, dest, k, -1, 0);
        // // System.out.println("Min cost = " + minCost);
        // for (int c : costsWithinKStops) {
        // System.out.print(c + " ");
        // }
        int minCost = getMinCost(costsWithinKStops);
        System.out.println("Min Cost = " + minCost);
    }
}
