package design;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * @author raychen
 * 
 * Problem:
 * Design a thread-safe blocking queue.
 * 
 */ 

public class SimpleBlockingQueue<T> {
    static class ListNode<T> {
        volatile T item;
        ListNode<T> next;
        
        ListNode(T item) {
            this.item = item;
        }
    }
    
    /** The capacity bound */
    private final int capacity;
    private final AtomicInteger count = new AtomicInteger(0);
    
    private ListNode<T> head;
    private ListNode<T> tail;
    
    /** Lock held by take */
    private final ReentrantLock takeLock = new ReentrantLock();
    /** Wait queue for waiting takes */
    private final Condition notEmpty = takeLock.newCondition();
    
    /** Lock held by put */
    private final ReentrantLock putLock = new ReentrantLock();
    /** Wait queue for waiting puts */
    private final Condition notFull = putLock.newCondition();
    
    /** Signals a waiting take */
    private void signalNotEmpty() {
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }
    
    /** Signals a waiting put */
    private void signalNotFull() {
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }
    
    private void insert(T item) {
        tail = tail.next = new ListNode<T>(item);
    }
    
    private T extract() {
        ListNode<T> first = head.next;
        head = first;
        T item = first.item;
        first.item = null;
        return item;
    }
    
    private void fullyLock() {
        takeLock.lock();
        putLock.lock();
    }
    
    private void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
    }
    
    public SimpleBlockingQueue() {
        this(Integer.MAX_VALUE);
    }
    
    public SimpleBlockingQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        head = tail = new ListNode<T>(null);
    }
    
    public int size() { 
        return count.get(); 
    }
    
    public void put(T item) throws InterruptedException {
        int c = -1;
        putLock.lockInterruptibly();
        try {
            try {
                while (count.get() == capacity)
                    notFull.await();
            } catch (InterruptedException ie) {
                notFull.signal();
                throw ie;
            }
            insert(item);
            c = count.getAndIncrement();
            if (c + 1 < capacity)
                notFull.signal();
        } finally {
            putLock.unlock();
        }
        if (c == 0)
            signalNotEmpty();
    }
    
    public T take() throws InterruptedException {
        T item;
        int c = -1;
        takeLock.lockInterruptibly();
        try {
            try {
                while (count.get() == 0)
                    notEmpty.await();
            } catch (InterruptedException ie) {
                notEmpty.signal();
                throw ie;
            }
            item = extract();
            c = count.decrementAndGet();
            if (c > 0)
                notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
        if (c == capacity) 
            signalNotFull();
        return item;
    }
    
    public T peek() {
        return null;
    }
    



}
