package com.trees;

public abstract class BinaryTreeBase<Item> implements BinaryTreeInterface<Item> {

    public Node<Item> root;

    @Override
    public Node<Item> insert(Node<Item> node, Item key) {
        if (isEmpty(node)) return root = new Node<>(key);

        if (node.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else if(node.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else throw new IllegalArgumentException("Cannot insert duplicate keys :(");

        return node;
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
        return node;
    }

    @Override
    public Node<Item> search(Node<Item> node, Item key) {
        if (isEmpty(node)) return null;

        if (node.compareTo(key) > 0) return search(node.left, key);
        else if (node.compareTo(key) < 0) return search(node.right, key);
        else return node;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public boolean isEmpty(Node<Item> node) {
        return node == null;
    }

    protected String preOrder(Node<Item> node, StringBuilder builder) {
        if (!isEmpty(node)) {
            builder.append(node.key).append(" ");
            preOrder(node.left, builder);
            preOrder(node.right, builder);
        }
        return builder.toString().trim();
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
        if (isEmpty()) throw new NullPointerException("Tree is Empty :(");
        StringBuilder builder = new StringBuilder(preOrder(root, new StringBuilder()))
                .insert(0, "[")
                .append("] ");

        return builder.toString();
    }

}
