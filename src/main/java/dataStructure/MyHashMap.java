package dataStructure;

public class MyHashMap<K, V> {
    public static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        
        Entry(K key, V value, Entry<K, V> next) {
            this.key = key; this.value = value; this.next = next;
        }
    }
    
    transient private final Entry<K, V>[] table;
    private int threshold;
    private int size = 0;
    private float loadFactor = 1.0f;
    
    public MyHashMap() {
        this(100, 0.75f);
    }
    
    public MyHashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        threshold = (int)(initialCapacity*loadFactor);
        table = new Entry[initialCapacity];
    }
    
    public int size() {
        return size;
    }
    
    public void put(K key, V value) {
        int i = indexFor(key.hashCode());
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            if (key == e.key && key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        table[i] = new Entry<K, V>(key, value, table[i]);
        if (++size > threshold) resize();
    }

    private void resize() {
        // TODO Auto-generated method stub
        int newCapacity = table.length*2;
        threshold = (int)(newCapacity*loadFactor);
        
        Entry<K, V>[] newTable = new Entry[newCapacity];
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> e = table[i];
            if (e != null) {
                table[i] = null;
                do {
                    Entry<K, V> next = e.next;
                    int p = indexFor(e.key.hashCode());
                    e.next = newTable[p];
                    newTable[p] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    private int indexFor(int hashCode) {
        return (hashCode & 0x7FFFFFFF) %table.length;
    }

    public V get(K key) {
        int i = indexFor(key.hashCode());
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            if (key == e.key && key.equals(e.key))
                return e.value;
        }
        return null;
    }
}
