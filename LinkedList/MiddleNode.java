import java.util.Scanner;

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    void insertAtLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void printMidNode(Node head) {
        if (head == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        fast = fast.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        System.out.println(slow.val);

    }
}

public class MiddleNode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList ll = new LinkedList();
        for (int i = 1; i <= n; i++) {
            int val = sc.nextInt();
            ll.insertAtLast(val);
        }
        ll.printMidNode(ll.head);
    }
}
