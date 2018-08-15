package com.javaclasses.ballot;

public class BST {

    private class Node {
        /**
         * id of the node.
         */
        private int value;

        public void setVotes(int votes) {
            this.votes = votes;
        }

        public int getVotes() {
            return votes;
        }

        /**
         * count of votes for the id.
         */
        private int votes;
        private Node left;
        private Node right;

        private Node(int value, int votes) {
            this.value = value;
            this.votes = votes;
        }
    }

    private Node root;

    /**
     * @param value id of the node.
     * @return node with searched id.
     */
    public Node search(int value) {
        return searchWrapper(root, value);
    }

    private Node searchWrapper(Node node, int value) {
        if (node == null || node.value == value)
            return node;
        if (value < node.value)
            return searchWrapper(node.left, value);
        return searchWrapper(node.right, value);
    }

    /**
     * @param node current node.
     * @return count of votes for current node.
     */
    public int getValue(Node node) {
        int i = node.getVotes();
        return i;
    }

    public void inorder() {
        inorderWrapper(root);
    }

    private void inorderWrapper(Node root) {
        if (root != null) {
            inorderWrapper(root.left);
            System.out.print(root.value + ", ");
            inorderWrapper(root.right);
        }
    }

    public void preorder() {
        preorderWrapper(root);
    }

    private void preorderWrapper(Node root) {
        if (root != null) {
            System.out.print(root.value + ", ");
            preorderWrapper(root.left);
            preorderWrapper(root.right);
        }
    }

    public void postorder() {
        postorderWrapper(root);
    }

    private void postorderWrapper(Node root) {
        if (root != null) {
            postorderWrapper(root.left);
            postorderWrapper(root.right);
            System.out.print(root.value + ":" + root.votes + ", ");
        }
    }

    /**
     * Method for incrementing count of votes for the id.
     * @param node current node.
     */
    public void increment(Node node) {
        node.setVotes(node.getVotes() + 1);
    }

    /**
     * Method for inserting a new candidate.
     * @param value id of the candidate.
     * @param voted count of votes.
     */
    public void insert(int value, int voted) {
        root = insertWrapper(root, value, voted);
    }

    private Node insertWrapper(Node node, int value, int voted) {
        if (node == null)
            return new Node(value, voted);

        Node newSubtree;
        if (value < node.value) {
            newSubtree = insertWrapper(node.left, value, voted);
            node.left = newSubtree;
            return node;
        } else if (value > node.value) {
            newSubtree = insertWrapper(node.right, value, voted);
            node.right = newSubtree;
            return node;
        } else
            throw new TreeException("Duplicate record!");
    }

    /**
     * Method for deleting the node.
     *
     * Four cases to consider
     * 1. The node is a leaf.
     * 2. The node has no left child.
     * 3. The node has no right child.
     * 4. The node has two children.
     */
    private Node deleteNode(Node node) {
        if (node.left == null && node.right == null) // test for leaf
            return null;
        else if (node.left == null)
            return node.right;
        else if (node.right == null)
            return node.left;
        else { //there are 2 children
            int replacementValue = findRightmost(node.left);
            node.value = replacementValue;
            node.left = deleteRightmost(node.left);
            return node;
        }
    }

    private int findRightmost(Node node) {
        if (node.right == null)
            return node.value;
        return findRightmost(node.right);
    }

    private Node deleteRightmost(Node node) {
        if (node.right == null)
            return node.left;
        node.right = deleteRightmost(node.right);
        return node;
    }
}