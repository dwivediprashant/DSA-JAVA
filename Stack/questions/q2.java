package Stack.questions;

import java.util.Stack;

//que : reverse string using stack
public class Q2 {

    static void reverse(String str, Stack<Character> s, int idx, StringBuilder rev) {
        if (idx == str.length()) {
            return;
        }
        char currChar = str.charAt(idx);
        s.push(currChar);
        reverse(str, s, idx + 1, rev);

        rev.append(currChar);

    }

    public static void main(String[] args) {
        String str = "prashant";
        Stack<Character> s = new Stack<>();
        StringBuilder rev = new StringBuilder("");
        reverse(str, s, 0, rev);

        System.out.println(rev);
    }
}
