package Iteration;

import java.util.*;

public class FilterItr<T> implements Filter<T> {

    /*
     * Assume only accept positive integer
     */
    public boolean accepts(T t) {
        return (Integer)t > 0;
    }

    T next = null;
    ListIterator<T> itr = null;
    
    FilterItr(List<T> list) {
        this.itr = list.listIterator();
        filter();
    }
    
    public boolean hasNext() {
        return next != null;
    }
    
    public T next() {
        if (!hasNext())
            throw new IllegalArgumentException();
        T r = next;
        filter();
        return r;
    }
    
    private void filter() {
        while (itr.hasNext()) {
            next = itr.next();
            if (accepts(next)) break;
            else next = null;
        }
    }
}
