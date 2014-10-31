package lru_cache;

import java.util.*;

public class LRUCache<K, V> {
	class DoublyLinkedListNode {
		K key;
		V value;
		DoublyLinkedListNode prev = null;
		DoublyLinkedListNode next = null;
		DoublyLinkedListNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private HashMap<K, DoublyLinkedListNode> hm = 
			new HashMap<K, DoublyLinkedListNode>();
	private DoublyLinkedListNode head = null;
	private DoublyLinkedListNode tail = null;
	private int capacity;
	private int size;
	
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	this.size = 0;
    }

    public V get(K key) {
    	if (hm.containsKey(key)) {
    		DoublyLinkedListNode n = hm.get(key);
    		update(n);
    		return n.value;
    	}
    	return null;
    }

	public void set(K key, V value) {
    	if (hm.containsKey(key)) {
    		DoublyLinkedListNode n = hm.get(key);
    		n.value = value;
    		update(n);
    	} else {
    		DoublyLinkedListNode n = new DoublyLinkedListNode(key, value);
    		add(n);
    	}
    }
	
    private void update(DoublyLinkedListNode n) {
    	if (head == n) return;
    	n.prev = n.next;
    	n.next = head;
    	head = n;
    }
    
    private void add(DoublyLinkedListNode n) {
    	n.next = head;
    	head = n;
    	if (tail == null) tail = n;
    	if (size == capacity) {	// purge tail
    		hm.remove(tail.key);
    		tail = tail.prev;
    		tail.next = null;   		
    	} else
    		size++;
    	hm.put(n.key, n);
    }
}
