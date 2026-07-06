package citi.karat.Gtrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AMaximumDepthRecursion {
    public static void main(String[] args) {

        /*
                3
               / \
              9   20
                 /  \
                15   7
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AMaximumDepthRecursion solution = new AMaximumDepthRecursion();
        solution.maxDepth(root);
        System.out.println("Maximum Depth: " + solution.maxDepth(root));
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // return is a stopper of recursion call.
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    // Non-recursive Solution 1: DFS using a Stack (Iterative) // TODO: aj - explore this more difficult than recursive method.
    public int maxDepthDFSUsingStack(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        int maxDepth = 0;

        while (!stack.isEmpty()) {

            Pair current = stack.pop();

            TreeNode node = current.node;
            int depth = current.depth;

            maxDepth = Math.max(maxDepth, depth);

            if (node.left != null) {
                stack.push(new Pair(node.left, depth + 1));
            }

            if (node.right != null) {
                stack.push(new Pair(node.right, depth + 1));
            }
        }

        return maxDepth;
    }

    // Non-recursive Solution 2: BFS (Level Order Traversal) // TODO: aj - explore this more difficult than recursive method.
    public int maxDepthBFSLevelOrderTraversal(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            depth++;

            for (int i = 0; i < levelSize; i++) {

                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return depth;
    }
}

//non-public (package-private or default access) top-level class.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Pair {
    TreeNode node;
    int depth;

    Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}


