package Stack.questions;
import java.util.Stack;
// que:  Push at bottom of the stack
public class q1 {

    public static void pushAtBottom(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int popped=s.pop();
        pushAtBottom(data, s);
        s.push(popped);
    }
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        pushAtBottom(50, s);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
