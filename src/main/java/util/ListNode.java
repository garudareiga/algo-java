package util;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; next = null; }
	
	public static void printList(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val + " ");
			head = head.next;
		}
		System.out.println(sb.toString());
	}
	
	public static ListNode reverse(ListNode head) {
		// reverse [head, null)
		ListNode prev = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public static ListNode reverse(ListNode head, ListNode tail) {
		// reverse [head, tail)
		ListNode curr = head, prev = null, next = null;
		while (curr != tail) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head.next = tail;
		return prev;
	}
	
    public static ListNode merge(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0), p = dummy;
    	while (l1 != null && l2 != null) {
    		if (l1.val <= l2.val) {
    			p.next = l1; l1 = l1.next;
    		} else {
    			p.next = l2; l2 = l2.next;
    		}
    		p = p.next;
    	}
    	p.next = l1 != null ? l1 : l2;
    	return dummy.next;
    }
}

