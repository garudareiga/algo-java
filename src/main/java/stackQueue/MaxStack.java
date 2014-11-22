package stackQueue;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Design a stack that supports push, pop, top, and retrieving the minimum 
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */

public class MaxStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> maxStack = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) 
            maxStack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (maxStack.peek() == x)
            maxStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }   
    
    public int popMax() {
        if (stack.isEmpty())
            throw new EmptyStackException();
        int r = maxStack.pop();
        Iterator<Integer> iter = stack.iterator();
        while (iter.hasNext()) {
            int v = iter.next();
            if (v == r) { iter.remove(); break; }
        }
        return r;
    }
}
