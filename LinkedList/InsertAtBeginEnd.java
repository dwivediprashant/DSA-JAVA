package LinkedList;

import LinkedList.InsertAtBeginEnd.LinkedList.Node;

public class InsertAtBeginEnd {
    public static class LinkedList {
        Node head;
        // int maxSize;

        // LinkedList(int size) {
        // maxSize = size;
        // head = null;
        // }

        public class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        void insertAtBegin(int data) {
            Node node = new Node(data);

            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        void insertAtLast(int data) {
            Node node = new Node(data);

            Node temp = head;
            if (head == null) {
                head = node;
            } else {

                while (temp.next != null) {
                    temp = temp.next;
                }

                temp.next = node;

            }
        }

        void printLL() {
            Node temp = head;
            if (temp == null) {
                System.err.println("empty linked list");
                return;
            }
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null");
        }

        int removeFromBegin() {
            // empty case

            if (head == null) {
                System.out.println("Empty linkedlist");
            } else {
                int removedval = head.data;
                head = head.next;
                return removedval;
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtBegin(10);
        ll.insertAtBegin(20);
        ll.insertAtBegin(30);
        ll.insertAtLast(40);
        ll.printLL();
        ll.removeFromBegin();
        ll.removeFromBegin();
        ll.removeFromBegin();
        ll.removeFromBegin();
        // ll.removeFromBegin();
        System.out.println();
        ll.printLL();
    }
}
