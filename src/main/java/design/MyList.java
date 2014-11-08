package design;

import java.util.Iterator;

/*
 * Implement a list interface
 */

public interface MyList<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains();
    Iterator<E> iterator();
    boolean add(E e);
    boolean remove(E e);
    void clear();
    void get(E item);
    void set(E item, int p);
    
    boolean equals(Object o);
    int hashCode();
}
