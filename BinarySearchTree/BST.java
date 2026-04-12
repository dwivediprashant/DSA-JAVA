package BinarySearchTree;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;

    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + "  ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] values = { 6, 5, 8, 9, 12, 10, 17 };

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorderTraversal(root);
    }
}
