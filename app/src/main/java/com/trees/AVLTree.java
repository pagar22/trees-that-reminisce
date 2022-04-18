package com.trees;

public class AVLTree {

    private class Node {
        int key, height;
        Node left, right;

        public Node(int key) {
            this.key = key;
            this.height = 0;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return Integer.toString(this.key);
        }
    }

    public Node root;

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(Node node) {
        return (node == null) ? 0 : (height(node.left) - height(node.right));
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private Node findSmallest(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public String preOrder(Node node, StringBuilder builder) {
        if (node != null) {
            builder.append(node.key).append(" ");
            preOrder(node.left, builder);
            preOrder(node.right, builder);
        }
        return builder.toString().trim();
    }

    //Right Rotate
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    //Left Rotate
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public Node balance(Node node, int key) {

        int balance = balanceFactor(node);

        //Left Heavy
        if (balance > 1) {
            if (key > node.left.key)
                node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //Right Heavy
        if (balance < -1) {
            if(key < node.right.key)
                node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (node.key > key) {
            node.left = insert(node.left, key);
        } else if(node.key < key) {
            node.right = insert(node.right, key);
        } else throw new IllegalArgumentException("Cannot insert duplicate keys :(");

        updateHeight(node);
        return balance(node, key);
    }

    public Node delete(Node node, int key) {
        if (node == null) return node;

        if (key > node.key)
            node.right = delete(node.right, key);
        else if (key < node.key)
            node.left = delete(node.left, key);
        else {
            if (node.left == null && node.right == null)
                node = null;
            else if (node.left == null)
                node = node.right;
            else if (node.right == null)
                node = node.left;
            else {
                Node successor = findSmallest(node.right);
                node.key = successor.key;
                node.right = delete(node.right, successor.key);
            }
        }
        if (node == null) return node;

        updateHeight(node);
        return balance(node, key);
    }

    public Node search(Node node, int key) {
        if (node == null) return node;

        if (key < node.key) return search(node.left, key);
        else if (key > node.key) return search(node.right, key);
        else return node;

    }

    @Override
    public String toString() {

        if(root == null) throw new NullPointerException("Tree is Empty :(");
        StringBuilder builder = new StringBuilder(preOrder(root, new StringBuilder()))
                .insert(0, "[")
                .append("] ").append("[").append("H=").append(height(root)).append(" B=").append(balanceFactor(root)).append("]");

        return builder.toString();
    }

}
