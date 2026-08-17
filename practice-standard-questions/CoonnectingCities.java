import java.util.*;

class Edge {
    int dest;
    int weight;

    Edge(int d, int w) {
        this.dest = d;
        this.weight = w;
    }
}

class Pair implements Comparable<Pair> {
    int vertex;
    int cost;

    Pair(int v, int c) {
        this.vertex = v;
        this.cost = c;
    }

    @Override
    public int compareTo(Pair p) {
        return this.cost - p.cost;
    }
}

public class CoonnectingCities {
    public static void prims(ArrayList<Edge>[] graph, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[graph.length];

        pq.add(new Pair(src, 0));// 0 for src

        int cost = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            if (!vis[p.vertex]) {
                vis[p.vertex] = true;
                cost += p.cost;
                for (int i = 0; i < graph[p.vertex].size(); i++) {
                    Edge e = graph[p.vertex].get(i);
                    pq.add(new Pair(e.dest, e.weight));

                }
            }
        }
        System.out.println("cost = " + cost);
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
            int w = sc.nextInt();
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        prims(graph, 0);
    }
}
