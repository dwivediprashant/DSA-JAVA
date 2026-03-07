package Stack.questions;

import java.util.Stack;

public class StockSpan {
    public static void calcSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < stocks.length; i++) {
            while (!s.isEmpty() && stocks[i] >= stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }

    }

    public static void main(String[] args) {
        int[] stocks = { 100, 80, 60, 70, 60, 75, 85 };
        int[] span = new int[stocks.length];
        calcSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + "   ");
        }
    }
}
