import java.util.Stack;

public class BracketBalanceCost {
    public static int getMinCost(String braces, int costOfOpenBrace, int costOfCloseBrace) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < braces.length(); i++) {
            if (st.isEmpty()) {
                st.push(braces.charAt(i));
            } else {
                if (braces.charAt(i) == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(braces.charAt(i));
                }
            }
        }
        int minCost = 0;
        while (!st.isEmpty()) {
            char curr = st.pop();
            if (curr == '(') {
                minCost += costOfOpenBrace;
            } else {
                minCost += costOfCloseBrace;
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        String braces = "()))((";
        int costOfOpenBrace = 1;
        int costOfCloseBrace = 1;

        // time : O(n) space: O(n) ; n is string length
        System.out.println(getMinCost(braces, costOfOpenBrace, costOfCloseBrace));
    }
}
