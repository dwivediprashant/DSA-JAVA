package LinkedList;
public class LinkedList{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public Node head;

    //Methods
    //Insert at begin
    void addAtBegin(int data){
        Node node=new Node(data);
        //empty linkedlist case
        if(head==null){
            head=node;
        }else {//single+multiple node case node
            node.next=head;
            head=node;
        }
    }
    //add at last
    void addAtLast(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
        }else{
            Node temp=head;
            //traverse to the last node
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
    }
    //Print linked list
    void printLinkedList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addAtBegin(10);
        ll.addAtBegin(20);
        ll.addAtBegin(30);
        ll.addAtLast(40);
        ll.addAtLast(40);
        ll.printLinkedList();
    }
}