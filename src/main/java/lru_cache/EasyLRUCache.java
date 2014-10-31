package lru_cache;

import java.util.*;

public class EasyLRUCache<K, V> {
	private int capacity;
	private LinkedHashMap<K, V> hm = null;
    
    public EasyLRUCache(int capacity) {
    	this.capacity = capacity;
        hm = new LinkedHashMap<K, V>(2*capacity);
    }
    
    public V get(K key) {
    	if (hm.containsKey(key))
    		return hm.get(key);
        return null;
    }
    
	public void set(K key, V value) {
		hm.put(key, value);
    }
	
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return hm.size() > capacity;
	}
}
