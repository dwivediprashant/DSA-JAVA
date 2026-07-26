import java.util.*;
import java.util.Stack;

public class AllPath {
    public static void allPath(ArrayList<Integer>[] graph, int src, int dest, boolean[] vis, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            int neighbor = graph[src].get(i);
            if (!vis[neighbor]) {
                allPath(graph, neighbor, dest, vis, path + src);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();
        allPath(graph, src, dest, new boolean[V], "");
    }
}
