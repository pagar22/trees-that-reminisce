package com.trees;

public class AVLTree<Item> {

    public Node<Item> root;

    private int height(Node<Item> node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(Node<Item> node) {
        return (node == null) ? 0 : (height(node.left) - height(node.right));
    }

    private void updateHeight(Node<Item> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private boolean isEmpty() {
        return root == null;
    }

    private Node<Item> findSmallest(Node<Item> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private String preOrder(Node<Item> node, StringBuilder builder) {
        if (node != null) {
            builder.append(node.key).append(" ");
            preOrder(node.left, builder);
            preOrder(node.right, builder);
        }
        return builder.toString().trim();
    }

    //Right Rotate
    private Node<Item> rightRotate(Node<Item> y) {
        Node<Item> x = y.left;
        Node<Item> z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    //Left Rotate
    private Node<Item> leftRotate(Node<Item> y) {
        Node<Item> x = y.right;
        Node<Item> z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public Node<Item> balance(Node<Item> node, Item key) {

        int balance = balanceFactor(node);

        //Left Heavy
        if (balance > 1) {
            if (node.left.compareTo(key) < 0)
                node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //Right Heavy
        if (balance < -1) {
            if(node.right.compareTo(key) > 0)
                node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public Node<Item> insert(Node<Item> node, Item key) {
        if (node == null) return root = new Node<>(key);

        if (node.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else if(node.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else throw new IllegalArgumentException("Cannot insert duplicate keys :(");

        updateHeight(node);
        return root = balance(node, key);
    }

    public Node<Item> delete(Node<Item> node, Item key) {
        if (node == null) return null;

        if (node.compareTo(key) > 0)
            node.left = delete(node.left, key);
        else if (node.compareTo(key) < 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null && node.right == null)
                node = null;
            else if (node.left == null)
                node = node.right;
            else if (node.right == null)
                node = node.left;
            else {
                Node<Item> successor = findSmallest(node.right);
                node.key = successor.key;
                node.right = delete(node.right, successor.key);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        return balance(node, key);
    }

    public Node<Item> search(Node<Item> node, Item key) {
        if (node == null) return null;

        if (node.compareTo(key) > 0) return search(node.left, key);
        else if (node.compareTo(key) < 0) return search(node.right, key);
        else return node;

    }

    @Override
    public String toString() {

        if (isEmpty()) throw new NullPointerException("Tree is Empty :(");
        StringBuilder builder = new StringBuilder(preOrder(root, new StringBuilder()))
                .insert(0, "[")
                .append("] ").append("[").append("H=").append(height(root)).append(" B=").append(balanceFactor(root)).append("]");

        return builder.toString();
    }

}
