package com.app;

import com.trees.AVLTree;

public class Driver {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 21);
        tree.root = tree.insert(tree.root, 25);

        System.out.println(tree.delete(tree.root, 14));
        tree.preOrder(tree.root);
    }
}
