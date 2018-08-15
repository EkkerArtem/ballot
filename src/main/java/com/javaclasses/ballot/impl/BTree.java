package com.javaclasses.ballot.impl;

public class BTree {
    private class Node {
        private Node left, right;
        /**
         * Stores count of votes for candidate id.
         */
        private int votes;
        /**
         * Stores the id of candidate.
         */
        private int id;
        private int height = 0;
        private int size = 1;

        void setVotes(int votes) {
            this.votes = votes;
        }

        int getVotes() {
            return votes;
        }

        Node(int id, int votes) {
            this.id = id;
            this.votes = votes;
        }
    }

    private Node root;

    /**
     * Method for incrementing the count of votes for candidate, that is stored in node.
     *
     * @param node node of the binary tree.
     */
    void increment(Node node) {
        node.setVotes(node.getVotes() + 1);
    }

    /**
     * Method for getting the count of votes for candidate, that is stored in node.
     *
     * @param node node of the binary tree.
     * @return amount of votes for candidate.
     */
    int getVotes(Node node) {
        return node.getVotes();
    }

    /**
     * Method for getting node from its id.
     *
     * @param id id of the node of the binary tree.
     * @return node searched by id.
     */
    Node search(int id) {
        return searchWrapper(root, id);
    }

    /**
     * Inner method for getting node from its id.
     *
     * @param node node of the binary tree.
     * @param id   id of the node of the binary tree.
     * @return node searched by id.
     */
    private Node searchWrapper(Node node, int id) {
        if (node == null || node.id == id)
            return node;
        if (id < node.id)
            return searchWrapper(node.left, id);
        return searchWrapper(node.right, id);
    }

    /**
     * Method for getting size of the node.
     *
     * @return size of the node.
     */
    private int size() {
        return size(root);
    }

    /**
     * Inner method for getting size of the node.
     *
     * @param node node of the binary tree.
     * @return size of the node.
     */
    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    /**
     * Method for getting height of the node.
     *
     * @param node node of the binary tree.
     * @return height of the node.
     */
    private int height(Node node) {
        Node left = node.left;
        Node right = node.right;

        if (left == null && right == null)
            return 0;
        else if (left == null)
            return 1 + right.height;
        else if (right == null)
            return 1 + left.height;
        else
            return 1 + Math.max(left.height, right.height);
    }

    /**
     * Method for inserting new candidate;
     *
     * @param id            id of the candidate.
     * @param amountOfVotes amount of votes of the candidate.
     */
    void insert(int id, int amountOfVotes) {
        this.root = insert(root, id, amountOfVotes);
    }

    /**
     * Inner method for inserting new candidate;
     *
     * @param node          node of the binary tree.
     * @param id            id of the candidate.
     * @param amountOfVotes amount of votes of the candidate.
     * @return new node.
     */
    private Node insert(Node node, int id, int amountOfVotes) {
        if (node == null) {
            return new Node(id, amountOfVotes);
        }

        if (node.id > id) {
            node.left = insert(node.left, id, amountOfVotes);
        } else if (node.id < id) {
            node.right = insert(node.right, id, amountOfVotes);
        } else {
            node.id = id;
        }

        node.height = height(node);
        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    /**
     * Method for getting the id of the node by its position.
     *
     * @param position position of the node.
     * @return node's id.
     */
    private int valueAtPosition(int position) {
        if (position < 0 || position > size() - 1) {
            throw new IllegalArgumentException("Position lies in the wrong range.");
        }
        return valueAtPosition(root, position).id;
    }

    /**
     * Inner method for getting the id of the node by its position.
     *
     * @param node     node of the binary tree.
     * @param position position of the node.
     * @return node searched.
     */
    private Node valueAtPosition(Node node, int position) {
        if (node == null) return null;

        int leftSize = size(node.left);
        if (leftSize > position) {
            return valueAtPosition(node.left, position);
        } else if (leftSize < position) {
            // Ignore left sub-tree of the root
            return valueAtPosition(node.right, position - leftSize - 1);
        } else {
            return node;
        }
    }

    /**
     * Method for balancing the binary tree.
     */
    void simpleBalance() {
        BTree balanced = new BTree();
        simpleBalance(balanced, 0, root.size - 1);
        this.root = balanced.root;
    }

    /**
     * Inner method for balancing the binary tree.
     *
     * @param tree  current binary tree.
     * @param left  last one on the left.
     * @param right last one on the right.
     */
    private void simpleBalance(BTree tree, int left, int right) {
        int median = Math.round((right + left) / 2);

        tree.insert(valueAtPosition(median), this.search(valueAtPosition(median)).getVotes());

        if (left <= (median - 1)) simpleBalance(tree, left, median - 1);
        if ((median + 1) <= right) simpleBalance(tree, median + 1, right);
    }

}
