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
    //Remove begin val from linkedlist
    int removeFromBegin(){
        if(head==null){
            System.out.println("Empty linked list.");
            return Integer.MIN_VALUE;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    // remove from end of linked list
    int removeFromLast(){
        if(head==null){
            System.out.println("Empty linked list.");
            return Integer.MIN_VALUE;
        }
        //if single node
        if(head.next==null){
            int val=head.data;
            head=null;
            size--;
            return val;
        }
        //traverse to the end
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        int val=temp.next.data;
        temp.next=null;
        size--;
        return val;
    }
    // remove from linkedlist at given position
    int removeAtGivenPos(int pos){
        if(head==null){
            System.out.println("Empty linked list");
            return Integer.MIN_VALUE;
        }
        if(pos==0){
            return removeFromBegin();    
        }
        if(pos<0){
            System.out.println("Position should be in between 0 to size of  linked list.");
            return Integer.MIN_VALUE;
        }
        Node temp=head;
        for(int i=0;i<=pos-2;i++){
            temp=temp.next;
            if(temp.next==null){
                System.out.println("Position should be in between 0 to size of  linked list.");
                return Integer.MIN_VALUE;
            }
        }
        int val=temp.next.data;
        temp.next=temp.next.next;
        size--;
        return val;
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
        ll.addAtLast(50);
        ll.addAtPosition(0, 90);
        
        ll.printLinkedList();
        System.out.println(ll.size);
        System.out.println(ll.removeFromBegin());
        
        ll.printLinkedList();
        System.out.println(ll.size);
        System.out.println(ll.removeFromBegin());
        System.out.println(ll.removeFromLast());
        System.out.println(ll.removeFromLast());
        System.out.println(ll.removeFromLast());
        System.out.println(ll.removeFromLast());
        ll.printLinkedList();
        System.out.println(ll.size);
        ll.addAtBegin(11);
        ll.addAtBegin(21);
        ll.addAtBegin(31);
        ll.addAtBegin(41);
        ll.printLinkedList();
        System.out.println(ll.removeAtGivenPos(2));
        ll.printLinkedList();
    }
}