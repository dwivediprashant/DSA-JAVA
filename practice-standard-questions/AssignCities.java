import java.util.*;

public class AssignCities {

    public static int getMinCost(int N, int[] A, int[] B, int currIdx, String empA, String empB) {
        if (empA.length() == N) {
            int costB = 0;
            for (int i = 0; i < empA.length(); i++) {
                int idx = empA.charAt(i) - '0';
                int idx2 = 2 * N - idx - 1;
                int min = Math.min(A[idx2], B[idx2]);
                costB += min + B[idx2];
            }
            return costB;
        }
        if (empB.length() == N) {
            int costA = 0;
            for (int i = 0; i < empB.length(); i++) {
                int idx = empB.charAt(i) - '0';
                int idx2 = 2 * N - idx - 1;
                costA += A[idx2];
            }
            return costA;
        }
        int c1 = A[currIdx] + getMinCost(N, A, B, currIdx + 1, empA + currIdx, empB);
        int min = Math.min(A[currIdx], B[currIdx]);
        int c2 = min + B[currIdx] + getMinCost(N, A, B, currIdx + 1, empA, empB + currIdx);

        return Math.min(c1, c2);
    }

    public static int getMinCost2(int N, int[] aCost, int[] bCost) {
        int[][] diffCost = new int[2 * N][2];// diff:idx

        for (int i = 0; i < 2 * N; i++) {
            diffCost[i][0] = bCost[i] - aCost[i];
            diffCost[i][1] = i;
        }

        Arrays.sort(diffCost, (a, b) -> {
            return a[0] - b[0];
        });
        int cost = 0;
        // B city employees
        for (int i = 0; i < N; i++) {
            int idx = diffCost[i][1];
            cost += bCost[i];
        }
        // A city employees
        for (int i = N; i < 2 * N; i++) {
            int idx = diffCost[i][1];
            cost += aCost[i];
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[2 * N];
        int[] B = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            int x = sc.nextInt();
            A[i] = x;
        }
        for (int i = 0; i < 2 * N; i++) {
            int x = sc.nextInt();
            B[i] = x;
        }
        System.out.println("recursion : -");
        System.out.println(getMinCost(N, A, B, 0, "", ""));
        System.out.println("Greedy : -");
        int[] bCost = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            int min = Math.min(A[i], B[i]);
            bCost[i] = min + B[i];
        }
        System.out.println(getMinCost2(N, A, bCost));
    }
}
