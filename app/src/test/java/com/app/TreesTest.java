package com.app;

import com.trees.BinaryTreeBase;
import com.trees.Node;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TreesTest {

    private final ArrayList<Integer> expected = new ArrayList<>();
    private final BinaryTreeBase<Integer> binaryTree = new BinaryTreeBase<>();

    @BeforeClass(alwaysRun = true)
    void testSetup() {
        System.out.println("Test suite starting up...");
        int i = 50;
        while(i != 0) {
            i--;
            int x = (int) (Math.random()*i*100);
            if (!expected.contains(x)){
                expected.add(x);
                binaryTree.insert(x);
            }
            else i++;
        }
        expected.sort(null);
        System.out.println("Randomized Sorted Array Generated: " + expected);
    }

    @Test(groups = {"random", "binary_base", "insert"}, priority = 1)
    public void randomBSTInsert() {
        assertEquals(binaryTree.inOrder(binaryTree.root, new ArrayList<>()).toString(), expected.toString());
    }

    //Right Heavy Skewed Tree
    @Test(groups = {"skewed", "binary_base", "insert"}, priority = 2)
    public void skewedRHBSTInsert() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        binaryTree.clear();
        expectedLocal.sort(null); //sort in ascending order to make right heavy tree
        for (int x : expectedLocal)
            binaryTree.insert(x);

        assertEquals(binaryTree.inOrder(binaryTree.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    //Left Heavy Skewed Tree
    @Test(groups = {"skewed", "binary_base", "insert"}, priority = 3)
    public void skewedLHBSTInsert() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        binaryTree.clear();
        expectedLocal.sort(Collections.reverseOrder()); //sort in descending order to make left heavy tree
        for (int x : expectedLocal)
            binaryTree.insert(x);
        expectedLocal.sort(null); //sort back to compare with inorder traversal

        assertEquals(binaryTree.inOrder(binaryTree.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    @Test(groups = {"binary_base", "search", "exists"}, priority = 4)
    public void BSTSearchExists() {
        int x = expected.get((int)(Math.random()*5));
        Node<Integer> node = binaryTree.search(x);
        assertEquals((int) node.key, x);
    }

    @Test (groups = {"binary_base", "search", "not_exists"}, priority = 5)
    public void BSTSearchDoesNotExist() {
        assertNull(binaryTree.search(120)); //since max range for BST is 100 (Before Class)
    }

    @Test(groups = {"binary_base", "delete", "exists"}, priority = 6)
    public void BSTDeleteExists() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        int x = expectedLocal.get((int)(Math.random()*5));
        expectedLocal.remove((Object) x);
        binaryTree.delete(x);
        assertEquals(binaryTree.inOrder(binaryTree.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    /*@Test(groups = {"binary_base", "delete", "not_exists"}, priority = 7)
    public void BSTDeleteDoesNotExist() {
        assertNull(binaryTree.delete(120)); //since max range for BST is 100
    }*/

    @Test(groups = {"binary_base", "delete", "exists"}, priority = 8)
    public void BSTDeleteAll() {
        BinaryTreeBase<Integer> binaryTreeLocal = binaryTree;
        for (Integer key : expected)
            binaryTreeLocal.delete(key);
        assertEquals(binaryTreeLocal.inOrder(binaryTreeLocal.root, new ArrayList<>()).toString(), "[]");
    }

}
