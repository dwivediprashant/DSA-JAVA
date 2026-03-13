package Stack;

public class StackImp {

    public static class Stack {
        private int top;
        private int maxSize;
        private int[] st;

        // constructor initialize stack
        public Stack(int size) {
            maxSize = size;
            this.top = -1;
            st = new int[maxSize];
        }

        // methods

        // push :
        void push(int data) {
            // empty case
            if (top == -1) {
                st[++top] = data;
                return;
            }
            // overflow case
            if (top == maxSize - 1) {
                System.out.println("-----------Overflow condition---------------");
                return;
            }
            // other case

            st[++top] = data;
        }

        // peek

        int peek() {
            if (top == -1) {
                System.out.println("---------------Empty stack by peek fxn-------------------");
                return Integer.MIN_VALUE;
            }
            return st[top];
        }
        // print stack

        void print() {
            if (top == -1) {
                System.out.println("--------------Empty stack by print fxn ---------------");
            }
            while (top != -1) {
                System.out.println(st[top]);
                top--;
            }
        }

        // pop
        int pop() {
            // empty stack
            if (top == -1) {
                System.out.println("-------------------------Underflow condition---------------------");
                return Integer.MIN_VALUE;
            }

            int val = st[top];
            top--;
            return val;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        // int val = st.pop();
        // st.print();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();// underflow hit
        // System.out.println("popped ele : " + val);
        // st.push(60);// overflow hit
        // System.out.println(st.peek());
        st.print();// print should be at last bcz it modifies the top variable
    }
}
