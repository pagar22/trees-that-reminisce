package com.app;

import com.trees.AVLTree;
import com.trees.Node;

public class Driver {

    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<>();

        tree.insert(tree.root, "Aaryan");
        tree.insert(tree.root, "Saniya");
        tree.insert(tree.root, "Diya");
        //tree.insert(tree.root, "Parth");
        //tree.insert(tree.root, "Zeira");
        //tree.insert(tree.root, 14);
        //tree.insert(tree.root, 20);
        //tree.insert(tree.root, 21);
        //tree.insert(tree.root, 25);

        System.out.println(tree);

        System.out.println(tree.delete(tree.root, "Aaryan"));
        System.out.println(tree);
        System.out.println(tree.delete(tree.root, "Parth"));
        System.out.println(tree);
        System.out.println(tree.delete(tree.root, "Zeira"));
        System.out.println(tree);

        System.out.println(tree.delete(tree.root, "Parth"));
        System.out.println(tree);
        System.out.println(tree.delete(tree.root, "Zeira"));

        System.out.println(tree);
    }
}