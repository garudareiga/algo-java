package design;

import java.util.*;

public class DeepHashMapItr {
    private final Stack<Object> stack;
    
    DeepHashMapItr(Map<Object, Object> map) {
        stack = new Stack<Object>();
        stack.push(map);
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public Object next() {
        if (!hasNext()) 
            throw new RuntimeException("No next");
        extract();
        Object r = stack.pop();       
        return r;
    }

    @SuppressWarnings("unchecked")
    public void extract() {
        while (!stack.isEmpty() && (stack.peek() instanceof Map<?, ?>)) {
            HashMap<Object, Object> top = (HashMap<Object, Object>) stack.pop();
            for (Object value : top.values()) {
                stack.push(value);
            }
        }
    }
    
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("1", 1);
        
        Map<Object, Object> sub_map_1 = new HashMap<Object, Object>();
        sub_map_1.put(2, 2);
        sub_map_1.put(3, 3);
        map.put("2", sub_map_1);
        
        Map<Object, Object> sub_map_2 = new HashMap<Object, Object>(); 
        map.put("4", sub_map_2);
        
        DeepHashMapItr iter = new DeepHashMapItr(map);
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
    }
}
