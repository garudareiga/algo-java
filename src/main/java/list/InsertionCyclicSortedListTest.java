package list;

import org.junit.Test;
import util.ListNode;

public class InsertionCyclicSortedListTest {

    @Test
    public void test1() {
        ListNode head = new ListNode(2);
        head.next = head;
        
        InsertionCyclicSortedList sol = new InsertionCyclicSortedList();
        head = sol.insert(head, 1);
        InsertionCyclicSortedList.printList(head);
    }
    
    @Test
    public void test2() {
        ListNode head = new ListNode(2);
        ListNode n1 = new ListNode(3);
        head.next = n1;
        n1.next = head;
        
        InsertionCyclicSortedList sol = new InsertionCyclicSortedList();
        head = sol.insert(head, 4);
        InsertionCyclicSortedList.printList(head);
    }
    
    @Test
    public void test3() {
        ListNode head = new ListNode(2);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = head;
        
        InsertionCyclicSortedList sol = new InsertionCyclicSortedList();
        head = sol.insert(head, 4);
        InsertionCyclicSortedList.printList(head);
    }

}
