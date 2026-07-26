import java.util.*;

public class Topological {
    public static void topSortUtil(ArrayList<Integer>[] graph, int curr, boolean[] vis, Stack<Integer> st) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i);
            if (!vis[neighbor]) {
                topSortUtil(graph, neighbor, vis, st);
            }
        }
        st.push(curr);
    }

    public static void topSort(ArrayList<Integer>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, st);
            }
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop());
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
        topSort(graph);
    }
}
