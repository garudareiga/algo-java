package dataStructure;

import java.util.HashMap;
import java.util.concurrent.locks.*;

/**
 * 
 * @author raychen
 * Problem:
 * Implement a HashMap with read/write lock
 */

public class MyHashMapWithRWLock<K, V> {
    final HashMap<K, V> map;
    final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    
    public MyHashMapWithRWLock(HashMap<K, V> map) {
        this.map = map;
    }
    
    void put(K key, V value) {
        try {
            rwLock.writeLock().lock();
            map.put(key, value);
        } finally {
            rwLock.writeLock().unlock();
        }
    }
    
    V get(K key) {
        V r = null;
        try {
            rwLock.readLock().lock();
            r = map.get(key);
        } finally {
            rwLock.readLock().unlock();
        }
        return r;
    }
}
