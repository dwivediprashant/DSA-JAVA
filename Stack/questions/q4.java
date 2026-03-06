package Stack.questions;
import java.util.Stack;
//in constant space
//*
// top se pop -> push at bottom -> repeat  


public class q4 {

    public static void pushTopAtBottom(Stack<Integer> s,int top){
        if(s.isEmpty()){
            s.push(top);
            return;
        }
        int popped=s.pop();
        pushTopAtBottom(s, top);
        s.push(popped);
    }
    public static void reverseStack(Stack<Integer> s){
       if(s.isEmpty()) {
        return;
       }
        int top=s.pop();
        reverseStack(s);
        pushTopAtBottom(s,top);

    }
    public static void  printStack(Stack <Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        // s.push(50);
        // s.push(60);
    
        reverseStack(s);
        printStack(s);
    }
}
