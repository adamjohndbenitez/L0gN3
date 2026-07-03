package citi.karat.Equeue;

class Node {

    //Variables
    private int data;
    private Node leftChild;
    private Node rightChild;

    //Constructor
    Node(int value) {
        this.data = value;
        leftChild = null;
        rightChild = null;
    }

    //Getter-Setter
    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int value) {
        this.data = value;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }
}

class InsertionInBinarySearchTree {
    private Node root;

    // Iterative Function to insert a value in BST
    boolean insertBSTIterative(int value) {
        // If Tree is empty then insert Root with the given value inside Tree
        if (root == null) {
            root = new Node(value);
        }

        // Starting from root
        Node currentNode = root;

        // Traversing the tree untill valid position to insert the value
        while (currentNode != null) {

            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            // If the value to insert is less than root value then move to left subtree
            if (currentNode.getData() > value) {
                // remember, before moving check if the subtree is null, if it's then insert the value.
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            }
            // else move to right subtree of root
            else {
                // remember, before moving check if the subtree is null, if it's then insert the value.
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            }
        }
        return false;
    }

    // Recursive function to insert a value in BST
    // Both iterative and recursive insertion in a BST have a time complexity of O(h), where h is the height of the tree. In the worst case (skewed tree), this is O(n), and in a balanced tree, it’s O(log n). The iterative approach uses O(1) space, while the recursive approach uses O(h) space due to the call stack. Iterative insertion is generally faster and more space-efficient because it avoids the overhead of recursive calls.
    private Node insertBSTRecursive(Node currentNode, int value) {

        //Base Case
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.getData()) {
            //Iterate left sub-tree
            currentNode.setLeftChild(insertBSTRecursive(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            //Iterate right sub-tree
            currentNode.setRightChild(insertBSTRecursive(currentNode.getRightChild(), value));
        } else {
            // value already exists
            return currentNode;
        }

        return currentNode;

    }

    //Function to call recursive insert
    public boolean add(int value) {

        root = insertBSTRecursive(this.root, value);
        return true;
    }


    /**
     * Search:
     * https://www.educative.io/courses/lta/data-structures-coding-interviews-java/search-in-binary-search-trees-implementation
     *
     * ..Skipped for now...
     */


    /**
     * Deletion:
     * https://www.educative.io/courses/lta/data-structures-coding-interviews-java/deletion-in-binary-search-trees-implementation
     *
     * ..Skipped for now...
     */

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

public class ABinaryTreeLevelOrderTraversal {

    public static void preTraverse(Node root) {

        if (root == null) return;

        System.out.print(root.getData() + ",");
        preTraverse(root.getLeftChild());
        preTraverse(root.getRightChild());

    }

    public static void inTraverse(Node root) {

        if (root == null) return;

        inTraverse(root.getLeftChild());
        System.out.print(root.getData() + ",");
        inTraverse(root.getRightChild());

    }

    public static void postTraverse(Node root) {

        if (root == null) return;

        postTraverse(root.getLeftChild());
        postTraverse(root.getRightChild());
        System.out.print(root.getData() + ",");

    }


    public static void main(String[] args) {

        ABinaryTreeLevelOrderTraversal BST = new ABinaryTreeLevelOrderTraversal();

        InsertionInBinarySearchTree InsertionBTS = new InsertionInBinarySearchTree();
        InsertionBTS.insertBSTIterative(6); //.add(6);
        InsertionBTS.insertBSTIterative(4); //.add(4);
        InsertionBTS.insertBSTIterative(2); //.add(2);
        InsertionBTS.insertBSTIterative(5); //.add(5);
        InsertionBTS.insertBSTIterative(9); //.add(9);
        InsertionBTS.insertBSTIterative(8); //.add(8);
        InsertionBTS.insertBSTIterative(12); //.add(12);
//            BST.add(6);
//            BST.add(4);
//            BST.add(2);
//            BST.add(5);
//            BST.add(9);
//            BST.add(8);
//            BST.add(12);

        preTraverse(InsertionBTS.getRoot());
        System.out.println('\n' + new String(new char[100]).replace('\0', '-'));
        inTraverse(InsertionBTS.getRoot());
        System.out.println('\n' + new String(new char[100]).replace('\0', '-'));
        postTraverse(InsertionBTS.getRoot());

    }

}

class ABinaryTreeLevelOrderTraversalAJKarat {

    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        ABinaryTreeLevelOrderTraversalAJKarat solution = new ABinaryTreeLevelOrderTraversalAJKarat();
        solution.insertionBTSIterative(6);
        solution.insertionBTSIterative(4);
        solution.insertionBTSIterative(2);
        solution.insertionBTSIterative(5);
        solution.insertionBTSIterative(9);
        solution.insertionBTSIterative(8);
        solution.insertionBTSIterative(12);

        solution.preOrderTraversal(solution.getRoot());
        System.out.println('\n' + new String(new char[100]).replace('\0', '-'));
        solution.inOrderTraversal(solution.getRoot());
        System.out.println('\n' + new String(new char[100]).replace('\0', '-'));
        solution.postOrderTraversal(solution.getRoot());
    }

    private Node root;
    public Node getRoot() {return this.root;}
    public void setRoot(Node root) {this.root = root;}
    private boolean insertionBTSIterative(int value) {

        if (root == null) {
            root = new Node(value);
        }
        Node currentNode = root;
        while(currentNode != null) {
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();
            if (currentNode.getData() > value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            }
        }
        return false;
    }

    public void preOrderTraversal(Node root) {
        if (root == null) {
            return; //recursive killer
        }
        System.out.print(root.getData() + ",");
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return; //recursive killer
        }
        preOrderTraversal(root.getLeftChild());
        System.out.print(root.getData() + ",");
        preOrderTraversal(root.getRightChild());
    }

    public void postOrderTraversal(Node root) {
        if (root == null) {
            return; //recursive killer
        }
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
        System.out.print(root.getData() + ",");
    }
}
