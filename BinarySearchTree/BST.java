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

    public static boolean searchVal(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.data) {
            return true;
        }
        if (key < root.data) {
            return searchVal(root.left, key);
        }
        return searchVal(root.right, key);

    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + "  ");
        inorderTraversal(root.right);
    }

    public static void printRange(Node root, int n1, int n2) {
        if (root == null) {
            return;
        }
        if (root.data <= n2 && root.data >= n1) {
            printRange(root.left, n1, n2);
            System.out.println(root.data);
            printRange(root.right, n1, n2);
        }

        if (root.data < n1) {
            printRange(root.right, n1, n2);
        }

        if (root.data > n2) {
            printRange(root.left, n1, n2);
        }
    }

    public static int getMax(Node root, int max) {
        if (root == null) {
            return max;
        }
        max = (int) Math.max(max, root.data);
        int leftRes = getMax(root.left, max);
        int rightRes = getMax(root.right, max);

        return leftRes > rightRes ? leftRes : rightRes;
    }

    public static int getMin(Node root, int min) {
        if (root == null) {
            return min;
        }
        min = (int) Math.min(min, root.data);
        int leftRes = getMin(root.left, min);
        int rightRes = getMin(root.right, min);

        return leftRes < rightRes ? leftRes : rightRes;
    }

    public static boolean validateBST(Node root) {
        if (root == null) {
            return true;
        }

        int leftMax = getMax(root.left, Integer.MIN_VALUE);
        int rightMin = getMin(root.right, Integer.MAX_VALUE);

        if (leftMax > root.data || rightMin < root.data) {
            return false;
        }

        return validateBST(root.left) && validateBST(root.right);
    }

    public static void main(String[] args) {
        int[] values = { 6, 5, 8, 9, 12, 10, 17 };

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorderTraversal(root);
        System.out.println();
        int key = -10;
        if (searchVal(root, key)) {
            System.out.println(key + " found");
        } else {
            System.out.println(key + " not found");
        }

        // System.out.println(root.data);
        System.out.println("Range");
        printRange(root, 8, 20);

        Node head = new Node(100);
        head.left = new Node(50);
        head.right = new Node(110);
        head.left.left = new Node(30);
        head.left.right = new Node(90);
        head.right.left = new Node(105);
        head.right.right = new Node(150);
        head.left.right.left = new Node(60);
        head.left.right.right = new Node(95);
        head.right.left.right = new Node(107);
        head.right.right.right = new Node(200);
        head.right.right.right.left = new Node(170);

        System.out.println("Is valid bst : " + validateBST(head));

    }
}
