package Stack.questions;

import java.util.Stack;

public class ValidParenthesis {
    static Stack<Character> st = new Stack<>();

    public static char getOpenBrace(char p) {
        if (p == ')') {
            return '(';
        }
        if (p == '}') {
            return '{';
        }

        return '[';

    }

    public static char getCloseBrace(char p) {
        if (p == '(') {
            return ')';
        }
        if (p == '{') {
            return '}';
        }

        return ']';

    }

    public static boolean isValid(String str) {
        int n = str.length();
        String openBraces = "([{";
        for (int i = 0; i < n; i++) {
            char currBrace = str.charAt(i);
            // stack is empty and first brace is closing brace
            if (st.isEmpty() && openBraces.indexOf(currBrace) == -1) {
                return false;
            }
            if (openBraces.indexOf(currBrace) != -1) {
                st.push(currBrace);
            } else if (!st.isEmpty()) {
                char openBrace = getOpenBrace(currBrace);
                if (openBrace != st.peek()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "((({}[])))";
        if (isValid(str)) {
            System.out.println("Valid parenthesis");
        } else {
            System.out.println("Inavalid parenthesis");
        }
    }
}
