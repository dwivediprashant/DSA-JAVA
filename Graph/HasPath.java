import java.util.*;

public class HasPath {
    public static boolean hasPath(ArrayList<Integer>[] graph, int src, int dest, boolean[] vis) {

        if (src == dest) {
            return true;
        }

        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            int neighbor = graph[src].get(i);
            if (!vis[neighbor]) {
                if (hasPath(graph, neighbor, dest, vis)) {
                    return true;
                }
            }
        }
        return false;
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
            graph[v].add(u);
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();

        System.out.println(hasPath(graph, src, dest, new boolean[V]));
    }
}
