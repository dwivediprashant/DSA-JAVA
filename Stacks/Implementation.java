package Stacks;
import java.util.ArrayList;
import java.util.List;
public class Implementation {
    public static class Stack{
        List<Integer> stk=new ArrayList<>();
        //methods
        //isEmpty()
        boolean isEmpty(){
            if(stk.size()==0){
                return true;
            }
            return false;
        }
        //push 
        void push(int data){
            stk.add(data);
        }
        //pop
        int pop(){
            if(stk.isEmpty()){
                return Integer.MIN_VALUE;
            }
            int topIdx=stk.size()-1;
            int top=stk.get(topIdx);
            stk.remove(topIdx);
            return top;
        }
        //peek
        int peek(){
            if(stk.isEmpty()){
                return Integer.MIN_VALUE;
            }
            int topIdx=stk.size()-1;
            int top=stk.get(topIdx);
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(10);
        s.push(20);
        int deleteData=s.pop();
        int deleteData2=s.pop();
        int x=s.pop();
        System.out.println(x);
        System.out.println(deleteData+ "  "+ deleteData2);
        System.out.println(s.peek());
    }
}
