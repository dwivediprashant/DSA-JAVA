import java.util.*;

class Edge {
    int dest;
    int weight;

    Edge(int _dest, int _weight) {
        dest = _dest;
        weight = _weight;
    }
}

public class Bellman {
    public static void relax(int u, Edge e, ArrayList<Edge>[] graph, int[] dist) {
        if (dist[u] + e.weight < dist[e.dest]) {
            dist[e.dest] = dist[u] + e.weight;
        }
    }

    public static int[] bellmanFord(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        // O(V*E)
        for (int times = 1; times <= graph.length - 1; times++) {
            // O(E)
            for (int i = src; i < graph.length; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    if (dist[i] != Integer.MAX_VALUE && dist[i] + e.weight < dist[e.dest]) {
                        dist[e.dest] = dist[i] + e.weight;
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // directed graph : [[(1,2),(2,5),(3,-2)],[(3,-2)],....];
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            Edge e = new Edge(v, w);
            graph[u].add(e);
        }
        int src = sc.nextInt();

        int[] dist = bellmanFord(graph, src);

        System.out.println("Shortest distance : ");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
