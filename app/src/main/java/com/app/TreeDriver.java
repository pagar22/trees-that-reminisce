package com.app;

import com.trees.AVLTree;
import com.trees.BinaryTreeBase;


public class TreeDriver {

    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<>();

        tree.insert("Aaryan");
        tree.insert("Diya");
        tree.insert("Parth");
        tree.insert("Saniya");
        tree.insert("Zeira");
        //tree.insert(tree.root, 14);
        //tree.insert(tree.root, 20);
        //tree.insert(tree.root, 21);
        //tree.insert(tree.root, 25);

        System.out.println(tree);

        tree.delete("Aaryan");
        tree.delete("Parth");
        tree.delete("Zeira");
        tree.delete("Saniya");
        tree.delete("Diya");
        System.out.println(tree);
        System.out.println(tree.search("Saniya"));
    }
}