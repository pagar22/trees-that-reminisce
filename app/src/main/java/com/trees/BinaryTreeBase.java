package com.trees;

import java.util.ArrayList;

/**
 * Traditional Binary Search Tree. Can be implemented using types <code>Integer</code> and <code>String</code>.
 * Default functions - <code>insert, delete, search</code>
 * @param <Item> <code>Integer, String</code>
 */
public class BinaryTreeBase<Item> implements BinaryTreeInterface<Item> {

    public Node<Item> root;

    protected Node<Item> insert(Node<Item> node, Item key) {
        if (node == null) return root = new Node<>(key);

        if (node.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else if(node.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else return null;

        updateHeight(node);
        return root = node;
    }

    protected Node<Item> delete(Node<Item> node, Item key) {
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

        if(node != null) updateHeight(node);
        return root = node;
    }

    protected Node<Item> search(Node<Item> node, Item key) {
        if (node == null) return null;

        if (node.compareTo(key) > 0) return search(node.left, key);
        else if (node.compareTo(key) < 0) return search(node.right, key);
        else return node;
    }

    //Simplified polymorphic non-recursive public methods
    @Override
    public void insert(Item key) {
        insert(this.root, key);
    }

    //TODO could create polymorphic insert to simplify insert call, but increase class coupling

    @Override
    public void delete(Item key) {
        delete(this.root, key);
    }

    @Override
    public Node<Item> search(Item key) {
        return search(this.root, key);
    }

    //Auxiliary Functions
    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    protected ArrayList<Item> preOrder(Node<Item> node, ArrayList<Item> arr) {
        if (node != null) {
            arr.add(node.key);
            preOrder(node.left, arr);
            preOrder(node.right, arr);
        }
        return arr;
    }

    public ArrayList<Item> inOrder(Node<Item> node, ArrayList<Item> arr) {
        if (node != null) {
            inOrder(node.left, arr);
            arr.add(node.key);
            inOrder(node.right, arr);
        }
        return arr;
    }

    protected Node<Item> findSmallest(Node<Item> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    protected int height(Node<Item> node) {
        return (node == null) ? -1 : node.height;
    }

    protected void updateHeight(Node<Item> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
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

}
