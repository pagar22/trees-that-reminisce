package com.trees;

import javax.annotation.Nonnull;

/**
 * Single tree object containing attributes <code>key, height, left, right</code>
 * @param <Item> <code>Integer, String</code>
 */
public class Node<Item> implements Comparable<Item> {
    public Item key;
    protected int height;
    protected Node<Item> left, right;

    protected Node(Item key) {
        this.key = key;
        this.height = 0;
        this.left = this.right = null;
    }

    /**
     * Provides a literal representation of a <code>Node</code> object.
     * @return String
     */
    @Override
    public String toString() {
        return "[Key=" + key + " H=" + height + "]";
    }


    /**
     * Compares the values of two <code>Node</code> objects.
     * Only supports <code>Integer</code> and <code>String</code> types.
     * @return int
     * @throws IllegalArgumentException if type is anything other than <code>Integer</code> or <code>String</code>
     */
    @Override
    public int compareTo(@Nonnull Item o) {
        if(key instanceof Integer) return (Integer) this.key - (Integer) o;
        else if (key instanceof String) return this.key.toString().compareTo(o.toString());
        else throw new IllegalArgumentException("AVLTree does not support this generic type");
    }
}
