package LinkedList;
public class LinkedList{
    //head pointer
    public Node head;
    public int size;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    //Methods
    //Insert at begin
    void addAtBegin(int data){
        Node node=new Node(data);
        size++;
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
        size++;
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
    //add at given position
    void addAtPosition(int pos,int data){
        if(pos==0){
            addAtBegin(data);
            return;
        }
        if(pos<0){
            System.out.println("Position should be in between 0 to size of linked list .");
            return;
        }
        Node node=new Node(data);
        size++;
        //empty linkedlist
        if(head==null){
            head=node;
        }else{
            //traverse to the given position
            Node temp=head;
            for(int i=0;i<=pos-2;i++){
                temp=temp.next;
                if(temp==null){
                    System.out.println("Position should be in between 0 to size of linked list .");
                    return;
                }
            }
            node.next=temp.next;
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
        ll.addAtPosition(0, 90);
        ll.printLinkedList();
        System.out.println(ll.size);
    }
}