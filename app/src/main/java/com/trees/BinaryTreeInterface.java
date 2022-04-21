package com.trees;

interface BinaryTreeInterface<Item> {

    Node<Item> insert(Node<Item> node, Item key);
    Node<Item> delete(Node<Item> node, Item key);
    Node<Item> search(Node<Item> node, Item key);
    boolean isEmpty();
    boolean isEmpty(Node<Item> node);
    String toString();
}
