package Trees;

public class SumTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int getSumTree(Node head) {
        if (head == null) {
            return 0;
        }

        int leftSum = getSumTree(head.left);
        int rightSum = getSumTree(head.right);

        int preserveHead = head.data;
        head.data = leftSum + rightSum;

        return leftSum + rightSum + preserveHead;

    }

    public static void printTreePreOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printTreePreOrder(head.left);
        printTreePreOrder(head.right);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        getSumTree(head);// Sum tree call
        printTreePreOrder(head);

    }
}
