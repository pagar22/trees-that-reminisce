package com.trees;


public class AVLTree<Item> extends BinaryTreeBase<Item> {

    public Node<Item> root;

    @Override
    public Node<Item> insert(Node<Item> node, Item key) {
        if (isEmpty(node)) return root = new Node<>(key);

        if (node.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else if(node.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else throw new IllegalArgumentException("Cannot insert duplicate keys :(");

        updateHeight(node);
        return root = balance(node, node.key);
    }

    @Override
    public Node<Item> delete(Node<Item> node, Item key) {
        if (isEmpty(search(node, key))) return null;

        if (node.compareTo(key) > 0)
            node.left = delete(node.left, key);
        else if (node.compareTo(key) < 0)
            node.right = delete(node.right, key);
        else {
            if (isEmpty(node.left) && isEmpty(node.right))
                node = null;
            else if (isEmpty(node.left))
                node = node.right;
            else if (isEmpty(node.right)) {
                node = node.left;
            }
            else {
                Node<Item> successor = findSmallest(node.right);
                node.key = successor.key;
                node.right = delete(node.right, successor.key);
            }
        }

        if (node == null)
            return null;

        updateHeight(node);
        return root = balance(node, node.key);
    }

    @Override
    public Node<Item> search(Node<Item> node, Item key) {
        if (isEmpty(node)) return null;

        if (node.compareTo(key) > 0) return search(node.left, key);
        else if (node.compareTo(key) < 0) return search(node.right, key);
        else return node;

    }

    private int height(Node<Item> node) {
        return (isEmpty(node)) ? -1 : node.height;
    }

    private int balanceFactor(Node<Item> node) {
        return (isEmpty(node)) ? 0 : (height(node.left) - height(node.right));
    }

    private void updateHeight(Node<Item> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private Node<Item> findSmallest(Node<Item> node) {
        while (!isEmpty(node.left)) node = node.left;
        return node;
    }

    private String preOrder(Node<Item> node, StringBuilder builder) {
        if (!isEmpty(node)) {
            builder.append(node.key).append(" ");
            preOrder(node.left, builder);
            preOrder(node.right, builder);
        }
        return builder.toString().trim();
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

    private Node<Item> balance(Node<Item> node, Item key) {

        int balance = balanceFactor(node);

        //Left Heavy
        if (balance > 1) {
            if (node.compareTo(node.left.key) > 0)
                node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //Right Heavy
        if (balance < -1) {
            if(node.compareTo(node.right.key) < 0)
                node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
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