package com.app;

import com.trees.AVLTree;
import com.trees.BinaryTreeBase;

public class Driver {

    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<>();

        tree.insert(tree.root, "Aaryan");
        tree.insert(tree.root, "Diya");
        tree.insert(tree.root, "Parth");
        tree.insert(tree.root, "Saniya");
        tree.insert(tree.root, "Zeira");
        //tree.insert(tree.root, 14);
        //tree.insert(tree.root, 20);
        //tree.insert(tree.root, 21);
        //tree.insert(tree.root, 25);

        System.out.println(tree);

        tree.delete(tree.root, "Aaryan");
        tree.delete(tree.root, "Parth");
        tree.delete(tree.root, "Zeira");
        tree.delete(tree.root, "Saniya");
        tree.delete(tree.root, "Diya");
        System.out.println(tree);
        System.out.println(tree.search(tree.root, "Saniya"));
    }
}