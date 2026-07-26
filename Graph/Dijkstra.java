import java.util.*;

class Edge {
    int dest;
    int weight;

    Edge(int _dest, int _weight) {
        dest = _dest;
        weight = _weight;
    }
}

public class Dijkstra {
    public static int pickShortestUnvisited(int[] dist, boolean[] vis) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!vis[i] && dist[i] < min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src, int[] dist) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            // pick shortest distance node
            int shortest = pickShortestUnvisited(dist, vis);
            if (shortest == -1) {
                break;
            }
            vis[shortest] = true;
            for (int j = 0; j < graph[shortest].size(); j++) {
                int neighbor = graph[shortest].get(j).dest;
                int neighborW = graph[shortest].get(j).weight;

                if (!vis[neighbor]) {
                    // relaxation
                    if (dist[shortest] + neighborW < dist[neighbor]) {
                        dist[neighbor] = dist[shortest] + neighborW;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

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
            Edge e = new Edge(v, w);
            graph[u].add(e);
        }
        int src = sc.nextInt();
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i == src) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        dijkstra(graph, src, dist);
    }
}
