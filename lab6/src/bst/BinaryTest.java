package bst;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class BinaryTest {

    private BinarySearchTree<Integer> integerBinaryTree;
    private BinarySearchTree secondBinaryTree;

    @BeforeEach
    void setUp() {
        integerBinaryTree = new BinarySearchTree<Integer>();
        secondBinaryTree = new BinarySearchTree((s1,s2)-> s2.toString().length() - s1.toString().length());

    }

    @AfterEach
    void tearDown(){
        integerBinaryTree = null;
        secondBinaryTree = null;
    }


    @Test
    void  EmptySearchTree(){
        assertEquals(0, integerBinaryTree.size());
        assertEquals(0, integerBinaryTree.height());


    }

    @Test
    void AddToTree(){
        secondBinaryTree.add("Hej");
        secondBinaryTree.add("Tjena");
        secondBinaryTree.add("Chaos");
        secondBinaryTree.add("Tests");

        assertEquals(2, secondBinaryTree.size);
        assertTrue(secondBinaryTree.add("This should be true"));
        assertFalse(secondBinaryTree.add("False"));
        assertEquals(3,secondBinaryTree.height());
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
