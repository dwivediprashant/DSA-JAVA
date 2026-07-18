import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stack {
    List<String> stack = new ArrayList<>();
    private int top = -1;

    public void push(String value) {
        top++;
        stack.add(top, value);
    }

    public String pop() {
        if (top == -1) {
            return "-1";
        }
        String rem = stack.remove(top);
        top--;
        return rem;
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String inpExp = sc.nextLine();
        String[] exp = inpExp.split(" ");
        for (int i = 0; i < N; i++) {
            String s = exp[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int val1 = Integer.parseInt(st.pop());
                int val2 = Integer.parseInt(st.pop());
                if (s.equals("+")) {
                    st.push((val2 + val1 + ""));
                }
                if (s.equals("-")) {
                    st.push((val2 - val1 + ""));
                }
                if (s.equals("/")) {
                    st.push((val2 / val1 + ""));
                }
                if (s.equals("*")) {
                    st.push((val2 * val1 + ""));
                }
            } else {
                st.push(s + "");
            }
        }

        int res = Integer.parseInt(st.pop());
        System.out.println(res);

    }
}
