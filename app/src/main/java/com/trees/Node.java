package com.trees;

import javax.annotation.Nonnull;

//TODO add getters and setters and change field access modifiers

/**
 * Single tree object containing attributes <code>key, height, left, right</code>
 * @param <Item> <code>Integer, String, KVP</code>
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
     * @throws IllegalArgumentException if type is anything other than <code>Integer, String or KVP</code>
     */
    @Override
    public int compareTo(@Nonnull Item o) {
        if (key instanceof Integer) return (Integer) this.key - (Integer) o;
        else if (key instanceof String) return this.key.toString().compareTo(o.toString());
        else if (key instanceof KeyValuePair) {
            return ((KeyValuePair<?, ?>) this.key).compareTo(((KeyValuePair<?, ?>) o).value);
        }
        else throw new TypeNotPresentException(key.getClass().getTypeName(),
                new Exception("BinaryTree does not support this generic type :("));
    }
}
