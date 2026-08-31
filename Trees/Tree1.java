import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Tree1 {
    static int idx = -1;

    public static TreeNode buildTree1(int[] preOrder) {

        ++idx;

        if (preOrder[idx] == -1) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[idx]);
        node.left = buildTree1(preOrder);
        node.right = buildTree1(preOrder);

        return node;
    }

    public static TreeNode buildTree2(int[] levelOrder) {

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        for (int i = 1; i < levelOrder.length;) {
            TreeNode curr = q.remove();

            if (i < levelOrder.length && levelOrder[i] != -1) {
                curr.left = new TreeNode(levelOrder[i]);
                q.add(curr.left);
            }
            i++;
            if (i < levelOrder.length && levelOrder[i] != -1) {
                curr.right = new TreeNode(levelOrder[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // int[] preOrder = new int[n];
        // for (int i = 0; i < n; i++) {
        // preOrder[i] = sc.nextInt();
        // }

        // TreeNode root = buildTree1(preOrder);
        // System.out.println(root.val);

        int[] levelOrder = new int[n];

        for (int i = 0; i < n; i++) {
            levelOrder[i] = sc.nextInt();
        }

        TreeNode root = buildTree2(levelOrder);
        // System.out.println(root.val);
        System.out.println("pre");
        preOrderTraversal(root);
        System.out.println("post");
        postOrderTraversal(root);
        System.out.println("in");
        inorderTraversal(root);

    }
}
