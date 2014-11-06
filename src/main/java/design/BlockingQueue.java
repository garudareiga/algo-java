package design;

import java.util.EmptyStackException;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Design a thread-safe blocking queue.
 * 
 */ 

public class BlockingQueue<T> {
    class DoublyLinkedListNode {
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode next = null;
        T element;
        
        DoublyLinkedListNode(T element) {
            this.element = element;
        }
    }
    
    private int size;
    private DoublyLinkedListNode head = null;
    private DoublyLinkedListNode tail = null;
    
    public BlockingQueue() {
        size = 0;
    }
    
    public int size() { return size; }
    
    public void enqueue(T elem) {
        DoublyLinkedListNode n = new DoublyLinkedListNode(elem);
        if (size == 0) { head = tail = n; }
        else { tail.next = n; n.prev = tail; tail = n; }
        size++;
    }
    
    public T dequeue() {
        if (size == 0) return null;
        DoublyLinkedListNode n = head;
        if (size == 1) { head = tail = null; }
        else { head = n.next; n.next = null; head.prev = null; }     
        return n.element;
    }
}
