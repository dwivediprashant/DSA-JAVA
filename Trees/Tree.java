package Trees;

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

    }
}
