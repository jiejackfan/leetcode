// April 8, 2021
// tag: Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Recursive
    // O(n+m), O(n+m)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = (mergeTwoLists(l1.next, l2));
            return l1;
        }
        else {
            l2.next = (mergeTwoLists(l1, l2.next));
            return l2;
        }
    }

    // Iteration
    // O(n+m), O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        
        // at this point one of l1 l2 is null and the other one is not
        prev.next = l1 == null? l2 : l1;
        
        return dummy.next;
    }
}