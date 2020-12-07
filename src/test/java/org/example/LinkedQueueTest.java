package org.example;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    @Test
    void testNewQueue() {
        LinkedQueue queue = new LinkedQueue();

        assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueue() {
        LinkedQueue queue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue("abc");
        }

        assertFalse(queue.isEmpty());
        assertEquals(10, queue.size());
    }

    @Test
    void testPeek() {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("abc");
        queue.enqueue("def");
        queue.enqueue("ghi");

        assertEquals("abc", queue.peek());
    }

    @Test
    public void testPeekIntoEmptyQueue() {
        LinkedQueue queue = new LinkedQueue();

        assertTrue(queue.isEmpty());
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }

    @Test
    void testDequeue() {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("abc");
        queue.enqueue("def");
        queue.enqueue("ghi");

        assertEquals(3, queue.size());
        assertEquals("abc", queue.dequeue());
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeueAll() {
        LinkedQueue queue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue("abc");
        }
        for (int i = 0; i < 10; i++) {
            queue.dequeue();
        }

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testDequeueOnEmptyQueue() {
        LinkedQueue queue = new LinkedQueue();

        assertTrue(queue.isEmpty());
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }
}
