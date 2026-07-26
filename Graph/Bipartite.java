import java.util.*;

public class Bipartite {
    public static boolean isBiPartiteUtil(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        vis[src] = true;
        HashMap<Integer, String> colorMap = new HashMap<>();// node:color
        colorMap.put(src, "Blue");

        while (!q.isEmpty()) {
            int rem = q.remove();
            for (int i = 0; i < graph[rem].size(); i++) {
                int neighbor = graph[rem].get(i);
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                    if (colorMap.get(rem).equals("Blue")) {
                        colorMap.put(neighbor, "Red");
                    } else {
                        colorMap.put(neighbor, "Blue");
                    }
                    // check collision with neighbor's color
                    String neighborColor = colorMap.get(neighbor);
                    for (int j = 0; j < graph[neighbor].size(); j++) {
                        int neigh = graph[neighbor].get(j);
                        String neighColor = colorMap.containsKey(neigh) ? colorMap.get(neigh) : "";
                        if (neighborColor.equals(neighColor)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isBiPartite(ArrayList<Integer>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (!isBiPartiteUtil(graph, i, vis)) {
                    return false;
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
