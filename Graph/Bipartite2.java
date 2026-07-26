import java.util.*;

public class Bipartite2 {
    public static boolean isBiPartite(ArrayList<Integer>[] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {

                q.add(i);
                color[i] = 0;
                vis[i] = true;
                // bfs
                while (!q.isEmpty()) {
                    int rem = q.remove();
                    for (int j = 0; j < graph[rem].size(); j++) {
                        int neighbor = graph[rem].get(j);
                        if (color[neighbor] == -1) {
                            color[neighbor] = color[rem] == 0 ? 1 : 0;
                            q.add(neighbor);
                        } else if (color[neighbor] == color[rem]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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
        System.out.println(isBiPartite(graph));
    }
}
