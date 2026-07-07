import java.util.ArrayDeque;
import java.util.Queue;

public class Province {

    static class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean isVisited[] = new boolean[n];
            int province = 0;
            for (int i = 0; i < n; i++) {
                if (!isVisited[i]) {
                    bfs(i, isConnected, isVisited);
                    province++;
                }
            }
            return province;
        }

        public void bfs(int curr, int[][] isConnected, boolean isVisited[]) {
            int n = isConnected.length;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(curr);
            isVisited[curr] = true;

            while (!q.isEmpty()) {
                int removed = q.remove();
                for (int j = 0; j < n; j++) {

                    if (removed == j)
                        continue;

                    if (1 == isConnected[removed][j]) {
                        int neighbor = j;
                        if (!isVisited[neighbor]) {
                            isVisited[neighbor] = true;
                            q.add(neighbor);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected1 = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println("Test Case 1 Output: " + solution.findCircleNum(isConnected1));// 2

        int[][] isConnected2 = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println("Test Case 2 Output: " + solution.findCircleNum(isConnected2));// 3

    }
}