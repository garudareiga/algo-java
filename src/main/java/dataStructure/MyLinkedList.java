package dataStructure;

//public class MyLinkedList<E> implements Iterable<E> {
public class MyLinkedList<E> {
    public static class Entry<E> {
        E elem;
        Entry<E> prev;
        Entry<E> next;
    }
    
    Entry<E> head = null;
    Entry<E> tail = null;
    
    public MyLinkedList() {
    }
    
    public void addFirst(E elem) {
        
    }
    
    public void addLast(E elem) {
        
    }
    
    public E get(int i) {
        return null;
    }
    
    public int size() {
        return 0;
    }
    
    public E pollFirst() {
        return null;
    }
    
    public E pollLast() {
        return null;
    }
}
