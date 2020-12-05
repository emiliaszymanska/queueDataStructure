package org.example;

import java.util.NoSuchElementException;

public class LinkedQueue {

    private Node head;
    private Node tail;
    private int numberOfElements;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.numberOfElements = 0;
    }

    // Adds a new value to the end of the queue (tail)
    public void enqueue(String value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        numberOfElements++;
    }

    // Removes the value at the front of the queue (head) and returns it
    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        String elementToRemove = head.getValue();
        head = head.getNext();
        if (isEmpty()) {
            tail = null;
        }
        numberOfElements--;

        return elementToRemove;
    }

    // Returns the value least recently added to the queue
    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        return head.getValue();
    }

    // Returns the number of values in the queue
    public int size() {
        return numberOfElements;
    }

    // Returns true if the queue is empty
    public boolean isEmpty() {
        return head == null;
    }
}
