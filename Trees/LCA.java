package Trees;

import java.util.ArrayList;

import Trees.LCA.BinaryTree.Node;

public class LCA {

    public static class BinaryTree {

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

    }

    public static boolean getPath(Node head, int n, ArrayList<Node> path) {

        if (head == null) {
            return false;
        }

        path.add(head);

        if (head.data == n) {
            return true;
        }

        boolean isInLeft = getPath(head.left, n, path);

        boolean isInRight = getPath(head.right, n, path);

        if (!isInLeft && !isInRight) {
            path.remove(path.size() - 1);
            return false;
        }

        return true;
    }

    public static int getLowestAncestor(ArrayList<Node> pathN1, ArrayList<Node> pathN2) {
        int i = 0;
        for (; i < pathN1.size() && i < pathN2.size(); i++) {
            if (pathN1.get(i).data != pathN2.get(i).data) {
                return pathN1.get(i - 1).data;
            }
        }
        return pathN1.size() < pathN2.size() ? pathN1.get(i - 1).data : pathN2.get(i - 1).data;
    }

    public static int getLowestCommonAncestor(Node head, int n1, int n2) {

        ArrayList<Node> pathN1 = new ArrayList<>();
        ArrayList<Node> pathN2 = new ArrayList<>();

        // traverse to each node and ask is it's data is n1 or n2
        getPath(head, n1, pathN1);
        getPath(head, n2, pathN2);

        // debug loops
        // for (int i = 0; i < pathN1.size(); i++) {
        // System.out.println(pathN1.get(i).data + " ");
        // }
        // System.out.println("--------------------");

        // for (int i = 0; i < pathN2.size(); i++) {
        // System.out.println(pathN2.get(i).data + " ");
        // }

        // from both paths see lowest ancestor
        return getLowestAncestor(pathN1, pathN2);

    }

    public static void main(String[] args) {
        // BinaryTree bt = new BinaryTree();
        Node head = new Node(1);

        head.left = new Node(2);
        head.right = new Node(3);

        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        head.left.right.left = new Node(10);
        head.left.right.right = new Node(11);
        head.right.left.left = new Node(12);
        head.right.left.right = new Node(13);
        head.right.right.left = new Node(14);
        head.right.right.right = new Node(15);

        System.out.println("Lowest commom ancestor : " + getLowestCommonAncestor(head, 5, 6));

    }
}
