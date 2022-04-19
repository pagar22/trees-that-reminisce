package com.trees;

import javax.annotation.Nonnull;


//NEED TO CHANGE ACCESS MODIFIERS
public class Node<Item> implements Comparable<Item> {
    Item key;
    int height;
    public Node<Item> left, right;

    protected Node(Item key) {
        this.key = key;
        this.height = 0;
        this.left = this.right = null;
    }

    @Override
    public String toString() {
        return "[Key=" + key + " H=" + height + "]";
    }

    @Override
    public int compareTo(@Nonnull Item o) {
        if(key instanceof Integer) return (Integer) this.key - (Integer) o;
        else if (key instanceof String) return this.key.toString().compareTo(o.toString());
        else throw new IllegalArgumentException("AVLTree does not support this generic type");
    }
}
