package Stack;

import java.util.Stack;;

public class DuplicateParentheses {

    public static boolean hasDuplicate(String exp) {
        int n = exp.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char currSymbol = exp.charAt(i);
            // case : a-z operands
            if (currSymbol <= 'z' && currSymbol >= 'a') {
                continue;
            }
            // case of closing braces
            if (currSymbol == ')') {
                if (st.peek() == '(') {
                    return true;// duplicate found case
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop(); // one more time to remove open parentheses
                }
            } else {

                st.push(currSymbol);
            }
        }

        return false;// no duplicate parentheses

    }

    public static void main(String[] args) {
        String exp = "(((a+b))+c)";

        if (hasDuplicate(exp)) {
            System.out.println(exp + " has duplicate parentheses.");
        } else {
            System.out.println(exp + " has no duplicate parentheses");
        }
    }
}
