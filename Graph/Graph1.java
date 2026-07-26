import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Graph1 {
    public static void dfs(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        System.out.print(src + " ");
        for (int i = 0; i < graph[src].size(); i++) {
            int neighbor = graph[src].get(i);
            if (!vis[neighbor]) {
                dfs(graph, neighbor, vis);
            }
        }
    }

    public static void bfs(ArrayList<Integer>[] graph, int src) {
        boolean[] vis = new boolean[graph.length];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        vis[src] = true;
        while (!q.isEmpty()) {
            int rem = q.remove();

            System.out.print(rem + " ");
            for (int i = 0; i < graph[rem].size(); i++) {
                int neighbor = graph[rem].get(i);
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices : ");
        int V = sc.nextInt();
        System.out.println("Enter no of edges  : ");
        int e = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // edge wise input
        // for (int i = 1; i <= e; i++) {
        // System.out.println("Enter src : ");
        // int src = sc.nextInt();
        // System.out.println("Enter dest : ");
        // int dest = sc.nextInt();
        // graph[src].add(dest);
        // graph[dest].add(src);
        // }
        // specific node's edge wise input
        for (int i = 0; i < V; i++) {
            System.out.println("Enter destinations for node : " + i);
            String inp = sc.nextLine();
            String[] destinations = inp.split(" ");

            for (int j = 0; j < destinations.length; j++) {
                int dest = Integer.parseInt(destinations[j]);
                graph[i].add(dest);
            }
        }

        System.out.println("dfs : ");
        dfs(graph, 0, new boolean[V]);
        System.out.println("bfs : ");
        bfs(graph, 0);
    }
}
