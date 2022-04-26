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
        if (isEmpty(node)) return root = new Node<>(key);

        if (node.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else if(node.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else throw new IllegalArgumentException("Cannot insert duplicate keys :(");

        updateHeight(node);
        return root = node;
    }

    protected Node<Item> delete(Node<Item> node, Item key) {
        if (isEmpty(node)) return null;

        if (node.compareTo(key) > 0)
            node.left = delete(node.left, key);
        else if (node.compareTo(key) < 0)
            node.right = delete(node.right, key);
        else {
            if (isEmpty(node.left) && isEmpty(node.right))
                node = null;
            else if (isEmpty(node.left))
                node = node.right;
            else if (isEmpty(node.right))
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
        if (isEmpty(node)) return null;

        if (node.compareTo(key) > 0) return search(node.left, key);
        else if (node.compareTo(key) < 0) return search(node.right, key);
        else return node;
    }

    //Simplified non-recursive public methods
    @Override
    public void insert(Item key) {
        insert(this.root, key);
    }

    //TODO could create polymorphic insert to simplify insert call, but increase class coupling

    @Override
    public Node<Item> delete(Item key) {
        return delete(this.root, key);
    }

    @Override
    public Node<Item> search(Item key) {
        return search(this.root, key);
    }

    //Auxiliary Functions
    public void clear() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isEmpty(Node<Item> node) {
        return node == null;
    }

    public ArrayList<Item> preOrder(Node<Item> node, ArrayList<Item> arr) {
        if (!isEmpty(node)) {
            arr.add(node.key);
            preOrder(node.left, arr);
            preOrder(node.right, arr);
        }
        return arr;
    }

    public ArrayList<Item> inOrder(Node<Item> node, ArrayList<Item> arr) {
        if (!isEmpty(node)) {
            inOrder(node.left, arr);
            arr.add(node.key);
            inOrder(node.right, arr);
        }
        return arr;
    }

    protected Node<Item> findSmallest(Node<Item> node) {
        while (!isEmpty(node.left)) node = node.left;
        return node;
    }

    protected int height(Node<Item> node) {
        return (isEmpty(node)) ? -1 : node.height;
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
