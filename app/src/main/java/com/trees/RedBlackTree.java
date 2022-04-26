package com.trees;

import java.util.ArrayList;

public class RedBlackTree<Item> extends BinaryTreeBase<Item> implements BinaryTreeInterface<Item>{

    private static class Node<Item> extends com.trees.Node<Item> {
        enum COLOUR {
            RED,
            BLACK
        }
        protected COLOUR colour;
        protected Node<Item> left, right, parent;

        protected Node(Item key) {
            super(key);
            this.colour = COLOUR.RED;
            this.left = this.right = this.parent = null;
        }
    }

    public Node<Item> root;

    private Node<Item> insert(Node<Item> node, Item key) {
        if (node == null) return new Node<>(key);
        else if (node.compareTo(key) > 0) {
            node.left = insert(node.left, key);
            node.left.parent = node;

            if (node != this.root) {
                if(node.colour == Node.COLOUR.RED && node.left.colour == Node.COLOUR.RED);
                //deal with red red case
            }
        } else {
            node.right = insert(node.right, key);
            node.right.parent = node;
            if (node != this.root) {
                if (node.colour == Node.COLOUR.RED && node.right.colour == Node.COLOUR.RED);
                //deal with red red case
            }
        }
        return node;
    }

    public void insert(Item key) {
        /*this.root = isEmpty() ? new Node<>(key) : insert(this.root, key);
        this.root.colour = Node.COLOUR.BLACK;*/
        if (isEmpty()) {
            this.root = new Node<>(key);
            this.root.colour = Node.COLOUR.BLACK;
        } else this.root = insert(this.root, key);
    }


    //Left Rotate
    private Node<Item> leftRotate(Node<Item> grandParent) {
        Node<Item> parent = grandParent.right;
        Node<Item> grandChild = parent.left;
        parent.left = grandParent;
        grandParent.right = grandChild;
        grandParent.parent = parent;
        if(grandChild != null) grandChild.parent = grandParent;
        return parent;
    }

    //Right Rotate
    private Node<Item> rightRotate(Node<Item> grandParent) {
        Node<Item> parent = grandParent.left;
        Node<Item> grandChild = parent.right;
        parent.right = grandParent;
        grandParent.left = grandChild;
        grandParent.parent = parent;
        if(grandChild != null) grandChild.parent = grandParent;
        return parent;
    }

    private Node<Item> getPibling(Node<Item> parent) {
        Node<Item> grandParent = parent.parent;
        if(grandParent.left == parent) return grandParent.right;
        else if(grandParent.right == parent) return grandParent.left;
        else throw new IllegalStateException("Parent isn't a child of grandparent");
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (isEmpty()) builder.append("Tree is Empty :(");
        else
            builder = new StringBuilder(preOrder(root, new ArrayList<>()).toString())
                    .append(" [H=").append(height(root)).append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert(redBlackTree.root, 10);
    }
}
