package design;

import java.util.*;

public class DeepListItr {
    private Stack<Object> stack;
    
    DeepListItr(List<Object> list) {
        stack = new Stack<Object>();
        stack.push(list);
        extract();
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public Object next() {
        if (!hasNext())
            throw new RuntimeException("no next");
        Object r = (Object) stack.pop();
        extract();
        return r;
    }

    @SuppressWarnings("unchecked")
    private void extract() {
        while (!stack.isEmpty() && (stack.peek() instanceof Collection<?>)) {
            List<Object> top = (List<Object>) stack.pop();
            for (int i = top.size() - 1; i >= 0; i--)
                stack.push(top.get(i));            
        }
    }
    
    public static void main(String[] args) {
        List<Object> list = new LinkedList<Object>();
        list.add(1);
        
        List<Object> sub_list_1 = new LinkedList<Object>();
        sub_list_1.add(2);
        sub_list_1.add(3);
        list.add(sub_list_1);
        
        List<Object> sub_list_2 = new LinkedList<Object>();
        sub_list_2.add(4);
        sub_list_2.add(5);
        sub_list_2.add(6);
        list.add(sub_list_2);
        
        List<Object> sub_list_3 = new LinkedList<Object>();
        list.add(sub_list_3);
       
        list.add(7);
        
        DeepListItr iter = new DeepListItr(list);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
