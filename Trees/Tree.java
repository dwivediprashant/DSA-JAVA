package Trees;

import java.util.LinkedList;
import java.util.Queue;

//binary tree from preorder
public class Tree {

    // node
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

    static class BinaryTree {
        static int idx = -1;
        static int height = 0;

        Node buildTree(int[] preorder) {
            ++idx;
            if (preorder[idx] == -1) {
                return null;
            }

            Node newNode = new Node(preorder[idx]);
            newNode.left = buildTree(preorder);
            newNode.right = buildTree(preorder);

            return newNode;
        }

        // preorder: node->left->right
        void preorderTraverse(Node node) {
            if (node == null) {
                // System.out.print("-1 ");
                return;
            }
            System.out.print(node.data + " ");
            preorderTraverse(node.left);
            preorderTraverse(node.right);
        }

        // postorder: left->right->node
        void postorderTraverse(Node node) {
            if (node == null) {
                // System.out.print("-1 ");
                return;
            }

            postorderTraverse(node.left);
            postorderTraverse(node.right);
            System.out.print(node.data + " ");
        }

        // inorder : left->node->right
        void inorderTraverse(Node node) {
            if (node == null) {
                return;
            }

            inorderTraverse(node.left);
            System.out.print(node.data + " ");
            inorderTraverse(node.right);
        }

        // level order traversal : BFS (Breadth first search)

        void levelorderTraverse(Node node) {
            // empty
            if (node == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            // initial root node(start)
            q.add(node);
            q.add(null);// for next line
            ++height;// root node counted
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (!q.isEmpty()) {
                        q.add(null);
                        ++height;
                    } else {
                        break;// q become empty
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
            System.out.println("height of tree is : " + height);
        }

        // calculate height
        int getHeight(Node root) {

            if (root == null) {
                return 0;
            }

            int leftH = getHeight(root.left);
            int rightH = getHeight(root.right);

            return 1 + Math.max(leftH, rightH);
        }

        // count no of node
        int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

        // sum of nodes values

        int nodeSum(Node root) {
            if (root == null) {
                return 0;
            }
            return root.data + nodeSum(root.left) + nodeSum(root.right);
        }

        // diameter of tree

        int getDiameter(Node root) {
            if (root == null) {
                return 0;
            }

            // subtree diameter
            int ld = getDiameter(root.left);
            int lh = getHeight(root.left);
            int rd = getDiameter(root.right);
            int rh = getHeight(root.right);

            int selfDiam = lh + rh + 1;

            int maxD = Math.max(ld, rd);

            return Math.max(selfDiam, maxD);
        }

    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };// -1 => null
        BinaryTree bt = new BinaryTree();
        Node node = bt.buildTree(preorder);

        bt.preorderTraverse(node);
        System.out.println();
        bt.postorderTraverse(node);
        System.out.println();
        bt.inorderTraverse(node);
        System.out.println();
        bt.levelorderTraverse(node);

        System.out.println("Height by getHeight method : " + bt.getHeight(node));
        System.out.println("number of nodes in tree : " + bt.countNodes(node));
        System.out.println("Sum of nodes val in tree is : " + bt.nodeSum(node));
        System.out.println("Diameter of tree : " + bt.getDiameter(node));
    }
}
