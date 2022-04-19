package com.trees;

import java.security.Key;

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


    //Problem occurs when deleting the root when theres no successors
    @Override
    public Node<Item> delete(Node<Item> node, Item key) {
        if (isEmpty(search(node, key))) return null;

        if (node.compareTo(key) > 0) {
            System.out.println(node + "Node > key" + key);
            node.left = delete(node.left, key);
            System.out.println(node.left + "returned recursion" + node);
        }
        else if (node.compareTo(key) < 0) {
            System.out.println("Node < key" + node);
            node.right = delete(node.right, key);
        }
        else {
            if (isEmpty(node.left) && isEmpty(node.right)) {
                System.out.println(node + "No children");
                node = null;
                System.out.println(node + "No children");
            }
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

        if (node == null) {
            System.out.println("NULLLL");
            return null;
        }

        System.out.println(node + "REACHEDD");
        System.out.println(this + "REACHEDD");

        updateHeight(node);
        Node b = balance(node, node.key);
        System.out.println(this + "REACHEDD");
        return b;
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
            if (node.left.compareTo(key) < 0)
                node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //Right Heavy
        if (balance < -1) {
            System.out.println(key + ", " + node.right.key + node.right.compareTo(key));
            if(node.right.compareTo(key) > 0)
                node.right = rightRotate(node.right);
            System.out.println(this + "balance function");
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
