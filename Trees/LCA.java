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

    public static Node getLCA(Node head, int n1, int n2) {

        if (head == null || head.data == n1 || head.data == n2) {
            return head;
        }

        Node leftLca = getLCA(head.left, n1, n2);
        Node rightLca = getLCA(head.right, n1, n2);

        if (leftLca == null) {
            return rightLca;
        } else if (rightLca == null) {
            return leftLca;
        }

        return head;

    }

    public static int getDistfromLca(Node lca, int n, int dist) {
        if (lca == null) {
            return 0;// indicates node not exists
        }
        if (lca.data == n) {
            return dist;
        }
        return getDistfromLca(lca.left, n, dist + 1) + getDistfromLca(lca.right, n, dist + 1);

    }

    public static int getMinDist(Node head, int n1, int n2) {
        Node lca = getLCA(head, n1, n2);

        int n1Dist = getDistfromLca(lca, n1, 0);// in terms of edges
        int n2Dist = getDistfromLca(lca, n2, 0);// in terms of edges

        return n1Dist + n2Dist;
    }

    public static boolean getAllAncestor(Node head, int n, ArrayList<Integer> allAncestors) {
        if (head == null) {
            return false;
        }
        if (head.data == n) {
            // allAncestors.add(head.data);
            return true;
        }
        boolean leftRes = getAllAncestor(head.left, n, allAncestors);
        boolean rightRes = getAllAncestor(head.right, n, allAncestors);
        if (leftRes || rightRes) {
            allAncestors.add(head.data);
            return true;
        }
        return false;
    }

    public static int getKthAncestor(Node head, int n, int k) {
        if (k <= 0 || k >= n) {

            return -1;
        }
        ArrayList<Integer> allAncestors = new ArrayList<>();

        getAllAncestor(head, n, allAncestors);

        // System.out.println(allAncestors);

        return allAncestors.get(k - 1);
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

        System.out.println("Approach1 : Lowest commom ancestor : " + getLowestCommonAncestor(head, 11, 9));
        System.out.println("Approach2 : Lowest common ancestor : " + getLCA(head, 9, 11).data);
        int minDist = getMinDist(head, 15, 10);
        if (minDist == 0) {
            System.out.println("Given nodes are invalid or of same values.");
        } else {
            System.out.println("Minimum distance between nodes is  : " + minDist);
        }
        int kAncestor = getKthAncestor(head, 2, 1);
        if (kAncestor == -1) {
            System.out.print("Invalid value of k . It should be greater than 0 and less than n.");
        } else {
            System.out.println("Kth ancestor is : " + kAncestor);
        }
    }
}
