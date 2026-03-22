package Stack.questions;

import java.util.Stack;

public class Q3 {

    public static Stack<Integer> reverseStack(Stack<Integer> s) {
        Stack<Integer> revS = new Stack<>();

        while (!s.isEmpty()) {
            int top = s.peek();
            revS.push(top);
            s.pop();
        }
        return revS;
    }

    public static void printStack(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
        // System.out.println("print completed");
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);

        // original stack
        // printStack(s);
        // reverse stack fxn
        Stack<Integer> revS = reverseStack(s);
        printStack(revS);
    }
}
