import java.util.*;

public class IsCycle {
    public static boolean isCycleUtil(ArrayList<Integer>[] graph, int src, int prev, boolean[] vis) {

        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {

            int neighbor = graph[src].get(i);

            if (vis[neighbor] && neighbor != prev) {
                return true;
            }

            if (!vis[neighbor]) {
                if (isCycleUtil(graph, neighbor, src, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle(ArrayList<Integer>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, -1, vis)) {
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
        System.out.println(isCycle(graph));
    }
}
