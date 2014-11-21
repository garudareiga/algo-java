package list;

import util.ListNode;

/*
 * @author raychen
 * 
 * Problem:
 * Given two singly linked lists and they both intersect at one point 
 * (i.e. forming a Y shaped list). Find where the two linked lists merge.
 * 
 * http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 */

public class ListIntersection {
    ListNode findIntersection(ListNode head1, ListNode head2) {
        int cnt1 = 0, cnt2 = 0;
        ListNode ln;
        ln = head1;
        while (ln != null) { cnt1++; ln = ln.next; }
        ln = head2;
        while (ln != null) { cnt2++; ln = ln.next; }
        if (cnt1 < cnt2) { ln = head1; head1 = head2; head2 = ln; }
        for (int i = 0; i < Math.abs(cnt1 - cnt2); i++) head1 = head1.next;
        while (head1 != head2) { head1 = head1.next; head2 = head2.next; }
        return head1;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(15);
        ListNode n5 = new ListNode(30);
        ListNode n6 = new ListNode(10);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n6.next = n4;
        n4.next = n5;
        
        ListIntersection sol = new ListIntersection();
        ListNode ln = sol.findIntersection(n1, n6);
        System.out.println(ln.val);
    }
}
