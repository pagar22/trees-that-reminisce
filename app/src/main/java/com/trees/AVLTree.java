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
    }

    public Node root;

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(Node node) {
        return (node == null) ? 0 : (height(node.left) - height(node.right));
    }

    private void updateHeight (Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
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

    public Node insert(Node node, int key) {
        if(node == null) return new Node(key);

        if(node.key > key) {
            node.left = insert(node.left, key);
        } else if(node.key < key) {
            node.right = insert(node.right, key);
        } else throw new IllegalArgumentException("Cannot insert duplicate keys :(");

        updateHeight(node);
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

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.height + "!");
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}
