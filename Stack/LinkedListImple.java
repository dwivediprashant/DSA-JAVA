package Stack;

public class LinkedListImple {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    //Stack
    static class Stack{
        static Node head=null;

        //methods
        boolean isEmpty(){
            if(head==null){
                return true;
            }
            return false;
        }

        int peek(){
            if(head==null){
            System.out.println("Empty stack");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }

        void push(int data){

            Node newNode=new Node(data);
            newNode.next=head;
            head=newNode;
            
        }

        int pop(){
            if(this.isEmpty()){
                System.out.println("Empty stack");
                return Integer.MIN_VALUE;
            }
            int top=head.data;

            head=head.next;
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s=new Stack();
        System.out.println(s.peek());
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        System.out.println();
    }
}
