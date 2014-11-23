package dataStructure;

public class MyStack<E> {
    private final Object[] elementData;
    private int elementCount = 0;
    
    public MyStack() {
        this(10);
    }
    
    public MyStack(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }
    
    public void add(E elem) {
        
    }
    
    public E pop() {
        return null;
    }
    
    public E get(int i) {
        return null;
    }
    
    public int size() {
        return 0;
    }
    
}
