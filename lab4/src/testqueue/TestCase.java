package testqueue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue_singlelinkedlist.FifoQueue;

import java.io.FileReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase {

    private FifoQueue<Integer> firstQueue;
    private FifoQueue<Integer> secondQueue;

    @BeforeEach
    void setUp() {
        firstQueue = new FifoQueue<Integer>();
        secondQueue = new FifoQueue<Integer>();
    }

    @AfterEach
    void tearDown(){
        firstQueue = null;
        secondQueue = null;
    }


    @Test
    void  TwoEmptyQueue(){
        assertThrows(IllegalArgumentException.class, ()->firstQueue.append(secondQueue));
    }

    @Test
    void NotEmptyAndEmpty(){
        int nbr = 5;
        for (int i = 1; i <= nbr; i++) {
            firstQueue.offer(i);
        }
        firstQueue.append(secondQueue);
        Iterator<Integer> itr = firstQueue.iterator();
        assertTrue(itr.hasNext(), "Wrong result from hasNext");
        for (int i = 1; i <= nbr; i++) {
            assertTrue(itr.hasNext(), "Wrong result from hasNext");
            assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
        }
        assertFalse(itr.hasNext(), "Wrong result from hasNext");
        assertThrows(NoSuchElementException.class, () -> itr.next());
    }

    @Test
    void EmptyAndNotEmpty() {
        int nbr = 5;
        for (int i = 1; i <= nbr; i++) {
            secondQueue.offer(i);
        }
        firstQueue.append(secondQueue);
        Iterator<Integer> itr = firstQueue.iterator();
        assertTrue(itr.hasNext(), "Wrong result from hasNext");
        for (int i = 1; i <= nbr; i++) {
            assertTrue(itr.hasNext(), "Wrong result from hasNext");
            assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
        }
        assertFalse(itr.hasNext(), "Wrong result from hasNext");
        assertThrows(NoSuchElementException.class, () -> itr.next());
        assertTrue(secondQueue.isEmpty());
        assertEquals(firstQueue.size(),nbr);
    }

    @Test
    void BothNotEmpty(){
        int nbr = 5;
        for (int i = 1; i <= nbr; i++) {
            firstQueue.offer(i);
        }
        int nbr2 = 10;
        for (int i = 6; i <= nbr2; i++) {
            secondQueue.offer(i);
        }

        firstQueue.append(secondQueue);
        Iterator<Integer> itr = firstQueue.iterator();
        assertTrue(itr.hasNext(), "Wrong result from hasNext");
        for (int i = 1; i <= nbr2; i++) {
            assertTrue(itr.hasNext(), "Wrong result from hasNext");
            assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
        }
        assertFalse(itr.hasNext(), "Wrong result from hasNext");
        assertThrows(NoSuchElementException.class, () -> itr.next());
        assertTrue(secondQueue.isEmpty());
        assertEquals(firstQueue.size(),10);

    }

    @Test
    void AppendItself(){
        int nbr = 5;

        for (int i = 1; i <= nbr; i++) {
            firstQueue.offer(i);
            secondQueue.offer(i);
        }
        assertThrows(IllegalArgumentException.class, ()->firstQueue.append(firstQueue));

    }


}
