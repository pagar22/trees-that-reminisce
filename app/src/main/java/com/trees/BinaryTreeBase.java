package com.trees;

public abstract class BinaryTreeBase<Item> implements BinaryTreeInterface<Item> {

    Node<Item> root;

    @Override
    public abstract Node<Item> insert(Node<Item> node, Item key);

    @Override
    public abstract Node<Item> delete(Node<Item> node, Item key);

    @Override
    public abstract Node<Item> search(Node<Item> node, Item key);

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public boolean isEmpty(Node<Item> node) {
        return node == null;
    }

    private String preOrder(Node<Item> node, StringBuilder builder) {
        if (isEmpty(node)) {
            builder.append(node.key).append(" ");
            preOrder(node.left, builder);
            preOrder(node.right, builder);
        }
        return builder.toString().trim();
    }



}
