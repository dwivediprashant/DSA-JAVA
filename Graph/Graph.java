package Graph;

import java.util.*;

import Graph.Graph.Edge;

public class Graph {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int src) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];// to prevent cycle

        int srcVertex = src;
        q.add(srcVertex);

        while (!q.isEmpty()) {

            int frontVertex = q.remove();
            if (!visited[frontVertex]) {
                // print vertex
                System.out.println(frontVertex);
                visited[frontVertex] = true;
                // add neighbours
                for (int i = 0; i < graph[frontVertex].size(); i++) {
                    q.add(graph[frontVertex].get(i).dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int src) {
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[graph.length];

        int srcVertex = src;
        s.push(srcVertex);

        while (!s.isEmpty()) {
            int top = s.pop();

            if (!visited[top]) {
                System.out.println(top);
                visited[top] = true;
                for (int i = 0; i < graph[top].size(); i++) {
                    int neighbor = graph[top].get(i).dest;
                    s.push(neighbor);
                }
            }
        }
    }

    public static void dfsRecursion(ArrayList<Edge>[] graph, int src, boolean[] visited) {

        System.out.println(src);
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            int neighbor = graph[src].get(i).dest;
            if (!visited[neighbor]) {
                dfsRecursion(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;// total vertex in graph

        // total edges
        Edge e01 = new Edge(0, 1, 2);
        Edge e02 = new Edge(0, 2, 6);
        Edge e12 = new Edge(1, 2, 3);
        Edge e13 = new Edge(1, 3, -2);
        Edge e10 = new Edge(1, 0, 2);
        Edge e20 = new Edge(2, 0, 6);
        Edge e21 = new Edge(2, 1, 3);
        Edge e23 = new Edge(2, 3, 6);
        Edge e31 = new Edge(3, 1, -2);
        Edge e32 = new Edge(3, 2, 6);
        Edge e34 = new Edge(3, 4, 6);
        Edge e43 = new Edge(4, 3, 6);

        // Array of arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];
        // null to empty
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // vertex 0
        graph[0].add(e01);
        graph[0].add(e02);
        // vertex 1
        graph[1].add(e10);
        graph[1].add(e12);
        graph[1].add(e13);
        // vertex 2
        graph[2].add(e20);
        graph[2].add(e21);
        graph[2].add(e23);
        // vertex 3
        graph[3].add(e31);
        graph[3].add(e32);
        graph[3].add(e34);
        // vertex 4
        graph[4].add(e43);

        // print neighbours of given vertex
        int getNeighFor = 3;
        System.out.println("=========Neighbor of " + getNeighFor + "================");
        for (int i = 0; i < graph[getNeighFor].size(); i++) {
            Edge e = graph[getNeighFor].get(i);
            System.out.println(e.dest);
        }

        // BFS traversal
        System.out.println("==============BFS================");
        bfs(graph, 0);// O(V+E)
        // DFS
        System.out.println("============DFS================");
        dfs(graph, 0);
        System.out.println("===========DFS recursion==========");
        dfsRecursion(graph, 0, new boolean[graph.length]);

    }
}
