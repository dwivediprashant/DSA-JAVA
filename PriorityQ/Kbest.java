package PriorityQ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Kbest {
    public static int getKBestProduct(int[] sales, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < sales.length; i++) {
            pq.add(sales[i]);
        }

        int numOfDeletion = sales.length - k;
        while (!pq.isEmpty() && numOfDeletion > 0) {
            pq.remove();
            numOfDeletion--;
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] sales = new int[N];
        for (int i = 0; i < N; i++) {
            sales[i] = sc.nextInt();
        }
        int kBest = getKBestProduct(sales, K);
        System.out.println(kBest);
    }
}
