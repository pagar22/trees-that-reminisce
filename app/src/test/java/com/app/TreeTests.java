package com.app;

import com.trees.AVLTree;
import com.trees.BinaryTreeBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TreeTests {

    private final ArrayList<Integer> expected = new ArrayList<>();
    private final BinaryTreeBase<Integer> actualTree = new AVLTree<>();

    @BeforeClass (alwaysRun = true)
    void testSetup() {
        System.out.println("Test suite starting up...");
        int i = 100;
        while (i != 0) {
            i--;
            int x = (int) (Math.random()*i*100);
            if (!expected.contains(x)){
                expected.add(x);
                actualTree.insert(x);
            }
            else i++;
        }
        expected.sort(null);
        System.out.println("Randomized Sorted Array Generated: " + expected);
    }

    @Test(groups = {"tree", "random", "insert"}, priority = 1)
    public void randomBSTInsert() {
        assertEquals(actualTree.inOrder(actualTree.root, new ArrayList<>()).toString(), expected.toString());
    }

    @Test(groups = {"tree", "insert"}, priority = 1)
    public void randomBSTInsertDuplicate() {
        try {
            actualTree.insert(expected.size()-1);
        } catch (IllegalArgumentException illegalArgumentException) {
            assertEquals(illegalArgumentException, new IllegalArgumentException("Cannot insert duplicate keys :("));
        }
    }

    //Right Heavy Skewed Tree
    @Test(groups = {"tree", "skewed", "insert"}, priority = 2)
    public void skewedRHBSTInsert() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        actualTree.clear();
        expectedLocal.sort(null); //sort in ascending order to make right heavy tree
        for (int x : expectedLocal)
            actualTree.insert(x);

        assertEquals(actualTree.inOrder(actualTree.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    //Left Heavy Skewed Tree
    @Test(groups = {"tree", "skewed", "insert"}, priority = 3)
    public void skewedLHBSTInsert() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        actualTree.clear();
        expectedLocal.sort(Collections.reverseOrder()); //sort in descending order to make left heavy tree
        for (int x : expectedLocal)
            actualTree.insert(x);
        expectedLocal.sort(null); //sort back to compare with inorder traversal

        assertEquals(actualTree.inOrder(actualTree.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    @Test(groups = {"tree", "search", "exists"}, priority = 4)
    public void BSTSearchExists() {
        int x = expected.get((int)(Math.random()*5));
        assertEquals((int) actualTree.search(x).key, x);
    }

    @Test (groups = {"tree", "search", "not_exists"}, priority = 5)
    public void BSTSearchDoesNotExist() {
        assertNull(actualTree.search(-1)); //since negative numbers aren't inserted
    }

    @Test(groups = {"tree", "delete", "exists"}, priority = 6)
    public void BSTDeleteExists() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        int x = expectedLocal.get((int)(Math.random()*5));
        expectedLocal.remove((Object) x);
        actualTree.delete(x);
        assertEquals(actualTree.inOrder(actualTree.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    /*@Test(groups = {"binary_base", "delete", "not_exists"}, priority = 7)
    public void BSTDeleteDoesNotExist() {
        assertNull(binaryTree.delete(-1)); //since negative numbers aren't inserted
    }*/

    //TODO optimize runtime
    @Test(groups = {"tree", "delete", "exists"}, priority = 8)
    public void BSTDeleteAll() {
        BinaryTreeBase<Integer> binaryTreeLocal = actualTree;
        for (Integer key : expected)
            binaryTreeLocal.delete(key);
        assertEquals(binaryTreeLocal.inOrder(binaryTreeLocal.root, new ArrayList<>()).toString(), "[]");
    }

    @AfterClass (alwaysRun = true)
    void testTeardown() {
        System.out.println("Test suite tearing down...");
        expected.clear();
        actualTree.clear();
    }

}
