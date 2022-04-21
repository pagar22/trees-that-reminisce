package com.trees;

interface BinaryTreeInterface<Item> {

    void insert(Item key);
    void delete(Item key);
    Node<Item> search(Item key);
    boolean isEmpty();
    boolean isEmpty(Node<Item> node);
    String toString();
}
