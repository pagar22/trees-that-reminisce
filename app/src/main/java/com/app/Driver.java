package com.app;

import com.trees.AVLTree;
import com.trees.Node;

public class Driver {

    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<>();

        tree.insert(tree.root, "Aaryan");
        tree.insert(tree.root, "Saniya");
        tree.insert(tree.root, "Diya");
        tree.insert(tree.root, "Parth");
        tree.insert(tree.root, "Zeira");
        //tree.insert(tree.root, 14);
        //tree.insert(tree.root, 20);
        //tree.insert(tree.root, 21);
        //tree.insert(tree.root, 25);

        System.out.println(tree);

        /*Node<String> diya = tree.search(tree.root, "Diya");
        System.out.println(tree.search(tree.root, "Aaryan"));
        System.out.println(diya.left + "diyas left");*/
        //System.out.println(tree.delete(tree.root, 10));
        //System.out.println(tree.delete(tree.root, 13));
        //tree.delete(tree.root, 14);
        //tree.delete(tree.root, 20);

        System.out.println(tree.delete(tree.root, "Aaryan"));
        System.out.println(tree.root.right);
        System.out.println(tree);
        System.out.println(tree.search(tree.root, "Aaryan"));
        System.out.println(tree.delete(tree.root, "Parth"));
        System.out.println(tree.delete(tree.root, "Zeira"));
        System.out.println(tree.delete(tree.root, "Parth"));
        System.out.println(tree.search((tree.root), "Diya"));
        System.out.println(tree.search((tree.root), "Saniya"));

        //System.out.println(tree.isEmpty());
        System.out.println(tree);

        System.out.println(tree.delete(tree.root, "Parth"));
        System.out.println(tree);
        System.out.println(tree.delete(tree.root, "Zeira"));

        System.out.println(tree);
    }
}
