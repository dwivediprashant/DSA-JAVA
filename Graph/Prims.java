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

    Pair(int _vertex, int _cost) {
        this.vertex = _vertex;
        this.cost = _cost;
    }

    @Override
    public int compareTo(Pair p) {
        return this.cost - p.cost;
    }
}

public class Prims {
    public static int mstPrimsAlgo(ArrayList<Edge> graph[]) {
        int startNode = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(startNode, 0));
        boolean[] vis = new boolean[graph.length];
        int miCost = 0;

        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            if (!vis[rem.vertex]) {
                vis[rem.vertex] = true;
                miCost += rem.cost;
                for (int i = 0; i < graph[rem.vertex].size(); i++) {
                    int vertex = graph[rem.vertex].get(i).dest;
                    int weight = graph[rem.vertex].get(i).weight;
                    pq.add(new Pair(vertex, weight));
                }
            }
        }
        return miCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            Edge e1 = new Edge(v, weight);
            Edge e2 = new Edge(u, weight);
            // undirected
            graph[u].add(e1);
            graph[v].add(e2);
        }
        int minCost = mstPrimsAlgo(graph);
        System.out.println("Min cost = " + minCost);
    }
}
