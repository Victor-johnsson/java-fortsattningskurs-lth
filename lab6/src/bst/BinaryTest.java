package bst;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class BinaryTest {

    private BinarySearchTree<Integer> integerBinaryTree;
    private BinarySearchTree<Integer> secondQueue;

    @BeforeEach
    void setUp() {
        integerBinaryTree = new BinarySearchTree<Integer>();
        secondQueue = new BinarySearchTree<Integer>();
    }

    @AfterEach
    void tearDown(){
        integerBinaryTree = null;
        secondQueue = null;
    }


    @Test
    void  EmptySearchTree(){
        assertEquals(0, integerBinaryTree.size());
        assertEquals(0, integerBinaryTree.height());


    }

    @Test
    void AddToTree(){
        integerBinaryTree.add(10);
        integerBinaryTree.add(17);
        integerBinaryTree.add(26);
        integerBinaryTree.add(9);
        assertEquals(3, integerBinaryTree.height());
        assertEquals(4, integerBinaryTree.size());
        assertFalse(integerBinaryTree.add(17));
        assertTrue(integerBinaryTree.add(81));
        integerBinaryTree.clear();
        assertEquals(0, integerBinaryTree.height());
        assertEquals(0, integerBinaryTree.size());

    }






}
