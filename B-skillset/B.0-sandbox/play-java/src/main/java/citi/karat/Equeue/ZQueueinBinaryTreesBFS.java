package citi.karat.Equeue;

import java.util.LinkedList;
import java.util.Queue;

public class ZQueueinBinaryTreesBFS {
    public static void bfs(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // Start with the root node
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Remove the first node
            TreeNode current = queue.poll();

            // Visit the node
            System.out.println(current.val);

            // Add the left child
            if (current.left != null) {
                queue.offer(current.left);
            }

            // Add the right child
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {

        /*
                3
              /   \
             9     20
                  /  \
                 15   7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        bfs(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}