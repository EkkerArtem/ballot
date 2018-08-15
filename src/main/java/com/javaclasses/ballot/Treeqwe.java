package com.javaclasses.ballot;

import java.util.ArrayList;

public class Treeqwe {
    private class Node {
        Node left, right;

        private int votes;

        private int value;

        public void setVotes(int votes) {
            this.votes = votes;
        }

        public int getVotes() {
            return votes;
        }

        int height = 0;
        int size = 1;

        public Node(int value) {
            this.value = value;
            this.votes = value;
        }
    }

    private Node root;

    public void increment(Node node){
        node.setVotes(node.getVotes()+1);
    }

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

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int height() {
        if (root == null) return -1;
        return height(root);
    }

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

    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean exists(Node node, int checkValue) {
        if (node == null) return false;

        if (node.value > checkValue) {
            return exists(node.left, checkValue);
        } else if (node.value < checkValue) {
            return exists(node.right, checkValue);
        } else {
            return true;
        }
    }

    public boolean exists(int checkValue) {
        return exists(root, checkValue);
    }

    private Node insert(Node node, int insertValue, int value) {
        if (node == null) {
            return new Node(insertValue);
        }

        if (node.value > insertValue) {
            node.left = insert(node.left, insertValue, value);
        } else if (node.value < insertValue) {
            node.right = insert(node.right, insertValue, value);
        } else {
            node.value = insertValue;
        }

        node.height = height(node);
        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    public void insert(int insertValue, int value) {
        this.root = insert(root, insertValue, value);
    }

    public void delete(int delValue) {
        this.root = delete(root, delValue);
    }

    private Node delete(Node node, int delValue) {
        if (node == null) return null;

        if (node.value > delValue) {
            node.left = delete(node.left, delValue);
        } else if (node.value < delValue) {
            node.right = delete(node.right, delValue);
        } else {
            // If left/right child is null, return the opposite
            // If both are null, then obviously the node must be substituted with null, as well
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Save node as it was
            // Substitute it with the lowest element in the right sub-tree
            // Put the old right sub-tree in the substitution, but additionally remove the minimal element from there
            // Copy left sub-tree
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.height = height(node);
        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    // Deletes the minimal element of the sub-tree
    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    // Finds the minimal element of the sub-tree
    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public int valueAtPosition(int position) {
        if (position < 0 || position > size() - 1) {
            throw new IllegalArgumentException("Position lies in the wrong range.");
        }
        return valueAtPosition(root, position).value;
    }

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

    public int position(final int checkValue) {
        if (root == null) return 0;
        return position(root, checkValue);
    }

    public int position(Node node, int val) {
        if (node.value > val) {
            if (node.left != null) {
                return position(node.left, val);
            } else {
                return 0;
            }
        } else if (node.value < val) {
            if (node.right == null) {
                return position(node, node.value) + 1;
            } else if (node.left != null) {
                return node.left.size + 1 + position(node.right, val);
            } else {
                return position(node.right, val) + 1;
            }
        } else {
            if (node.left != null) {
                return node.left.size;
            } else {
                return 0;
            }
        }
    }

    // References work faster than returns
    public Iterable<Integer> values(int lo, int hi) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        values(root, list, lo, hi);
        return list;
    }

    private void values(Node node, ArrayList<Integer> list, int lo, int hi) {
        if (node == null) return;

        int cmplo = lo - node.value;
        int cmphi = hi - node.value;

        if (cmplo < 0) {
            values(node.left, list, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            list.add(node.value);
        }
        if (cmphi > 0) {
            values(node.right, list, lo, hi);
        }
    }

    public void simpleBalance() {
        Treeqwe balanced = new Treeqwe();
        simpleBalance(balanced, 0, root.size - 1);
        this.root = balanced.root;
    }

    private void simpleBalance(Treeqwe tree, int l, int r) {
        int median = Math.round((r + l) / 2);

        tree.insert(valueAtPosition(median), this.search(valueAtPosition(median)).getVotes() );

        if (l <= (median - 1)) simpleBalance(tree, l, median - 1);
        if ((median + 1) <= r) simpleBalance(tree, median + 1, r);
    }

}
