package com.trees;


public class AVLTree<Item> extends BinaryTreeBase<Item> implements BinaryTreeInterface<Item>{

    public Node<Item> root;

    @Override
    public Node<Item> insert(Node<Item> node, Item key) {
        Node<Item> inserted = super.insert(node, key);

        return root = balance(inserted, key);
    }

    @Override
    public Node<Item> delete(Node<Item> node, Item key) {
        Node<Item> deleted = super.delete(node, key);

        return root = balance(deleted, key);
    }

    @Override
    public Node<Item> search(Node<Item> node, Item key) {
        return super.search(node, key);
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    private int balanceFactor(Node<Item> node) {
        return (isEmpty(node)) ? 0 : (height(node.left) - height(node.right));
    }

    //Left Rotate
    private Node<Item> leftRotate(Node<Item> parent) {
        Node<Item> child = parent.right;
        Node<Item> grandChild = child.left;
        child.left = parent;
        parent.right = grandChild;
        updateHeight(parent);
        updateHeight(child);
        return child;
    }

    //Right Rotate
    private Node<Item> rightRotate(Node<Item> parent) {
        Node<Item> child = parent.left;
        Node<Item> grandChild = child.right;
        child.right = parent;
        parent.left = grandChild;
        updateHeight(parent);
        updateHeight(child);
        return child;
    }

    private Node<Item> balance(Node<Item> node, Item key) {

        int balance = balanceFactor(node);

        //Left Left
        if (balance > 1 && balanceFactor(node.left) >= 0)
            return rightRotate(node);

        // Left Right
        if (balance > 1 && balanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right
        if (balance < -1 && balanceFactor(node.right) <= 0)
            return leftRotate(node);

        // Right Left
        if (balance < -1 && balanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (isEmpty()) builder.append("Tree is Empty :(");
        else {
            builder = new StringBuilder(super.preOrder(root, new StringBuilder()))
                    .insert(0, "[")
                    .append("] ").append("[").append("H=").append(height(root)).append(" B=").append(balanceFactor(root)).append("]");
        }

        return builder.toString();
    }

}