package list;

import util.ListNode;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Given a node from a cyclic linked list which has been sorted, write a function
 * to insert a value into the list such that it remains a cyclic sorted list.
 * 
 * Be careful if the list has only one node !!!
 */

public class InsertionCyclicSortedList {
    ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            // empty list
            newNode.next = newNode;
            head = newNode;
        } else if (value <= head.val) {
            // Insert at the head
            ListNode tail = head;
            while (tail.next != head)
                tail = tail.next;
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        } else {
            // Insert in the middle or at the tail
            ListNode prev = null, curr = head;
            do {
                prev = curr; curr = curr.next;
            } while (curr != head && curr.val < value);
            prev.next = newNode;
            newNode.next = curr;
        }
        return head;
    }
    
    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        do {
            sb.append(p.val + " ");
            p = p.next;
        } while (p != head);
        System.out.println(sb.toString());
    }
}
