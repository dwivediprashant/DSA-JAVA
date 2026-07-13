
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Cycle {

    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // condition of working :-
    // 1. undirected graph 2. connected graph

    // Time : O(v+e) space : O(v)
    public static boolean isCycle(ArrayList<Edge>[] graph, int src) {
        boolean isVisited[] = new boolean[graph.length];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        for (int i = 0; i < graph.length; i++) {
            int rem = q.remove();
            isVisited[rem] = true;

            for (int j = 0; j < graph[rem].size(); j++) {
                int neighbor = graph[rem].get(j).dest;
                if (!isVisited[neighbor]) {
                    q.add(neighbor);
                }
            }
        }

        if (q.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // int V = 3;

        // // edges
        // Edge e01 = new Edge(0, 1);
        // Edge e10 = new Edge(1, 0);

        // Edge e12 = new Edge(1, 2);
        // Edge e21 = new Edge(2, 1);

        // Edge e20 = new Edge(2, 0);
        // Edge e02 = new Edge(0, 2);

        // // graph
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // for (int i = 0; i < V; i++) {
        // graph[i] = new ArrayList<>();
        // }

        // graph[0].add(e01);
        // graph[0].add(e02);

        // graph[1].add(e10);
        // graph[1].add(e12);

        // graph[2].add(e21);
        // graph[2].add(e20);

        // System.out.println(isCycle(graph, 0));// true

        // example 2
        int V = 3;

        // edges
        Edge e01 = new Edge(0, 1);
        Edge e10 = new Edge(1, 0);
        Edge e12 = new Edge(1, 2);
        Edge e21 = new Edge(2, 1);

        // graph
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(e01);

        graph[1].add(e10);
        graph[1].add(e12);

        graph[2].add(e21);

        System.out.println(isCycle(graph, 0));

    }
}
