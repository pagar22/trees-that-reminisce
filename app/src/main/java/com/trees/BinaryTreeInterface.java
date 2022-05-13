package com.trees;

public interface BinaryTreeInterface<Item> {

    /**
     * Inserts a unique value into a specified <code>BinaryTree</code>.
     * Duplicate values aren't supported.
     * @param key Value to be inserted
     */
    void insert(Item key);

    /**
     * Deletes the input value, if it exists, from a <code>BinaryTree</code>.
     * @param key Value to be deleted
     */
    void delete(Item key);

    /**
     * Looks for whether the input value exists in a specified <code>BinaryTree</code>.
     * @param key Value to be searched
     * @return <code>Node</code> value is found, else <code>null</code>
     */
    Node<Item> search(Item key);

    /**
     * Clears all the nodes in the specified <code>BinaryTree</code>
     */
    void clear();

    /**
     * Checks whether the specified <code>BinaryTree</code> has <code>Nodes</code> or not.
     * @return <code>true</code> if empty, <code>false</code> if not
     */
    boolean isEmpty();


    /**
     * Provides a literal representation of the <code>BinaryTree</code> object.
     * @return <code>String</code>
     */
    String toString();
}
